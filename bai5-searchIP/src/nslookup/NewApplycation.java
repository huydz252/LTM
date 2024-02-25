package nslookup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.awt.event.ActionEvent;

public class NewApplycation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTenMien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewApplycation frame = new NewApplycation();
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
	public NewApplycation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lablenameOfDomain = new JLabel("Tên Miền: ");
		lablenameOfDomain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lablenameOfDomain.setBounds(41, 37, 107, 49);
		contentPane.add(lablenameOfDomain);
		
		textFieldTenMien = new JTextField();
		textFieldTenMien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldTenMien.setBounds(145, 41, 209, 49);
		contentPane.add(textFieldTenMien);
		textFieldTenMien.setColumns(10);
		
		JTextArea textAreaKetQua = new JTextArea();
		textAreaKetQua.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaKetQua.setBounds(41, 100, 496, 122);
		contentPane.add(textAreaKetQua);
		
		JButton buttonSearchIP = new JButton("Search\r\n");
		buttonSearchIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenmien = textFieldTenMien.getText();
				
				try {
					 InetAddress ipAdress = InetAddress.getByName(tenmien);
					String ip = ipAdress.getHostAddress();
					textAreaKetQua.setText("IP: "+ip);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "khong tim thay dia chi IP");
				}
				
			}
		});
		buttonSearchIP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSearchIP.setBounds(405, 37, 132, 49);
		contentPane.add(buttonSearchIP);
		
		
	}
}
