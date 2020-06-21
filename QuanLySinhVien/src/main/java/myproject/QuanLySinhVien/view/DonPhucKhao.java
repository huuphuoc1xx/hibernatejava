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

public class DonPhucKhao extends JFrame {

	private JPanel contentPane;
	private JTextField MaMon;


	public DonPhucKhao(final HocSinh hs) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Mã môn");
		contentPane.add(lblNewLabel, "2, 4, default, fill");
		
		MaMon = new JTextField();
		contentPane.add(MaMon, "6, 4, 3, 1, fill, default");
		MaMon.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cột điểm ");
		contentPane.add(lblNewLabel_1, "2, 6, default, top");
		
		final JRadioButton gkBtn = new JRadioButton("Điểm GK");
		contentPane.add(gkBtn, "6, 6");
		
		final JRadioButton ckBtn = new JRadioButton("Điểm CK");
		contentPane.add(ckBtn, "8, 6");
		
		final JRadioButton khacBtn = new JRadioButton("Điểm Khác");
		contentPane.add(khacBtn, "10, 6");
		
		final JRadioButton tongBtn = new JRadioButton("Điểm Tổng");
		contentPane.add(tongBtn, "12, 6");
		
		ButtonGroup cotDiem = new ButtonGroup();
		cotDiem.add(gkBtn);
		cotDiem.add(ckBtn);
		cotDiem.add(khacBtn);
		cotDiem.add(tongBtn);
		JLabel lblNewLabel_3 = new JLabel("Điểm mong muốn");
		contentPane.add(lblNewLabel_3, "2, 8");
		
		JFormattedTextField diemMM = new JFormattedTextField(new InputNumberFormat(NumberFormat.getInstance()));
		contentPane.add(diemMM, "6, 8");
		
		JLabel lblNewLabel_4 = new JLabel("Lý do");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel_4, "2, 10, default, top");
		
		JTextPane lyDo = new JTextPane();
		lblNewLabel_4.setLabelFor(lyDo);
		contentPane.add(lyDo, "6, 10, 6, 1, fill, fill");
		
		JLabel lblNewLabel_2 = new JLabel("");
		contentPane.add(lblNewLabel_2, "2, 12");
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonHoc mon=MonHocDAO.getByMaMon(MaMon.getText());
				if(!mon.isPhucKhao()||mon.getDeadLine().before(new Date()))
					JOptionPane.showMessageDialog(DonPhucKhao.this,"Môn học chưa được phép phúc khảo!!");
				else {
					String CotDiem=null;
					if(gkBtn.isSelected())
						CotDiem="DiemGK";
					if(ckBtn.isSelected())
						CotDiem="DiemCK";
					if(khacBtn.isSelected())
						CotDiem="DiemKhac";
					if(tongBtn.isSelected())
						CotDiem="DiemTong";
					PhucKhao pk=new PhucKhao(new PhucKhaoId(hs.getMssv(),mon.getMaMon()),CotDiem,null);
					PhucKhaoDAO.add(pk);
				}
			}
		});
		contentPane.add(btnNewButton, "8, 12");
	}

}
