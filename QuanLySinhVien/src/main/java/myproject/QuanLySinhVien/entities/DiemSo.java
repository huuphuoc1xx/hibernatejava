package myproject.QuanLySinhVien.entities;
// Generated Jun 21, 2020 10:12:58 PM by Hibernate Tools 5.4.14.Final

/**
 * DiemSo generated by hbm2java
 */
public class DiemSo implements java.io.Serializable {

	private DiemSoId id;
	private float diemGk;
	private float diemCk;
	private float diemKhac;
	private float diemTong;

	public DiemSo() {
	}

	public DiemSo(DiemSoId id, float diemGk, float diemCk, float diemKhac, float diemTong) {
		this.id = id;
		this.diemGk = diemGk;
		this.diemCk = diemCk;
		this.diemKhac = diemKhac;
		this.diemTong = diemTong;
	}

	public DiemSoId getId() {
		return this.id;
	}

	public void setId(DiemSoId id) {
		this.id = id;
	}

	public float getDiemGk() {
		return this.diemGk;
	}

	public void setDiemGk(float diemGk) {
		this.diemGk = diemGk;
	}

	public float getDiemCk() {
		return this.diemCk;
	}

	public void setDiemCk(float diemCk) {
		this.diemCk = diemCk;
	}

	public float getDiemKhac() {
		return this.diemKhac;
	}

	public void setDiemKhac(float diemKhac) {
		this.diemKhac = diemKhac;
	}

	public float getDiemTong() {
		return this.diemTong;
	}

	public void setDiemTong(float diemTong) {
		this.diemTong = diemTong;
	}

}
