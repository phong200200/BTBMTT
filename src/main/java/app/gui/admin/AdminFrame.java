package app.gui.admin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import app.dto.NguoiDung;
import app.gui.GhiLichSu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminFrame extends JFrame {
	private NguoiDung nguoiDung;
	private JPanel contentPane;
	public AdminFrame(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Theo dõi", null, new PanelTheoDoi(), null);
		tabbedPane.addTab("Tạo người dùng", null, new PanelTaoNguoiDung(), null);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDangXuatClicked();
			}
		});
		tabbedPane.addTab("Đăng xuất", null, btnDangXuat, null);
	}
	
	private void btnDangXuatClicked() {
		this.dispose();
		GhiLichSu.ghiLichSu(nguoiDung.getNguoiDungId(), 2);
		Admin frm = new Admin();
		frm.setVisible(true);
	}
}
