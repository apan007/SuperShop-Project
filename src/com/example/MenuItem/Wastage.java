package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
import com.toedter.calendar.JDateChooser;
public class Wastage extends JPanel{
	
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();
	
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();
	
	JButton btnSearch = new JButton("",new ImageIcon("Images/Search16.png"));
	JButton btnAdd = new JButton("Add",new ImageIcon("Images/file_add.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDelete = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));
	JButton btnReport = new JButton("Report",new ImageIcon("Images/Save24.png"));
	
	JTextArea txtReason=new JTextArea(3,15);
	JScrollPane scroll=new JScrollPane(txtReason,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);
	
	String col[]={"Wastage No","Product Name","Wastage Qty","Date"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll1=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	SuggestText cmbSearch=new SuggestText();
	SuggestText cmbCategoryId=new SuggestText();
	SuggestText cmbSubCategoryId=new SuggestText();
	SuggestText cmbSupplierName=new SuggestText();
	SuggestText cmbProductId=new SuggestText();
	SuggestText cmbProductType=new SuggestText();
	
	JLabel lblWastageNo=new JLabel("Wastage No: ");
	JLabel lblProductID=new JLabel("Product ID: ");
	JLabel lblCategoryID=new JLabel("Category ID: ");
	JLabel lblSubCategoryID=new JLabel("Sub Category ID: ");
	JLabel lblSupplierName=new JLabel("Supplier Name: ");
	JLabel lblProductType=new JLabel("Product Type: ");
	JLabel lblUnit=new JLabel("Unit: ");
	JLabel lblDate=new JLabel("Date: ");
	JLabel lblWasatgeQuantity=new JLabel("Wastage Quantity: ");
	JLabel lblDealerPrice=new JLabel("Dealer Price: ");
	JLabel lblAmount=new JLabel("Amount: ");
	JLabel lblReason=new JLabel("Reason: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblGeneral=new JLabel("General");
	
	public static JTextField txtWastageNo= new JTextField(20);
	JTextField txtUnit= new JTextField(20);
	JTextField txtWasatgeQuantity= new JTextField(20);
	JTextField txtDealerPrice= new JTextField(20);
	JTextField txtAmount= new JTextField(20);
	JTextField txtUserName= new JTextField(20);
	
	JDateChooser date=new JDateChooser();
	
	
	public Wastage() {
		setBackground(Color.blue);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,0,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
		btnActon();
	}

	private void txtClearWastage() {
		txtWastageNo.setText("");
		cmbProductId.txtSuggest.setText("");
		cmbCategoryId.txtSuggest.setText("");
		cmbSubCategoryId.txtSuggest.setText("");
		cmbSupplierName.txtSuggest.setText("");
		cmbProductType.txtSuggest.setText("");
		txtUnit.setText("");
		txtWasatgeQuantity.setText("");
		txtDealerPrice.setText("");
		txtAmount.setText("");
		txtReason.setText("");
		txtUserName.setText("");
		date.setDate(new Date());
	}
	
	private void btnActon() {
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClearWastage();
				CommonMethod.autoId(Wastage.getAutoIdQueryWastage(), "w",txtWastageNo);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckValidationWastage()) {
					
				}
			}
		});
		
	}
	private boolean CheckValidationWastage() {
		if(!txtWastageNo.getText().trim().isEmpty()) {
			if(!cmbProductId.txtSuggest.getText().trim().isEmpty()) {
				if(!cmbCategoryId.txtSuggest.getText().trim().isEmpty()) {
					if(!cmbSubCategoryId.txtSuggest.getText().trim().isEmpty()) {
						if(!cmbSupplierName.txtSuggest.getText().trim().isEmpty()) {
							if(!cmbProductType.txtSuggest.getText().trim().isEmpty()) {
								if(!txtUnit.getText().trim().isEmpty()) {
									if(!txtWasatgeQuantity.getText().trim().isEmpty()) {
										if(!txtDealerPrice.getText().trim().isEmpty()) {
											if(!txtAmount.getText().trim().isEmpty()) {
												if(!txtReason.getText().trim().isEmpty()) {
													if(!txtUserName.getText().trim().isEmpty()) {
													return true;	
													}
													else {
														JOptionPane.showMessageDialog(null, "Please Insert User Name");
													}
												}
												else {
													JOptionPane.showMessageDialog(null, "Please Insert Reason");
												}
											}
											else {
												JOptionPane.showMessageDialog(null, "Please Insert Amount");
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "Please Insert Dealer Price");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Please Insert Wastage Quantity");
									}	
								}
								else {
									JOptionPane.showMessageDialog(null, "Please Insert Unit");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please Insert Product Type");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Please Insert Supplier Name");
						}	
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Insert Sub-Category Id");
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Insert Category Id");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Insert Product Id");
			}	
		}
		else {
			JOptionPane.showMessageDialog(null, "Please Insert Wastage No");
		}
		return false;
	}
	public static String getAutoIdQueryWastage() {
		String sql="select ifnull(max(cast(subString(WastageNo,\r\n" + 
				"locate('-',WastageNo)+1,\r\n" + 
				"length(WastageNo)-locate('-',WastageNo))as UNSIGNED)),0)+1 id from tbwastage";
		return sql;
	}

	private void panelCenterwork() {
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
		panelWestSouth.setPreferredSize(new Dimension(0,90));
		FlowLayout flow = new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(20);
		panelWestSouth.add(btnAdd);
		panelWestSouth.add(btnEdit);
		panelWestSouth.add(btnRefresh);
		panelWestSouth.add(btnDelete);
		panelWestSouth.add(btnReport);
	}

	private void panelWestCenterwork() {
		//panelWestCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestCenter.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblWastageNo,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtWastageNo,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblProductID,c);
		
		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbProductId.cmbSuggest,c);
		
		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblCategoryID,c);
		
		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbCategoryId.cmbSuggest,c);
		
		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSubCategoryID,c);
		
		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSubCategoryId.cmbSuggest,c);
		
		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSupplierName,c);
		
		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSupplierName.cmbSuggest,c);
		
		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblProductType,c);
		
		c.gridx=1;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbProductType.cmbSuggest,c);
		cmbProductType.v.add("");
		cmbProductType.v.add("Wastge");
		cmbProductType.v.add("Broken");
		
		c.gridx=0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblUnit,c);
		
		c.gridx=1;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtUnit,c);
		
		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblDate,c);
		
		c.gridx=1;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(date,c);
		date.setDateFormatString("dd-MM-yyyy");
		date.setDate(new Date());
		
		c.gridx=0;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblWasatgeQuantity,c);
		
		c.gridx=1;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtWasatgeQuantity,c);
		
		c.gridx=0;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblDealerPrice,c);
		
		c.gridx=1;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtDealerPrice,c);
		
		c.gridx=0;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblAmount,c);
		
		c.gridx=1;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtAmount,c);
		
		c.gridx=0;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblReason,c);
		
		c.gridx=1;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(scroll,c);
		txtReason.setLineWrap(true);
		
		
		c.gridx=0;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblUserName,c);
		
		c.gridx=1;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtUserName,c);
		
		c.gridx=2;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblGeneral,c);
		
	}

	private void panelWestNorthwork() {
		//panelWestNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestNorth.setPreferredSize(new Dimension(0,90));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestNorth.setLayout(grid);
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestNorth.add(cmbSearch.cmbSuggest,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestNorth.add(btnSearch,c);
		
	}

}