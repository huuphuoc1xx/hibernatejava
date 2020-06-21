package myproject.QuanLySinhVien.view;

import java.awt.Font;
import java.awt.Window;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import myproject.QuanLySinhVien.entities.DiemSo;
import myproject.QuanLySinhVien.entities.DiemSoDAO;
import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;
import myproject.QuanLySinhVien.entities.MonHoc;
import myproject.QuanLySinhVien.entities.MonHocDAO;
import myproject.QuanLySinhVien.entities.PhucKhao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BangDiem extends JPanel {

	JTable table;

	/**
	 * Create the panel.
	 */
	public BangDiem(final String Lop, final String Mon) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblNewLabel = new JLabel(Lop + "-" + Mon);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 34, SpringLayout.WEST, this);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblNewLabel);

		String[] columnNames = { "STT", "MSSV", "Họ tên", "Điểm GK", "Điểm CK", "Điểm Khác", "Điểm Tổng", "Kết quả" };
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		table = new JTable(defaultTableModel);
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		List<DiemSo> list = DiemSoDAO.getBySubject(Mon);
		int hsDau = 0;
		int hsRot = 0;
		Integer stt = 1;
		for (DiemSo ds : list) {
			HocSinh hs = HocSinhDAO.getByMssv(ds.getId().getMssv());
			String ketQua;
			if (ds.getDiemTong() <= 0)
				ketQua = " ";
			else if (ds.getDiemTong() > 5.0) {
				ketQua = "Đậu";
				hsDau++;
			} else {
				ketQua = "Rớt";
				hsRot++;
			}
			Object[] temp = { stt.toString(), "" + hs.getMssv(), hs.getHoTen(), "" + ds.getDiemGk(),
					"" + ds.getDiemCk(), "" + ds.getDiemKhac(), "" + ds.getDiemTong(), ketQua };
			defaultTableModel.addRow(temp);
			stt++;
		}
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();

		render.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < columnNames.length; i++)
			table.getColumnModel().getColumn(i).setCellRenderer(render);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int mssv = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 1));
				String HoTen = (String) table.getValueAt(table.getSelectedRow(), 2);
				float DiemGK = Float.parseFloat((String) table.getValueAt(table.getSelectedRow(), 3));
				float DiemCK = Float.parseFloat((String) table.getValueAt(table.getSelectedRow(), 4));
				float DiemKhac = Float.parseFloat((String) table.getValueAt(table.getSelectedRow(), 5));
				float DiemTong = Float.parseFloat((String) table.getValueAt(table.getSelectedRow(), 6));
				JFrame nhapDiemSinhVien = new NhapDiemSinhVien(Lop,Mon, mssv, HoTen, DiemGK, DiemCK, DiemKhac, DiemTong);
				nhapDiemSinhVien.setVisible(true);
				SwingUtilities.getWindowAncestor(BangDiem.this).dispose();
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 40, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);
		
		final int soLuong=stt;
		final int slDau=hsDau;
		final int slRot=hsRot;

		JButton btnNewButton = new JButton("Thống kê");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(BangDiem.this, new BangThongKe(Mon,soLuong,slDau,slRot), "Thống kê", JOptionPane.OK_OPTION);
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -29, SpringLayout.EAST, this);
		add(btnNewButton);

	}
}
