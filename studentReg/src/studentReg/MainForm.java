package studentReg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class MainForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JLabel StudentCount;
	public static JLabel CourseCount;
	public static JLabel lblWelcome;
	private JMenuBar menuBar;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setBackground(SystemColor.activeCaptionBorder);
		setForeground(SystemColor.info);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\symbols\\iconfinder_buddhism_religion_temple_buddha_ancient_landmark_japan_statue_5296675 (2).png"));
		setTitle("MOHAN UNIVERSITY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1204, 521);
		
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBackground(SystemColor.activeCaptionBorder);
		setJMenuBar(menuBar);
		
		JMenu StudentMenu = new JMenu("Students");
		StudentMenu.setBackground(Color.BLACK);
		StudentMenu.setIcon(new ImageIcon("E:\\symbols\\iconfinder_group2_309041.png"));
		StudentMenu.setFont(new Font("Serif", Font.BOLD, 15));
		menuBar.add(StudentMenu);
		
		JMenuItem AddStudentMenuItem = new JMenuItem("Add Students");
		AddStudentMenuItem.setAction(action);
		AddStudentMenuItem.setIcon(new ImageIcon("E:\\symbols\\iconfinder_add_group_309050.png"));
		StudentMenu.add(AddStudentMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		JLabel lblNewLabel = new JLabel("MOHAN UNIVERSITY");
		lblNewLabel.setBounds(37, 24, 386, 106);
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setIcon(new ImageIcon("E:\\symbols\\iconfinder_buddhism_religion_temple_buddha_ancient_landmark_japan_statue_5296675 (3).png"));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 24));
		panel.setSize(getMaximumSize());
		
		StudentCount = new JLabel("Student Count : ");
		StudentCount.setBounds(10, 219, 196, 73);
		StudentCount.setFont(new Font("Segoe Print", Font.BOLD, 19));
		
		CourseCount = new JLabel("Course Count : ");
		CourseCount.setBounds(10, 303, 196, 73);
		CourseCount.setFont(new Font("Segoe Print", Font.BOLD, 19));
		
		lblWelcome = new JLabel("Welcome  ");
		lblWelcome.setBounds(25, 117, 154, 106);
		lblWelcome.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 19));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(lblWelcome);
		panel.add(StudentCount);
		panel.add(CourseCount);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
	public class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Add Students");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			AddStudent AS= new AddStudent();
			AS.setVisible(true);
			AS.pack();
			AS.setLocale(null);
			AS.setBounds(100, 100, 503, 476);
			AS.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
	}
}
