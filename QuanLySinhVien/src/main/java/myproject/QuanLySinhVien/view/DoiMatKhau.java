package myproject.QuanLySinhVien.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import myproject.QuanLySinhVien.entities.Account;
import myproject.QuanLySinhVien.entities.AccountDAO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JPasswordField currentPass;
	private JPasswordField newPass;
	private JPasswordField rePass;
	private JTextField username;

	
	public DoiMatKhau(final String userName) {
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_3 = new JLabel("Tên đăng nhập");
		contentPane.add(lblNewLabel_3, "4, 2");
		
		username = new JTextField();
		username.setEnabled(false);
		username.setEditable(false);
		username.setText(userName);
		contentPane.add(username, "6, 2, 9, 1, fill, fill");
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu hiện tại");
		contentPane.add(lblNewLabel, "4, 6");
		
		currentPass = new JPasswordField();
		contentPane.add(currentPass, "6, 6, 9, 1, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới");
		contentPane.add(lblNewLabel_1, "4, 10");
		
		newPass = new JPasswordField();
		contentPane.add(newPass, "6, 10, 9, 1, fill, default");
		
		JLabel lblNewLabel_2 = new JLabel("Nhập lại");
		contentPane.add(lblNewLabel_2, "4, 14");
		
		rePass = new JPasswordField();
		contentPane.add(rePass, "6, 14, 9, 1, fill, default");
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc=AccountDAO.getAccount(userName);
				if(!currentPass.getPassword().toString().equals(acc.getPassword())) {
					JOptionPane.showMessageDialog(DoiMatKhau.this, "Invalid Password!!");
					dispose();
				}else if(!newPass.getPassword().equals(rePass.getPassword())) {
					JOptionPane.showMessageDialog(DoiMatKhau.this, "Password not match!!");
					dispose();
				}else {
					Account account=new Account(acc.getUsername(),newPass.getPassword().toString(),false,acc.getMssv());
					AccountDAO.changeAccount(account);
				}
			}
		});
		contentPane.add(btnNewButton, "12, 18");
	}

}
