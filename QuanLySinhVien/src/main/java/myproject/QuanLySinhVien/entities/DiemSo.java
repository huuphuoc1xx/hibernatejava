package myproject.QuanLySinhVien.entities;
// Generated Jun 21, 2020 2:09:50 PM by Hibernate Tools 5.4.14.Final

/**
 * DiemSo generated by hbm2java
 */
public class DiemSo implements java.io.Serializable {

	private DiemSoId id;
	private Float diemGk;
	private Float diemCk;
	private Float diemKhac;
	private Float diemTong;

	public DiemSo() {
	}

	public DiemSo(DiemSoId id) {
		this.id = id;
	}

	public DiemSo(DiemSoId id, Float diemGk, Float diemCk, Float diemKhac, Float diemTong) {
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

	public Float getDiemGk() {
		return this.diemGk;
	}

	public void setDiemGk(Float diemGk) {
		this.diemGk = diemGk;
	}

	public Float getDiemCk() {
		return this.diemCk;
	}

	public void setDiemCk(Float diemCk) {
		this.diemCk = diemCk;
	}

	public Float getDiemKhac() {
		return this.diemKhac;
	}

	public void setDiemKhac(Float diemKhac) {
		this.diemKhac = diemKhac;
	}

	public Float getDiemTong() {
		return this.diemTong;
	}

	public void setDiemTong(Float diemTong) {
		this.diemTong = diemTong;
	}

}
