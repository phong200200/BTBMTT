package app.Test;

import java.util.*;

import app.gui.Crypto;

public class TestCrypto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap thu gi do");
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		Crypto cr = new Crypto();
		try {
			System.out.println("Original text: " + a);
			String b = cr.setPass(a);
			System.out.println("Crypted text: " + b);
			String c = cr.getPass(b);
			System.out.println("Encrypted text: " + c);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
