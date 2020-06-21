package myproject.QuanLySinhVien.view;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import myproject.QuanLySinhVien.entities.DiemSo;
import myproject.QuanLySinhVien.entities.DiemSoDAO;
import myproject.QuanLySinhVien.entities.DiemSoId;
import myproject.QuanLySinhVien.entities.HocSinh;
import myproject.QuanLySinhVien.entities.HocSinhDAO;
import myproject.QuanLySinhVien.entities.LopHoc;
import myproject.QuanLySinhVien.entities.LopHocDAO;
import myproject.QuanLySinhVien.entities.MonHoc;
import myproject.QuanLySinhVien.entities.MonHocDAO;
import myproject.QuanLySinhVien.entities.ThoiKhoaBieu;
import myproject.QuanLySinhVien.entities.ThoiKhoaBieuDAO;
import myproject.QuanLySinhVien.entities.ThoiKhoaBieuId;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

public class Main extends JFrame {


	public Main(JPanel panel) {
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();;
		
		setSize((int)toolkit.getScreenSize().getWidth()/2,(int)toolkit.getScreenSize().getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mainMenu = new JMenu("Tuỳ chọn");
		mainMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mainMenu);
        final JPanel mainPanel=new JPanel();
        JPanel contentPanel =new JPanel();
		
		JMenuItem importSV = new JMenuItem("Import Sinh Viên from file");
		importSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooseFile = new JFileChooser();
				chooseFile.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
				chooseFile.showOpenDialog(null);
				File f = chooseFile.getSelectedFile();
				if(f.canRead())
				try {
					BufferedReader br =new BufferedReader(new FileReader(f));
					String line;
					line = br.readLine();
					String[] value = line.split(",");
					String maLop = value[0];
					br.readLine();
					List<HocSinh> list = new ArrayList<>();
					while ((line = br.readLine())!=null) {
						String UTF8Str = new String(line.getBytes(),"UTF-8");
						String[] s = UTF8Str.split(",");
						int mssv = Integer.valueOf(s[1]);
						String ten = s[2];
						boolean gioi = (s[3].equals("Nam"));
						int cmnd = Integer.valueOf(s[4]);  
						list.add(new HocSinh(mssv,ten, gioi, cmnd, maLop));
						
					}
					
					LopHoc lopHoc=new LopHoc(maLop);
					
					
					boolean check = LopHocDAO.addClass(lopHoc)&&HocSinhDAO.importSinhVien(list);
					br.close();
					if (check) {
						JOptionPane.showMessageDialog(getContentPane(), "Successful!");
						repaint();
					}
					else
						JOptionPane.showMessageDialog(getContentPane(), "Fail!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(getContentPane(), "Fail!");
				} 
			}
		});
		
		importSV.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenu.add(importSV);
		
		JMenuItem addSV = new JMenuItem("Thêm Sinh Viên");
		addSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame addStudent=new ThemSinhVien();
				addPopup(addStudent, null);
			}
		});
		
		addSV.setHorizontalAlignment(SwingConstants.LEFT);
		mainMenu.add(addSV);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Import Thời Khoá Biểu from file");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooseFile = new JFileChooser();
				chooseFile.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
				chooseFile.showOpenDialog(null);
				File f = chooseFile.getSelectedFile();
				if(f.canRead())
				try {
					BufferedReader br =new BufferedReader(new FileReader(f));
					String line;
					line = br.readLine();
					String[] value = line.split(",");
					String maLop = value[0];
					br.readLine();
					List<MonHoc> list = new ArrayList<>();
					List<ThoiKhoaBieu> tkb=new ArrayList<>();
					List<DiemSo> ds=new ArrayList<>();
					List<HocSinh> lisths=HocSinhDAO.getByClass(maLop);
					while ((line = br.readLine())!=null) {
						String UTF8Str = new String(line.getBytes(),"UTF-8");
						String[] s = UTF8Str.split(",");

						String maMon=s[1];
						String tenMon = s[2];
						String PhongHoc =s[3];
						list.add(new MonHoc(maMon,tenMon, PhongHoc,false));
						for(HocSinh hs:lisths) {
							ds.add(new DiemSo(new DiemSoId(maMon,hs.getMssv())));
						}
						tkb.add(new ThoiKhoaBieu(new ThoiKhoaBieuId(maMon,maLop)));
					}
					LopHoc lopHoc=new LopHoc(maLop);
					
					boolean check = LopHocDAO.addClass(lopHoc)&&MonHocDAO.addSubject(list)&&ThoiKhoaBieuDAO.addSchedule(tkb)
							&&DiemSoDAO.addScore(ds);
					br.close();
					if (check) {
						JOptionPane.showMessageDialog(getContentPane(), "Successful!");
						repaint();
					}
					else
						JOptionPane.showMessageDialog(getContentPane(), "Fail!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(getContentPane(), "Fail!");
				} 
			}
		});
		mainMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Import Bảng Điểm from file");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooseFile = new JFileChooser();
				chooseFile.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
				chooseFile.showOpenDialog(null);
				File f = chooseFile.getSelectedFile();
				if(f.canRead())
				try {
					BufferedReader br =new BufferedReader(new FileReader(f));
					String line;
					line = br.readLine();
					String[] value = line.split(",")[0].split("-");
					String maLop = value[0];
					String maMon = value[1];
					br.readLine();
					List<DiemSo> list = new ArrayList<>();
					while ((line = br.readLine())!=null) {
						String UTF8Str = new String(line.getBytes(),"UTF-8");
						String[] s = UTF8Str.split(",");

						int mssv=Integer.parseInt(s[1]);
						String ten = s[2];
						float diemGK=Float.parseFloat(s[3]);
						float diemCK=Float.parseFloat(s[4]);
						float diemKhac=Float.parseFloat(s[5]);
						float diemTong=Float.parseFloat(s[6]);
						list.add(new DiemSo(new DiemSoId(maMon,mssv),diemGK, diemCK,diemKhac,diemTong));
					}
					LopHoc lopHoc=new LopHoc(maLop);
					
					boolean check = LopHocDAO.addClass(lopHoc)&&DiemSoDAO.addScore(list)&&
							ThoiKhoaBieuDAO.addSchedule(new ThoiKhoaBieu(new ThoiKhoaBieuId(maMon, maLop)));
					br.close();
					if (check) {
						JOptionPane.showMessageDialog(getContentPane(), "Successful!");
						repaint();
					}
					else
						JOptionPane.showMessageDialog(getContentPane(), "Fail!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(getContentPane(), "Fail!");
				} 
			}
		});
		mainMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		mainMenu.add(mntmNewMenuItem_2);
		JMenu chonLop = new JMenu("Chọn Lớp");
		menuBar.add(chonLop);
		

        contentPanel.setLayout(new BorderLayout(0, 0));
        contentPanel.add(mainPanel);
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.add(panel);
        setContentPane(contentPanel);
		
		List<LopHoc> dsLop=LopHocDAO.getAll();
		
		for(LopHoc lop : dsLop) {
			final String MaLop=lop.getMaLop();
			JMenu itemLop = new JMenu(MaLop);
			chonLop.add(itemLop);
			
			JMenuItem dsSinhVien= new JMenuItem("Danh sách sinh viên");
			dsSinhVien.addActionListener(new java.awt.event.ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					mainPanel.removeAll();
			        mainPanel.repaint();
			        mainPanel.revalidate();
			        
			        mainPanel.add(new DanhSachLop(MaLop),BorderLayout.CENTER);
			        mainPanel.repaint();
			        mainPanel.revalidate();
			    }
			});
			dsSinhVien.setHorizontalAlignment(SwingConstants.TRAILING);
			itemLop.add(dsSinhVien);
			
			JMenuItem TKB= new JMenuItem("Thời khoá biểu");

			TKB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainPanel.removeAll();
			        mainPanel.repaint();
			        mainPanel.revalidate();
			        
			        mainPanel.add(new ThoiKhoaBieuLop(MaLop),BorderLayout.CENTER);
			        mainPanel.repaint();
			        mainPanel.revalidate();
			    }
			});
			dsSinhVien.setHorizontalAlignment(SwingConstants.TRAILING);
			itemLop.add(TKB);
		}
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
	
	public Main() {
		this(new WelcomeTeacher());
	}
}
