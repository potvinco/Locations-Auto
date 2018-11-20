package alv.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Reservation {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation window = new Reservation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 852, 1092);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenu mnNewMenu = new JMenu("Fichier");
		mnNewMenu.setBounds(71, 0, 107, 24);
		frame.getContentPane().add(mnNewMenu);
		
		JMenuItem mntmImprimer = new JMenuItem("Imprimer");
		mnNewMenu.add(mntmImprimer);
		
		JMenuItem mntmChangerDusager = new JMenuItem("Changer d'usager");
		mnNewMenu.add(mntmChangerDusager);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnNewMenu.add(mntmQuitter);
		
		JMenu mnAdministration = new JMenu("Administration");
		mnAdministration.setBounds(14, 28, 164, 24);
		frame.getContentPane().add(mnAdministration);
		
		JMenu mnAide = new JMenu("Aide");
		mnAide.setBounds(86, 57, 92, 24);
		frame.getContentPane().add(mnAide);
		
		JMenuItem mntmAide = new JMenuItem("Aide");
		mnAide.add(mntmAide);
		
		JMenuItem mntmAPropos = new JMenuItem("A propos...");
		mnAide.add(mntmAPropos);
		
		JMenu mnUsager = new JMenu("[Nom Usager]");
		mnUsager.setBounds(27, 82, 151, 24);
		frame.getContentPane().add(mnUsager);
		
		JMenuItem mntmChangerDusager_1 = new JMenuItem("Changer D'usager");
		mnUsager.add(mntmChangerDusager_1);
		
		JMenuItem mntmDeconnecter = new JMenuItem("Deconnecter");
		mnUsager.add(mntmDeconnecter);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Reservations");
		tglbtnNewToggleButton.setBounds(14, 137, 137, 25);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Retours de location");
		tglbtnNewToggleButton_1.setBounds(284, 137, 137, 25);
		frame.getContentPane().add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Locations");
		tglbtnNewToggleButton_2.setBounds(149, 137, 137, 25);
		frame.getContentPane().add(tglbtnNewToggleButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(12, 162, 810, 870);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(173, 249, 447, 611);
		panel_2.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setBounds(12, 33, 56, 16);
		panel.add(lblClasse);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(96, 30, 189, 22);
		panel.add(comboBox);
		
		JLabel lblDebut = new JLabel("Debut");
		lblDebut.setBounds(12, 72, 56, 16);
		panel.add(lblDebut);
		
		JLabel lblFin = new JLabel("Fin");
		lblFin.setBounds(12, 104, 56, 16);
		panel.add(lblFin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 69, 189, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 101, 189, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnRechercher_1 = new JButton("Rechercher");
		btnRechercher_1.setBounds(295, 100, 97, 25);
		panel.add(btnRechercher_1);
		
		JLabel lblVehiculeDisponible = new JLabel("1 Vehicule disponible");
		lblVehiculeDisponible.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVehiculeDisponible.setForeground(Color.BLACK);
		lblVehiculeDisponible.setBounds(106, 138, 257, 16);
		panel.add(lblVehiculeDisponible);
		
		JRadioButton rdbtnPossedeSaPropre = new JRadioButton("Possede sa propre assurance");
		rdbtnPossedeSaPropre.setBounds(37, 183, 327, 25);
		panel.add(rdbtnPossedeSaPropre);
		
		JRadioButton rdbtnNePossedePas = new JRadioButton("Ne possede pas d'assurance +18.30$/jour");
		rdbtnNePossedePas.setBounds(37, 213, 367, 25);
		panel.add(rdbtnNePossedePas);
		
		JRadioButton rdbtnKmIllimit = new JRadioButton("Km  illimit\u00E9");
		rdbtnKmIllimit.setBounds(37, 253, 127, 25);
		panel.add(rdbtnKmIllimit);
		
		JRadioButton rdbtnKm = new JRadioButton("0.15$ / Km");
		rdbtnKm.setBounds(37, 283, 127, 25);
		panel.add(rdbtnKm);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(121, 464, 182, 108);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSoustotal = new JLabel("Sous-total:");
		lblSoustotal.setBounds(12, 13, 113, 16);
		panel_1.add(lblSoustotal);
		
		JLabel lblTvq = new JLabel("TVQ:");
		lblTvq.setBounds(12, 31, 56, 16);
		panel_1.add(lblTvq);
		
		JLabel lblTps = new JLabel("TPS");
		lblTps.setBounds(12, 53, 56, 16);
		panel_1.add(lblTps);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(12, 79, 56, 16);
		panel_1.add(lblTotal);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(12, 0, 56, 16);
		panel_1.add(lblPrix);
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.setBounds(306, 573, 129, 25);
		panel.add(btnSauvegarder);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(12, 573, 97, 25);
		panel.add(btnAnnuler);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(12, 4, 56, 16);
		panel.add(lblDetails);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(76, 328, 293, 130);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNom_1 = new JLabel("Nom");
		lblNom_1.setBounds(12, 13, 56, 16);
		panel_3.add(lblNom_1);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(12, 45, 56, 16);
		panel_3.add(lblPrnom);
		
		JLabel lblNoTlphone = new JLabel("No t\u00E9l\u00E9phone");
		lblNoTlphone.setBounds(12, 72, 101, 16);
		panel_3.add(lblNoTlphone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(103, 10, 178, 22);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(103, 42, 178, 22);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(103, 69, 178, 22);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCourriel = new JLabel("Courriel");
		lblCourriel.setBounds(12, 104, 56, 16);
		panel_3.add(lblCourriel);
		
		textField_6 = new JTextField();
		textField_6.setBounds(103, 101, 178, 22);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(676, 226, 97, 25);
		panel_2.add(btnNouveau);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(77, 78, 56, 16);
		panel_2.add(lblDate);
		
		JLabel lblNoReservationn = new JLabel("No Reservation");
		lblNoReservationn.setBounds(163, 78, 108, 16);
		panel_2.add(lblNoReservationn);
		
		textField = new JTextField();
		textField.setBounds(527, 24, 137, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Filter");
		btnRechercher.setBounds(676, 23, 97, 25);
		panel_2.add(btnRechercher);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(296, 78, 56, 16);
		panel_2.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(480, 78, 56, 16);
		panel_2.add(lblPrenom);
		
		JLabel lblNoTelephone = new JLabel("No Telephone");
		lblNoTelephone.setBounds(650, 78, 123, 16);
		panel_2.add(lblNoTelephone);
		
		table = new JTable();
		table.setBounds(71, 96, 702, 122);
		panel_2.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Date", "No Reservation", "Prenom", "Nom", "No Telephone"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNewLabel = new JLabel("Usager 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel.setBounds(685, 28, 107, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrepos = new JLabel("Pr\u00E9pos\u00E9");
		lblPrepos.setBounds(684, 13, 56, 16);
		frame.getContentPane().add(lblPrepos);
		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(198);
		table.getColumnModel().getColumn(3).setPreferredWidth(183);
		table.getColumnModel().getColumn(4).setPreferredWidth(146);
	}
}
