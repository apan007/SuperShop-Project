 package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
public class Sales extends JPanel{
	
	JPanel panelNorth=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelSouth=new JPanel();
	JPanel panelWest =new JPanel();
	
	JPanel panelWestSouth =new JPanel();
	JPanel panelWestCenter =new JPanel();
	
	JPanel panelSouthSouth=new JPanel();
	JPanel panelSouthCenter=new JPanel();
	

	JPanel panelNorthWest=new JPanel();
	JPanel panelNorthCenter=new JPanel();
	
	JPanel panelSouthSouthWest=new JPanel();
	JPanel panelSouthSouthCenter=new JPanel();
	
	JPanel panelCenterNorth=new JPanel();
	JPanel panelCenterCenter=new JPanel();
	
	JCheckBox registerclient=new JCheckBox();
	JCheckBox unregisterclient=new JCheckBox();
	
	
	JButton btnSubmit1 = new JButton(" ",new ImageIcon("Images/Clockwise-arrow16.png"));
	JButton btnSubmit = new JButton("Submit",new ImageIcon("Images/Clockwise-arrow24.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDelete = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));
	JButton btnReport = new JButton("Report",new ImageIcon("Images/Save24.png"));
	JButton btnRefresh1 = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnConfirm = new JButton("Confirm",new ImageIcon("Images/Accept24.png"));
	
	
	JLabel lblRegisterClient=new JLabel("Register Client");
	JLabel lblUnregisterClient=new JLabel("Unregister Client");
	JLabel lblClientId=new JLabel("Client Id: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblGeneral=new JLabel("General");
	JLabel lblSalesReturnNo=new JLabel("SaleReturn No: ");
	JLabel lblProductId=new JLabel("Product Id: ");
	JLabel lblCategory=new JLabel("Category: ");
	JLabel lblSubCategory=new JLabel("Sub Category: ");
	JLabel lblUnit=new JLabel("Unit: ");
	JLabel lblStockQty=new JLabel("Stock Qty: ");
	JLabel lblSalesQty=new JLabel("Sales Qty: ");
	JLabel lblDealerPrice=new JLabel("Dealer Price: ");
	JLabel lblTradePrice=new JLabel("Trade Price: ");
	JLabel lblAmount=new JLabel("Amount: ");
	JLabel lblRemarks=new JLabel("Remarks: ");
	JLabel lblPaymentProtocol=new JLabel("Payment Protocol: ");
	JLabel lblReference=new JLabel("Reference: ");
	JLabel lblToatalAmount=new JLabel("Total Amount: ");
	JLabel lblDiscountAmount=new JLabel("Discount Amount: ");
	JLabel lblPaidAmount=new JLabel("Paid Amount: ");
	JLabel lblDue=new JLabel("Due: ");
	JLabel lblSalesReturn=new JLabel("SalesReturn No: ");
	JLabel lblDate=new JLabel("Date: ");
	
	JTextField txtClientId=new JTextField(10);
	JTextField txtUserName=new JTextField(10);
	JTextField txtSalesReturnNo=new JTextField(10);
	JTextField txtDate=new JTextField(10);
	JTextField txtUnit=new JTextField(10);
	JTextField txtStockQty=new JTextField(10);
	JTextField txtSalesQty=new JTextField(10);
	JTextField txtDealerPrice=new JTextField(10);
	JTextField txtTradePrice=new JTextField(10);
	JTextField txtAmount=new JTextField(10);
	JTextField txtRemarks=new JTextField(10);
	JTextField txtReference=new JTextField(10);
	JTextField txtTotalAmount=new JTextField(10);
	JTextField txtDiscountAmount=new JTextField(10);
	JTextField txtPaidAmount=new JTextField(10);
	JTextField txtDue=new JTextField(10);
	
	String value1[]= {" ","01","02","03"};
	String value2[]= {" ","ABC","XYZ","Others"};
	String value3[]= {" ","abc","xyz","Others"};
	String value4[]= {" ","i","ii","iii"};
	
	JLabel lblFromDate=new JLabel("From Date: ");
	JLabel lblToDate=new JLabel("To Date: ");
	
	JTextField txtSalesReturn=new JTextField(10);
	
	JDateChooser date = new JDateChooser();
	JDateChooser fromdate=new JDateChooser();
	JDateChooser todate =new JDateChooser();
	
	JComboBox cmbProductId=new JComboBox(value1);
	JComboBox cmbCategory=new JComboBox(value2);
	JComboBox cmbSubCategory=new JComboBox(value3);
	JComboBox cmbPaymentProtocol=new JComboBox(value4);
	
	String col[]={"ProductID","ProductName","CategoryID","CategoryName","SubCatName",
			"Unit","StockQty","SalesQty","DealerPrice","TradePrice","Remarks","Amount"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String col1[]={"SalesNo","Total Amount","DueAmount","Date"};
	Object row1[][];
	DefaultTableModel model1=new DefaultTableModel(row1,col1);
	JTable table1=new JTable(model1);
	JScrollPane scroll1=new JScrollPane(table1,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	JTextArea Remarks=new JTextArea(3,10);
	JScrollPane scroll2=new JScrollPane(Remarks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);
	
	
	
	public Sales() {
		setBackground(Color.blue);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new BorderLayout());
		add(panelNorth,BorderLayout.NORTH);
		panelNorthwork();
		add(panelCenter,BorderLayout.CENTER);
		panelCenterwork();
		add(panelSouth,BorderLayout.SOUTH);
		panelSouthwork();
		add(panelWest,BorderLayout.WEST);
		panelWestwork();
	}

	private void panelWestwork() {
		//panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWest.setPreferredSize(new Dimension (550,0));
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		panelWestSouthwork();
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWestCenterwork();
		}

	private void panelWestCenterwork() {
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestCenter.setLayout(grid);
		
		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblStockQty,c);
		
		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtStockQty,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblProductId,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbProductId,c);
		
		c.gridx=2;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSalesQty,c);
		
		c.gridx=3;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtSalesQty,c);
		
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblCategory,c);
		
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbCategory,c);
		
		c.gridx=2;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblDealerPrice,c);
		
		c.gridx=3;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtDealerPrice,c);
		
		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSubCategory,c);
		
		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSubCategory,c);
		
		c.gridx=2;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblTradePrice,c);
		
		c.gridx=3;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtTradePrice,c);
		
		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblUnit,c);
		
		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtUnit,c);
		
		c.gridx=2;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblAmount,c);
		
		c.gridx=3;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtAmount,c);
		
		c.gridx=2;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblRemarks,c);
		
		c.gridx=3;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(scroll2,c);
		Remarks.setLineWrap(true);
		
		
		
	}

	private void panelWestSouthwork() {
		//panelWestSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestSouth.setPreferredSize(new Dimension(0,80));
		FlowLayout flow = new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(20);
		panelWestSouth.add(btnSubmit);
		panelWestSouth.add(btnEdit);
		panelWestSouth.add(btnRefresh);
		panelWestSouth.add(btnDelete);
		panelWestSouth.add(btnReport);
		
	}

	private void panelNorthwork() {
		//panelNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelNorth.setPreferredSize(new Dimension(0,120));
		panelNorth.setLayout(new BorderLayout());
		panelNorth.add(panelNorthWest,BorderLayout.WEST);
		panelNorthWestwork();
		panelNorth.add(panelNorthCenter,BorderLayout.CENTER);
		panelNorthCenterwork();
		
	}

	private void panelNorthCenterwork() {
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelNorthCenter.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthCenter.add(lblSalesReturn,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthCenter.add(txtSalesReturn,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthCenter.add(lblDate,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthCenter.add(date,c);
		date.setDateFormatString("dd-MM-yyyy");
		date.setDate(new Date());
	}

	private void panelNorthWestwork() {
		//panelNorthWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelNorthWest.setPreferredSize(new Dimension(550,0));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelNorthWest.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(registerclient,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(unregisterclient,c);
		
		
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(lblRegisterClient,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(lblUnregisterClient,c);
		
		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(lblClientId,c);
		
		c.gridx=2;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(lblUserName,c);
		
		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(txtClientId,c);
		
		c.gridx=3;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(txtUserName,c);
		
		c.gridx=4;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(lblGeneral,c);
	}

	private void panelCenterwork() {
		//panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenter.setPreferredSize(new Dimension (550,0));
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelCenterNorth,BorderLayout.NORTH);
		panelCenterNorthwork();
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		panelCenterCenterwork();
	}

	private void panelCenterCenterwork() {
		FlowLayout flow =new FlowLayout();
		panelCenterCenter.setLayout(flow);
		flow.setVgap(0);
		panelCenterCenter.add(scroll1);
		scroll1.setPreferredSize(new Dimension(535,330));
	}

	private void panelCenterNorthwork() {
		panelCenterNorth.setPreferredSize(new Dimension(0,50));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelCenterNorth.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterNorth.add(lblFromDate,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterNorth.add(fromdate,c);
		fromdate.setDateFormatString("dd-MM-yyyy");
		fromdate.setDate(new Date());
		
		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterNorth.add(lblToDate,c);
		
		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterNorth.add(todate,c);
		todate.setDateFormatString("dd-MM-yyyy");
		todate.setDate(new Date());
		
		c.gridx=4;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterNorth.add(btnSubmit1,c);
	}

	private void panelSouthwork() {
		//panelSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouth.setPreferredSize(new Dimension(0,230));
		panelSouth.setLayout(new BorderLayout());
		panelSouth.add(panelSouthSouth,BorderLayout.SOUTH);
		panelSouthSouthwork();
		panelSouth.add(panelSouthCenter,BorderLayout.CENTER);
		panelSouthCenterwork();
		
	}

	private void panelSouthCenterwork() {
		FlowLayout flow =new FlowLayout();
		panelSouthCenter.setLayout(flow);
		flow.setVgap(0);
		panelSouthCenter.add(scroll);
		scroll.setPreferredSize(new Dimension(1100,145));
		
		
	}

	private void panelSouthSouthwork() {
		//panelSouthSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouthSouth.setPreferredSize(new Dimension(0,80));
		panelSouthSouth.setLayout(new BorderLayout());
		panelSouthSouth.add(panelSouthSouthWest,BorderLayout.WEST);
		panelSouthSouthWestwork();
		panelSouthSouth.add(panelSouthSouthCenter,BorderLayout.CENTER);
		panelSouthSouthCenterwork();
	}

	private void panelSouthSouthCenterwork() {
		FlowLayout flow = new FlowLayout();
		panelSouthSouthCenter.setLayout(flow);
		flow.setVgap(20);
		panelSouthSouthCenter.add(btnConfirm);
		panelSouthSouthCenter.add(btnRefresh1);
	}

	private void panelSouthSouthWestwork() {
		//panelSouthSouthWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouthSouthWest.setPreferredSize(new Dimension(750,0));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelSouthSouthWest.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(lblPaymentProtocol,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(cmbPaymentProtocol,c);
		
		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(lblToatalAmount,c);
		
		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(txtTotalAmount,c);
		
		c.gridx=4;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(lblPaidAmount,c);
		
		c.gridx=5;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(txtPaidAmount,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(lblReference,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(txtReference,c);
		
		c.gridx=2;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(lblDiscountAmount,c);
		
		c.gridx=3;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(txtDiscountAmount,c);
		
		c.gridx=4;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(lblDue,c);
		
		c.gridx=5;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthWest.add(txtDue,c);
	}

	}
