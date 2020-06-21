package myproject.QuanLySinhVien.entities;
// Generated Jun 21, 2020 2:09:50 PM by Hibernate Tools 5.4.14.Final

/**
 * PhucKhao generated by hbm2java
 */
public class PhucKhao implements java.io.Serializable {

	private PhucKhaoId id;
	private String cotDiem;
	private Integer diemMongMuon;
	private String lyDo;
	private String ketQua;

	public PhucKhao() {
	}

	public PhucKhao(PhucKhaoId id, String cotDiem, String ketQua) {
		this.id = id;
		this.cotDiem = cotDiem;
		this.ketQua = ketQua;
	}

	public PhucKhao(PhucKhaoId id, String cotDiem, Integer diemMongMuon, String lyDo, String ketQua) {
		this.id = id;
		this.cotDiem = cotDiem;
		this.diemMongMuon = diemMongMuon;
		this.lyDo = lyDo;
		this.ketQua = ketQua;
	}

	public PhucKhaoId getId() {
		return this.id;
	}

	public void setId(PhucKhaoId id) {
		this.id = id;
	}

	public String getCotDiem() {
		return this.cotDiem;
	}

	public void setCotDiem(String cotDiem) {
		this.cotDiem = cotDiem;
	}

	public Integer getDiemMongMuon() {
		return this.diemMongMuon;
	}

	public void setDiemMongMuon(Integer diemMongMuon) {
		this.diemMongMuon = diemMongMuon;
	}

	public String getLyDo() {
		return this.lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public String getKetQua() {
		return this.ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

}
