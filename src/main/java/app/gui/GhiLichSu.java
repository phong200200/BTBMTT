package app.gui;

import app.bus.LSNguoiDungBUS;

public class GhiLichSu {
	/**
	 * 1. Dang Nhap <br>
	 * 2. Dang xuat <br>
	 * 3. Tao tai khoan user
	 * @param idNguoiDung
	 * @param loaiLichSu
	 */
	public static void ghiLichSu(int idNguoiDung, int loaiLichSu) {
		try {
			LSNguoiDungBUS.themLichSu(idNguoiDung, loaiLichSu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
