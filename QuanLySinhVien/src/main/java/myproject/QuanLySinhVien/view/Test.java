package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pojo.Sinhvien;
import pojo.SinhvienDAO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Xem danh sách lớp");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 150, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -150, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		String[] lop = SinhvienDAO.layDanhSachLop();
		comboBox = new JComboBox(lop);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 50, SpringLayout.NORTH, contentPane);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Lớp");
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 21, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		String[] columnNames = {"STT", "MSSV", "Họ và tên", "Giới tính", "CMND"};
		String[][] data = {{}};
		DefaultTableModel modelEmpty = new DefaultTableModel(data, columnNames);
		final JTable table = new JTable(modelEmpty);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 31, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, contentPane);
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				String lop = comboBox.getSelectedItem().toString();
				int stt = 1;
				List<Sinhvien> sv= SinhvienDAO.layDanhSachSinhVienTheoLop(lop);
				for	(Sinhvien i: sv) {
					String gioi = (i.getGioiTinh()==1) ? "Nam" : "Nữ";
					String[] temp = {String.valueOf(stt), String.valueOf(i.getMssv()), i.getHoTen(),  gioi, String.valueOf(i.getCmnd())};
					model.addRow(temp);
					stt++;
				}
			}				
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 145, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -27, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, comboBox);
		contentPane.add(btnNewButton);
		
		
		contentPane.add(scrollPane);
	}
}
