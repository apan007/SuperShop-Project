package com.example.Admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.StyledEditorKit.ItalicAction;

import com.example.MenuItem.Category;
import com.example.MenuItem.ChangePassword;
import com.example.MenuItem.ItemReceipt;
import com.example.MenuItem.NewUser;
import com.example.MenuItem.OpeningStock;
import com.example.MenuItem.PartyInfo;
import com.example.MenuItem.ProductInfo;
import com.example.MenuItem.ReceiptReturn;
import com.example.MenuItem.Sales;
import com.example.MenuItem.SalesReturn;
import com.example.MenuItem.SetupReport;
import com.example.MenuItem.SupplierInfo;
import com.example.MenuItem.TaskReport;
import com.example.MenuItem.Wastage;
public class WorkingPanel extends JPanel{

	JPanel panelWest = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();

	JButton btnSetup =new JButton("Setup");
	JButton btnSecurity =new JButton("Security");
	JButton btnTask =new JButton("Task");
	JButton btnReport =new JButton("Report");
	JButton btnOthers =new JButton("Others");

	JPanel panelSetup = new JPanel();
	JPanel panelSecurity = new JPanel();
	JPanel panelTask = new JPanel();
	JScrollPane scrollTask=new JScrollPane(panelTask,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel panelReport = new JPanel();
	JPanel panelOthers = new JPanel();

	JButton btnCategory = new JButton(new ImageIcon("Images/Distributor-report64.png") );
	JButton btnSupplier = new JButton(new ImageIcon("Images/Personal-information64.png"));
	JButton btnParty = new JButton(new ImageIcon("Images/info64.png"));
	JButton btnProduct = new JButton(new ImageIcon("Images/Inventory-maintenance64.png"));

	JLabel lvlCategoryInfo = new JLabel("Category Info");
	JLabel lvlSupplierInfo = new JLabel("Suppllier Info");
	JLabel lvlPartyInfo = new JLabel("Party Info");
	JLabel lvlProductInfo = new JLabel("Product Info");

	JButton btnNewUser = new JButton(new ImageIcon("Images/newuser5.png") );
	JButton btnChangePassword = new JButton(new ImageIcon("Images/change-password-box-icon.png") );

	JLabel lvlNewUser = new JLabel("New User");
	JLabel lvlChangePassword = new JLabel("Change Password");

	JButton btnOpeningStock = new JButton(new ImageIcon("Images/stock_lock-broken.png") );
	JButton btnItemReceipt = new JButton(new ImageIcon("Images/stock_task-assigned.png") );
	JButton btnReceiptReturn = new JButton(new ImageIcon("Images/x-office-calendar.png") );
	JButton btnSales = new JButton(new ImageIcon("Images/stock_mail-import.png") );
	JButton btnSalesReturn = new JButton(new ImageIcon("Images/gnome-session-switch.png") );
	JButton btnWastage = new JButton(new ImageIcon("Images/edit-delete.png") );

	JLabel lvlOpeningStock = new JLabel("Opening Stock");
	JLabel lvlItemReceipt = new JLabel("Item Receipt");
	JLabel lvlReceiptReturn = new JLabel("Receipt Return");
	JLabel lvlSales = new JLabel("Sales");
	JLabel lvlSalesReturn = new JLabel("Sales Return");
	JLabel lvlWastage = new JLabel("Wastage");

	JButton btnSetupReport = new JButton(new ImageIcon("Images/Rank-history64.png") );
	JButton btnTaskReport = new JButton(new ImageIcon("Images/Order-history64.png") );

	JLabel lvlSetupReport = new JLabel("Setup Report");
	JLabel lvlTaskReport = new JLabel("Task Report");

	JButton btnSMS = new JButton(new ImageIcon("Images/chat64.png") );
	JButton btnMAIL = new JButton(new ImageIcon("Images/mail-folder-sent.png") );
	JButton btnLogOff = new JButton(new ImageIcon("Images/evolution-contacts.png") );
	JButton btnExit = new JButton(new ImageIcon("Images/close64.png") );

	JLabel lvlSMS = new JLabel("SMS");
	JLabel lvlMAIL = new JLabel("MAIL");
	JLabel lvlLogOff = new JLabel("Log Off");
	JLabel lvlExit = new JLabel("Exit");

	Category cat = new Category();
	SupplierInfo si = new SupplierInfo();
	PartyInfo pi =new PartyInfo();
	ProductInfo pdi =new ProductInfo();
	NewUser nu =new NewUser();
	ChangePassword cp=new ChangePassword();
	OpeningStock os=new OpeningStock();
	ItemReceipt ir=new ItemReceipt();
	ReceiptReturn rr=new ReceiptReturn();
	Sales s =new Sales();
	SalesReturn sr = new SalesReturn();
	Wastage w=new Wastage();
	SetupReport str=new SetupReport();
	TaskReport tr =new TaskReport();
	JFrame frame;
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();

	public WorkingPanel(JFrame frmObject) {
		this.frame=frmObject;
		setLayout(new BorderLayout());
		add(panelWest,BorderLayout.WEST);
		panelWest.setLayout(new BorderLayout());
		panelWestwork();
		add(panelCenter,BorderLayout.CENTER);
		panelCenterwork();
		setEventAction();
	}

	private void setEventAction() {
		btnSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sidepanelTrueFalse();
				panelSetup.setVisible(true);

			}
		});
		btnSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sidepanelTrueFalse();
				panelSecurity.setVisible(true);

			}
		});
		btnTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sidepanelTrueFalse();
				scrollTask.setVisible(true);
				frame.setSize((int)screen.getWidth()+1,(int)screen.getHeight()+1);
			}
		});
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sidepanelTrueFalse();
				panelReport.setVisible(true);

			}
		});
		btnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sidepanelTrueFalse();
				panelOthers.setVisible(true);

			}
		});
		btnCategory.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				cat.setVisible(true);
				CommonMethod.autoId(Category.getAutoIdQueryCatagory(), "Cat",Category.txtCategoryID);
				cat.setAutoIdSubCatagory();
				cat.cmbCatagoryDataLoad();
			}
		});
		btnSupplier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				si.setVisible(true);
				CommonMethod.autoId(SupplierInfo.getAutoIdQuerySupplierInfo(), "si",SupplierInfo.txtSupplierID);

			}
		});
		btnParty.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				pi.setVisible(true);
				CommonMethod.autoId(PartyInfo.getAutoIdQueryPartyInfo(), "pi",PartyInfo.txtClientID);
			}
		});

		btnProduct.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				pdi.setVisible(true);
				CommonMethod.autoId(ProductInfo.getAutoIdQueryProductInfo(), "pdi",ProductInfo.txtProductID);
				pdi.cmbCatagoryDataLoad();
				pdi.cmbSupplierDataLoad();
			}
		});

		btnNewUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				nu.setVisible(true);
				CommonMethod.autoId(NewUser.getAutoIdQueryNewUser(), "nu",NewUser.txtUserID);


			}
		});

		btnChangePassword.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				cp.setVisible(true);

			}
		});

		btnOpeningStock.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				os.setVisible(true);
				CommonMethod.autoId(OpeningStock.getAutoIdQueryOpeningStock(), "os",OpeningStock.txtStockId);
				os.cmbProductDataLoad();
			}
		});
		btnItemReceipt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				ir.setVisible(true);

			}
		});

		btnReceiptReturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				rr.setVisible(true);

			}
		});

		btnSales.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				s.setVisible(true);

			}
		});
		btnSalesReturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				sr.setVisible(true);

			}
		});

		btnWastage.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				w.setVisible(true);
				CommonMethod.autoId(Wastage.getAutoIdQueryWastage(), "w",Wastage.txtWastageNo);

			}
		});

		btnSetupReport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				str.setVisible(true);

			}
		});

		btnTaskReport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centerpaneltruefalse();
				tr.setVisible(true);

			}
		});

	}

	private void panelCenterwork() {
		panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow =new FlowLayout();
		panelCenter.setLayout(flow);
		flow.setVgap(0);
		panelCenter.add(cat);
		panelCenter.add(si);
		panelCenter.add(pi);
		panelCenter.add(pdi);
		panelCenter.add(nu);
		panelCenter.add(cp);
		panelCenter.add(os);
		panelCenter.add(ir);
		panelCenter.add(rr);
		panelCenter.add(s);
		panelCenter.add(sr);
		panelCenter.add(w);
		panelCenter.add(str);
		panelCenter.add(tr);

		centerpaneltruefalse();

	}

	private void centerpaneltruefalse() {
		cat.setVisible(false);
		si.setVisible(false);
		pi.setVisible(false);
		pdi.setVisible(false);
		nu.setVisible(false);
		cp.setVisible(false);
		os.setVisible(false);
		ir.setVisible(false);
		rr.setVisible(false);
		s.setVisible(false);
		sr.setVisible(false);
		w.setVisible(false);
		str.setVisible(false);
		tr.setVisible(false);

	}

	private void panelWestwork() {
		panelWest.setPreferredSize(new Dimension(250,0));
		panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWestCenterwork();
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWestNorthwork();

	}
	private void panelWestNorthwork() {

		panelWestNorth.setPreferredSize(new Dimension(0,200));
		panelWestNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestNorth.setLayout(new GridLayout(5,1,0,5));
		panelWestNorth.add(btnSetup);
		panelWestNorth.add(btnSecurity);
		panelWestNorth.add(btnTask);
		panelWestNorth.add(btnReport);
		panelWestNorth.add(btnOthers);

	}

	private void panelWestCenterwork() {
		FlowLayout fl =new FlowLayout();
		panelWestCenter.setLayout(fl);
		fl.setVgap(0);
		panelWestCenter.add(panelSetup);
		panelSetupWork();
		panelWestCenter.add(panelSecurity);
		panelSecurityWork();
		panelWestCenter.add(panelReport);
		panelReportWork();
		panelWestCenter.add(scrollTask);
		panelTaskWork();
		panelWestCenter.add(panelOthers);
		panelOthersWork();

		sidepanelTrueFalse();

	}

	private void sidepanelTrueFalse() {
		panelSetup.setVisible(false);
		panelSecurity.setVisible(false);
		scrollTask.setVisible(false);
		panelReport.setVisible(false);
		panelOthers.setVisible(false);
	}

	private void panelOthersWork() {
		//panelOthers.setBackground(Color.green);
		panelOthers.setPreferredSize(new Dimension(250,535));
		GridBagConstraints c =new GridBagConstraints();
		panelOthers.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(btnSMS,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(lvlSMS,c);
		lvlSMS.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlSMS.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(btnMAIL,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(lvlMAIL,c);
		lvlMAIL.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlMAIL.setForeground(Color.black);

		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(btnLogOff,c);

		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(lvlLogOff,c);
		lvlLogOff.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlLogOff.setForeground(Color.black);

		c.gridx=0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(btnExit,c);

		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(lvlExit,c);
		lvlExit.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlExit.setForeground(Color.black);

	}
	private void panelReportWork() {

		//panelReport.setBackground(Color.cyan);
		panelReport.setPreferredSize(new Dimension(250,535));
		GridBagConstraints c =new GridBagConstraints();
		panelReport.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelReport.add(btnSetupReport,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelReport.add(lvlSetupReport,c);
		lvlSetupReport.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlSetupReport.setForeground(Color.black);


		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelReport.add(btnTaskReport,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelReport.add(lvlTaskReport,c);
		lvlTaskReport.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlTaskReport.setForeground(Color.black);


	}
	private void panelTaskWork() {

		//panelTask.setBackground(Color.gray);
		scrollTask.setPreferredSize(new Dimension(250,535));
		GridBagConstraints c =new GridBagConstraints();
		panelTask.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(btnOpeningStock,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(lvlOpeningStock,c);
		lvlOpeningStock.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlOpeningStock.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(btnItemReceipt,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(lvlItemReceipt,c);
		lvlItemReceipt.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlItemReceipt.setForeground(Color.black);

		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(btnReceiptReturn,c);

		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(lvlReceiptReturn,c);
		lvlReceiptReturn.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlReceiptReturn.setForeground(Color.black);

		c.gridx=0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(btnSales,c);

		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(lvlSales,c);
		lvlSales.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlSales.setForeground(Color.black);


		c.gridx=0;
		c.gridy=8;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(btnSalesReturn,c);

		c.gridx=0;
		c.gridy=9;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(lvlSalesReturn,c);
		lvlSalesReturn.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlSalesReturn.setForeground(Color.black);

		c.gridx=0;
		c.gridy=10;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(btnWastage,c);

		c.gridx=0;
		c.gridy=11;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(3, 3, 3, 3);
		panelTask.add(lvlWastage,c);
		lvlWastage.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlWastage.setForeground(Color.black);

	}

	private void panelSecurityWork() {
		//panelSecurity.setBackground(Color.darkGray);
		panelSecurity.setPreferredSize(new Dimension(250,535));
		GridBagConstraints c =new GridBagConstraints();
		panelSecurity.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSecurity.add(btnNewUser,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSecurity.add(lvlNewUser,c);
		lvlNewUser.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,15));
		lvlNewUser.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSecurity.add(btnChangePassword,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSecurity.add(lvlChangePassword,c);
		lvlChangePassword.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,12));
		lvlChangePassword.setForeground(Color.black);
	}
	private void panelSetupWork() {
		panelSetup.setBackground(Color.white);
		panelSetup.setPreferredSize(new Dimension(250,535));

		GridBagConstraints c = new GridBagConstraints();
		panelSetup.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(btnCategory,c);

		c.gridx=0;
		c.gridy=1;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(lvlCategoryInfo,c);
		lvlCategoryInfo.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,15));
		lvlCategoryInfo.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(btnSupplier,c);

		c.gridx=0;
		c.gridy=3;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(lvlSupplierInfo,c);
		lvlSupplierInfo.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,15));
		lvlSupplierInfo.setForeground(Color.black);

		c.gridx=0;
		c.gridy=4;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(btnParty,c);

		c.gridx=0;
		c.gridy=5;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(lvlPartyInfo,c);
		lvlPartyInfo.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,15));
		lvlPartyInfo.setForeground(Color.black);

		c.gridx=0;
		c.gridy=6;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(btnProduct,c);

		c.gridx=0;
		c.gridy=7;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(lvlProductInfo,c);
		lvlProductInfo.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,15));
		lvlProductInfo.setForeground(Color.black);
	}

}
