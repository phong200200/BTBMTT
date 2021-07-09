package app.gui.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import app.bus.NguoiDungBUS;
import app.dto.NguoiDung;
import app.gui.GhiLichSu;

import javax.swing.JPasswordField;


public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTK;
	private JPasswordField txtMK;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(180, 72, 93, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMtKhu.setBounds(180, 140, 93, 25);
		contentPane.add(lblMtKhu);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangNhapClicked();
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDangNhap.setBounds(283, 175, 160, 49);
		contentPane.add(btnDangNhap);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(586, 175, 160, 49);
		contentPane.add(btnExit);
		
		txtTK = new JTextField();
		txtTK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTK.setBounds(283, 61, 463, 36);
		contentPane.add(txtTK);
		txtTK.setColumns(10);
		
		txtMK = new JPasswordField();
		txtMK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMK.setBounds(283, 129, 463, 36);
		contentPane.add(txtMK);
	}
	
	//====================================================================================================================
	private void btnDangNhapClicked() {
		try {
			String pass = new String(txtMK.getPassword());
			//băm cái pass ở đây
			
			//===============================
			NguoiDung user = NguoiDungBUS.nguoiDungDangNhap(txtTK.getText(), pass);
			if (user == null) {
				JOptionPane.showMessageDialog(this, "Sai tên tài khoản hoặc mật khẩu!");
			} else if (user.getVaiTro().getId() != 1) {
				JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào ứng dụng này!");
			} else {
				JOptionPane.showMessageDialog(this, "Chào " + user.getTen());
				//ghi lịch sử
				GhiLichSu.ghiLichSu(user.getNguoiDungId(), 1);
				//====================
				this.dispose();
				AdminFrame frm = new AdminFrame(user);
				frm.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	//====================================================================================================================
}
