package app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class LoaiLichSu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int loaiLichSuId;

    private String tenLoai;
    
    @OneToMany(mappedBy = "loaiLichSu")
    private List<LSNguoiDung> lsNguoiDungs;

	public int getLoaiLichSuId() {
		return loaiLichSuId;
	}

	public void setLoaiLichSuId(int loaiLichSuId) {
		this.loaiLichSuId = loaiLichSuId;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<LSNguoiDung> getLsNguoiDungs() {
		return lsNguoiDungs;
	}

	public void setLsNguoiDungs(List<LSNguoiDung> lsNguoiDungs) {
		this.lsNguoiDungs = lsNguoiDungs;
	}
    
    
}
