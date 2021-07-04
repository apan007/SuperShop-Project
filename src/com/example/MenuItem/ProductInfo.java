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
import java.sql.ResultSet;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.Admin.CommonMethod;
import com.example.Admin.SuggestText;
import com.example.Main.DbConnection;
public class ProductInfo extends JPanel{

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

	SuggestText cmbSearch=new SuggestText();
	SuggestText cmbCategoryId=new SuggestText();
	SuggestText cmbSubCategoryId=new SuggestText();
	SuggestText cmbSupplierName=new SuggestText();

	JLabel lblProductID=new JLabel("Product ID: ");
	JLabel lblCategoryID=new JLabel("Category ID: ");
	JLabel lblSubCategoryID=new JLabel("Sub Category ID: ");
	JLabel lblProductName=new JLabel("Product Name: ");
	JLabel lblProductDes=new JLabel("Product Description: ");
	JLabel lblUnit=new JLabel("Unit: ");
	JLabel lblDealerPrice=new JLabel("Dealer Price: ");
	JLabel lblTradePrice=new JLabel("Trade Price: ");
	JLabel lblSupplierName=new JLabel("Supplier Name: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblGeneral = new JLabel("General");


	public static JTextField txtProductID=new JTextField(20);
	JTextField txtProductName=new JTextField(20);
	JTextField txtProductDes=new JTextField(20);
	JTextField txtUnit=new JTextField(20);
	JTextField txtDealerPrice=new JTextField(20);
	JTextField txtTradePrice=new JTextField(20);
	JTextField txtUserName=new JTextField(20);

	String col[]={"Product Id","Product Name","Dealer Price","Trade Price"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public ProductInfo() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,0,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
		btnAction();
	}
	public void cmbCatagoryDataLoad() {
		try {
			/*String idName=cmbCategoryId.txtSuggest.getText().trim();
			StringTokenizer token=new StringTokenizer(idName,"#");*/

			cmbCategoryId.v.clear();
			cmbCategoryId.txtSuggest.setText("");
			cmbCategoryId.v.add("");

			String sql="select categoryId,categoryName from tbCategoryINfo order by categoryName";
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				cmbCategoryId.v.add(rs.getString("categoryId")+" # "+rs.getString("categoryName"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	public void cmbSubCatagoryDataLoad() {
		try {
			String idName=cmbCategoryId.txtSuggest.getText().trim();
			StringTokenizer tokenSub=new StringTokenizer(idName,"#");

			cmbSubCategoryId.v.clear();
			cmbSubCategoryId.txtSuggest.setText("");
			cmbSubCategoryId.v.add("");

			String sql="select subCategoryId,subCategoryName from tbSubCategoryInfo"
					+ " where categoryId='"+tokenSub.nextToken().trim()+"'";
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				cmbSubCategoryId.v.add(rs.getString("subCategoryId")+" # "+rs.getString("subCategoryName"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	public void cmbSupplierDataLoad() {
		try {
			/*String idName=cmbSupplierName.txtSuggest.getText().trim();
			StringTokenizer tokenSupp=new StringTokenizer(idName,"#");*/

			cmbSupplierName.v.clear();
			cmbSupplierName.txtSuggest.setText("");
			cmbSupplierName.v.add("");

			String sql="select supplierId,SupplierName from tbSupplierInfo order by SupplierName";
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				cmbSupplierName.v.add(rs.getString("supplierId")+" # "+rs.getString("SupplierName"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private void txtClearProductInfo() {
		txtProductID.setText("");
		cmbCategoryId.txtSuggest.setText("");
		cmbSubCategoryId.txtSuggest.setText("");
		txtProductName.setText("");
		txtProductDes.setText("");
		txtUnit.setText("");
		txtDealerPrice.setText("");
		txtTradePrice.setText("");
		cmbSupplierName.txtSuggest.setText("");
		txtUserName.setText("");	
	}
	private String getIsExistQueryProductInfo() {
		String sql="select * from tbProductInfo where ProductName='"+txtProductName.getText().trim()+"'";
		return sql;
	}

	private void btnAction() {
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClearProductInfo();
				CommonMethod.autoId(ProductInfo.getAutoIdQueryProductInfo(), "pdi",txtProductID);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckValidationProductInfo()) {
					if(CommonMethod.isExistName(getIsExistQueryProductInfo())) {
						if(CommonMethod.checkConfirmation("Sure to Save?")){
							if(CommonMethod.insertData(getInsertQuery())) {
								JOptionPane.showMessageDialog(null, "All Information Save successfully");
								txtClearProductInfo();
								CommonMethod.autoId(ProductInfo.getAutoIdQueryProductInfo(), "pdi",ProductInfo.txtProductID);

							}
						}
					}

				} 
			}
		});
		cmbCategoryId.cmbSuggest.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!cmbCategoryId.txtSuggest.getText().trim().isEmpty()) {
					cmbSubCatagoryDataLoad();
				}
				else {
					cmbSubCategoryId.v.clear();
					cmbSubCategoryId.txtSuggest.setText("");
					cmbSubCategoryId.v.add("");
				}
			}
		});
	}

	private String getInsertQuery() {

		String catIdName=cmbCategoryId.txtSuggest.getText().trim();
		StringTokenizer tokenCat=new StringTokenizer(catIdName,"#");

		String subCatIdName=cmbSubCategoryId.txtSuggest.getText().trim();
		StringTokenizer tokenSubCat=new StringTokenizer(subCatIdName,"#");

		String supplierIdName=cmbSupplierName.txtSuggest.getText().trim();
		StringTokenizer tokenSupplier=new StringTokenizer(supplierIdName,"#");

		String sql="insert into tbproductinfo(productid,categoryid,CategoryName,subcategoryid,SubCategoryName,productname,"
				+ "ProductDescription,unit,dealerprice,tradeprice,SupplierId,supplierName,username,"
				+ "userip,entrytime)\r\n" + 
				"values("
				+ "'"+txtProductID.getText().trim()+"',"
				+ "'"+tokenCat.nextToken().trim()+"',"
				+ "'"+tokenCat.nextToken().trim()+"',"
				+ "'"+tokenSubCat.nextToken().trim()+"',"	
				+ "'"+tokenSubCat.nextToken().trim()+"',"	
				+ "'"+txtProductName.getText().trim()+"',"
				+ "'"+txtProductDes.getText().trim()+"',"
				+ "'"+txtUnit.getText().trim()+"',"
				+ "'"+txtDealerPrice.getText().trim()+"',"
				+ "'"+txtTradePrice.getText().trim()+"',"
				+ "'"+tokenSupplier.nextToken().trim()+"',"
				+ "'"+tokenSupplier.nextToken().trim()+"',"
				+ "'"+txtUserName.getText().trim()+"',"
				+ "'',"
				+ "now())";
		System.out.println(sql);
		return sql;
	}
	private boolean CheckValidationProductInfo() {
		if(!txtProductID.getText().trim().isEmpty()) {
			if(!cmbCategoryId.txtSuggest.getText().trim().isEmpty()) {
				if(!cmbSubCategoryId.txtSuggest.getText().trim().isEmpty()) {
					if(!txtProductName.getText().trim().isEmpty()) {
						if(!txtProductDes.getText().trim().isEmpty()) {
							if(!txtUnit.getText().trim().isEmpty()) {
								if(!txtDealerPrice.getText().trim().isEmpty()) {
									if(!txtTradePrice.getText().trim().isEmpty()) {
										if(!cmbSupplierName.txtSuggest.getText().trim().isEmpty()) {
											if(!txtUserName.getText().trim().isEmpty()) {
												return true;
											}
											else {
												JOptionPane.showMessageDialog(null, "Insert User Name Please");
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "Insert Supplier Name Please");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Insert Trade Price Please");
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Insert Dealer Price Please");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Insert Unit Please");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Insert Product Description Please");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Insert Product Name Please");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Insert Sub-Category Id Please");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Insert Category Id Please");
			}	
		}
		else {
			JOptionPane.showMessageDialog(null, "Insert Product Id Please");
		}
		return false;
	}

	public static String getAutoIdQueryProductInfo() {
		String sql="select ifnull(max(cast(subString(ProductId,\r\n" + 
				"locate('-',ProductId)+1,\r\n" + 
				"length(ProductId)-locate('-',ProductId))as UNSIGNED)),0)+1 id from tbProductInfo";
		return sql;
	}

	private void panelCenterwork() {
		//panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow =new FlowLayout();
		panelCenter.setLayout(flow);
		flow.setVgap(0);
		panelCenter.add(scroll);
		scroll.setPreferredSize(new Dimension(535,730));

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
		panelWestCenter.add(lblProductID,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtProductID,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblCategoryID,c);

		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbCategoryId.cmbSuggest,c);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSubCategoryID,c);

		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSubCategoryId.cmbSuggest,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblProductName,c);

		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtProductName,c);

		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblProductDes,c);

		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtProductDes,c);

		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblUnit,c);

		c.gridx=1;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtUnit,c);

		c.gridx=0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblDealerPrice,c);

		c.gridx=1;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtDealerPrice,c);

		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblTradePrice,c);

		c.gridx=1;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtTradePrice,c);

		c.gridx=0;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSupplierName,c);

		c.gridx=1;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSupplierName.cmbSuggest,c);

		c.gridx=0;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblUserName,c);

		c.gridx=1;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtUserName,c);

		c.gridx=2;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblGeneral,c);


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
