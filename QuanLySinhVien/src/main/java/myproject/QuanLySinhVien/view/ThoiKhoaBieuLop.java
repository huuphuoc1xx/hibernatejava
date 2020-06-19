package myproject.QuanLySinhVien.view;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import myproject.QuanLySinhVien.entities.MonHoc;
import myproject.QuanLySinhVien.entities.MonHocDAO;
import javax.swing.ListSelectionModel;

public class ThoiKhoaBieuLop extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ThoiKhoaBieuLop(final String Lop) {
		SpringLayout springLayout=new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel(Lop);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 167, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		String[] columnNames = {"STT", "Mã môn", "Tên môn", "Phòng Học"};
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		table = new JTable(defaultTableModel);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		List<MonHoc> ds=MonHocDAO.getByClass(Lop);
		Integer stt=1;
		for(MonHoc mh :ds) {
			String[] temp = {stt.toString(),mh.getMaMon(),mh.getTenMon(),mh.getPhongHoc()};
			defaultTableModel.addRow(temp);
			stt++;
		}
		
		
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		
		render.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0;i<columnNames.length;i++)
			table.getColumnModel().getColumn(i).setCellRenderer(render);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String maMon=(String) table.getValueAt(table.getSelectedRow(), 1);
				JPanel danhSachHocSinhTheoMon=new DanhSachHocSinhTheoMon(Lop,maMon);
				JFrame dsmon=new Main(danhSachHocSinhTheoMon);
				dsmon.setVisible(true);
				SwingUtilities.getWindowAncestor(ThoiKhoaBieuLop.this).dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);
		
	}
}
