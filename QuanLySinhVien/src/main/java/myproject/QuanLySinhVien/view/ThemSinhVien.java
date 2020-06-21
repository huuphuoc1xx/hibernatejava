package myproject.QuanLySinhVien.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;
import myproject.QuanLySinhVien.entities.LopHoc;
import myproject.QuanLySinhVien.entities.LopHocDAO;

import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class ThemSinhVien extends JFrame {

	private JPanel mainPanel;
	private JTextField mssv;
	private JTextField name;
	private JLabel lblNewLabel_1;
	private JTextField cmnd;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JRadioButton namRadioButton;
	private JRadioButton nuRadioButton;
	private JButton confirmButton;
	private JButton cancelButton;
	private JLabel lblNewLabel_4;
	private JTextField maLop;

	public ThemSinhVien() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);

		JLabel lblNewLabel = new JLabel("MSSV");

		mssv = new JTextField();
		mssv.setColumns(10);

		lblNewLabel_1 = new JLabel("Họ Tên");

		name = new JTextField();
		name.setColumns(10);

		lblNewLabel_4 = new JLabel("Mã Lớp");

		maLop = new JTextField();
		maLop.setEnabled(true);
		maLop.setEditable(true);
		maLop.setText("");
		maLop.setColumns(10);

		lblNewLabel_2 = new JLabel("CMND");

		cmnd = new JTextField();
		cmnd.setText("");
		cmnd.setColumns(10);

		ButtonGroup gioiTinh = new ButtonGroup();

		lblNewLabel_3 = new JLabel("Giới tính");
		namRadioButton = new JRadioButton("Nam");
		namRadioButton.setSelected(true);

		gioiTinh.add(namRadioButton);

		confirmButton = new JButton("Xác nhận");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				HocSinh hs = new HocSinh();
				hs.setMssv(Integer.parseInt(mssv.getText()));
				hs.setCmnd(Integer.parseInt(cmnd.getText()));
				hs.setGioiTinh(namRadioButton.isSelected());
				hs.setMaLop(maLop.getText());
				hs.setHoTen(name.getText());
				
				boolean check = LopHocDAO.addClass(new LopHoc(maLop.getText()))&&HocSinhDAO.addSinhVien(hs);
				if (check) {
					JOptionPane.showMessageDialog(getContentPane(), "Thêm sinh viên thành công!");
					dispose();
				}
				else 
					JOptionPane.showMessageDialog(getContentPane(), "Thất bại!");
				}catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(getContentPane(), "Thất bại!");
				}
				
			}
		});
		nuRadioButton = new JRadioButton("Nữ");
		gioiTinh.add(nuRadioButton);

		cancelButton = new JButton("Huỷ Bỏ");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_cmnd = new GroupLayout(mainPanel);
		gl_cmnd.setHorizontalGroup(
			gl_cmnd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cmnd.createSequentialGroup()
					.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(56)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(maLop, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(56)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cmnd, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(56)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(namRadioButton)
							.addGap(6)
							.addComponent(nuRadioButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(178)
							.addComponent(confirmButton)
							.addGap(31)
							.addComponent(cancelButton))
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
								.addComponent(mssv, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))))
					.addGap(46))
		);
		gl_cmnd.setVerticalGroup(
			gl_cmnd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cmnd.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_cmnd.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(mssv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1)))
					.addGap(6)
					.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
						.addComponent(maLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4)))
					.addGap(6)
					.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
						.addComponent(cmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2)))
					.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
								.addComponent(namRadioButton)
								.addComponent(nuRadioButton))
							.addGap(31)
							.addGroup(gl_cmnd.createParallelGroup(Alignment.LEADING)
								.addComponent(confirmButton)
								.addComponent(cancelButton)))
						.addGroup(gl_cmnd.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_3))))
		);
		mainPanel.setLayout(gl_cmnd);

	}
}
