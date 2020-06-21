package myproject.QuanLySinhVien.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import myproject.QuanLySinhVien.entities.Account;
import myproject.QuanLySinhVien.entities.AccountDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Username");

		username = new JTextField();
		username.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");

		password = new JPasswordField();
		password.setToolTipText("");
		password.setColumns(10);

		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				Account account = AccountDAO.getAccount(user);
				if (account == null)
					JOptionPane.showMessageDialog(frame, "Invalid username!");

				char[] pass = password.getPassword();

				if (pass.toString().equals(account.getPassword())) {
					if (account.getStatus()) {
						Main main = new Main();
						main.setVisible(true);
					}else {
						
					}
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid password!");

				}

			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(
						74)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(loginBtn)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1).addComponent(lblNewLabel))
								.addGap(36)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(password)
										.addComponent(username, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
				.addContainerGap(132, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(75)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(27).addComponent(loginBtn).addContainerGap(78, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
