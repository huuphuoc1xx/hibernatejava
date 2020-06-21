package myproject.QuanLySinhVien.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import myproject.QuanLySinhVien.entities.DiemSo;
import myproject.QuanLySinhVien.entities.DiemSoDAO;
import myproject.QuanLySinhVien.entities.DiemSoId;
import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;
import myproject.QuanLySinhVien.entities.LopHoc;
import myproject.QuanLySinhVien.entities.LopHocDAO;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NhapDiemSinhVien extends JFrame {

	private JPanel mainPanel;
	private JFormattedTextField mssv;
	private JTextField name;
	private JLabel lblNewLabel_1;
	private JFormattedTextField diemCK;
	private JLabel lblNewLabel_2;
	private JButton confirmButton;
	private JButton cancelButton;
	private JLabel lblNewLabel_4;
	private JFormattedTextField diemGK;
	private JFormattedTextField diemKhac;
	private JFormattedTextField diemTong;

	public NhapDiemSinhVien(final String Mon, final int ms, String HoTen, float DiemGK, float DiemCK, float DiemKhac,
			float DiemTong) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);

		JLabel lblNewLabel = new JLabel("MSSV");

		mssv = new JFormattedTextField();
		mssv.setEditable(false);
		mssv.setText("" + ms);
		mssv.setColumns(10);

		lblNewLabel_1 = new JLabel("Họ Tên");

		name = new JTextField();
		name.setEditable(false);
		name.setText(HoTen);
		name.setColumns(10);

		lblNewLabel_4 = new JLabel("Điểm GK");

		diemGK = new JFormattedTextField(new InputNumberFormat(NumberFormat.getInstance()));
		diemGK.setColumns(10);
		diemGK.setText("" + DiemGK);

		lblNewLabel_2 = new JLabel("Điểm GK");

		diemCK = new JFormattedTextField(new InputNumberFormat(NumberFormat.getInstance()));
		diemCK.setColumns(10);
		diemCK.setText("" + DiemCK);

		ButtonGroup gioiTinh = new ButtonGroup();

		confirmButton = new JButton("Xác nhận");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float GK = 0, CK = 0, Khac = 0, Tong = 0;
					if (!diemGK.getText().isEmpty())
						GK = Float.parseFloat(diemGK.getText());
					if (!diemCK.getText().isEmpty())
						CK = Float.parseFloat(diemCK.getText());
					if (!diemKhac.getText().isEmpty())
						Khac = Float.parseFloat(diemKhac.getText());
					if (!diemTong.getText().isEmpty())
						Tong = Float.parseFloat(diemTong.getText());
					DiemSo ds = new DiemSo(new DiemSoId(Mon, ms), GK, CK, Khac, Tong);

					boolean check = DiemSoDAO.addScore(ds);
					if (check) {
						JOptionPane.showMessageDialog(getContentPane(), "Nhập điểm thành công!");
						dispose();
					} else
						JOptionPane.showMessageDialog(getContentPane(), "Nhập điểm thất bại!");
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(getContentPane(), "Thất bại!");
				}

			}
		});

		cancelButton = new JButton("Huỷ Bỏ");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Điểm Khác");

		JLabel lblDiemtong = new JLabel("Điểm Tổng");

		diemKhac = new JFormattedTextField(new InputNumberFormat(NumberFormat.getInstance()));
		diemKhac.setColumns(10);
		diemKhac.setText("" + DiemKhac);

		diemTong = new JFormattedTextField(new InputNumberFormat(NumberFormat.getInstance()));
		diemTong.setColumns(10);
		diemTong.setText("" + DiemTong);
		GroupLayout gl_cmnd = new GroupLayout(mainPanel);
		gl_cmnd.setHorizontalGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cmnd.createSequentialGroup().addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_cmnd.createSequentialGroup().addGap(178).addComponent(confirmButton).addGap(31)
								.addComponent(cancelButton))
						.addGroup(gl_cmnd.createSequentialGroup().addGap(56)
								.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
										.addComponent(mssv, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(name, GroupLayout.PREFERRED_SIZE, 253,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_cmnd.createSequentialGroup().addGap(56)
								.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_cmnd.createSequentialGroup().addComponent(lblDiemtong).addGap(18)
												.addComponent(diemTong, GroupLayout.PREFERRED_SIZE, 63,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_cmnd
												.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(Alignment.LEADING, gl_cmnd
														.createSequentialGroup()
														.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 51,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(diemGK, 0, 0, Short.MAX_VALUE))
												.addGroup(Alignment.LEADING, gl_cmnd.createSequentialGroup()
														.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_cmnd.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblNewLabel_2,
																				GroupLayout.PREFERRED_SIZE, 51,
																				GroupLayout.PREFERRED_SIZE))
																.addComponent(lblNewLabel_3))
														.addGap(18)
														.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
																.addComponent(diemCK, GroupLayout.PREFERRED_SIZE, 63,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(diemKhac, GroupLayout.PREFERRED_SIZE, 63,
																		GroupLayout.PREFERRED_SIZE)))))))
						.addGap(46)));
		gl_cmnd.setVerticalGroup(gl_cmnd.createParallelGroup(Alignment.LEADING).addGroup(gl_cmnd.createSequentialGroup()
				.addGap(9)
				.addGroup(gl_cmnd.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(mssv,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cmnd.createSequentialGroup().addGap(3).addComponent(lblNewLabel_1)))
				.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cmnd.createSequentialGroup().addGap(9).addComponent(lblNewLabel_4))
						.addGroup(gl_cmnd.createSequentialGroup().addGap(6).addComponent(diemGK,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_cmnd.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(
						diemCK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_cmnd.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						diemKhac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_cmnd.createParallelGroup(Alignment.TRAILING).addComponent(lblDiemtong).addComponent(
						diemTong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33).addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING).addComponent(confirmButton)
						.addComponent(cancelButton))));
		mainPanel.setLayout(gl_cmnd);

	}
}
