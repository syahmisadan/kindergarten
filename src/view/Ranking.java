/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author lenovo
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Ranking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
					frame.setSize(750, 560);
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
	public Ranking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO EXAMINATION OF KINDERGARTEN SYSTEM");
		lblNewLabel.setFont(new Font("Stencil Std", Font.BOLD, 16));
		lblNewLabel.setBounds(121, 11, 511, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnExamResult = new JButton("EXAM RESULT");
		btnExamResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExamResult classAgui = new ExamResult();
				classAgui.setVisible(true);
			}
		});
		btnExamResult.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Test-paper-icon.png"));
		btnExamResult.setBounds(148, 48, 180, 64);
		contentPane.add(btnExamResult);
		
		JButton btnRanking = new JButton("RANKING");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnRanking.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Class-icon.png"));
		btnRanking.setBounds(423, 48, 148, 64);
		contentPane.add(btnRanking);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 111, 734, 16);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("CLASS C");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Classroom-icon (1).png"));
		btnNewButton.setBounds(563, 130, 142, 57);
		contentPane.add(btnNewButton);
		
		JButton btnClassB = new JButton("CLASS B");
		btnClassB.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Classroom-icon (1).png"));
		btnClassB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClassB.setBounds(296, 130, 142, 57);
		contentPane.add(btnClassB);
		
		JButton btnClassA = new JButton("CLASS A");
		btnClassA.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Classroom-icon (1).png"));
		btnClassA.setBounds(37, 130, 142, 57);
		contentPane.add(btnClassA);
		
		JLabel lblRankingClass = new JLabel("RANKING CLASS ");
		lblRankingClass.setFont(new Font("Stencil Std", Font.BOLD, 13));
		lblRankingClass.setBounds(297, 225, 117, 16);
		contentPane.add(lblRankingClass);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\print-icon (1).png"));
		btnNewButton_1.setBounds(659, 462, 65, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPrint = new JLabel(" PRINT");
		lblPrint.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		lblPrint.setBounds(669, 496, 55, 25);
		contentPane.add(lblPrint);
                
                 btnClassA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String url = "jdbc:mysql://localhost:3306/kindergarten";
                          String userid = "root";
                          String password = "root";
                          String sql = "select s.studentName,r.percentage from student s,result r where s.studentID=r.studentID order by percentage DESC";
                          
                        ArrayList columnNames = new ArrayList();
                        ArrayList data = new ArrayList();
                            
                        try (Connection connection = DriverManager.getConnection( url, userid, password );
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException f)
        {
            System.out.println( f.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
                            
                            
                            
			JScrollPane scrollPane = new JScrollPane( table );
                        scrollPane.setBounds(175, 250, 400,200);
                        contentPane.add(scrollPane);
       // getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
                        
                            
			}
		});
	}
}
