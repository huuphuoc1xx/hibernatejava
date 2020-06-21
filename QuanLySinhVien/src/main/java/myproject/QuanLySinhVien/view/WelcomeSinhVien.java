package myproject.QuanLySinhVien.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
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

public class WelcomeSinhVien extends JPanel {

	JTable table;

	/**
	 * Create the panel.
	 */
	public WelcomeSinhVien(HocSinh hs) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblNewLabel = new JLabel(hs.getHoTen());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 172, SpringLayout.WEST, this);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblNewLabel);

		String[] columnNames = { "STT", "Mã môn", "Tên môn", "Điểm GK", "Điểm CK", "Điểm Khác", "Điểm Tổng", "Kết quả" };
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		table = new JTable(defaultTableModel);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		List<DiemSo> list = DiemSoDAO.getBySinhVien(hs.getMssv());
		int hsDau = 0;
		int hsRot = 0;
		Integer stt = 1;
		for (DiemSo ds : list) {
			MonHoc mh=MonHocDAO.getByMaMon(ds.getId().getMaMh());
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
			
			String DiemTong = ds.getDiemTong()<=0?"":""+ds.getDiemTong();
			String DiemGK = ds.getDiemGk()<=0?"":""+ds.getDiemGk();
			String DiemCK = ds.getDiemCk()<=0?"":""+ds.getDiemCk();
			String DiemKhac = ds.getDiemKhac()<=0?"":""+ds.getDiemKhac();
			Object[] temp = { stt.toString(), "" + ds.getId().getMaMh(), mh.getTenMon(), DiemGK,
					DiemCK, DiemKhac, DiemTong, ketQua };
			defaultTableModel.addRow(temp);
			stt++;
		}
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();

		render.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < columnNames.length; i++)
			table.getColumnModel().getColumn(i).setCellRenderer(render);


		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 40, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);
		
		final int soLuong=stt;
		final int slDau=hsDau;
		final int slRot=hsRot;

	}

}
