package app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class LSNguoiDung {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int lSNguoiDungId;


    private Date thoiGian;
    
    @ManyToOne
    @JoinColumn(name = "nguoiDungId")
    private NguoiDung nguoiDung;
    
    public int getlSNguoiDungId() {
		return lSNguoiDungId;
	}

	public void setlSNguoiDungId(int lSNguoiDungId) {
		this.lSNguoiDungId = lSNguoiDungId;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public LoaiLichSu getLoaiLichSu() {
		return loaiLichSu;
	}

	public void setLoaiLichSu(LoaiLichSu loaiLichSu) {
		this.loaiLichSu = loaiLichSu;
	}

	@ManyToOne
    @JoinColumn(name = "loaiLichSuId")
    private LoaiLichSu loaiLichSu;
    
    
}
