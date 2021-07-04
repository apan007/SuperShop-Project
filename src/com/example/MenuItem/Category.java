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
public class Category extends JPanel{

	JPanel panelWest = new JPanel();
	JPanel panelCenter = new JPanel();

	JPanel panelWestNorth = new JPanel();
	JPanel panelWestSouth = new JPanel();
	JPanel panelWestCenter = new JPanel();

	JPanel panelWestCenterCenter = new JPanel();
	JPanel panelWestCenterSouth = new JPanel();

	JPanel panelCenterNorth = new JPanel();
	JPanel panelCenterSouth = new JPanel();
	JPanel panelCenterCenter = new JPanel();

	JPanel panelCenterCenterCenter = new JPanel();
	JPanel panelCenterCenterSouth = new JPanel();

	SuggestText cmbSearch=new SuggestText();

	SuggestText cmbSearchSub=new SuggestText();

	JButton btnSearch = new JButton("",new ImageIcon("Images/Search16.png"));
	JButton btnAdd = new JButton("Add",new ImageIcon("Images/file_add.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDelete = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));

	JButton btnSearchSub = new JButton("",new ImageIcon("Images/Search16.png"));
	JButton btnAddSub = new JButton("New",new ImageIcon("Images/file_add.png"));
	JButton btnEditSub = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefreshSub = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDeleteSub = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));

	JLabel lblCategoryID=new JLabel("Category ID: ");
	JLabel lblCategoryName=new JLabel("Category Name: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblGeneral = new JLabel("General");


	JLabel lblCategoryIDSub=new JLabel("Category ID: ");
	JLabel lblSubCategoryIDSub=new JLabel("Sub Category ID: ");
	JLabel lblSubCategoryNameSub=new JLabel("Sub Category Name: ");
	JLabel lblGeneralSub=new JLabel("Username: ");
	JLabel lblExecutive = new JLabel("Executive");

	public static JTextField txtCategoryID=new JTextField(20);
	JTextField txtCategoryName=new JTextField(20);
	JTextField txtUserName=new JTextField(20);

	SuggestText cmbCategoryIDSub=new SuggestText();
	JTextField txtSubCatagoryId=new JTextField(20);
	JTextField txtUserNameSub=new JTextField(20);
	JTextField txtSubCategoryName = new JTextField(20);

	String col[]={"CatagoryId","CatagoryName","Username"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	String col1[]= {"Category ID","Sub Category Id","Sub Category Name","User Name"};
	Object row1[][];
	DefaultTableModel model1 = new DefaultTableModel(row1,col1);
	JTable table1=new JTable(model1);
	JScrollPane Scroll1= new JScrollPane(table1,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public Category() {
		//setBackground(Color.black);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,20,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
		btnAction();
	}
	private void txtClearCategory() {
		txtCategoryID.setText("");
		txtCategoryName.setText("");
		txtUserName.setText("");
	}
	private void txtClearSubCategory() {
		cmbCategoryIDSub.txtSuggest.setText("");
		txtSubCatagoryId.setText("");
		txtSubCategoryName.setText("");
		txtUserNameSub.setText("");
	}
	private String getIsExistQueryCategory() {
		String sql="select * from tbCategoryInfo where categoryName='"+txtCategoryName.getText().trim()+"'";
		return sql;
	}
	private String getIsExistQuerySubCategory() {
		String sql="select * from tbSubCategoryInfo where subcategoryName='"+txtSubCategoryName.getText().trim()+"'";
		return sql;
	}
	private String getInsertQuery() {
		String sql="insert into tbCategoryINfo(categoryId,cateGoryName,username,userip,entryTime)\r\n" + 
				"values("
				+ "'"+txtCategoryID.getText().trim()+"',"
				+ "'"+txtCategoryName.getText().trim()+"',"
				+ "'"+txtUserName.getText().trim()+"',"
				+ "'',"
				+ "now())";
		return sql;
	}
	public void cmbCatagoryDataLoad() {
		try {
			cmbCategoryIDSub.v.clear();
			cmbCategoryIDSub.txtSuggest.setText("");
			cmbCategoryIDSub.v.add("");
			
			String sql="select categoryId,categoryName from tbCategoryINfo order by categoryName";
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				cmbCategoryIDSub.v.add(rs.getString("categoryId")+" # "+rs.getString("categoryName"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private void btnAction() {
		btnRefresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				txtClearCategory();
				CommonMethod.autoId(getAutoIdQueryCatagory(), "Cat", txtCategoryID);
			}
		});
		btnRefreshSub.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				txtClearSubCategory();
				setAutoIdSubCatagory();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(checkValidationCategory()) {
					if(CommonMethod.isExistName(getIsExistQueryCategory())) {
						if(CommonMethod.checkConfirmation("Sure To Save?")) {
							if(CommonMethod.insertData(getInsertQuery())) {
								JOptionPane.showMessageDialog(null, "All Information Save Successfully");
								txtClearCategory();
								CommonMethod.autoId(Category.getAutoIdQueryCatagory(), "Cat",Category.txtCategoryID);
								cmbCatagoryDataLoad();
							}
						}
					}
				}
			}
		});
		btnAddSub.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(checkValidationSubCategory()) {
					if(CommonMethod.isExistName(getIsExistQuerySubCategory())) {
						if(CommonMethod.checkConfirmation("Sure To Save?")) {
							if(CommonMethod.insertData(getInsertDataSubCatagory())) {
								JOptionPane.showMessageDialog(null, "All Information Save Successfully");
								txtClearSubCategory();
								setAutoIdSubCatagory();
							}
						}
					}
				}
			}
		});
	}
	private String getInsertDataSubCatagory() {
		String idName=cmbCategoryIDSub.txtSuggest.getText().trim();
		StringTokenizer token=new StringTokenizer(idName,"#");
		String sql="insert into tbSubCategoryInfo(categoryId,CategoryName,"
				+ "subCategoryId,subCategoryName,username,userIp,entryTime)\r\n" + 
				"values("
				+ "'"+token.nextToken().trim()+"',"
				+ "'"+token.nextToken().trim()+"',"
				+ "'"+txtSubCatagoryId.getText().trim()+"',"
				+ "'"+txtSubCategoryName.getText().trim()+"',"
				+ "'"+txtUserNameSub.getText().trim()+"',"
				+ "'',"
				+ "now())";
		return sql;
	}
	private boolean checkValidationSubCategory() {
		if(!cmbCategoryIDSub.txtSuggest.getText().trim().isEmpty()) {
			if(!txtSubCatagoryId.getText().trim().isEmpty()) {
				if(!txtSubCategoryName.getText().trim().isEmpty()) {
					if(!txtUserNameSub.getText().trim().isEmpty()) {
						return true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Insert Sub User Name Please");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Insert Sub Catagory Name Please");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Insert Sub Catagory Id Please");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Please Provide Catagory Name");
		}
		return false;
	}
	private boolean checkValidationCategory() {
		
		if(!txtCategoryID.getText().trim().isEmpty()) {
			if(!txtCategoryName.getText().trim().isEmpty()) {
				if(!txtUserName.getText().trim().isEmpty()) {
					return true;
				}
				else {
					JOptionPane.showMessageDialog(null, "Insert user Name Please");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Insert Category Name Please");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Insert Category Id Please");
		}
		return false;
	}
	public static String getAutoIdQueryCatagory() {
		String sql="select ifnull(max(cast(subString(categoryId,\r\n" + 
				"locate('-',categoryId)+1,\r\n" + 
				"length(categoryId)-locate('-',categoryId))as UNSIGNED)),0)+1 id from tbCategoryInfo";
		return sql;
	}
	public void setAutoIdSubCatagory() {
		String sql="select ifnull(max(cast(subString(SubCategoryid,\r\n" + 
				"locate('-',SubCategoryid)+1,\r\n" + 
				"length(SubCategoryid)-locate('-',SubCategoryid))as UNSIGNED)),0)+1 id from tbSubCategoryInfo";
		try {
			DbConnection.connect();
			ResultSet rs=DbConnection.Sta.executeQuery(sql);
			while(rs.next()) {
				txtSubCatagoryId.setText("SubCat-"+rs.getString("id"));
			}
			DbConnection.Con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private void panelCenterwork() {
		//panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelCenterNorth,BorderLayout.NORTH);
		panelCenterNorthwork();
		panelCenter.add(panelCenterSouth,BorderLayout.SOUTH);
		panelCenterSouthwork();
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		panelCenterCenterwork();
	}


	private void panelCenterCenterwork() {
		//panelCenterCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenterCenter.setLayout(new BorderLayout());
		panelCenterCenter.add(panelCenterCenterCenter,BorderLayout.CENTER);
		panelCenterCenterCenterwork();
		panelCenterCenter.add(panelCenterCenterSouth,BorderLayout.SOUTH);
		panelCenterCenterSouthwork();

	}


	private void panelCenterCenterSouthwork() {
		//panelCenterCenterSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenterCenterSouth.setPreferredSize(new Dimension(0,80));
		FlowLayout flow = new FlowLayout();
		panelCenterCenterSouth.setLayout(flow);
		flow.setVgap(15);
		panelCenterCenterSouth.add(btnAddSub);
		panelCenterCenterSouth.add(btnEditSub);
		panelCenterCenterSouth.add(btnRefreshSub);
		panelCenterCenterSouth.add(btnDeleteSub);

	}


	private void panelCenterCenterCenterwork() {
		//panelCenterCenterCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelCenterCenterCenter.setLayout(grid);

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(lblCategoryIDSub,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(cmbCategoryIDSub.cmbSuggest,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(lblSubCategoryIDSub,c);

		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(txtSubCatagoryId,c);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(lblSubCategoryNameSub,c);

		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(txtSubCategoryName,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(lblGeneralSub,c);

		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(txtUserNameSub,c);

		c.gridx=2;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterCenterCenter.add(lblExecutive,c);


	}


	private void panelCenterSouthwork() {
		//panelCenterSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenterSouth.setPreferredSize(new Dimension(0,350));
		FlowLayout flow =new FlowLayout();
		panelCenterSouth.setLayout(flow);
		flow.setVgap(0);
		panelCenterSouth.add(Scroll1);
		Scroll1.setPreferredSize(new Dimension(530,347));

	}


	private void panelCenterNorthwork() {
		//panelCenterNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenterNorth.setPreferredSize(new Dimension(0,100));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelCenterNorth.setLayout(grid);

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterNorth.add(cmbSearchSub.cmbSuggest,c);
		cmbSearchSub.cmbSuggest.setPreferredSize(new Dimension(300,20));

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelCenterNorth.add(btnSearchSub,c);
	}


	private void panelWestwork() {
		//panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWestNorthwork();
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		panelWestSouthwork();
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWestCenterwork();

	}


	private void panelWestCenterwork() {
		//panelWestCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestCenter.setLayout(new BorderLayout());
		panelWestCenter.add(panelWestCenterSouth,BorderLayout.SOUTH);
		panelWestCenterSouthwork();
		panelWestCenter.add(panelWestCenterCenter,BorderLayout.CENTER);
		panelWestCenterCenterwork();

	}


	private void panelWestCenterCenterwork() {
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestCenterCenter.setLayout(grid);

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(lblCategoryID,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(txtCategoryID,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(lblCategoryName,c);

		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(txtCategoryName,c);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(lblUserName,c);

		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(txtUserName,c);

		c.gridx=2;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterCenter.add(lblGeneral,c);

	}


	private void panelWestCenterSouthwork() {
		//panelWestCenterSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestCenterSouth.setPreferredSize(new Dimension(0,80));
		FlowLayout flow = new FlowLayout();
		panelWestCenterSouth.setLayout(flow);
		flow.setVgap(15);
		panelWestCenterSouth.add(btnAdd);
		panelWestCenterSouth.add(btnEdit);
		panelWestCenterSouth.add(btnRefresh);
		panelWestCenterSouth.add(btnDelete);

	}


	private void panelWestSouthwork() {
		//panelWestSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestSouth.setPreferredSize(new Dimension(0,350));
		FlowLayout flow=new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(0);
		panelWestSouth.add(scroll);
		scroll.setPreferredSize(new Dimension(530,347));
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
