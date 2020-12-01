package studentReg;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class LoginForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField textPassword;
	final JLabel lblUSerNameCheck;
	final JLabel lblPasswordCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\symbols\\iconfinder_buddhism_religion_temple_buddha_ancient_landmark_japan_statue_5296675.png"));
		setTitle("MOHAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 132, 93, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lao UI", Font.BOLD, 23));
		lblNewLabel_1.setBounds(138, 27, 76, 48);
		panel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(35, 193, 93, 36);
		panel.add(lblPassword);
		
		textUserName = new JTextField();
		textUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==KeyEvent.VK_ENTER)
				{
					textPassword.requestFocus();
				}
			}
		});
		textUserName.setBounds(138, 134, 164, 36);
		panel.add(textUserName);
		textUserName.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassword.addKeyListener(new KeyAdapter() {
			@Override// EnterKey
//========================================================   Password Text fields ==============================================================
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER)
				{
					Connection con=MyConnector.getConnection();					
					PreparedStatement ps;
					try {
						ps=con.prepareStatement("SELECT * FROM `user` WHERE  username=? and password = ?");
						ps.setString(1, textUserName.getText());
						ps.setString(2, String.valueOf(textPassword.getPassword()));
						ResultSet rs= ps.executeQuery();
						if(rs.next())
						{
							MainForm mf= new MainForm();
							mf.setVisible(true);
							mf.pack();
							mf.setLocale(null);
							mf.setBounds(100, 100, 1204, 521);
							MainForm.lblWelcome.setText("<html>Welcome <br/>"+textUserName.getText().toUpperCase()+"</html>");
							MainForm.StudentCount.setText("Student Count : "+Integer.toString(MyFunction.countData("student")));
							MainForm.CourseCount.setText("Coures Count : "+Integer.toString(MyFunction.countData("user")));

							dispose();
						}else
						{
							JOptionPane.showMessageDialog(null,"Invaild user");
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					
				}
			}
		});
		textPassword.setColumns(10);
		textPassword.setBounds(138, 193, 164, 35);
		panel.add(textPassword);
		
		lblUSerNameCheck = new JLabel("Please Enter the UserName");
		lblUSerNameCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUSerNameCheck.setForeground(Color.RED);
		lblUSerNameCheck.setBounds(101, 86, 211, 35);
		panel.add(lblUSerNameCheck);
		
		lblPasswordCheck = new JLabel("Please Enter the Password");
		lblPasswordCheck.setForeground(Color.RED);
		lblPasswordCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPasswordCheck.setBounds(101, 237, 211, 19);
		panel.add(lblPasswordCheck);
		contentPane.setLayout(gl_contentPane);
		
		lblUSerNameCheck.setVisible(false);
		lblPasswordCheck.setVisible(false);
		
		JButton btnLoginButton = new JButton("Login");
		btnLoginButton.setIcon(new ImageIcon("E:\\symbols\\login.png"));
		btnLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblUSerNameCheck.setVisible(false);
				lblPasswordCheck.setVisible(false);
				
				if(textUserName.getText().equals(""))
				{
					lblUSerNameCheck.setVisible(true);
				}
				else if(String.valueOf(textPassword.getPassword()).equals(""))
				{
					lblPasswordCheck.setVisible(true);
				}else {
					Connection con=MyConnector.getConnection();					
					PreparedStatement ps;
					try {
						ps=con.prepareStatement("SELECT * FROM `user` WHERE  username=? and password = ?");
						ps.setString(1, textUserName.getText());
						ps.setString(2, String.valueOf(textPassword.getPassword()));
						ResultSet rs= ps.executeQuery();
						if(rs.next())
						{
							MainForm mf= new MainForm();
							mf.setVisible(true);
							mf.pack();
							mf.setLocale(null);
							mf.setBounds(100, 100, 1204, 521);
							MainForm.lblWelcome.setText("<html>Welcome <br/>"+textUserName.getText().toUpperCase()+"</html>");
							MainForm.StudentCount.setText("Student Count : "+Integer.toString(MyFunction.countData("student")));
							MainForm.CourseCount.setText("Coures Count : "+Integer.toString(MyFunction.countData("user")));

							dispose();
						}else
						{
							JOptionPane.showMessageDialog(null,"Invaild user");
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					
				}
			}
		});
		btnLoginButton.setBounds(193, 278, 101, 36);
		panel.add(btnLoginButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("E:\\symbols\\close.png"));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(58, 278, 101, 36);
		panel.add(btnCancel);
		
	
	}
}
