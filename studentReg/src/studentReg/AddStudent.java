package studentReg;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextPane;



public class AddStudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstnametextbox;
	private JTextField Lastnametextbox;
	private JTextField phonenotextbox;
	public final JDateChooser dateChooser;
	final JTextPane Addresstextbox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\symbols\\iconfinder_buddhism_religion_temple_buddha_ancient_landmark_japan_statue_5296675 (2).png"));
		setTitle("MOHAN UNIVERSITY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 476);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Student Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(140, 31, 221, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(26, 91, 100, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblLastName.setBounds(26, 134, 100, 32);
		contentPane.add(lblLastName);
		
		JLabel lblSex = new JLabel("DOB :");
		lblSex.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblSex.setBounds(74, 166, 44, 32);
		contentPane.add(lblSex);
		
		JLabel lblSex_1 = new JLabel(" Sex :");
		lblSex_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblSex_1.setBounds(74, 197, 52, 32);
		contentPane.add(lblSex_1);
		
		JLabel lblPhoneNo = new JLabel("Phone No :");
		lblPhoneNo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblPhoneNo.setBounds(34, 240, 92, 32);
		contentPane.add(lblPhoneNo);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblAddress.setBounds(48, 275, 78, 32);
		contentPane.add(lblAddress);
		
		
		firstnametextbox = new JTextField();
		firstnametextbox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==KeyEvent.VK_ENTER)
				{
					Lastnametextbox.requestFocus();
				}
			}
		});
		firstnametextbox.setBounds(150, 90, 177, 30);
		contentPane.add(firstnametextbox);
		firstnametextbox.setColumns(10);
		
		
		
		Lastnametextbox = new JTextField();
		Lastnametextbox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==KeyEvent.VK_ENTER)
				{
					dateChooser.requestFocus();
				}
			}
		});
		Lastnametextbox.setColumns(10);
		Lastnametextbox.setBounds(150, 138, 177, 30);
		contentPane.add(Lastnametextbox);
		
		
		phonenotextbox = new JTextField();
		phonenotextbox.addKeyListener(new KeyAdapter() {
			// =================================== phone action(Allow only numbers)
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		phonenotextbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		phonenotextbox.setColumns(10);
		phonenotextbox.setBounds(150, 237, 177, 30);
		contentPane.add(phonenotextbox);

		
		Addresstextbox = new JTextPane();
		Addresstextbox.setBounds(150, 278, 177, 78);
		contentPane.add(Addresstextbox);
		
		JRadioButton MaleButton = new JRadioButton("Male");
		MaleButton.setBounds(150, 205, 66, 23);
		contentPane.add(MaleButton);
		
		final JRadioButton femaleButton = new JRadioButton("Female");
		femaleButton.setBounds(235, 205, 66, 23);
		contentPane.add(femaleButton);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon("E:\\symbols\\close.png"));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(101, 385, 110, 23);
		contentPane.add(btnCancel);
		
		//Button code
		ButtonGroup bg=new ButtonGroup();
		bg.add(MaleButton);
		bg.add(femaleButton);
		MaleButton.setSelected(true);
		
		//===================================================================  Date
	    dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 178, 177, 20);
		contentPane.add(dateChooser);
		
		
		//================================================ ADD Button
		JButton AddButton = new JButton("Add ");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname= firstnametextbox.getText();
				String lname= Lastnametextbox.getText();
				String phone= phonenotextbox.getText();
				String sex="Male";
				if(femaleButton.isSelected()) 
				{
					sex="Female";
				}
				if(VerifText())
				{
					Student stud=new Student();
					String address=Addresstextbox.getText();
					SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
					String bdate=dateformate.format(dateChooser.getDate());
					stud.insertUpdateDeleteStudent('i', null, fname, lname, sex, bdate, phone, address);	
					MainForm.StudentCount.setText("Student Count : "+Integer.toString(MyFunction.countData("student")));
					//dispose();

				}
		
				
			}
		});
		AddButton.setIcon(new ImageIcon("E:\\symbols\\iconfinder_add_group_309050.png"));
		AddButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		AddButton.setBounds(279, 385, 100, 23);
		contentPane.add(AddButton);
		
	}

	public boolean VerifText()
	{
		if(firstnametextbox.getText().equals("")||Lastnametextbox.getText().equals("")||phonenotextbox.getText().equals("")
				||Addresstextbox.getText().equals("")||dateChooser.getDate()==null) 
		{
			JOptionPane.showMessageDialog(null, "No Empty field !");
			return false;
		}
		else if(dateChooser.getDate().compareTo(new Date())>0) 
		{
			JOptionPane.showMessageDialog(null, "No Future Students Application Not Allowed");
			return false;
		}else
		{
		return true;
		}
		}
}
