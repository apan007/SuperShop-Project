package com.example.Admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginFrame extends JFrame{
	JPanel loginpanel = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelNorth = new JPanel();
	JPanel panelSouth = new JPanel();
	JLabel lblwelcome= new JLabel("WELCOME TO SUPERSHOP");
	JLabel lblIcon = new JLabel(new ImageIcon("Images/super.png"));
	JButton btnLogin = new JButton("Log In",new ImageIcon("Images/button_ok.png"));
	JButton btnCancel = new JButton("Cancel",new ImageIcon("Images/cancel-icon.png"));
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	JLabel lblUsername=new JLabel("Username: ");
	JLabel lblPassword=new JLabel("Passowrd: ");
	JLabel lblUsertype=new JLabel("Usertype: ");

	JTextField txtUsername=new JTextField(20);
	JPasswordField txtPassword=new JPasswordField(20);
	SuggestText cmbUsertype=new SuggestText();


	public LoginFrame() {
		init();
		cmp();
		btnAction();
	}
	private void btnAction() {
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginAction();

			}

		});

	}

	private void loginAction() {
		loginpanel.setVisible(false);
		WorkingPanel wp=new WorkingPanel(this);
		add(wp);
		wp.setVisible(true);
		setSize(screen);
		setLocationRelativeTo(null);
		setTitle("WELCOME TO SUPERSHOP");

	}
	private void cmp() {
		add(loginpanel);
		loginpanel.setLayout(new BorderLayout());
		loginpanel.add(panelCenter,BorderLayout.CENTER);
		panelCenterwork();
		loginpanel.add(panelWest,BorderLayout.WEST);
		panelWestwork();
		loginpanel.add(panelNorth,BorderLayout.NORTH);
		panelNorthwork();
		loginpanel.add(panelSouth,BorderLayout.SOUTH);
		panelSouthwork();

	}
	private void panelCenterwork() {
		panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelCenter.setLayout(grid);

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(lblUsername,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(txtUsername,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(lblPassword,c);

		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(txtPassword,c);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(lblUsertype,c);

		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(cmbUsertype.cmbSuggest,c);
		//cmbUsertype.cmbSuggest.setPreferredSize(new Dimension(300,20));
	}
	private void panelWestwork() {
		panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWest.setPreferredSize(new Dimension(140,0));
		FlowLayout flow = new FlowLayout();
		panelWest.setLayout(flow);
		flow.setVgap(45);
		panelWest.add(lblIcon);
	}
	private void panelNorthwork() {
		panelNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelNorth.setPreferredSize(new Dimension(0,40));
		panelNorth.add(lblwelcome);
		FlowLayout fl=new FlowLayout();
		panelNorth.setLayout(fl);
		fl.setVgap(10);
		lblwelcome.setFont(new Font("Cooper Black",Font.BOLD+Font.ITALIC,15));

	}
	private void panelSouthwork() {
		panelSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouth.setPreferredSize(new Dimension(0,55));
		FlowLayout flow = new FlowLayout();
		panelSouth.setLayout(flow);
		panelSouth.add(btnLogin);
		panelSouth.add(btnCancel);

	}

	private void init() {
		setSize(500,300);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);

	}
}
