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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.toedter.calendar.JDateChooser;
public class OpeningStock extends JPanel{
	
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
	SuggestText cmbProductId=new SuggestText();
	
	JLabel lblStockID=new JLabel("Stock ID: ");
	JLabel lblProductID=new JLabel("Product ID: ");
	JLabel lblCategoryID=new JLabel("Category ID: ");
	JLabel lblSubCategoryID=new JLabel("Sub Category ID: ");
	JLabel lblUnit=new JLabel("Unit: ");
	JLabel lblStockQuantity=new JLabel("Stock Quantity: ");
	JLabel lblDealerPrice=new JLabel("Dealer Price: ");
	JLabel lblAmount=new JLabel("Amount: ");
	JLabel lblStockDate=new JLabel("Stock Date: ");
	JLabel lblSupplierName=new JLabel("Supplier Name: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblGeneral = new JLabel("General");
	
	public static JTextField txtStockId=new JTextField(20);
	JTextField txtUnit=new JTextField(20);
	JTextField txtStockQuantity=new JTextField(20);
	JTextField txtDealerPrice=new JTextField(20);
	JTextField txtAmount=new JTextField(20);
	JDateChooser StockDate=new JDateChooser();
	JTextField txtUserName=new JTextField(20);
	
	SimpleDateFormat dateFormatSql = new  SimpleDateFormat("yyyy-MM-dd");
	
	String col[]={"Stock Id","Product Name","Stock Quantity","Stock Date"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	DecimalFormat df=new DecimalFormat("#0.00");
	
	public OpeningStock() {
		setBackground(Color.blue);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,0,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
		btnAction();
		
	}
	public void cmbProductDataLoad() {
		try {
			cmbProductId.v.clear();
			cmbProductId.txtSuggest.setText("");
			cmbProductId.v.add("");

			String sql="select productId,productName from tbProductInfo order by productName";
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				cmbProductId.v.add(rs.getString("productId")+" # "+rs.getString("productName"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private void txtClearOpeningStock() {
		txtStockId.setText("");
		cmbProductId.txtSuggest.setText("");
		cmbCategoryId.txtSuggest.setText("");
		cmbSubCategoryId.txtSuggest.setText("");
		txtUnit.setText("");
		txtStockQuantity.setText("");
		txtDealerPrice.setText("");
		txtAmount.setText("");
		cmbSupplierName.txtSuggest.setText("");
		txtUserName.setText("");
		StockDate.setDate(new Date());
		
		
	}
	/*private String getIsExistQueryOpeningStock() {
		String sql="select * from tbopeningstock where StockId='"+txtStockId.getText().trim()+"'";
		return sql;
	}
	*/
	private void btnAction() {
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClearOpeningStock();
				CommonMethod.autoId(OpeningStock.getAutoIdQueryOpeningStock(), "os",txtStockId);
				
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckValidatonOpeningStock()) {
					if(CommonMethod.checkConfirmation("Sure To Save?")) {
						if(CommonMethod.insertData(getInsertQuery())) {
							JOptionPane.showMessageDialog(null,"All Information Save Successfully");
							txtClearOpeningStock();
							CommonMethod.autoId(OpeningStock.getAutoIdQueryOpeningStock(), "os",txtStockId);
						}
					}
				}
			}
		});
		cmbProductId.cmbSuggest.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!cmbProductId.txtSuggest.getText().trim().isEmpty()) {
					productDetailsDataLoad();
				}
				else {
					
				}
			}
		});
		txtStockQuantity.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				calcAmount();
			}
			public void keyPressed(KeyEvent e) {}
		});
	}
	private String getInsertQuery() 
	{
		String catIdName=cmbCategoryId.txtSuggest.getText().trim();
		StringTokenizer tokenCat=new StringTokenizer(catIdName,"#");
		
		String productIdName=cmbProductId.txtSuggest.getText().trim();
		StringTokenizer tokenProduct=new StringTokenizer(productIdName,"#");
		
		String subCatId="",subCatName="";
		if(!cmbSubCategoryId.txtSuggest.getText().trim().isEmpty()) {
			String SubCatIdName=cmbSubCategoryId.txtSuggest.getText().trim();
			StringTokenizer tokenSubCat=new StringTokenizer(SubCatIdName,"#");
			subCatId=tokenSubCat.nextToken().trim();
			subCatName=tokenSubCat.nextToken().trim();
		}
		
		String supplierIdName=cmbSupplierName.txtSuggest.getText().trim();
		StringTokenizer tokenSupplier=new StringTokenizer(supplierIdName,"#");
		
		String stockDate;
		stockDate = dateFormatSql.format(StockDate.getDate());
		
		String sql="insert into tbopeningstock(stockid,productid,ProductName,CategoryId,CategoryName,"
				+ "SubCategoryId,SubCategoryName,Unit,StockQuantity,DealerPrice,\r\n" + 
				"Amount,StockDate,SupplierId,SupplierName,UserName,UserIp,EntryTime) "
				+ "values ("
				+ "'"+txtStockId.getText().trim()+"',"
				+ "'"+tokenProduct.nextToken().trim()+"',"
				+ "'"+tokenProduct.nextToken().trim()+"',"
				+ "'"+tokenCat.nextToken().trim()+"',"
				+ "'"+tokenCat.nextToken().trim()+"',"
				+ "'"+subCatId+"',"
				+ "'"+subCatName+"',"
				+ "'"+txtUnit.getText().trim()+"',"
				+ "'"+txtStockQuantity.getText().trim()+"',"
				+ "'"+txtDealerPrice.getText().trim()+"',"
				+ "'"+txtAmount.getText().trim()+"',"
				+ "'"+stockDate+"',"
				+ "'"+tokenSupplier.nextToken().trim()+"',"
				+ "'"+tokenSupplier.nextToken().trim()+"',"
				+ "'"+txtUserName.getText().trim()+"',"
				+ "'',"
				+ "now())";
		System.out.println(sql);
		return sql;
	}
	private void calcAmount() {
		double qty,rate,amount;
		qty=Double.parseDouble(txtStockQuantity.getText().trim().isEmpty()?"0":txtStockQuantity.getText().trim());
		rate=Double.parseDouble(txtDealerPrice.getText().trim().isEmpty()?"0":txtDealerPrice.getText().trim());
		amount=qty*rate;
		txtAmount.setText(df.format(amount));
	}
	private void productDetailsDataLoad() {
		String idName=cmbProductId.txtSuggest.getText().trim();
		StringTokenizer token=new StringTokenizer(idName,"#");
		txtClearOpeningStock();
		CommonMethod.autoId(OpeningStock.getAutoIdQueryOpeningStock(), "os",txtStockId);
		
		cmbCategoryId.v.clear();
		cmbCategoryId.txtSuggest.setText("");
		cmbCategoryId.v.add("");

		cmbSubCategoryId.v.clear();
		cmbSubCategoryId.txtSuggest.setText("");
		cmbSubCategoryId.v.add("");
		
		cmbProductId.v.clear();
		cmbProductId.txtSuggest.setText("");
		cmbProductId.v.add("");
		
		
		try {
			String sql="select CategoryId,categoryName,subCategoryId,subCategoryName,unit,dealerPrice,supplierId,supplierName\r\n" + 
					" from tbProductInfo where productId='"+token.nextToken().trim()+"' ";
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				cmbCategoryId.v.add(rs.getString("CategoryId")+" # "+rs.getString("categoryName"));
				cmbSubCategoryId.v.add(rs.getString("subCategoryId")+" # "+rs.getString("subCategoryName"));
				cmbSupplierName.v.add(rs.getString("supplierId")+" # "+rs.getString("supplierName"));
				
				cmbCategoryId.txtSuggest.setText(rs.getString("CategoryId")+" # "+rs.getString("categoryName"));
				cmbSubCategoryId.txtSuggest.setText(rs.getString("subCategoryId")+" # "+rs.getString("subCategoryName"));
				cmbSupplierName.txtSuggest.setText(rs.getString("supplierId")+" # "+rs.getString("supplierName"));
				
				txtUnit.setText(rs.getString("unit"));
				txtDealerPrice.setText(rs.getString("dealerPrice"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private boolean CheckValidatonOpeningStock() {
		if(!txtStockId.getText().trim().isEmpty()){
			if(!cmbProductId.txtSuggest.getText().trim().isEmpty()){
				if(!cmbCategoryId.txtSuggest.getText().trim().isEmpty()){
					if(!cmbSubCategoryId.txtSuggest.getText().trim().isEmpty()){
						if(!txtUnit.getText().trim().isEmpty()){
							if(!txtStockQuantity.getText().trim().isEmpty()){
								if(!txtDealerPrice.getText().trim().isEmpty()){
									if(!txtAmount.getText().trim().isEmpty()){
										if(!cmbSupplierName.txtSuggest.getText().trim().isEmpty()){
											if(!txtUserName.getText().trim().isEmpty()){
											   	return true;
											}
											else {
												JOptionPane.showMessageDialog(null,"Insert User Name Please");
											}  	
										}
										else {
											JOptionPane.showMessageDialog(null,"Insert Supplier Name Please");
										}  	
									}
									else {
										JOptionPane.showMessageDialog(null,"Insert Amount Please");
									}  		
								}
								else {
									JOptionPane.showMessageDialog(null,"Insert Dealer Price Please");
								}  	 	
							}
							else {
								JOptionPane.showMessageDialog(null,"Insert Stock Quantity Please");
							}  		
						}
						else {
							JOptionPane.showMessageDialog(null,"Insert Unit Please");
						}  	
					}
					else {
						JOptionPane.showMessageDialog(null,"Insert Sub-Category Id Please");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Insert Category Id Please");
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Insert Product Id Please");
			}	
		}
		else {
			JOptionPane.showMessageDialog(null,"Insert Stock Id Please");
		}
		return false;
	}
	
	public static String getAutoIdQueryOpeningStock() {
		String sql="select ifnull(max(cast(subString(StockId,\r\n" + 
				"locate('-',StockId)+1,\r\n" + 
				"length(StockId)-locate('-',StockId))as UNSIGNED)),0)+1 id from tbopeningstock";
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
		panelWestCenter.add(lblStockID,c);
		
		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtStockId,c);
		
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
		cmbCategoryId.cmbSuggest.setEnabled(false);
		
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
		cmbSubCategoryId.cmbSuggest.setEnabled(false);
		
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
		txtUnit.setEnabled(false);
		
		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblStockQuantity,c);
		
		c.gridx=1;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtStockQuantity,c);
		
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
		txtDealerPrice.setEnabled(false);
		
		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblAmount,c);
		
		c.gridx=1;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtAmount,c);
		
		c.gridx=0;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblStockDate,c);
		
		c.gridx=1;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(StockDate,c);
		StockDate.setDateFormatString("dd-MM-yyyy");
		StockDate.setDate(new Date());
		
		c.gridx=0;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblSupplierName,c);
		
		c.gridx=1;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(cmbSupplierName.cmbSuggest,c);
		cmbSupplierName.cmbSuggest.setEnabled(false);
		
		c.gridx=0;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblUserName,c);
		
		c.gridx=1;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(txtUserName,c);
		
		c.gridx=2;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenter.add(lblGeneral,c);
		
		
	}

	private void panelWestNorthwork() {
	//	panelWestNorth.setBorder(BorderFactory.createRaisedBevelBorder());
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
