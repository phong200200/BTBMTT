package app.bus;

import java.util.Date;
import java.util.List;

import app.dao.LSNguoiDungDAO;
import app.dto.LSNguoiDung;
import app.dto.LoaiLichSu;
import app.dto.NguoiDung;

public class LSNguoiDungBUS {
	public static int themLichSu(int id, int loaiId) {
		NguoiDung user = new NguoiDung();
		user.setNguoiDungId(id);
		LoaiLichSu loai = new LoaiLichSu();
		loai.setLoaiLichSuId(loaiId);
		LSNguoiDung ls = new LSNguoiDung();
		ls.setLoaiLichSu(loai);
		ls.setNguoiDung(user);
		ls.setThoiGian(new Date());
		return LSNguoiDungDAO.add(ls);
	}
	
	public static List<LSNguoiDung> layTatCaLichSu(){
		return LSNguoiDungDAO.layListTatCa();
	}
}
