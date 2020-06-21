package myproject.QuanLySinhVien.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.GridLayout;

public class WelcomeTeacher extends JPanel {

	/**
	 * Create the panel.
	 */
	public WelcomeTeacher() {
		setBackground(Color.ORANGE);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label = new JLabel("Chào mừng đến với ứng dụng quản lý sinh viên");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.ORANGE);
		add(label);

	}

}
