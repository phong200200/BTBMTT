package app.dto;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NguoiDung {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nguoiDungId;
	
	
	private String ten;
	
	private String email;
	
	private String matKhau;
	
	@ManyToOne
    @JoinColumn(name = "id")
    private VaiTro vaiTro;
	
	@OneToMany(mappedBy = "nguoiDung")
    private List<LSNguoiDung> lsNguoiDungs;

	public int getNguoiDungId() {
		return nguoiDungId;
	}

	public void setNguoiDungId(int nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public VaiTro getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(VaiTro vaiTro) {
		this.vaiTro = vaiTro;
	}

	public List<LSNguoiDung> getLsNguoiDungs() {
		return lsNguoiDungs;
	}

	public void setLsNguoiDungs(List<LSNguoiDung> lsNguoiDungs) {
		this.lsNguoiDungs = lsNguoiDungs;
	}
    
}
