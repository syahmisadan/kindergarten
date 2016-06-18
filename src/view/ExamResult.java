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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class ExamResult extends JFrame
{
        private JPanel contentPane;
	private JTable table;
    public ExamResult()
    {   
       	
//        ArrayList columnNames = new ArrayList();
//        ArrayList data = new ArrayList();

        //  Connect to an MySQL Database, run query, get result set
//        String url = "jdbc:mysql://localhost:3306/kindergarten";
//        String userid = "root";
//        String password = "root";
//        String sql = "SELECT * FROM student WHERE classroomID='C1'";
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO EXAMINATION OF KINDERGARTEN SYSTEM");
		lblNewLabel.setFont(new Font("Stencil Std", Font.BOLD, 16));
		lblNewLabel.setBounds(257, 11, 511, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnExamResult = new JButton("EXAM RESULT");
		btnExamResult.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Test-paper-icon.png"));
		btnExamResult.setBounds(148, 48, 180, 64);
		contentPane.add(btnExamResult);
		
		JButton btnRanking = new JButton("RANKING");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ranking rankingui = new Ranking();
				rankingui.setVisible(true);
				
			}
		});
		btnRanking.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Class-icon.png"));
		btnRanking.setBounds(649, 48, 148, 64);
		contentPane.add(btnRanking);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 111, 934, 16);
		contentPane.add(separator);
		
                
		
		JButton btnClassA = new JButton("CLASS A");
//		btnClassA.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnClassA.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Classroom-icon (1).png"));
		btnClassA.setBounds(37, 130, 142, 57);
		contentPane.add(btnClassA);
		
		JButton btnClassB = new JButton("CLASS B");
		btnClassB.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Classroom-icon (1).png"));
//		btnClassB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		btnClassB.setBounds(404, 130, 142, 57);
		contentPane.add(btnClassB);
		
		JButton btnNewButton = new JButton("CLASS C");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\A550\\Desktop\\OOP IMAGE\\Science-Classroom-icon (1).png"));
		btnNewButton.setBounds(727, 130, 142, 57);
		contentPane.add(btnNewButton);
		
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(679, 478, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(778, 478, 89, 23);
		contentPane.add(btnCancel);
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(37, 225, 835, 207);
		//contentPane.add(scrollPane);
		

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them

        
      //  JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(37, 225, 835, 207);
		//contentPane.add(scrollPane);
                
                
         btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String url = "jdbc:mysql://localhost:3306/kindergarten";
                          String userid = "root";
                          String password = "root";
                          String sql = "SELECT studentName FROM student WHERE classroomID='C3'";
                          
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
                columnNames.add("NAMA");
                String columnName = md.getColumnName(i);
                columnNames.add("BM");
                columnNames.add("BI");
                columnNames.add("ART");
                columnNames.add("MATH");
                columnNames.add("PERCENTAGE");
                columnNames.add("COMMENT");
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
                        scrollPane.setBounds(37, 225, 835, 207);
                        contentPane.add(scrollPane);
       // getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
                        
                            
			}
		});
                
        btnClassB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            String url = "jdbc:mysql://localhost:3306/kindergarten";
                          String userid = "root";
                          String password = "root";
                          String sql = "SELECT studentName FROM student WHERE classroomID='C2'";
                          
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
                columnNames.add("NAMA");
                String columnName = md.getColumnName(i);
                columnNames.add("BM");
                columnNames.add("BI");
                columnNames.add("ART");
                columnNames.add("MATH");
                columnNames.add("PERCENTAGE");
                columnNames.add("COMMENT");
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
                        scrollPane.setBounds(37, 225, 835, 207);
                        contentPane.add(scrollPane);
       // getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
                        
                            
			}
		});
        
        btnClassA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                         
                          String url = "jdbc:mysql://localhost:3306/kindergarten";
                          String userid = "root";
                          String password = "root";
                          String sql = "SELECT studentName, studentID FROM student WHERE classroomID='C1'";
                          
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
//                columnNames.add( md.getColumnName(i));
//                String columnName = md.(i);
//                String studentID = md.get(i);
                
//                columnNames.add("BM");
//                columnNames.add("BI");
//                columnNames.add("ART");
//                columnNames.add("MATH");
//                columnNames.add("PERCENTAGE");
//                columnNames.add("COMMENT");
                //model.addColumn("Col3", colData.toArray());
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
                        scrollPane.setBounds(37, 225, 835, 207);
                        contentPane.add(scrollPane);
       // getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
                        }
		});
        
    }

    public static void main(String[] args)
    {
        ExamResult frame = new ExamResult();
        frame.setSize(950, 560);
        //frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
       // frame.pack();
        frame.setVisible(true);
    }
}