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
import java.time.chrono.JapaneseDate;
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
public class PartyInfo extends JPanel{

	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();

	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();

	JPanel panelWestCenterWest=new JPanel();
	JPanel panelWestCenterCenter=new JPanel();

	SuggestText cmbSearch=new SuggestText();
	SuggestText cmbGender=new SuggestText();
	SuggestText cmbReferenceBy=new SuggestText();

	JButton btnSearch = new JButton("",new ImageIcon("Images/Search16.png"));
	JButton btnAdd = new JButton("Add",new ImageIcon("Images/file_add.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("Images/edit-128.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("Images/refresh.png"));
	JButton btnDelete = new JButton("Delete",new ImageIcon("Images/button_cancel.png"));
	JButton btnReport = new JButton("Report",new ImageIcon("Images/Save24.png"));
	JButton btnUpload = new JButton("Upload",new ImageIcon("Images/up24.png"));

	JLabel lblClientID=new JLabel("Client ID: ");
	JLabel lblClientName=new JLabel("Client Name: ");
	JLabel lblGender=new JLabel("Gender: ");
	JLabel lblFathersName=new JLabel("Fathers Name: ");
	JLabel lblMothersName=new JLabel("Mothers Name: ");
	JLabel lblReligion=new JLabel("Religion: ");
	JLabel lblDateofBirth=new JLabel("Date of Birth: ");
	JLabel lblDateofJoin=new JLabel("Date of Join: ");
	JLabel lblMobileNumber=new JLabel("Mobile Number: ");
	JLabel lblAddress=new JLabel("Address: ");
	JLabel lblEmail=new JLabel("Email: ");
	JLabel lblNationalID=new JLabel("National ID: ");
	JLabel lblNationality=new JLabel("Nationality: ");
	JLabel lblUserName=new JLabel("User Name: ");
	JLabel lblReferenceBy=new JLabel("Reference By: ");
	JLabel lblGeneral = new JLabel("General");
	JLabel lblPhoto = new JLabel("");


	public static JTextField txtClientID=new JTextField(20);
	JTextField txtClientName=new JTextField(20);
	JTextField txtFathersName=new JTextField(20);
	JTextField txtMothersName=new JTextField(20);
	JTextField txtReligion=new JTextField(20);
	JDateChooser DateofBirth=new JDateChooser();
	JDateChooser DateofJoin=new JDateChooser();
	JTextField txtMobileNumber=new JTextField(20);
	JTextField txtEmail=new JTextField(20);
	JTextField txtNationalId=new JTextField(20);
	JTextField txtNationality=new JTextField(20); 
	JTextField txtUserName=new JTextField(20);

	JTextArea txtAddress=new JTextArea(3,15);
	JScrollPane scroll=new JScrollPane(txtAddress,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
			);

	String col[]={"Client Id","Client Name","Mobile Number","Email"};
	Object row[][];
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll1=new JScrollPane(table,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	SimpleDateFormat dateFormatSql=new SimpleDateFormat("yyyy-MM-dd");

	public PartyInfo() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(1105,735));
		setLayout(new GridLayout(1,2,0,0));
		add(panelWest);
		panelWestwork();
		add(panelCenter);
		panelCenterwork();
		btnaction();

	}

	private void txtClearPartyInfo() {
		txtClientID.setText("");
		txtClientName.setText("");
		cmbGender.txtSuggest.setText("");
		txtFathersName.setText("");
		txtMothersName.setText("");
		txtReligion.setText("");
		txtMobileNumber.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		txtNationalId.setText("");
		txtNationality.setText("");
		txtUserName.setText("");
		cmbReferenceBy.txtSuggest.setText("");
		DateofBirth.setDate(new Date());
		DateofJoin.setDate(new Date());
	}
	private String getIsExistQueryPartyInfo() {
		String sql="select * from tbPartyInfo where ClientName='"+txtClientName.getText().trim()+"'";
		return sql;
	}

	private void btnaction() {
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClearPartyInfo();
				CommonMethod.autoId(PartyInfo.getAutoIdQueryPartyInfo(), "pi",txtClientID);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckValidationPartyInfo()) {
					if(CommonMethod.isExistName(getIsExistQueryPartyInfo())) {
						if(CommonMethod.checkConfirmation("Sure To Save?")) {
							if(CommonMethod.insertData(getInsertQuery())) {
								JOptionPane.showMessageDialog(null, "All Information Save Successfully");
								txtClearPartyInfo();
								CommonMethod.autoId(PartyInfo.getAutoIdQueryPartyInfo(), "pi",PartyInfo.txtClientID);
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
		String birthDate,joinDate;
		birthDate=dateFormatSql.format(DateofBirth.getDate());
		joinDate=dateFormatSql.format(DateofJoin.getDate());
		
		String sql="insert into tbpartyinfo(clientid,clientname,gender,fathersname,mothersname,religion,dateofbirth,dateofjoin,mobilenumber,address,\r\n" + 
				"email,nationalid,nationality,username,referenceby,userip,entrytime)\r\n" + 
				"values("
				+ "'"+txtClientID.getText().trim()+"',"
				+ "'"+txtClientName.getText().trim()+"',"
				+ "'"+cmbGender.txtSuggest.getText().trim()+"',"
				+ "'"+txtFathersName.getText().trim()+"',"
				+ "'"+txtMothersName.getText().trim()+"',"
				+ "'"+txtReligion.getText().trim()+"',"
				+ "'"+birthDate+"',"
				+ "'"+joinDate+"',"
				+ "'"+txtMobileNumber.getText().trim()+"',"
				+ "'"+txtAddress.getText().trim()+"',"
				+ "'"+txtEmail.getText().trim()+"',"
				+ "'"+txtNationalId.getText().trim()+"',"
				+ "'"+txtNationality.getText().trim()+"',"
				+ "'"+txtUserName.getText().trim()+"',"
				+ "'"+cmbReferenceBy.txtSuggest.getText().trim()+"',"
				+ "'',"
				+ "now())";
		return sql;

	}
	private boolean CheckValidationPartyInfo() {
		if(!txtClientID.getText().trim().isEmpty()) {
			if(!txtClientName.getText().trim().isEmpty()) {
				if(!cmbGender.txtSuggest.getText().trim().isEmpty()) {
					if(!txtFathersName.getText().trim().isEmpty()) {
						if(!txtMothersName.getText().trim().isEmpty()) {
							if(!txtReligion.getText().trim().isEmpty()) {
								//if(!DateofBirth.getText().trim().isEmpty()) {
								//if(!DateofJoin.getText().trim().isEmpty()) {
								if(!txtMobileNumber.getText().trim().isEmpty()) {
									if(!txtAddress.getText().trim().isEmpty()) {
										if(!txtEmail.getText().trim().isEmpty()) {
											if(!txtNationalId.getText().trim().isEmpty()) {
												if(!txtNationality.getText().trim().isEmpty()) {
													if(!txtUserName.getText().trim().isEmpty()) {
														if(!cmbReferenceBy.txtSuggest.getText().trim().isEmpty()) {
															return true;
														}
														else {
															JOptionPane.showMessageDialog(null, "Insert Reference By Please");
														}
													}
													else {
														JOptionPane.showMessageDialog(null, "Insert User Name Please");
													}	
												}
												else {
													JOptionPane.showMessageDialog(null, "Insert Nationality Please");
												}	
											}
											else {
												JOptionPane.showMessageDialog(null, "Insert National Id Please");
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "Insert Email Please");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Insert Address Please");
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Insert Mobile Number Please");
								}
							}
							/*else {
										JOptionPane.showMessageDialog(null, "Insert Date of Join Please");
									}	
								}
								else {
									JOptionPane.showMessageDialog(null, "Insert Date of Birth Please");
								}
							}*/
							else {
								JOptionPane.showMessageDialog(null, "Insert Religion Please");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Insert Mothers Name Please");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Insert Fathers Name Please");
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Insert Gender Please");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Insert Client Name Please");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Insert Client Id Please");
		}
		return false;
	}

	public static String getAutoIdQueryPartyInfo() {
		String sql="select ifnull(max(cast(subString(ClientId,\r\n" + 
				"locate('-',ClientId)+1,\r\n" + 
				"length(ClientId)-locate('-',ClientId))as UNSIGNED)),0)+1 id from tbPartyInfo";
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
		panelWestCenterWest.add(lblClientID,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtClientID,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblClientName,c);

		c.gridx=1;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtClientName,c);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblGender,c);

		c.gridx=1;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(cmbGender.cmbSuggest,c);
		cmbGender.v.add("");
		cmbGender.v.add("Male");
		cmbGender.v.add("FeMale");
		cmbGender.v.add("Others");

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblFathersName,c);

		c.gridx=1;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtFathersName,c);

		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblMothersName,c);

		c.gridx=1;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtMothersName,c);

		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblReligion,c);

		c.gridx=1;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtReligion,c);

		c.gridx=0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblDateofBirth,c);

		c.gridx=1;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(DateofBirth,c);
		DateofBirth.setDateFormatString("dd-MM-yyyy");
		DateofBirth.setDate(new Date());

		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblDateofJoin,c);

		c.gridx=1;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(DateofJoin,c);
		DateofJoin.setDateFormatString("dd-MM-yyyy");
		DateofJoin.setDate(new Date());

		c.gridx=0;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblMobileNumber,c); 

		c.gridx=1;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtMobileNumber,c);

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
		panelWestCenterWest.add(lblEmail,c);

		c.gridx=1;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtEmail,c);

		c.gridx=0;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblNationalID,c);

		c.gridx=1;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtNationalId,c);

		c.gridx=0;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblNationality,c);

		c.gridx=1;
		c.gridy=12;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtNationality,c);

		c.gridx=0;
		c.gridy=13;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblUserName,c);

		c.gridx=1;
		c.gridy=13;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(txtUserName,c);

		c.gridx=2;
		c.gridy=13;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblGeneral,c);

		c.gridx=0;
		c.gridy=14;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(lblReferenceBy,c);

		c.gridx=1;
		c.gridy=14;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelWestCenterWest.add(cmbReferenceBy.cmbSuggest,c);
		//cmbReferenceBy.cmbSuggest.setPreferredSize(new Dimension(300,20));

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
