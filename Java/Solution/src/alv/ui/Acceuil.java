package alv.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Acceuil {
	private JFrame Frm_Acceuil;

	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;

	private javax.swing.JTabbedPane jTabbedPane1;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	private JTable table;

	public Acceuil() {
		initialize();
	}

	private void initialize() {
		Frm_Acceuil = new JFrame("Location de vehicule");
		Frm_Acceuil.setBounds(100, 100, 600, 800);
		Frm_Acceuil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frm_Acceuil.getContentPane().setLayout(null);

		initialiseMenu();
		initialiseOnglets();
		initialiseContenuOngletReservation();
		initialiseContenuOngletLocation();

		Frm_Acceuil.setResizable(false);
		Frm_Acceuil.pack();

	}

	private void initialiseOnglets() {
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 185, Short.MAX_VALUE));

		jTabbedPane1.addTab("Reservations", jPanel1);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 185, Short.MAX_VALUE));

		jTabbedPane1.addTab("Locations", jPanel2);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 185, Short.MAX_VALUE));

		jTabbedPane1.addTab("Retours de location", jPanel3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(Frm_Acceuil.getContentPane());
		Frm_Acceuil.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(72, 72, 72).addComponent(jTabbedPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(62, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(39, 39, 39).addComponent(jTabbedPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(48, Short.MAX_VALUE)));
	}

	private void initialiseMenu() {
		JMenuBar barMenu = new JMenuBar();

		JMenu mnNewMenu = new JMenu("Fichier");
		mnNewMenu.setBounds(71, 0, 107, 24);
		barMenu.add(mnNewMenu);

		JMenuItem mntmImprimer = new JMenuItem("Imprimer");
		mnNewMenu.add(mntmImprimer);

		mnNewMenu.addSeparator();

		JMenuItem mntmChangerDusager = new JMenuItem("Changer d'usager");
		mnNewMenu.add(mntmChangerDusager);

		mnNewMenu.addSeparator();

		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnNewMenu.add(mntmQuitter);

		JMenu mnAdministration = new JMenu("Administration");
		mnAdministration.setBounds(14, 28, 164, 24);
		barMenu.add(mnAdministration);

		JMenu mntmUtilisateur = new JMenu("Utilisateurs");
		mnAdministration.add(mntmUtilisateur);

		JMenuItem mntmConsulterUser = new JMenuItem("Consulter");
		mntmUtilisateur.add(mntmConsulterUser);

		JMenuItem mntmCreerUser = new JMenuItem("Creer");
		mntmUtilisateur.add(mntmCreerUser);

		mnAdministration.addSeparator();

		JMenuItem mntmRapports = new JMenuItem("Rapports");
		mnAdministration.add(mntmRapports);

		JMenu mnAide = new JMenu("?");
		mnAide.setBounds(86, 57, 92, 24);
		barMenu.add(mnAide);

		JMenuItem mntmAide = new JMenuItem("Aide");
		mnAide.add(mntmAide);

		mnAide.addSeparator();

		JMenuItem mntmAPropos = new JMenuItem("A propos...");
		mnAide.add(mntmAPropos);

		JMenu mnUsager = new JMenu("[Nom Usager]");
		mnUsager.setBounds(27, 82, 151, 24);
		barMenu.add(mnUsager);

		JMenuItem mntmChangerDusager_1 = new JMenuItem("Changer D'usager");
		mnUsager.add(mntmChangerDusager_1);

		JMenuItem mntmDeconnecter = new JMenuItem("Deconnecter");
		mnUsager.add(mntmDeconnecter);

		Frm_Acceuil.setJMenuBar(barMenu);
	}

	private void initialiseContenuOngletReservation() {
		jPanel1.setLayout(null);

		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setBounds(12, 33, 56, 16);
		jPanel1.add(lblClasse);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(96, 30, 189, 22);
		jPanel1.add(comboBox);

		JLabel lblDebut = new JLabel("Debut");
		lblDebut.setBounds(12, 72, 56, 16);
		jPanel1.add(lblDebut);

		JLabel lblFin = new JLabel("Fin");
		lblFin.setBounds(12, 104, 56, 16);
		jPanel1.add(lblFin);

		textField_1 = new JTextField();
		textField_1.setBounds(96, 69, 189, 19);
		jPanel1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(96, 101, 189, 19);
		jPanel1.add(textField_2);
		textField_2.setColumns(10);

		JButton btnRechercher_1 = new JButton("Rechercher");
		btnRechercher_1.setBounds(295, 100, 97, 25);
		jPanel1.add(btnRechercher_1);

		JRadioButton rdbtnPossedeSaPropre = new JRadioButton("Possede sa propre assurance");
		rdbtnPossedeSaPropre.setBounds(37, 183, 327, 25);
		jPanel1.add(rdbtnPossedeSaPropre);

		JRadioButton rdbtnNePossedePas = new JRadioButton("Ne possede pas d'assurance +18.30$/jour");
		rdbtnNePossedePas.setBounds(37, 213, 367, 25);
		jPanel1.add(rdbtnNePossedePas);

		JRadioButton rdbtnKmIllimit = new JRadioButton("Km  illimit\u00E9");
		rdbtnKmIllimit.setBounds(37, 253, 127, 25);
		jPanel1.add(rdbtnKmIllimit);

		JRadioButton rdbtnKm = new JRadioButton("0.15$ / Km");
		rdbtnKm.setBounds(37, 283, 127, 25);
		jPanel1.add(rdbtnKm);

		Panel panel_1 = new Panel();

		panel_1.setBounds(121, 464, 182, 108);
		panel_1.setLayout(null);
		jPanel1.add(panel_1);

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
		jPanel1.add(btnSauvegarder);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(12, 573, 97, 25);
		jPanel1.add(btnAnnuler);

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(12, 4, 56, 16);
		jPanel1.add(lblDetails);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(76, 328, 293, 130);
		jPanel1.add(panel_3);
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

		Panel panel_2 = new Panel();
		jPanel1.add(panel_2);

		panel_2.add(btnNouveau);
		panel_2.setLayout(null);

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
		table.setBounds(100, 130, 600, 50);
		jPanel1.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Date", "No Reservation", "Prenom", "Nom", "No Telephone" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, Object.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(198);
		table.getColumnModel().getColumn(3).setPreferredWidth(183);
		table.getColumnModel().getColumn(4).setPreferredWidth(146);

	}

	private void initialiseContenuOngletLocation() {
		jPanel2.setLayout(null);

		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setBounds(12, 33, 56, 16);
		jPanel2.add(lblClasse);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(96, 30, 189, 22);
		jPanel2.add(comboBox);

		JLabel lblDebut = new JLabel("Debut");
		lblDebut.setBounds(12, 72, 56, 16);
		jPanel2.add(lblDebut);

		JLabel lblFin = new JLabel("Fin");
		lblFin.setBounds(12, 104, 56, 16);
		jPanel2.add(lblFin);

		textField_1 = new JTextField();
		textField_1.setBounds(96, 69, 189, 19);
		jPanel2.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(96, 101, 189, 19);
		jPanel2.add(textField_2);
		textField_2.setColumns(10);

		JButton btnRechercher_1 = new JButton("Rechercher");
		btnRechercher_1.setBounds(295, 100, 97, 25);
		jPanel2.add(btnRechercher_1);

		JRadioButton rdbtnPossedeSaPropre = new JRadioButton("Possede sa propre assurance");
		rdbtnPossedeSaPropre.setBounds(37, 183, 327, 25);
		jPanel2.add(rdbtnPossedeSaPropre);

		JRadioButton rdbtnNePossedePas = new JRadioButton("Ne possede pas d'assurance +18.30$/jour");
		rdbtnNePossedePas.setBounds(37, 213, 367, 25);
		jPanel2.add(rdbtnNePossedePas);

		JRadioButton rdbtnKmIllimit = new JRadioButton("Km  illimit\u00E9");
		rdbtnKmIllimit.setBounds(37, 253, 127, 25);
		jPanel2.add(rdbtnKmIllimit);

		JRadioButton rdbtnKm = new JRadioButton("0.15$ / Km");
		rdbtnKm.setBounds(37, 283, 127, 25);
		jPanel2.add(rdbtnKm);

		Panel panel_1 = new Panel();

		panel_1.setBounds(121, 464, 182, 108);
		panel_1.setLayout(null);
		jPanel2.add(panel_1);

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
		jPanel2.add(btnSauvegarder);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(12, 573, 97, 25);
		jPanel2.add(btnAnnuler);

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(12, 4, 56, 16);
		jPanel2.add(lblDetails);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(76, 328, 293, 130);
		jPanel2.add(panel_3);
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

		Panel panel_2 = new Panel();
		jPanel2.add(panel_2);

		panel_2.add(btnNouveau);
		panel_2.setLayout(null);

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
		table.setBounds(100, 130, 600, 50);
		jPanel2.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Date", "No Reservation", "Prenom", "Nom", "No Telephone" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, Object.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(198);
		table.getColumnModel().getColumn(3).setPreferredWidth(183);
		table.getColumnModel().getColumn(4).setPreferredWidth(146);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.Frm_Acceuil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
