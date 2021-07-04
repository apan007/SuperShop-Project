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
import java.text.SimpleDateFormat;
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
public class NewUser extends JPanel{

	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();

	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();

	JPanel panelWestCenterWest=new JPanel();
	JPanel panelWestCenterCenter=new JPanel();

	JPanel panelCenterCenter=new JPanel();
	JPanel panelCenterSouth=new JPanel();

	JButton btnSearch = new JButton("",new ImageIcon("Images/Search16.png"));
	JButton btnAdd = new JButton("Add",new ImageIcon("Images/file_add.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDelete = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));
	JButton btnReport = new JButton("Report",new ImageIcon("Images/Save24.png"));
	JButton btnUpload = new JButton("Upload",new ImageIcon("Images/up24.png"));
	JButton btnPrint = new JButton("Print",new ImageIcon("Images/printer-blue24.png"));

	SuggestText cmbSearch=new SuggestText();
	SuggestText cmbActivation=new SuggestText();
	SuggestText cmbUserType=new SuggestText();

	JLabel lblUserID=new JLabel("User ID: ");
	JLabel lblName=new JLabel("Name: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblDesignation=new JLabel("Designation: ");
	JLabel lblPassword=new JLabel("Password: ");
	JLabel lblDateofJoin=new JLabel("Date of Join: ");
	JLabel lblActivation=new JLabel("Activation: ");
	JLabel lblMobile=new JLabel("Mobile Number: ");
	JLabel lblEmailAddress=new JLabel("Eamil Address: ");
	JLabel lblAddress=new JLabel("Address: ");
	JLabel lblNationalID=new JLabel("National ID: ");
	JLabel lblNationality=new JLabel("Nationality ID: ");
	JLabel lblUserType=new JLabel("User Type: ");
	JLabel lblReferenceBy=new JLabel("ReferenceByUserName: ");
	JLabel lblPhoto = new JLabel("");

	public static JTextField txtUserID=new JTextField(20);
	JTextField txtName=new JTextField(20);
	JTextField txtUserName=new JTextField(20);
	JTextField txtDesignation=new JTextField(20);
	JTextField txtPassword=new JTextField(20);
	JTextField txtMobile=new JTextField(20);
	JDateChooser DateofJoin=new JDateChooser( );
	JTextField txtEmailAddress=new JTextField(20);
	JTextField txtNationalId=new JTextField(20);
	JTextField txtReferenceBy=new JTextField(20);

	SimpleDateFormat dateFormatSql = new  SimpleDateFormat("yyyy-MM-dd");

	JTextArea txtAddress=new JTextArea(3,15);
	JScrollPane scroll=new JScrollPane(txtAddress,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);

	String col[]={"User Id","User Name","Activation","Email"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll1=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public NewUser() {
		setBackground(Color.green);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,0,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
		btnAction();
	}
	private void txtClearNewUser() {
		txtUserID.setText("");
		txtName.setText("");
		txtUserName.setText("");
		txtDesignation.setText("");
		txtPassword.setText("");
		cmbActivation.txtSuggest.setText("");
		txtEmailAddress.setText("");
		txtNationalId.setText("");
		txtAddress.setText("");
		txtMobile.setText("");
		cmbUserType.txtSuggest.setText("");
		txtReferenceBy.setText("");
		DateofJoin.setDate(new Date());
	}

	private String getIsExistQueryNewUser() {
		String sql="select * from tbnewuser where UserName='"+txtUserName.getText().trim()+"'";
		return sql;
	}

	private void btnAction() {
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClearNewUser();
				CommonMethod.autoId(NewUser.getAutoIdQueryNewUser(), "nu",txtUserID);

			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckValidationNewUser()) {
					if(CommonMethod.isExistName(getIsExistQueryNewUser())) {
						if(CommonMethod.checkConfirmation("Sure to Save?")) {
							if(CommonMethod.insertData(getInsertQuery())) {
								JOptionPane.showMessageDialog(null, "All Information Save Successfully");
								txtClearNewUser();
								CommonMethod.autoId(NewUser.getAutoIdQueryNewUser(), "nu",NewUser.txtUserID);	
							}
						}
					}

				}
			}
		});
		btnReport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	private String getInsertQuery() {
		String joinDate;
		joinDate = dateFormatSql.format(DateofJoin.getDate());
		String sql="insert into tbnewuser(userid,name,username,designation,password,dateofjoin,activation,email,nationalid,address,mobile,usertype,referencebyusername,userip,entrytime)\r\n" + 
				"values("
				+ "'"+txtUserID.getText().trim()+"',"
				+ "'"+txtName.getText().trim()+"',"
				+ "'"+txtUserName.getText().trim()+"',"
				+ "'"+txtDesignation.getText().trim()+"',"
				+ "'"+txtPassword.getText().trim()+"',"
				+ "'"+joinDate+"',"
				+ "'"+cmbActivation.txtSuggest.getText().trim()+"',"
				+ "'"+txtEmailAddress.getText().trim()+"',"
				+ "'"+txtNationalId.getText().trim()+"',"
				+ "'"+txtAddress.getText().trim()+"',"
				+ "'"+txtMobile.getText().trim()+"',"
				+ "'"+cmbUserType.txtSuggest.getText().trim()+"',"
				+ "'"+txtReferenceBy.getText().trim()+"',"
				+ "'',"
				+ "now())";
		return sql;
	}
	private boolean CheckValidationNewUser() {
		if(!txtUserID.getText().trim().isEmpty()) {
			if(!txtName.getText().trim().isEmpty()) {
				if(!txtUserName.getText().trim().isEmpty()) {
					if(!txtDesignation.getText().trim().isEmpty()) {
						if(!txtPassword.getText().trim().isEmpty()) {
							if(!cmbActivation.txtSuggest.getText().trim().isEmpty()) {
								if(!txtEmailAddress.getText().trim().isEmpty()) {
									if(!txtNationalId.getText().trim().isEmpty()) {
										if(!txtAddress.getText().trim().isEmpty()) {
											if(!txtMobile.getText().trim().isEmpty()) {
												if(!cmbUserType.txtSuggest.getText().trim().isEmpty()) {
													if(!txtReferenceBy.getText().trim().isEmpty()) {
														return true;
													}
													else {
														JOptionPane.showMessageDialog(null, "Please Insert Reference By User Name");
													}
												}
												else {
													JOptionPane.showMessageDialog(null, "Please Insert User Type");
												}
											}
											else {
												JOptionPane.showMessageDialog(null, "Please Insert Mobile Number");
											}	
										}
										else {
											JOptionPane.showMessageDialog(null, "Please Insert Address");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Please Insert National Id");
									}	
								}
								else {
									JOptionPane.showMessageDialog(null, "Please Insert Email Address");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please Insert Activation");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Please Insert Password");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Insert Designation");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Insert User Name");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Insert Name");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Please Insert User Id");
		}
		return false; 
	}
	public static String getAutoIdQueryNewUser() {
		String sql="select ifnull(max(cast(subString(UserId,\r\n" + 
				"locate('-',UserId)+1,\r\n" + 
				"length(UserId)-locate('-',UserId))as UNSIGNED)),0)+1 id from tbNewUser";
		return sql;

	}
	private void panelCenterwork() {
		//panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		panelCenterCenterWork();
		panelCenter.add(panelCenterSouth,BorderLayout.SOUTH);
		panelCenterSouthWork();

	}

	private void panelCenterCenterWork() {
		//panelCenterCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow =new FlowLayout();
		panelCenterCenter.setLayout(flow);
		flow.setVgap(0);
		panelCenterCenter.add(scroll1);
		scroll1.setPreferredSize(new Dimension(535,730));


	}
	private void panelCenterSouthWork() {
		//panelCenterSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenterSouth.setPreferredSize(new Dimension(0,80));
		FlowLayout flow = new FlowLayout();
		panelCenterSouth.setLayout(flow);
		flow.setVgap(15);
		panelCenterSouth.add(btnPrint);

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
		panelWestSouth.setPreferredSize(new Dimension(0,80));
		FlowLayout flow = new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(15);
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
		panelWestCenterWest.setPreferredSize(new Dimension(350,0));
		GridBagConstraints c = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		panelWestCenterWest.setLayout(grid);

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblUserID,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtUserID,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblName,c);

		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtName,c);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblUserName,c);

		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtUserName,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblDesignation,c);

		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtDesignation,c);

		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblPassword,c);

		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtPassword,c);

		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblDateofJoin,c);

		c.gridx=1;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(DateofJoin,c);
		DateofJoin.setDateFormatString("dd-MM-yyyy");
		DateofJoin.setDate(new Date());

		c.gridx=0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblActivation,c);

		c.gridx=1;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(cmbActivation.cmbSuggest, c);
		cmbActivation.v.add("");
		cmbActivation.v.add("Yes");
		cmbActivation.v.add("No");

		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblEmailAddress,c);

		c.gridx=1;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtEmailAddress,c);

		c.gridx=0;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblNationalID,c); 

		c.gridx=1;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtNationalId,c);

		c.gridx=0;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblAddress,c);

		c.gridx=1;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(scroll,c);
		txtAddress.setLineWrap(true);

		c.gridx=0;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblMobile,c);

		c.gridx=1;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtMobile,c);

		c.gridx=0;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblUserType,c);

		c.gridx=1;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(cmbUserType.cmbSuggest,c);
		cmbUserType.v.add("");
		cmbUserType.v.add("Admin");
		cmbUserType.v.add("Super Admin");
		cmbUserType.v.add("Member");

		c.gridx=0;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblReferenceBy,c);

		c.gridx=1;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtReferenceBy,c);
	}

	private void panelWestNorthwork() {
		//panelWestNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestNorth.setPreferredSize(new Dimension(0,80));
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
