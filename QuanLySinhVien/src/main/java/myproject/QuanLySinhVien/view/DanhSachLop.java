package myproject.QuanLySinhVien.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;

public class DanhSachLop extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public DanhSachLop(String Lop) {
		SpringLayout springLayout=new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel(Lop);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 167, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		String[] columnNames = {"STT", "MSSV", "Họ và tên", "Giới tính", "CMND"};
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		
		List<HocSinh> ds=HocSinhDAO.getByClass(Lop);
		Integer stt=1;
		for(HocSinh hs :ds) {
			String gioiTinh = (hs.isGioiTinh()) ? "Nam" : "Nữ";
			String[] temp = {stt.toString(),""+ hs.getMssv(), hs.getHoTen(),  gioiTinh, ""+hs.getCmnd()};
			defaultTableModel.addRow(temp);
			stt++;
		}
		
		table = new JTable(defaultTableModel);
		
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		
		render.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0;i<columnNames.length;i++)
			table.getColumnModel().getColumn(i).setCellRenderer(render);
		
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);
		
	}
}
