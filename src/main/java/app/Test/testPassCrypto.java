package app.Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.gui.Crypto;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class testPassCrypto extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testPassCrypto frame = new testPassCrypto();
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
	public testPassCrypto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn = new JButton("New button");
		btn.setBounds(55, 97, 85, 21);
		contentPane.add(btn);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					// TODO Auto-generated method stub
					String string = new String(txtPass.getPassword());
					System.out.println("plaint: " + string);
					Crypto cr = new Crypto();

					String string2 = cr.setPass(string);
					System.out.println("Encrypted" + string2);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		txtPass = new JPasswordField();
		txtPass.setBounds(10, 56, 215, 19);
		contentPane.add(txtPass);
	}
}
