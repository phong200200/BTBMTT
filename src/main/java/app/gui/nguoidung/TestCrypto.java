package app.gui.nguoidung;

import app.gui.Crypto;

public class TestCrypto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "becauseditconmemetvailon";
		Crypto cr = new Crypto();
		try {
			System.out.println(a);
			String b = cr.setPass(a);
			System.out.println("â" + b);
			String c = cr.getPass(b);
			System.out.println(c);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
