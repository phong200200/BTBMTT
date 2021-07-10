package app.gui.admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import app.bus.NguoiDungBUS;
import app.dto.NguoiDung;
import app.dto.VaiTro;
import app.gui.Crypto;
import app.gui.Crypto;
import app.gui.GhiLichSu;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTaoNguoiDung extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTen;
	private JTextField txtEmail;
	private JPasswordField txtMK;
	private JPasswordField txtXacNhan;

	public PanelTaoNguoiDung() {
		setBounds(0, 0, 876, 528);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 125, 46);
		add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 66, 125, 46);
		add(lblEmail);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(10, 122, 125, 46);
		add(lblMtKhu);
		
		JLabel lblXcNhn = new JLabel("Xác nhận");
		lblXcNhn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXcNhn.setBounds(10, 187, 125, 46);
		add(lblXcNhn);
		
		txtTen = new JTextField();
		txtTen.setBounds(145, 19, 541, 37);
		add(txtTen);
		txtTen.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(145, 75, 541, 37);
		add(txtEmail);
		
		txtMK = new JPasswordField();
		txtMK.setBounds(145, 131, 541, 37);
		add(txtMK);
		
		txtXacNhan = new JPasswordField();
		txtXacNhan.setBounds(145, 196, 541, 37);
		add(txtXacNhan);
		
		JButton btnTaoTK = new JButton("Tạo TK");
		btnTaoTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTaoTKClicked();
			}
		});
		btnTaoTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTaoTK.setBounds(561, 243, 125, 51);
		add(btnTaoTK);
	}

	private void btnTaoTKClicked() {
		try {
			if (txtEmail.getText().isBlank() || txtTen.getText().isBlank() || new String(txtMK.getPassword()).isBlank() ||  new String(txtXacNhan.getPassword()).isBlank()) {
				throw new Exception("Vui lòng nhập đủ thông tin");
			}
			if (new String(txtMK.getPassword()).compareTo(new String(txtXacNhan.getPassword())) != 0){
				throw new Exception("Mật khẩu không khớp");
			}
			NguoiDung user = new NguoiDung();
			user.setTen(txtTen.getText());
			user.setEmail(txtEmail.getText());
			user.setVaiTro(new VaiTro(2));
			Crypto cr = new Crypto();
			String EncrPass = cr.setPass(new String(txtMK.getPassword()));
			
			user.setMatKhau(EncrPass);
			
			NguoiDungBUS.themNguoiDung(user);
			
			//ghi lich su
			GhiLichSu.ghiLichSu(Admin.getNguoiDungHienTai().getNguoiDungId(), 3);
			
			JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
