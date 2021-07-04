package com.example.MenuItem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
public class ChangePassword extends JPanel{
	
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblOldPassword=new JLabel("Old Password: ");
	JLabel lblNewPassword=new JLabel("New Password: ");
	JLabel lblConfirmPassword=new JLabel("Confirm Password: ");
	
	String value[]= {" ","Hassan","MD.","Sharfuddin","Miraz"};
	
	JComboBox cmbUserName=new JComboBox(value);
	JPasswordField txtOldPassword=new JPasswordField(20);
	JPasswordField txtNewPassword=new JPasswordField(20);
	JPasswordField txtConfirmPassword=new JPasswordField(20);
	
	JButton btnChangePassword = new JButton("Change Password",new ImageIcon("Images/reset1.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	
	
	public ChangePassword() {
		//setBackground(Color.yellow);
		setPreferredSize(new Dimension(1105,735));
		setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(lblUserName,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(cmbUserName,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(lblOldPassword,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(txtOldPassword,c);
		
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(lblNewPassword,c);
		
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(txtNewPassword,c);
		
		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(lblConfirmPassword,c);
		
		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(txtConfirmPassword,c);
		
		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(btnChangePassword,c);
		
		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		add(btnRefresh,c);
		
		
		
	}

}
