package app.gui.nguoidung;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.hibernate.Session;

import app.bus.NguoiDungBUS;
import app.dto.NguoiDung;
import app.dto.VaiTro;
import app.gui.Crypto;
import app.gui.GhiLichSu;

public class PanelSuaThongTin extends JPanel {

	private JTextField txtTen;
	private JTextField txtEmail;
	private JPasswordField txtMK;
	private JPasswordField txtXacNhan;	
	
	/**
	 * Create the panel.
	 */
	public PanelSuaThongTin(int idUserLogging) {
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
		
		JButton btnSuaTT = new JButton("Sửa");
		btnSuaTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaTTClicked(idUserLogging);
			}
		});
		btnSuaTT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSuaTT.setBounds(561, 243, 125, 51);
		add(btnSuaTT);
	}

	

	protected void btnSuaTTClicked(int idUserLogging) {
		// TODO Auto-generated method stub
		JOptionPane pane = new JOptionPane("Are u sure?",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
		
			try {
				if (txtEmail.getText().isBlank() || txtTen.getText().isBlank() || new String(txtMK.getPassword()).isBlank() ||  new String(txtXacNhan.getPassword()).isBlank()) {
					throw new Exception("Vui lòng nhập đủ thông tin");
				}
				if (new String(txtMK.getPassword()).compareTo(new String(txtXacNhan.getPassword())) != 0){
					throw new Exception("Mật khẩu không khớp");
				}
				
				NguoiDung user = new NguoiDung();
				user.setNguoiDungId(idUserLogging);
				user.setTen(txtTen.getText());
				user.setEmail(txtEmail.getText());
				user.setVaiTro(new VaiTro(2));
				
				Crypto cr = new Crypto();
				user.setMatKhau(cr.setPass(new String(txtMK.getPassword())));
				
				NguoiDungBUS.updateNguoiDung(user);
				
				//ghi lich su
				GhiLichSu.ghiLichSu(idUserLogging, 4);
				
				JOptionPane.showMessageDialog(this, "Đổi thông tin thành công");
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		
	}

}
