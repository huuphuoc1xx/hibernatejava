package myproject.QuanLySinhVien.view;

import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.type.YesNoType;

import myproject.QuanLySinhVien.entities.DiemSo;
import myproject.QuanLySinhVien.entities.DiemSoDAO;
import myproject.QuanLySinhVien.entities.DiemSoId;
import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DanhSachHocSinhTheoMon extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public DanhSachHocSinhTheoMon(final String Lop, final String Mon) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblNewLabel = new JLabel(Lop + '-' + Mon);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 20, SpringLayout.WEST, this);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lblNewLabel);

		String[] columnNames = { "STT", "MSSV", "Họ và tên", "Giới tính", "CMND" };
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);

		List<HocSinh> ds = HocSinhDAO.getBySubject(Mon);
		Integer stt = 1;
		for (HocSinh hs : ds) {
			String gioiTinh = (hs.isGioiTinh()) ? "Nam" : "Nữ";
			String[] temp = { stt.toString(), "" + hs.getMssv(), hs.getHoTen(), gioiTinh, "" + hs.getCmnd() };
			defaultTableModel.addRow(temp);
			stt++;
		}

		table = new JTable(defaultTableModel);

		DefaultTableCellRenderer render = new DefaultTableCellRenderer();

		render.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < columnNames.length; i++)
			table.getColumnModel().getColumn(i).setCellRenderer(render);

		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -18, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);

		JButton addButton = new JButton("Thêm");
		springLayout.putConstraint(SpringLayout.SOUTH, addButton, 0, SpringLayout.SOUTH, lblNewLabel);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mssv = JOptionPane.showInputDialog("Nhập mã số sinh viên cần thêm vào môn học");
				try {
					int ms = Integer.parseInt(mssv);
					HocSinh hs = HocSinhDAO.getByMssv(ms);
					if(hs==null)
						throw new Exception("No student");

					int check = JOptionPane.showConfirmDialog(DanhSachHocSinhTheoMon.this, new ThongTinSinhVien(hs),
							"Xác nhận thêm?", JOptionPane.YES_NO_OPTION);
					if (check == 0) {
						DiemSoDAO.addScore(new DiemSo(new DiemSoId(Mon, ms)));
						JOptionPane.showMessageDialog(DanhSachHocSinhTheoMon.this, "Thêm thành công");
						getParent().repaint();
						getParent().revalidate();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(DanhSachHocSinhTheoMon.this, "Thêm thất bại");
				}
			}
		});
		add(addButton);

		JButton delButton = new JButton("Xoá");
		springLayout.putConstraint(SpringLayout.EAST, addButton, -6, SpringLayout.WEST, delButton);
		springLayout.putConstraint(SpringLayout.NORTH, delButton, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, delButton, -10, SpringLayout.EAST, this);
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mssv = JOptionPane.showInputDialog("Nhập mã số sinh viên cần xoá khỏi môn học");
				try {
					int ms = Integer.parseInt(mssv);

					HocSinh hs = HocSinhDAO.getByMssv(ms);

					int check = JOptionPane.showConfirmDialog(DanhSachHocSinhTheoMon.this, new ThongTinSinhVien(hs),
							"Xác nhận thêm?", JOptionPane.YES_NO_OPTION);
					if (check == 0) {
						DiemSoDAO.deleteScore(new DiemSo(new DiemSoId(Mon, ms)));
						JOptionPane.showMessageDialog(DanhSachHocSinhTheoMon.this, "Xoá thành công");
						repaint();
						revalidate();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(DanhSachHocSinhTheoMon.this, "Xoá thất bại");
				}
			}
		});
		add(delButton);
		
		JButton btnNewButton = new JButton("Xem Bảng Điểm");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -48, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, -96, SpringLayout.WEST, addButton);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -25, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -7, SpringLayout.WEST, addButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel bangDiem =new BangDiem(Lop, Mon);
				JFrame bangDiemFrame=new Main(bangDiem);
				bangDiemFrame.setVisible(true);
				SwingUtilities.getWindowAncestor(DanhSachHocSinhTheoMon.this).dispose();
			}
		});
		add(btnNewButton);

	}
}
