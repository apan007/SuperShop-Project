package com.example.MenuItem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;
public class TaskReport extends JPanel{
	
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();
	
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnPreview = new JButton("Preview",new ImageIcon("Images/submit.png"));
	

	JButton btnRefresh2nd = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnPreview2nd= new JButton("Preview",new ImageIcon("Images/submit.png"));
	
	JDateChooser fromdate=new JDateChooser();
	JDateChooser todate =new JDateChooser();
	
	JLabel lblReportType=new JLabel("Report Type: ");
	JLabel lblFromDate=new JLabel("From Date: ");
	JLabel lblToDate=new JLabel("To Date: ");
	JLabel lblReportType1=new JLabel("Report Type: ");
	JLabel lblTranscation=new JLabel("Transaction No: ");
	
	SuggestText cmbReportType=new SuggestText();
	SuggestText cmbReportType1=new SuggestText();
	SuggestText cmbtransaction = new SuggestText();
			
	
	
	public TaskReport() {
		//setBackground(Color.red);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,0,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
	}

	private void panelWestwork() {
		//panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		//panelWest.setBackground(Color.green);
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWest.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(lblReportType,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(cmbReportType.cmbSuggest,c);
		//cmbReportType.cmbSuggest.setPreferredSize(new Dimension(250,20));

		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(lblFromDate,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(fromdate,c);
		fromdate.setDateFormatString("dd-MM-yyyy");
		fromdate.setDate(new Date());
		
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(lblToDate,c);
		
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(todate,c);
		todate.setDateFormatString("dd-MM-yyyy");
		todate.setDate(new Date());
		
		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(btnPreview,c);
		
		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWest.add(btnRefresh,c);
		
	}

	private void panelCenterwork() {
		//panelCenter.setBackground(Color.cyan);
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelCenter.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(lblReportType1,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(cmbReportType1.cmbSuggest,c);
		//cmbReportType1.cmbSuggest.setPreferredSize(new Dimension(250,20));
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(lblTranscation,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(cmbtransaction.cmbSuggest,c);
		
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(btnPreview2nd,c);
		
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(btnRefresh2nd,c);
		
		
	}

}
