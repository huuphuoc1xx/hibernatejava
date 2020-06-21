package myproject.QuanLySinhVien.view;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;
import myproject.QuanLySinhVien.entities.MonHoc;
import myproject.QuanLySinhVien.entities.MonHocDAO;
import myproject.QuanLySinhVien.entities.PhucKhao;
import myproject.QuanLySinhVien.entities.PhucKhaoDAO;
import myproject.QuanLySinhVien.entities.PhucKhaoId;

public class DanhSachPhucKhao extends JPanel {

	private JTable table;

	/**
	 * Create the panel.
	 */
	public DanhSachPhucKhao(String Lop,final String Mon) {
		SpringLayout springLayout=new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel(Lop);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 167, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		String[] columnNames = {"STT", "MSSV", "Họ tên", "Cột Điểm","Lý do","Trạng thái"};
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		table = new JTable(defaultTableModel);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		List<PhucKhao> ds=PhucKhaoDAO.getBySubject(Mon);
		Integer stt=1;
		for(PhucKhao pk :ds) {
			HocSinh hs=HocSinhDAO.getByMssv(pk.getId().getMssv());
			String[] temp = {stt.toString(),""+pk.getId().getMssv(),hs.getHoTen(),pk.getCotDiem(),pk.getLyDo(),pk.getKetQua()};
			defaultTableModel.addRow(temp);
			stt++;
		}
		
		
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		
		render.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0;i<columnNames.length;i++)
			table.getColumnModel().getColumn(i).setCellRenderer(render);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getValueAt(table.getSelectedRow(), 4)=="Waiting") {
				int check=JOptionPane.showConfirmDialog(getParent(), "Cập nhật điểm?", "Xác nhận phúc khảo", JOptionPane.YES_NO_CANCEL_OPTION);
				if(check==0)
				{
					int mssv=Integer.parseInt((String) table.getValueAt(table.getSelectedRow(),1));
					String cotDiem=(String) table.getValueAt(table.getSelectedRow(), 3);
					String lyDo=(String) table.getValueAt(table.getSelectedRow(), 4);
					PhucKhao pk=new PhucKhao(new PhucKhaoId(mssv,Mon),cotDiem, mssv, lyDo, "Updated");
					PhucKhaoDAO.add(pk);
				}else if(check==1) {
					int mssv=Integer.parseInt((String) table.getValueAt(table.getSelectedRow(),1));
					String cotDiem=(String) table.getValueAt(table.getSelectedRow(), 3);
					String lyDo=(String) table.getValueAt(table.getSelectedRow(), 4);
					PhucKhao pk=new PhucKhao(new PhucKhaoId(mssv,Mon),cotDiem, mssv, lyDo, "Not Modify");
					PhucKhaoDAO.add(pk);
				}
			}}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
		add(scrollPane);
	}

}
