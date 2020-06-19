package myproject.QuanLySinhVien.view;

import javax.swing.JPanel;

import myproject.QuanLySinhVien.entities.HocSinh;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class ThongTinSinhVien extends JPanel {

	private JTextField mssv;
	private JTextField name;
	private JLabel lblNewLabel_1;
	private JTextField Cmnd;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField maLop;
	private JTextField gioi;

	public ThongTinSinhVien(HocSinh hs)  {
		setBounds(100, 100, 450, 300);

		JLabel lblNewLabel = new JLabel("MSSV");

		mssv = new JTextField(""+hs.getMssv());
		mssv.setEditable(false);
		mssv.setColumns(10);

		lblNewLabel_1 = new JLabel("Họ Tên");

		name = new JTextField(hs.getHoTen());
		name.setEditable(false);
		name.setColumns(10);

		lblNewLabel_4 = new JLabel("Mã Lớp");

		maLop = new JTextField(hs.getMaLop());
		maLop.setEnabled(true);
		maLop.setEditable(false);
		maLop.setColumns(10);

		lblNewLabel_2 = new JLabel("CMND");

		Cmnd = new JTextField(""+hs.getCmnd());
		Cmnd.setEditable(false);
		Cmnd.setColumns(10);


		lblNewLabel_3 = new JLabel("Giới tính");
		
		String gioiTinh=hs.isGioiTinh()?"Nam":"Nữ";
		gioi = new JTextField(gioiTinh);
		gioi.setEditable(false);
		gioi.setColumns(10);
		GroupLayout mainGroup = new GroupLayout(this);
		mainGroup.setHorizontalGroup(
			mainGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroup.createSequentialGroup()
					.addGap(56)
					.addGroup(mainGroup.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroup.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(41)
							.addComponent(mssv, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(171, Short.MAX_VALUE))
						.addGroup(mainGroup.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(mainGroup.createSequentialGroup()
							.addGroup(mainGroup.createParallelGroup(Alignment.LEADING)
								.addGroup(mainGroup.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(maLop, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
								.addGroup(mainGroup.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(Cmnd, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addGroup(mainGroup.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(mainGroup.createParallelGroup(Alignment.LEADING)
										.addComponent(gioi, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
										.addComponent(name, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))))
							.addGap(46))))
		);
		mainGroup.setVerticalGroup(
			mainGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroup.createSequentialGroup()
					.addGap(47)
					.addGroup(mainGroup.createParallelGroup(Alignment.BASELINE)
						.addComponent(mssv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(mainGroup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(gioi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(mainGroup.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(mainGroup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(maLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(mainGroup.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(Cmnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);
		setLayout(mainGroup);

	}
}
