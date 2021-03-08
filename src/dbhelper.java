/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author murli
 */
public class dbhelper extends JFrame{
    Connection cn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    String sql;
    long cnt=0;
      String url ="jdbc:mysql://localhost:3306/petrolpump?zeroDateTimeBehavior=convertToNull";

        public dbhelper()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
                        cn=DriverManager.getConnection(url,"root","");
		}
		catch(Exception ex)
		{}
	}

        public void updateRecord(String qry)
	{
		try
		{
			stmt=cn.createStatement();
                        stmt.executeUpdate(qry);
                        JOptionPane.showMessageDialog(this, "Data Update SuceessFully");
			
		}
		catch(Exception ex)
		{
                    System.out.println(ex);
                    //cnt=0;
                }
		//return cnt;
	}
        
       public void InsertData(String query)
{
  
        // Connection con=null;
        try {
    //       con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","murli@007");
        
        Statement st=null;
        st=cn.createStatement();
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(this, "Data Saved SuceessFully");

        }
        catch (Exception ex) {
        System.out.println(ex);
        
        }
}
       
       public void DeletreData(String query)
{
  
        // Connection con=null;
        try {
    //       con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","murli@007");
        
        Statement st=null;
        st=cn.createStatement();
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(this, "Data Delete SuceessFully");

        }
        catch (Exception ex) {
        System.out.println(ex);
        }
}
       
  
       
 
     public void getTable(JTable name,String s)
    {
        try
        {
            
        stmt=cn.createStatement();
        rs=stmt.executeQuery(s);
            System.out.println(rs);
        name.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception ex)
         {
             System.out.print(ex);
         }

    }
  
  
  public  void getimagedata(String sql,String imgg,JLabel photo)
  {
   try
   {
                 Statement st = cn.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 if(rs.next()){
                 byte[] img = rs.getBytes(imgg);

                     //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    photo.setIcon(newImage);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"No Data Found");
                }
                }
                catch(Exception ex)
                {
                 System.out.println(ex);
                }
        }
	public ResultSet getRecords(String qry)
	{
		try
		{
			stmt=cn.createStatement();
			rs=stmt.executeQuery(qry);   
		}
		catch(Exception ex)
		{
               
                }
		return rs;
	}
        public ResultSet DataFound(String qry)
        {
                try
                {
                PreparedStatement pst=null;
         
                stmt=cn.createStatement();
	
                rs = stmt.executeQuery(qry);
      //     System.out.println(qry);
                }
                catch(Exception ex)
                {
              
                }
	return rs;
}
        public long GetRecordCount(String qry1)
        {
            try
            {
                stmt=cn.createStatement();
                rs=stmt.executeQuery(qry1);
                while(rs.next())
                {
                    ++cnt;
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return cnt;
        }
        
        
        public void FillCombo(JComboBox cmb,String qry,String Display)
        {  

            try {
                Statement stat=null;
                cn = DriverManager.getConnection(url,"root","");
                 stat = cn.createStatement();
                ResultSet rs = stat.executeQuery(qry);
                while(rs.next()){
                 cmb.addItem(rs.getString(Display));
        }
    //rs.close();
   // stat.close();
   // cn.close();
         
  } catch (Exception e) {

      System.out.println(e);
    }
}
        
         public void Close()
	{
		try
		{
			cn.close();
		}
		catch(Exception ex)
		{
                    System.out.println("error   : "+ex);
                }

	}
}
