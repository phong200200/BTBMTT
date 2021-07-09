package app.gui;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import java.util.Base64;
public class Crypto {

	static String key = "Tt3rLPrDIVIhXqAz";
	
	static String EncryptData(String plainText) throws Exception {

		byte[] keyBytes = key.getBytes("UTF-8");
		if (keyBytes.length == 16) { // short key ? .. extend to 24 byte key
			byte[] tmpKey = new byte[24];
			System.arraycopy(keyBytes, 0, tmpKey, 0, 16);
			System.arraycopy(keyBytes, 0, tmpKey, 16, 8);
			keyBytes = tmpKey;
		}

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");

		if (keyBytes.length > 8) {
			byte[] tmpKey = new byte[8];
			System.arraycopy(keyBytes, 0, tmpKey, 0, 8);
			keyBytes = tmpKey;
		}

		IvParameterSpec ips = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(plainText.getBytes("UTF-8"));

		return Base64.getEncoder().encodeToString(bOut);
	}

	private String decrypter(String strEncrypted) throws Exception {
		byte[] keyBytes = key.getBytes("UTF-8");
		if (keyBytes.length == 16) { // short key ? .. extend to 24 byte key
			byte[] tmpKey = new byte[24];
			System.arraycopy(keyBytes, 0, tmpKey, 0, 16);
			System.arraycopy(keyBytes, 0, tmpKey, 16, 8);
			keyBytes = tmpKey;
		}

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");

		if (keyBytes.length > 8) {
			byte[] tmpKey = new byte[8];
			System.arraycopy(keyBytes, 0, tmpKey, 0, 8);
			keyBytes = tmpKey;
		}

		IvParameterSpec ips = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(Base64.getDecoder().decode(strEncrypted));

		return new String(bOut, "UTF-8");

	}

	public String getPass(String originPass) throws Exception {
		return decrypter(originPass);

	}

	public String setPass(String originPass) throws Exception {
		return EncryptData(originPass);
	}
}
