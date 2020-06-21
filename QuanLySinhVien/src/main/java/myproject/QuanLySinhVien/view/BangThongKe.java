package myproject.QuanLySinhVien.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormSpecs;

import myproject.QuanLySinhVien.entities.MonHoc;
import myproject.QuanLySinhVien.entities.MonHocDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class BangThongKe extends JPanel {
	protected static final long SECONDS_PER_DAY = 60 * 60 * 24;
	private JTextField SLDAU;
	private JTextField TLDAU;
	private JTextField SLROT;
	private JTextField TLROT;
	private JTextField SL;
	private JTextField TL;

	public BangThongKe(final String Mon, int soLuong, int slDau, int slRot) {
		JButton button = new JButton("Tạo phúc khảo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MonHoc mh = MonHocDAO.getByMaMon(Mon);
					mh.setPhucKhao(true);
					mh.setDeadLine(Date.from(Instant.now().plusSeconds(14*SECONDS_PER_DAY)));
					if (!MonHocDAO.addSubject(mh))
						throw new Exception("Fail");
					JOptionPane.showMessageDialog(BangThongKe.this, "Tạo phúc khảo tành công");

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(BangThongKe.this, "Tạo phúc khảo thất bại");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Số lượng");

		JLabel lblHcSinhu = new JLabel("Học sinh đậu");

		JLabel lblHcSinhRt = new JLabel("Học sinh rớt");

		JLabel lblPhnTrm = new JLabel("Phần trăm");

		SLDAU = new JTextField();
		SLDAU.setEditable(false);
		SLDAU.setColumns(10);
		SLDAU.setText("" + slDau);

		TLDAU = new JTextField();
		TLDAU.setEditable(false);
		TLDAU.setColumns(10);
		TLDAU.setText("" + Math.round((1.0 * slDau) / soLuong * 100) / 100 + "%");

		SLROT = new JTextField();
		SLROT.setEditable(false);
		SLROT.setColumns(10);
		SLROT.setText("" + slRot);

		TLROT = new JTextField();
		TLROT.setEditable(false);
		TLROT.setColumns(10);
		TLROT.setText("" + Math.round((1.0 * slRot) / soLuong * 100) / 100 + "%");

		SL = new JTextField();
		SL.setEditable(false);
		SL.setColumns(10);
		SL.setText("" + soLuong);

		TL = new JTextField();
		TL.setEditable(false);
		TL.setColumns(10);
		TL.setText("100%");

		JLabel lblTngCng = new JLabel("Tổng cộng");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(150).addComponent(lblNewLabel).addGap(58)
						.addComponent(lblPhnTrm))
				.addGroup(groupLayout.createSequentialGroup().addGap(57).addComponent(lblHcSinhu).addGap(10)
						.addComponent(SLDAU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(TLDAU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(57).addComponent(lblHcSinhRt).addGap(14)
						.addComponent(SLROT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(TLROT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(57).addComponent(lblTngCng).addGap(21)
						.addComponent(SL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(TL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(328).addComponent(button)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(11)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel).addComponent(lblPhnTrm))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(lblHcSinhu))
						.addComponent(SLDAU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(TLDAU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(lblHcSinhRt))
						.addComponent(SLROT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(TLROT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblTngCng))
						.addComponent(SL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(TL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(34).addComponent(button)));
		setLayout(groupLayout);
	}
}
