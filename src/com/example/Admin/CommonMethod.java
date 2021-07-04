package com.example.Admin;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.example.Main.DbConnection;
public class CommonMethod {

	public static String autoId(String sql,String caption,JTextField txt) {
		String id="";
		try {
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				txt.setText(caption+"-"+rs.getString("id"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
		return id;
	}
	public static boolean isExistName(String sql) {
		try {
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				JOptionPane.showMessageDialog(null, "Data Already Exists","Sorry...",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
		return true;
	}
	public static boolean checkConfirmation(String caption) {
		int a=JOptionPane.showConfirmDialog(null, caption,"Confirmation...",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	public static boolean insertData(String sql)
	{
		try {
			DbConnection.connect();
			DbConnection.Sta.executeUpdate(sql);
			DbConnection.Con.close();
			return true;
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
	}
}
