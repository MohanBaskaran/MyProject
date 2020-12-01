package studentReg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class manageStudents extends JFrame {
	
	Student std= new Student();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FirstNameText;
	private JTextField LastNameText;
	private JTextField PhoneText;
	private JTextField IDText;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageStudents frame = new manageStudents();
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
	public manageStudents() {
		setBackground(SystemColor.activeCaptionBorder);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(0, 0, 1064, 497);
		contentPane.add(panel);
		JLabel lblManageStudents = new JLabel("Manage Students");
		lblManageStudents.setFont(new Font("Times New Roman", Font.BOLD, 36));
		
		JLabel label_1 = new JLabel("First Name :");
		label_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		
		JLabel label_2 = new JLabel("Last Name :");
		label_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		
		JLabel label_3 = new JLabel("DOB :");
		label_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		
		JLabel label_4 = new JLabel(" Sex :");
		label_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		
		JLabel label_5 = new JLabel("Phone No :");
		label_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		
		JLabel label_6 = new JLabel("Address :");
		label_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		
		FirstNameText = new JTextField();
		FirstNameText.setColumns(10);
		
		LastNameText = new JTextField();
		LastNameText.setColumns(10);
		
		PhoneText = new JTextField();
		PhoneText.setColumns(10);
		
		final JTextPane AddressText = new JTextPane();
		
		final JRadioButton MaleButton = new JRadioButton("Male");
		MaleButton.setSelected(true);
		
		final JRadioButton femaleButton_1 = new JRadioButton("Female");
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setIcon(new ImageIcon("E:\\symbols\\close.png"));
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		final JDateChooser dateChooser = new JDateChooser();
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.setIcon(new ImageIcon("E:\\symbols\\iconfinder_add_group_309050.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblStudentId = new JLabel("Student ID :");
		lblStudentId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		
		IDText = new JTextField();
		IDText.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnEdit.setIcon(new ImageIcon("E:\\symbols\\iconfinder_user_profile_edit_103781.png"));
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 551, 383);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				int rowIndex = table.getSelectedRow();
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				if(model.getValueAt(rowIndex, 3).toString().equals("Male"))
				{
					femaleButton_1.setSelected(false);
					MaleButton.setSelected(true);
				}
				else 
				{
					MaleButton.setSelected(false);
					femaleButton_1.setSelected(true);
				}
				IDText.setText(model.getValueAt(rowIndex, 0).toString());
				FirstNameText.setText(model.getValueAt(rowIndex, 1).toString());
				LastNameText.setText(model.getValueAt(rowIndex, 2).toString());
			//	dateChooser.setDateFormatString(model.getValueAt(rowIndex, 4).toString());
				PhoneText.setText(model.getValueAt(rowIndex, 5).toString());
				AddressText.setText(model.getValueAt(rowIndex, 6).toString());
			}
		});
		table.setBorder(new EmptyBorder(10, 10, 10, 10));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Sex", "DOB", "Phone No", "Address"
			}
		));
		table.setBackground(SystemColor.scrollbar);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		std.fillStudentJtable(table, "");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(346)
					.addComponent(lblManageStudents, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStudentId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(IDText, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(FirstNameText, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(48)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_3))))
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(LastNameText, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(MaleButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addGap(19)
									.addComponent(femaleButton_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addGap(32)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblManageStudents, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblStudentId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addComponent(IDText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addComponent(FirstNameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(31)
											.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(LastNameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(MaleButton)
										.addComponent(femaleButton_1))))
							.addGap(8)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addComponent(PhoneText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addGap(29)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
	}
}
