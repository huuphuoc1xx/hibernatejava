package myproject.QuanLySinhVien.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.MonHoc;
import myproject.QuanLySinhVien.entities.MonHocDAO;
import myproject.QuanLySinhVien.entities.PhucKhao;
import myproject.QuanLySinhVien.entities.PhucKhaoDAO;
import myproject.QuanLySinhVien.entities.PhucKhaoId;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DonPhucKhao extends JFrame {

	private JPanel contentPane;
	private JTextField MaMon;

	public DonPhucKhao(final HocSinh hs) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Mã môn");

		MaMon = new JTextField();
		MaMon.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cột điểm ");

		final JRadioButton gkBtn = new JRadioButton("Điểm GK");
		gkBtn.setSelected(true);

		final JRadioButton ckBtn = new JRadioButton("Điểm CK");

		final JRadioButton khacBtn = new JRadioButton("Điểm Khác");

		final JRadioButton tongBtn = new JRadioButton("Điểm Tổng");

		ButtonGroup cotDiem = new ButtonGroup();
		cotDiem.add(gkBtn);
		cotDiem.add(ckBtn);
		cotDiem.add(khacBtn);
		cotDiem.add(tongBtn);
		JLabel lblNewLabel_3 = new JLabel("Điểm mong muốn");

		final JTextField diemMM = new InputNumber();

		JLabel lblNewLabel_4 = new JLabel("Lý do");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);

		final JTextPane lyDo = new JTextPane();
		lblNewLabel_4.setLabelFor(lyDo);

		JLabel lblNewLabel_2 = new JLabel("");

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonHoc mon = MonHocDAO.getByMaMon(MaMon.getText());
				if (mon == null || !mon.isPhucKhao() || mon.getDeadLine().before(new Date()))
					JOptionPane.showMessageDialog(DonPhucKhao.this, "Môn học chưa được phép phúc khảo!!");
				else {
					try {
						String CotDiem = null;
						if (gkBtn.isSelected())
							CotDiem = "DiemGK";
						if (ckBtn.isSelected())
							CotDiem = "DiemCK";
						if (khacBtn.isSelected())
							CotDiem = "DiemKhac";
						if (tongBtn.isSelected())
							CotDiem = "DiemTong";
						PhucKhao pk = new PhucKhao(new PhucKhaoId(hs.getMssv(), mon.getMaMon()), CotDiem,
								Integer.parseInt(diemMM.getText()), lyDo.getText(), "Waiting");
						PhucKhaoDAO.add(pk);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(DonPhucKhao.this, "Thông tin không chính xác!!");
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(6)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(31)
								.addComponent(MaMon, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(31).addComponent(gkBtn).addGap(6)
								.addComponent(ckBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addGap(6).addComponent(khacBtn).addGap(6).addComponent(tongBtn))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_3).addGap(31)
								.addComponent(diemMM, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(31)
								.addComponent(lyDo, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(102).addComponent(btnNewButton)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(31)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(MaMon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
								.addComponent(gkBtn).addComponent(ckBtn).addComponent(khacBtn).addComponent(tongBtn))
						.addGap(6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblNewLabel_3))
								.addComponent(diemMM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_4)
								.addComponent(lyDo, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(11).addComponent(lblNewLabel_2))
								.addComponent(btnNewButton))));
		contentPane.setLayout(gl_contentPane);
	}

}
