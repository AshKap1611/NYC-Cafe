package santai;

import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Ordering extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtQuantity;
	JComboBox cmbCoffeeType;
	JRadioButton rbnVenti;
	JRadioButton rbnGrande;
	JRadioButton rbnTall;
	private JTable tblOrders;
	private JScrollPane scrollPane;
	private JLabel lblDynamic;
	private JLabel lblError;
	private JButton btnMinus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordering frame = new Ordering();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ordering() {
		setBackground(new Color(186, 228, 225));
		this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(186, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbCoffeeType = new JComboBox();
		cmbCoffeeType.setModel(new DefaultComboBoxModel(new String[] {"Capuccino", "Latte", "Americano", "Espresso"}));
		cmbCoffeeType.setBounds(22, 84, 184, 36);
		contentPane.add(cmbCoffeeType);
		
		rbnVenti = new JRadioButton("Venti");
		buttonGroup.add(rbnVenti);
		rbnVenti.setBounds(237, 89, 69, 23);
		contentPane.add(rbnVenti);
		
		rbnGrande = new JRadioButton("Grande");
		buttonGroup.add(rbnGrande);
		rbnGrande.setBounds(349, 89, 76, 23);
		contentPane.add(rbnGrande);
		
		rbnTall = new JRadioButton("Tall");
		buttonGroup.add(rbnTall);
		rbnTall.setBounds(459, 89, 55, 23);
		contentPane.add(rbnTall);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setOpaque(true);
		btnAdd.setBackground(new Color(170, 255, 198));
		btnAdd.setBorderPainted(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCoffee();
			}
		});
		btnAdd.setBounds(22, 145, 117, 29);
		contentPane.add(btnAdd);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(195, 145, 111, 26);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		txtQuantity.setText("1");
		txtQuantity.setForeground(Color.gray);
		
		txtQuantity.getDocument().addDocumentListener(new DocumentListener() {
			 public void insertUpdate(DocumentEvent e) {
				 txtQuantity.setForeground(Color.black);
		    }

		    public void removeUpdate(DocumentEvent e) {
		    	txtQuantity.setForeground(Color.black);
		    }

		    public void changedUpdate(DocumentEvent e) {
		    	txtQuantity.setForeground(Color.black);
		    }
		   
		});
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(213, 130, 61, 16);
		contentPane.add(lblQuantity);
		
		JLabel lblPrabu = new JLabel("");
		lblPrabu.setIcon(new ImageIcon(Ordering.class.getResource("/santaiImages/urban-coffee-view-stockcake 4.11.37 PM.jpg")));
		lblPrabu.setBounds(332, 124, 220, 209);
		contentPane.add(lblPrabu);
		
		JLabel lblNewLabel = new JLabel("NYC Cafe");
		lblNewLabel.setForeground(new Color(255, 161, 19));
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 57));
		lblNewLabel.setBounds(137, 6, 273, 62);
		contentPane.add(lblNewLabel);
		
		DefaultTableModel tblModel = new DefaultTableModel();
		
		Vector columnTitles = new Vector();
		columnTitles.add("Type");
		columnTitles.add("Size");
		columnTitles.add("Quantity");
		columnTitles.add("Price");
		tblModel.setColumnIdentifiers(columnTitles);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 186, 295, 147);
		contentPane.add(scrollPane);
		
		tblOrders = new JTable(tblModel);
		scrollPane.setViewportView(tblOrders);
		
		// Assuming lblDynamic and cmbCoffeeType are already initialized
		lblDynamic = new JLabel("");
		
		lblDynamic.setIcon(new ImageIcon(Ordering.class.getResource("/santaiImages/capuccino.png")));

		// Add an ActionListener to cmbCoffeeType to handle selection changes
		cmbCoffeeType.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Get the selected item from the JComboBox
		        String coffeeText = cmbCoffeeType.getSelectedItem().toString();
		        
		        // Change the icon of lblDynamic based on the selected coffee type
		        if (coffeeText.equals("Capuccino")) {
		            lblDynamic.setIcon(new ImageIcon(Ordering.class.getResource("/santaiImages/capuccino.png")));
		        } else if (coffeeText.equals("Latte")) {
		            lblDynamic.setIcon(new ImageIcon(Ordering.class.getResource("/santaiImages/latte.png")));
		        } else if (coffeeText.equals("Americano")) {
		            lblDynamic.setIcon(new ImageIcon(Ordering.class.getResource("/santaiImages/americano.png")));
		        } else {
		            lblDynamic.setIcon(new ImageIcon(Ordering.class.getResource("/santaiImages/espresso.png")));
		        }
		    }
		});

		
		lblDynamic.setBounds(441, 6, 111, 82);
		contentPane.add(lblDynamic);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblError.setBounds(199, 169, 95, 16);
		contentPane.add(lblError);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newQuant = Integer.parseInt(txtQuantity.getText()) + 1;
				txtQuantity.setText("" + newQuant);
			}
		});
		btnPlus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnPlus.setBounds(172, 148, 24, 23);
		btnPlus.setBorder(null);
		contentPane.add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newQuant = Integer.parseInt(txtQuantity.getText()) - 1;
				txtQuantity.setText("" + newQuant);
			}
		});
		btnMinus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnMinus.setBounds(301, 150, 24, 16);
		btnMinus.setBorder(null);
		contentPane.add(btnMinus);
	}
	
	private void addCoffee() {
		// FIRST ADD TO THE JLIST
		
		
		// Find the data model for the list
		
		String message = "";
		
		String coffeeText = cmbCoffeeType.getSelectedItem().toString();
		
		// Add the order into the data model
		if (rbnTall.isSelected()) {
			message += "Tall";
		} else if (rbnGrande.isSelected()) {
			message += "Grande";
		} else {
			message += "Venti";
		}
		
		int coffeeQuantity = 0;
		lblError.setText("");
		
		try {
		coffeeQuantity = Integer.parseInt(txtQuantity.getText());
		
		int price = 0;
		
		if (coffeeText.equals("Capuccino")) {
			price = 10 * coffeeQuantity;
		} else if (coffeeText.equals("Latte")) {
			price = 14 * coffeeQuantity;
		} else if (coffeeText.equals("Americano")) {
			price = 6 * coffeeQuantity;
		} else {
			price = 6 * coffeeQuantity;
		}
		// NOW ADD TO JTABLE
		//1. Find Data Model
		
		DefaultTableModel coffeeTable = (DefaultTableModel)tblOrders.getModel();
		
		Vector data = new Vector();
		data.add(coffeeText);
		data.add(message);
		data.add("" + coffeeQuantity);
		data.add("$" + price);
		
		coffeeTable.addRow(data);

		} catch (Exception e) {
			lblError.setText("Enter a Number");
		}
		
	}
}
