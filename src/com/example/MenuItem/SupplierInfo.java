package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.Admin.CommonMethod;
import com.example.Admin.SuggestText;
public class SupplierInfo extends JPanel{
	
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();
	
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();
	
	JPanel panelWestCenterWest=new JPanel();
	JPanel panelWestCenterCenter=new JPanel();
	
	SuggestText cmbSearch=new SuggestText();
	
	JButton btnSearch = new JButton("",new ImageIcon("Images/Search16.png"));
	JButton btnAdd = new JButton("Add",new ImageIcon("Images/file_add.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDelete = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));
	JButton btnReport = new JButton("Report",new ImageIcon("Images/Save24.png"));
	JButton btnUpload = new JButton("Upload",new ImageIcon("Images/up24.png"));
	
	JLabel lblSupplierID=new JLabel("Supplier ID: ");
	JLabel lblSuplierName=new JLabel("Supplier Name: ");
	JLabel lblMailAddress=new JLabel("Mail Address: ");
	JLabel lblMobileNumber=new JLabel("Mobile Number: ");
	JLabel lblAddress=new JLabel("Address: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblGeneral = new JLabel("General");
	JLabel lblPhoto = new JLabel("");
	
	public static JTextField txtSupplierID=new JTextField(15);
	JTextField txtSupplierName=new JTextField(15);
	JTextField txtMailAddress=new JTextField(15);
	JTextField txtMobileNumber=new JTextField(15);
	JTextField txtUserName=new JTextField(15);
	
	JTextArea txtAddress=new JTextArea(3,15);
	JScrollPane scroll=new JScrollPane(txtAddress,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);
	
	String col[]={"Supplier Id","Supplier Name","Mobile Number"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll1=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	
	public SupplierInfo() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,0,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
		btnAction();
	}

	private void txtClearSupplierInfo() {
		txtSupplierID.setText("");
		txtSupplierName.setText("");
		txtMailAddress.setText("");
		txtMobileNumber.setText("");
		txtAddress.setText("");
		txtUserName.setText("");
	
	}
	private String getInsertQuery() {
		String sql="insert into tbsupplierinfo(SupplierId,SupplierName,mailaddress,MobileNumber,address,UserName,UserIp,entrytime)\r\n" + 
				"values("
				+ "'"+txtSupplierID.getText().trim()+"',"
				+ "'"+txtSupplierName.getText().trim()+"',"
				+ "'"+txtMailAddress.getText().trim()+"',"
				+ "'"+txtMobileNumber.getText().trim()+"',"
				+ "'"+txtAddress.getText().trim()+"',"
				+ "'"+txtUserName.getText().trim()+"',"
				+ "'',"
				+ "now())";
		return sql;
	}
	private String getIsExistQuerySuppllierInfo() {
		String sql="select * from tbSupplierInfo where SupplierName='"+txtSupplierName.getText().trim()+"'";
		return sql;
	}
	private void btnAction() {
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClearSupplierInfo();
				CommonMethod.autoId(SupplierInfo.getAutoIdQuerySupplierInfo(), "si",txtSupplierID);
				
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckValidationSupplierInfo()) {
					if(CommonMethod.isExistName(getIsExistQuerySuppllierInfo())) {
						if(CommonMethod.checkConfirmation("Sure to Save?")) {
							if(CommonMethod.insertData(getInsertQuery())) {
								JOptionPane.showMessageDialog(null, "All Information save successfuly");
								txtClearSupplierInfo();
								CommonMethod.autoId(SupplierInfo.getAutoIdQuerySupplierInfo(), "si",SupplierInfo.txtSupplierID);
							}
						}
					}
					
				}
			}
		});
		
	}
	private boolean CheckValidationSupplierInfo() {
		if(!txtSupplierID.getText().trim().isEmpty()) {
			if(!txtSupplierName.getText().trim().isEmpty()) {
				if(!txtMailAddress.getText().trim().isEmpty()) {
					if(!txtMobileNumber.getText().trim().isEmpty()) {
						if(!txtAddress.getText().trim().isEmpty()) {
							if(!txtUserName.getText().trim().isEmpty()) {
								return true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Provide User Name Please");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Provide Address Please");
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Provide Mobile Number Please");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Provide Mail Address Please");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Provide Supplier Name Please");
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Provide Supplier Id Please");
		}
		return false;
	}
	
	public static String getAutoIdQuerySupplierInfo() {
		String sql="select ifnull(max(cast(subString(SupplierId,\r\n" + 
				"locate('-',SupplierId)+1,\r\n" + 
				"length(SupplierId)-locate('-',SupplierId))as UNSIGNED)),0)+1 id from tbSupplierInfo";
		return sql;
	}


	private void panelCenterwork() {
		//panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow =new FlowLayout();
		panelCenter.setLayout(flow);
		flow.setVgap(0);
		panelCenter.add(scroll1);
		scroll1.setPreferredSize(new Dimension(535,730));
		
	}

	private void panelWestwork() {
		//panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWestNorthwork();
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWestCenterwork();
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		panelWestSouthwork();
	}

	private void panelWestSouthwork() {
		//panelWestSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestSouth.setPreferredSize(new Dimension(0,150));
		FlowLayout flow = new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(50);
		panelWestSouth.add(btnAdd);
		panelWestSouth.add(btnEdit);
		panelWestSouth.add(btnRefresh);
		panelWestSouth.add(btnDelete);
		panelWestSouth.add(btnReport);
	}

	private void panelWestCenterwork() {
		//panelWestCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestCenter.setLayout(new BorderLayout());
		panelWestCenter.add(panelWestCenterWest,BorderLayout.WEST);
		panelWestCenterWestwork();
		panelWestCenter.add(panelWestCenterCenter,BorderLayout.CENTER);
		panelWestCenterCenterwork();
		
	}

	private void panelWestCenterCenterwork() {
		//panelWestCenterCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestCenterCenter.setLayout(grid);

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(lblPhoto,c);
		lblPhoto.setPreferredSize(new Dimension(120,140));
		lblPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(btnUpload,c);
	
		
	}

	private void panelWestCenterWestwork() {
		//panelWestCenterWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestCenterWest.setPreferredSize(new Dimension(400,0));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestCenterWest.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblSupplierID,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtSupplierID,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblSuplierName,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtSupplierName,c);
		
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblMailAddress,c);
		
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtMailAddress,c);
		
		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblMobileNumber,c);
		
		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtMobileNumber,c);
		
		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblAddress,c);
		
		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(scroll,c);
		txtAddress.setLineWrap(true);
		
		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblUserName,c);
		
		c.gridx=1;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtUserName,c);
		
		c.gridx=2;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblGeneral,c);
	}

	private void panelWestNorthwork() {
		//panelWestNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestNorth.setPreferredSize(new Dimension(0,100));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestNorth.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestNorth.add(cmbSearch.cmbSuggest,c);
		cmbSearch.cmbSuggest.setPreferredSize(new Dimension(300,20));
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestNorth.add(btnSearch,c);
		
	}

}
