package app.gui.admin;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.bus.LSNguoiDungBUS;
import app.dto.LSNguoiDung;

import java.awt.Font;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTheoDoi extends JPanel {
	private JTable table;

	public PanelTheoDoi() {
		setBounds(0, 0, 876, 528);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new DefaultTableModel(new Object[] {"Người dùng", "Ngày", "Lịch sử"}, 0));
		table.setRowHeight(35);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(744, 0, 122, 40);
		panel.add(btnNewButton);
		
		loadTable();
	}
	//===============================================================================
	private void loadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		List<LSNguoiDung> list = LSNguoiDungBUS.layTatCaLichSu();
		for (LSNguoiDung item : list) {
			model.addRow(new Object[] {
					item.getNguoiDung().getEmail(),
					item.getThoiGian(),
					item.getLoaiLichSu().getTenLoai()
			});
		}
	}
}
