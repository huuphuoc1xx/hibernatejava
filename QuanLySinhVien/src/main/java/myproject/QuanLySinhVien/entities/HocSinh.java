package myproject.QuanLySinhVien.entities;
// Generated Jun 17, 2020 9:35:42 AM by Hibernate Tools 5.4.14.Final

import java.util.HashSet;
import java.util.Set;

/**
 * HocSinh generated by hbm2java
 */
public class HocSinh implements java.io.Serializable {

	private int mssv;
	private LopHoc lopHoc;
	private String hoTen;
	private boolean gioiTinh;
	private int cmnd;
	private Set diemSos = new HashSet(0);
	private Set phucKhaos = new HashSet(0);

	public HocSinh() {
	}

	public HocSinh(int mssv, LopHoc lopHoc, String hoTen, boolean gioiTinh, int cmnd) {
		this.mssv = mssv;
		this.lopHoc = lopHoc;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
	}

	public HocSinh(int mssv, LopHoc lopHoc, String hoTen, boolean gioiTinh, int cmnd, Set diemSos, Set phucKhaos) {
		this.mssv = mssv;
		this.lopHoc = lopHoc;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.diemSos = diemSos;
		this.phucKhaos = phucKhaos;
	}

	public int getMssv() {
		return this.mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public LopHoc getLopHoc() {
		return this.lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean isGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getCmnd() {
		return this.cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}

	public Set getDiemSos() {
		return this.diemSos;
	}

	public void setDiemSos(Set diemSos) {
		this.diemSos = diemSos;
	}

	public Set getPhucKhaos() {
		return this.phucKhaos;
	}

	public void setPhucKhaos(Set phucKhaos) {
		this.phucKhaos = phucKhaos;
	}

}
