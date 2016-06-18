import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Report extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentsReport = new JLabel("STUDENT'S REPORT");
		lblStudentsReport.setFont(new Font("Lithos Pro Regular", Font.BOLD, 14));
		lblStudentsReport.setBounds(269, 11, 157, 25);
		contentPane.add(lblStudentsReport);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\User-Preppy-Red-icon (1).png"));
		lblNewLabel.setBounds(279, 31, 128, 128);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(248, 170, 203, 32);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
			},
			new String[] {
				""
			}
		));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 674, 142);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, ""},
			},
			new String[] {
				"SUBJECT", "MARKS", "GRADE"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(293);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(104);
		scrollPane.setViewportView(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 366, 674, 45);
		contentPane.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"TESRCHER'S COMMENT"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblteachersName = new JLabel("(TEACHER'S NAME)");
		lblteachersName.setBounds(40, 499, 166, 14);
		contentPane.add(lblteachersName);
		
		JLabel lblguardiansName = new JLabel("(GUARDIAN'S NAME)");
		lblguardiansName.setBounds(530, 499, 157, 14);
		contentPane.add(lblguardiansName);
		
		JLabel lblNewLabel_1 = new JLabel("_________________________");
		lblNewLabel_1.setBounds(24, 474, 351, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("____________________________");
		lblNewLabel_2.setBounds(501, 474, 233, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\print-icon (1).png"));
		btnNewButton.setBounds(649, 509, 65, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblPrint = new JLabel("  PRINT");
		lblPrint.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		lblPrint.setBounds(654, 547, 60, 23);
		contentPane.add(lblPrint);
	}
}
