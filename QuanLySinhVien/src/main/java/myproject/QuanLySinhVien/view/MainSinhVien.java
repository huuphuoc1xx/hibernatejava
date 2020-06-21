package myproject.QuanLySinhVien.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;
public class MainSinhVien extends JFrame {

	private JPanel contentPane;

	public MainSinhVien(final String username) {
		final HocSinh hs=HocSinhDAO.getByUsername(username);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		;

		setSize((int) toolkit.getScreenSize().getWidth() / 2, (int) toolkit.getScreenSize().getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mainMenu = new JMenu("Tuỳ chọn");
		mainMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mainMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Phúc khảo");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame donPhucKhao=new DonPhucKhao(hs);
				donPhucKhao.setEnabled(true);
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Đăng xuất");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenu.add(mntmNewMenuItem);
		JPanel contentPanel = new WelcomeSinhVien(hs);

		setContentPane(contentPanel);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
