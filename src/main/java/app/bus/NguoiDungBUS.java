package app.bus;

import app.dao.NguoiDungDAO;
import app.dto.NguoiDung;

public class NguoiDungBUS {
	public static NguoiDung nguoiDungDangNhap(String email, String pass) {
		return NguoiDungDAO.layNguoiDungDangNhap(email, pass);
	}
	
	public static int themNguoiDung(NguoiDung nguoiDung) {
		return NguoiDungDAO.add(nguoiDung);
	}
	
	public static void updateNguoiDung(NguoiDung nguoiDung) {
		NguoiDungDAO.update(nguoiDung);
	}
}
