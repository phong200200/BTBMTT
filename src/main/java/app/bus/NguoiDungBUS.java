package app.bus;

import app.dao.NguoiDungDAO;
import app.dto.NguoiDung;

public class NguoiDungBUS {
	public static NguoiDung nguoiDungDangNhap(String email, String pass) {
		return NguoiDungDAO.layNguoiDungDangNhap(email, pass);
	}
}
