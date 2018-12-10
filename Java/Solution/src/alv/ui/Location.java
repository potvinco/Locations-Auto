package alv.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import alv.lib.Reservations;
import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Location extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_NumReservation;
	private JTable table;
	private JTextField txt_nom;
	private JTextField txt_prenom;
	private JTextField txt_adresse;
	private JLabel lblNewLabel_3;
	private JLabel lblVille;
	private JTextField txt_ville;
	private JLabel lblProvince;
	private JTextField txt_province;
	private JLabel lblCodePostal;
	private JTextField txt_codePostal;
	private JLabel lblpermis;
	private JTextField txt_numPermis;
	private JLabel lblPays;
	private JTextField txt_paysPermis;
	private JLabel lblProvince_1;
	private JTextField txt_provincePremis;
	private JLabel lblDateExp;
	private JLabel lblDateEmiss;
	private JLabel lblcarteCredit;
	private JTextField txt_carteCredit;
	private JLabel lblDateExp_1;
	private JLabel lblLocataireconducteur;
	private JLabel lblVehicule;
	private JLabel lblMarque;
	private JTextField txt_MarqueVehicule;
	private JLabel lblserie;
	private JTextField txt_NumSerie;
	private JLabel lblAuDepart;
	private JTextField txt_KmDepart;
	private JLabel lblKm;
	private JLabel lblAuRetour;
	private JTextField txt_KmRetour;
	private JLabel lblKm_1;
	private JLabel lblDateRetour;
	private JButton btnRechercher;
	private JButton btnLocation;
	private ArrayList<alv.lib.Reservation> al;
	private JButton btnEnregistrer;
	private JTextField txtDateNaiss;
	private JTextField txtDateExpCC;
	private JTextField txt_dateExpPermis;
	private JTextField txtDateRetour;
	private JTextField txtDateEmissPermis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Location frame = new Location();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void resize() {
		setBounds(100, 100, 750, 620);
	}

	public void backSize() {
		setBounds(100, 100, 750, 238);
	}

	/**
	 * Create the frame.
	 */
	public Location() {
		setTitle("Location");
		setResizable(false);
		//backSize();
		resize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		txt_NumReservation = new JTextField();
		txt_NumReservation.setToolTipText("Entrez un num\u00E9ro de r\u00E9servation");
		txt_NumReservation.setBounds(20, 11, 210, 20);
		getContentPane().add(txt_NumReservation);
		txt_NumReservation.setColumns(10);

		btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				al = Reservations.load().getItems();

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int j = 0; j < model.getRowCount(); j++) {
					for (int k = 0; k < model.getColumnCount(); k++) {
						model.setValueAt(null, j, k);
					}
				}

				for (int i = 0; i < al.size(); i++) {
					if (al.get(i).getId() == Integer.parseInt(txt_NumReservation.getText())) {
						model.setValueAt(al.get(i).getId(), 0, 0);
						model.setValueAt(al.get(i).getPersonne().getNom(), 0, 1);
						model.setValueAt(al.get(i).getPersonne().getPrenom(), 0, 2);
						model.setValueAt(al.get(i).getPersonne().getTelephone(), 0, 3);
						btnLocation.setEnabled(true);
					} else {
						btnLocation.setEnabled(false);
						backSize();
					}
				}
			}
		});

		btnRechercher.setBounds(240, 10, 129, 23);
		getContentPane().add(btnRechercher);

		btnLocation = new JButton("Location");
		btnLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resize();

				for (int i = 0; i < al.size(); i++) {
					if (al.get(i).getId() == Integer.parseInt(txt_NumReservation.getText())) {
						txt_nom.setText(al.get(i).getPersonne().getNom());
						txt_prenom.setText(al.get(i).getPersonne().getPrenom());
						txt_adresse.setText(al.get(i).getPersonne().getAdresse().getAdresse());

						txt_ville.setText(al.get(i).getPersonne().getAdresse().getVille());
						txt_province.setText("" + al.get(i).getPersonne().getAdresse().getProvince());
						txt_codePostal.setText(al.get(i).getPersonne().getAdresse().getCodePostal());
					}
				}
			}
		});
		btnLocation.setEnabled(false);
		btnLocation.setBounds(632, 72, 89, 23);
		getContentPane().add(btnLocation);

		txt_nom = new JTextField();
		txt_nom.setBounds(119, 242, 112, 20);
		getContentPane().add(txt_nom);
		txt_nom.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(21, 244, 33, 17);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(250, 245, 57, 14);
		getContentPane().add(lblNewLabel_1);

		txt_prenom = new JTextField();
		txt_prenom.setBounds(317, 242, 141, 20);
		getContentPane().add(txt_prenom);
		txt_prenom.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Date naissance");
		lblNewLabel_2.setBounds(498, 245, 89, 14);
		getContentPane().add(lblNewLabel_2);

		txt_adresse = new JTextField();
		txt_adresse.setBounds(119, 273, 588, 20);
		getContentPane().add(txt_adresse);
		txt_adresse.setColumns(10);

		lblNewLabel_3 = new JLabel("Adresse");
		lblNewLabel_3.setBounds(21, 276, 88, 14);
		getContentPane().add(lblNewLabel_3);

		lblVille = new JLabel("Ville");
		lblVille.setBounds(21, 307, 27, 14);
		getContentPane().add(lblVille);

		txt_ville = new JTextField();
		txt_ville.setBounds(119, 304, 111, 20);
		getContentPane().add(txt_ville);
		txt_ville.setColumns(10);

		lblProvince = new JLabel("Province");
		lblProvince.setBounds(250, 307, 57, 14);
		getContentPane().add(lblProvince);

		txt_province = new JTextField();
		txt_province.setBounds(317, 304, 141, 20);
		getContentPane().add(txt_province);
		txt_province.setColumns(10);

		lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setBounds(498, 304, 89, 14);
		getContentPane().add(lblCodePostal);

		txt_codePostal = new JTextField();
		txt_codePostal.setBounds(597, 304, 110, 20);
		getContentPane().add(txt_codePostal);
		txt_codePostal.setColumns(10);

		lblpermis = new JLabel("#Permis");
		lblpermis.setBounds(21, 332, 88, 14);
		getContentPane().add(lblpermis);

		txt_numPermis = new JTextField();
		txt_numPermis.setBounds(119, 335, 112, 20);
		getContentPane().add(txt_numPermis);
		txt_numPermis.setColumns(10);

		lblPays = new JLabel("Pays");
		lblPays.setBounds(250, 338, 46, 14);
		getContentPane().add(lblPays);

		txt_paysPermis = new JTextField();
		txt_paysPermis.setBounds(317, 335, 141, 20);
		getContentPane().add(txt_paysPermis);
		txt_paysPermis.setColumns(10);

		lblProvince_1 = new JLabel("Province");
		lblProvince_1.setBounds(498, 338, 71, 14);
		getContentPane().add(lblProvince_1);

		txt_provincePremis = new JTextField();
		txt_provincePremis.setBounds(597, 335, 110, 20);
		getContentPane().add(txt_provincePremis);
		txt_provincePremis.setColumns(10);

		lblDateExp = new JLabel("Date Exp.");
		lblDateExp.setBounds(21, 369, 62, 14);
		getContentPane().add(lblDateExp);

		lblDateEmiss = new JLabel("Date emiss.");
		lblDateEmiss.setBounds(251, 369, 78, 14);
		getContentPane().add(lblDateEmiss);

		lblcarteCredit = new JLabel("#Carte Credit");
		lblcarteCredit.setBounds(21, 400, 100, 14);
		getContentPane().add(lblcarteCredit);

		txt_carteCredit = new JTextField();
		txt_carteCredit.setBounds(119, 397, 339, 20);
		getContentPane().add(txt_carteCredit);
		txt_carteCredit.setColumns(10);

		lblDateExp_1 = new JLabel("Date Exp.");
		lblDateExp_1.setBounds(498, 400, 71, 14);
		getContentPane().add(lblDateExp_1);

		lblLocataireconducteur = new JLabel("Locataire/Conducteur");
		lblLocataireconducteur.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocataireconducteur.setBounds(20, 218, 210, 14);
		getContentPane().add(lblLocataireconducteur);

		lblVehicule = new JLabel("Vehicule");
		lblVehicule.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVehicule.setBounds(21, 425, 120, 14);
		getContentPane().add(lblVehicule);

		lblMarque = new JLabel("Marque");
		lblMarque.setBounds(21, 450, 46, 14);
		getContentPane().add(lblMarque);

		txt_MarqueVehicule = new JTextField();
		txt_MarqueVehicule.setBounds(119, 450, 339, 20);
		getContentPane().add(txt_MarqueVehicule);
		txt_MarqueVehicule.setColumns(10);

		lblserie = new JLabel("#Serie");
		lblserie.setBounds(498, 450, 46, 14);
		getContentPane().add(lblserie);

		txt_NumSerie = new JTextField();
		txt_NumSerie.setBounds(541, 447, 166, 20);
		getContentPane().add(txt_NumSerie);
		txt_NumSerie.setColumns(10);

		lblAuDepart = new JLabel("Au depart");
		lblAuDepart.setBounds(21, 490, 62, 14);
		getContentPane().add(lblAuDepart);

		txt_KmDepart = new JTextField();
		txt_KmDepart.setBounds(120, 487, 110, 20);
		getContentPane().add(txt_KmDepart);
		txt_KmDepart.setColumns(10);

		lblKm = new JLabel("KM");
		lblKm.setBounds(240, 490, 27, 14);
		getContentPane().add(lblKm);

		lblAuRetour = new JLabel("Au retour");
		lblAuRetour.setBounds(265, 490, 71, 14);
		getContentPane().add(lblAuRetour);

		txt_KmRetour = new JTextField();
		txt_KmRetour.setBounds(339, 487, 86, 20);
		getContentPane().add(txt_KmRetour);
		txt_KmRetour.setColumns(10);

		lblKm_1 = new JLabel("KM");
		lblKm_1.setBounds(442, 490, 46, 14);
		getContentPane().add(lblKm_1);

		lblDateRetour = new JLabel("Date retour");
		lblDateRetour.setBounds(21, 530, 88, 14);
		getContentPane().add(lblDateRetour);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 42, 609, 171);
		getContentPane().add(scrollPane);

		String[] columnNames = { "#Reservation", "Nom", "Prenom", "Tel." };
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				columnNames) {
			
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];

			}
		});
		scrollPane.setViewportView(table);

		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				alv.lib.Location lo = alv.lib.Location.create();
				for (int i = 0; i < al.size(); i++) {
					if (al.get(i).getId() == Integer.parseInt(txt_NumReservation.getText())) {
						lo.getPersonne().setNom(txt_nom.getText());
						lo.getPersonne().setPrenom(txt_prenom.getText());
						lo.getAdresse().setAdresse(txt_adresse.getText());
						lo.getAdresse().setVille(txt_ville.getText());
						//lo.getAdresse().setProvince(txt_province.getText());
						lo.getAdresse().setCodePostal(txt_codePostal.getText());
						lo.getPermisConduire().setNumero(txt_numPermis.getText());
						//lo.getPermisConduire().setCountry(txt_paysPermis.getText());
						//lo.getPermisConduire().setProvince(txt_provincePremis.getText());
						//lo.getVehicule().setNoSerie(txt_NumSerie.getText());
						//lo.getVehicule().setImmatriculation(txt_MarqueVehicule.getText());
						
						DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
						lo.getPersonne().setDateNaissance(LocalDate.parse(txtDateNaiss.getText(), DATE_FORMAT));
						lo.getPermisConduire().setDateExpiration(LocalDate.parse(txtDateEmissPermis.getText(), DATE_FORMAT));
						
			
						
					}
				}
				lo.save();
			}
		});
		btnEnregistrer.setBounds(597, 526, 110, 23);
		getContentPane().add(btnEnregistrer);
		
		txtDateNaiss = new JTextField();
		txtDateNaiss.setBounds(597, 242, 110, 20);
		getContentPane().add(txtDateNaiss);
		txtDateNaiss.setColumns(10);
		
		txtDateExpCC = new JTextField();
		txtDateExpCC.setBounds(597, 397, 110, 20);
		getContentPane().add(txtDateExpCC);
		txtDateExpCC.setColumns(10);
		
		txt_dateExpPermis = new JTextField();
		txt_dateExpPermis.setBounds(119, 366, 111, 20);
		getContentPane().add(txt_dateExpPermis);
		txt_dateExpPermis.setColumns(10);
		
		txtDateRetour = new JTextField();
		txtDateRetour.setBounds(119, 527, 111, 20);
		getContentPane().add(txtDateRetour);
		txtDateRetour.setColumns(10);
		
		txtDateEmissPermis = new JTextField();
		txtDateEmissPermis.setBounds(317, 366, 141, 20);
		getContentPane().add(txtDateEmissPermis);
		txtDateEmissPermis.setColumns(10);
	}
}
