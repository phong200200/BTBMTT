package app.gui.nguoidung;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.dto.NguoiDung;
import app.gui.admin.PanelTaoNguoiDung;
import app.gui.admin.PanelTheoDoi;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NguoiDungFrame extends JFrame {

	private JPanel contentPane;

	
	private NguoiDung nguoiDung;
	public NguoiDungFrame(NguoiDung user,int idUserLogging) {
		this.nguoiDung = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		contentPane.add(tabbedPane);
		tabbedPane.addTab("Hello", null, new PanelHelloUser(), null);
		
		contentPane.add(tabbedPane);
		tabbedPane.addTab("Đổi thông tin", null, new PanelSuaThongTin(idUserLogging), null);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangXuatClicked();
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tabbedPane.addTab("Đăng xuất", null, btnDangXuat, null);
		
	}

	private void btnDangXuatClicked() {
		this.dispose();
		NguoiDungDangNhap frm = new NguoiDungDangNhap();
		frm.setVisible(true);
	}
}
