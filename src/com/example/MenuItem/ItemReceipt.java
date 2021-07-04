package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.example.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;
public class ItemReceipt extends JPanel{
	
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
	
	JButton btnSubmit1 = new JButton(" ",new ImageIcon("Images/Clockwise-arrow16.png"));
	JButton btnSubmit = new JButton("Submit",new ImageIcon("Images/Clockwise-arrow24.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDelete = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));
	JButton btnReport = new JButton("Report",new ImageIcon("Images/Save24.png"));
	JButton btnRefresh1 = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnConfirm = new JButton("Confirm",new ImageIcon("Images/Accept24.png"));
	JButton btnDone = new JButton("Done",new ImageIcon("Images/semi-success24.png"));
	
	
	JLabel lblInvoiceNO=new JLabel("Invoice No: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblGeneral = new JLabel("General");
	JLabel lblDate=new JLabel("Date: ");
	JLabel lblInvoiceDate=new JLabel("Invoice Date: ");
	JLabel lblTotalAmount=new JLabel("Total Amount: ");
	
	JLabel lblProductID=new JLabel("Product ID: ");
	JLabel lblCategory=new JLabel("Category: ");
	JLabel lblSubCategory=new JLabel("Sub Category: ");
	JLabel lblUnit=new JLabel("Unit: ");
	JLabel lblStock=new JLabel("Stock: ");
	JLabel lblDealerPrice=new JLabel("Dealer Price: ");
	JLabel lblInvoiceQuantity=new JLabel("Invoice Quantity: ");
	JLabel lblReceiveQuantity=new JLabel("Receive Quantity: ");
	JLabel lblAmount=new JLabel("Amount: ");
	JLabel lblSoqty=new JLabel("S/O Qty: ");
	JLabel lblPresentStock=new JLabel("Present Stock: ");
	JLabel lblSupplierName=new JLabel("Supplier Name: ");
	JLabel lblRemarks=new JLabel("Remarks: ");
	
	JLabel lblFromDate=new JLabel("From Date: ");
	JLabel lblToDate=new JLabel("To Date: ");
	
	JDateChooser date = new JDateChooser();
	JDateChooser invoicedate = new JDateChooser();
	JDateChooser fromdate=new JDateChooser();
	JDateChooser todate =new JDateChooser();
	
	JTextField txtUnit=new JTextField(10);
	JTextField txtStock=new JTextField(10);
	JTextField txtDealerPrice=new JTextField(10);
	JTextField txtInvoiceQty=new JTextField(10);
	JTextField txtReceiveQty=new JTextField(10);
	JTextField txtAmount=new JTextField(10);
	JTextField txtSoqty=new JTextField(10);
	JTextField txtPresentStock=new JTextField(10);

	JTextField txtInvoiceNo=new JTextField(10);
	JTextField txtUserName=new JTextField(10);
	JTextField txtTotalAmount=new JTextField(30);
	JTextField txtFromDate=new JTextField(10);
	JTextField txtToDate=new JTextField(10);
	
	
	SuggestText cmbProductId=new SuggestText();
	SuggestText cmbCategory=new SuggestText();
	SuggestText cmbSubCategory=new SuggestText();
	SuggestText cmbSupplierName=new SuggestText();
	
	String col[]={"ProductID","ProductName","Unit","StoctQty","DealerPrice","InvoiceQty","ReceiveQty","ShortQty",
			"PresentStock","SuppierId","SupplierName","Remarks","Amount"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String col1[]={"Invoice","Total Amount","Date"};
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
	
	
	public ItemReceipt() {
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
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblProductID,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbProductId.cmbSuggest,c);
		
		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblInvoiceQuantity,c);
		
		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtInvoiceQty,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblCategory,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbCategory.cmbSuggest,c);
		
		c.gridx=2;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblReceiveQuantity,c);
		
		c.gridx=3;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtReceiveQty,c);
		
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSubCategory,c);
		
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSubCategory.cmbSuggest,c);
		
		c.gridx=2;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblAmount,c);
		
		c.gridx=3;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtAmount,c);
		
		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblUnit,c);
		
		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtUnit,c);
		
		c.gridx=2;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSoqty,c);
		
		c.gridx=3;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtSoqty,c);
		
		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblStock,c);
		
		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtStock,c);
		
		c.gridx=2;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblPresentStock,c);
		
		c.gridx=3;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtPresentStock,c);
		
		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblDealerPrice,c);
		
		c.gridx=1;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtDealerPrice,c);
		
		c.gridx=2;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSupplierName,c);
		
		c.gridx=3;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSupplierName.cmbSuggest,c);
		
		c.gridx=2;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblRemarks,c);
		
		c.gridx=3;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(scroll2,c);
		Remarks.setLineWrap(true);
		
	}

	private void panelWestSouthwork() {
		//panelWestSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestSouth.setPreferredSize(new Dimension(0,60));
		FlowLayout flow = new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(10);
		panelWestSouth.add(btnSubmit);
		panelWestSouth.add(btnEdit);
		panelWestSouth.add(btnRefresh);
		panelWestSouth.add(btnDelete);
		panelWestSouth.add(btnReport);
		
	}

	private void panelNorthwork() {
		//panelNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelNorth.setPreferredSize(new Dimension(0,60));
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
		panelNorthCenter.add(lblDate,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthCenter.add(date,c);
		date.setDateFormatString("dd-MM-yyyy");
		date.setDate(new Date());
		
		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthCenter.add(lblInvoiceDate,c);
		
		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthCenter.add(invoicedate,c);
		invoicedate.setDateFormatString("dd-MM-yyyy");
		invoicedate.setDate(new Date());
		
		
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
		panelNorthWest.add(lblInvoiceNO,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(txtInvoiceNo,c);
		
		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(lblUserName,c);
		
		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthWest.add(txtUserName,c);
		
		c.gridx=4;
		c.gridy=0;
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
		scroll1.setPreferredSize(new Dimension(535,380));
	}

	private void panelCenterNorthwork() {
		//panelCenterNorth.setBorder(BorderFactory.createRaisedBevelBorder());
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
		scroll.setPreferredSize(new Dimension(1100,170));
		
	}

	private void panelSouthSouthwork() {
		//panelSouthSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouthSouth.setPreferredSize(new Dimension(0,60));
		panelSouthSouth.setLayout(new BorderLayout());
		panelSouthSouth.add(panelSouthSouthWest,BorderLayout.WEST);
		panelSouthSouthWestwork();
		panelSouthSouth.add(panelSouthSouthCenter,BorderLayout.CENTER);
		panelSouthSouthCenterwork();
	}

	private void panelSouthSouthCenterwork() {
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelSouthSouthCenter.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthCenter.add(lblTotalAmount,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelSouthSouthCenter.add(txtTotalAmount,c);
		
	}

	private void panelSouthSouthWestwork() {
		//panelSouthSouthWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouthSouthWest.setPreferredSize(new Dimension(550,0));
		FlowLayout flow = new FlowLayout();
		panelSouthSouthWest.setLayout(flow);
		flow.setVgap(10);
		panelSouthSouthWest.add(btnConfirm);
		panelSouthSouthWest.add(btnDone);
		panelSouthSouthWest.add(btnRefresh1);
	}

}
