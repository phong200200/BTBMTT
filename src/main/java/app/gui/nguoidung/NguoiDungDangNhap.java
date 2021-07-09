package app.gui.nguoidung;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import app.bus.NguoiDungBUS;
import app.dto.NguoiDung;
import app.gui.Crypto;
import app.gui.GhiLichSu;
import app.gui.admin.AdminFrame;

public class NguoiDungDangNhap extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtUser;
	private JPasswordField txtPass;
	
	Crypto cr = new Crypto();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
					NguoiDungDangNhap frame = new NguoiDungDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NguoiDungDangNhap() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 46, 93, 25);
		contentPane.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMtKhu.setBounds(10, 98, 93, 25);
		contentPane.add(lblMtKhu);

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginClicked();
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDangNhap.setBounds(150, 160, 160, 49);
		contentPane.add(btnDangNhap);

		JButton btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(361, 160, 160, 49);
		contentPane.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnExitClicked();
			}
		});
		
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUser.setBounds(150, 40, 463, 36);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPass.setBounds(150, 92, 463, 36);
		contentPane.add(txtPass);
		
		
	}

	protected void btnExitClicked() {
		// TODO Auto-generated method stub
		
	}

	private void btnLoginClicked() {
		// TODO Auto-generated method stub
		
		try {
			String pass = new String(txtPass.getPassword());
			//băm cái pass ở đây
			
			
			String encrPass = cr.setPass(new String(txtPass.getPassword()));
			//===============================
			NguoiDung userLogin = NguoiDungBUS.nguoiDungDangNhap(txtUser.getText(), encrPass);
			if (userLogin == null) {
				JOptionPane.showMessageDialog(this, "Sai tên tài khoản hoặc mật khẩu!");
			} else if (userLogin.getVaiTro().getId() == 1) {
				JOptionPane.showMessageDialog(this, "Chào Admin");
				this.dispose();
				AdminFrame frm = new AdminFrame(userLogin);
				frm.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Chào " + userLogin.getTen());
				//ghi lịch sử
				GhiLichSu.ghiLichSu(userLogin.getNguoiDungId(), 1);
				//====================
				this.dispose();
				
				NguoiDungFrame frm = new NguoiDungFrame(userLogin);
				frm.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
}
