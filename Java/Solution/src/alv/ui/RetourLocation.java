package alv.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import alv.lib.Location;
import alv.lib.Locations;

import alv.lib.RetourLocations;

public class RetourLocation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField idRetourLocation;
	private JTextField kmDépart;
	private JList<Object> listRetourLocation;
	private JList<Object> listLocation;
	private JTextField nomClient;
	private JTextField adresse;
	private JTextField kmRetour;
	private JTextField dateDébut;
	private JTextField dateRetour;
	private JTextField heureRetour;
	private JTextField étatVéhicule;
	//private JTable table;
	private JTextField numéroContrat;
	private JTextField immaVéhicule;
	private JTextField coûtDommages;
	private JTextField niveauCarburant;
	private JTextField filtreLocation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetourLocation window = new RetourLocation();
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
	public RetourLocation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 703, 960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Menu
		JMenuItem retourLocation = new JMenuItem(" Retour de location");
		retourLocation.setBackground(SystemColor.inactiveCaption);
		retourLocation.setFont(new Font("Segoe UI", Font.BOLD, 20));
		retourLocation.setForeground(Color.BLUE);
		retourLocation.setBounds(0, 0, 242, 32);
		frame.getContentPane().add(retourLocation);

		rechercher();
		//remplirFormulaire();
	}

	// Panneau de recherche de location
	public void rechercher() {

		JPanel zoneRecherche = new JPanel();
		zoneRecherche.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Zone de recherche",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		zoneRecherche.setBounds(10, 45, 660, 236);
		frame.getContentPane().add(zoneRecherche);
		zoneRecherche.setLayout(null);

		JLabel lblEntrezUnIdentifiant = new JLabel("Identifiant retour location :");
		lblEntrezUnIdentifiant.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEntrezUnIdentifiant.setBounds(66, 20, 226, 27);
		zoneRecherche.add(lblEntrezUnIdentifiant);

		idRetourLocation = new JTextField();
		idRetourLocation.setBounds(304, 19, 202, 27);
		idRetourLocation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		idRetourLocation.setToolTipText("Entrez le num\u00E9ro de la location");
		idRetourLocation.setHorizontalAlignment(SwingConstants.LEFT);
		idRetourLocation.setColumns(15);
		zoneRecherche.add(idRetourLocation);

		JButton btnRechercherLocation = new JButton("Rechercher");
		btnRechercherLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			};	
		});
		btnRechercherLocation.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRechercherLocation.setBounds(518, 20, 132, 27);
		zoneRecherche.add(btnRechercherLocation);

		listRetourLocation = new JList<Object>();
		RetourLocations res = RetourLocations.load();
		ArrayList<alv.lib.RetourLocation> list = res.getItems();

		listRetourLocation.setModel(new AbstractListModel<Object>() {
			
			private static final long serialVersionUID = 1L;

			public int getSize() {
				return list.size();
			}

			public Object getElementAt(int index) {
				return "       " + list.get(index).getLocationId() + "       |       " + list.get(index).getFicheInspectionId() + "       |       "
					   + list.get(index).getRetourDt() + "       |       " + list.get(index).getLastUpdated() + "       |       "
						+ list.get(index).getUpdatedBy();
			}
		});
		
		listRetourLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		listRetourLocation.setBounds(1, 60, 617, 255);
		listRetourLocation.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		listRetourLocation.setFont(new Font("Times New Roman", Font.BOLD, 18));
		listRetourLocation.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listRetourLocation.setVisibleRowCount(-1);

		JScrollPane scrollPane = new JScrollPane(listRetourLocation);
		scrollPane.setBounds(10, 60, 640, 105);
		zoneRecherche.add(scrollPane);

		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			}
		});
		btnNouveau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.getContentPane().repaint();
				remplirFormulaire();
				
				Locations res = Locations.load();
				ArrayList<Location> list = res.getItems();

				listLocation.setModel(new AbstractListModel<Object>() {
					
					private static final long serialVersionUID = 1L;

					public int getSize() {
						return list.size();
					}

					public Object getElementAt(int index) {
						return  "       " + list.get(index).getContractNo() + "       |       " + list.get(index).getPersonne().getNom() + "       |       "
								+ list.get(index).getPermisConduire().getNumero() +  "       |       " + list.get(index).getAdresse().getCodePostal()
								+ "       |       " + list.get(index).getKm() + "       |       " + list.get(index).getPermisConduire().getDateExpiration();
					}
				});
				alv.lib.RetourLocation loc = alv.lib.RetourLocation.create();
				loc.getFicheInspection();
			}
		});
		btnNouveau.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNouveau.setBounds(537, 196, 111, 27);
		zoneRecherche.add(btnNouveau);
	}

	// Panneau du formulaire de retour
			public void remplirFormulaire() {

		JPanel formulaireRetour = new JPanel();
		formulaireRetour.setBorder(new TitledBorder(null, "Formulaire de retour", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLUE));
		formulaireRetour.setBounds(12, 294, 658, 609);
		frame.getContentPane().add(formulaireRetour);
		formulaireRetour.setLayout(null);

		JLabel lblKmDépart = new JLabel("Km de d\u00E9part :");
		lblKmDépart.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblKmDépart.setBounds(321, 260, 145, 27);
		formulaireRetour.add(lblKmDépart);

		JLabel lblDateDeRetour = new JLabel("Date de retour :");
		lblDateDeRetour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDateDeRetour.setBounds(333, 416, 145, 27);
		formulaireRetour.add(lblDateDeRetour);

		JLabel lbltatDuVhicule = new JLabel("\u00C9tat v\u00E9hicule:");
		lbltatDuVhicule.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbltatDuVhicule.setBounds(43, 456, 159, 27);
		formulaireRetour.add(lbltatDuVhicule);

		JButton btnSoumettre = new JButton("Soumettre");
		btnSoumettre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		btnSoumettre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSoumettre.setBounds(250, 553, 132, 43);
		formulaireRetour.add(btnSoumettre);

		kmDépart = new JTextField();
		kmDépart.setFont(new Font("Times New Roman", Font.BOLD, 18));
		kmDépart.setBounds(451, 254, 151, 33);
		formulaireRetour.add(kmDépart);
		kmDépart.setColumns(10);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNom.setBounds(43, 214, 74, 27);
		formulaireRetour.add(lblNom);

		nomClient = new JTextField();
		nomClient.setFont(new Font("Times New Roman", Font.BOLD, 18));
		nomClient.setColumns(10);
		nomClient.setBounds(152, 208, 139, 33);
		formulaireRetour.add(nomClient);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdresse.setBounds(43, 260, 145, 27);
		formulaireRetour.add(lblAdresse);

		adresse = new JTextField();
		adresse.setFont(new Font("Times New Roman", Font.BOLD, 18));
		adresse.setColumns(10);
		adresse.setBounds(152, 254, 139, 33);
		formulaireRetour.add(adresse);

		JLabel lblDateDébut = new JLabel("Date location :");
		lblDateDébut.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDateDébut.setBounds(321, 214, 139, 27);
		formulaireRetour.add(lblDateDébut);

		JLabel lblKmRetour = new JLabel("Km au retour :");
		lblKmRetour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblKmRetour.setBounds(43, 416, 145, 27);
		formulaireRetour.add(lblKmRetour);

		kmRetour = new JTextField();
		kmRetour.setFont(new Font("Times New Roman", Font.BOLD, 18));
		kmRetour.setColumns(10);
		kmRetour.setBounds(177, 410, 114, 33);
		formulaireRetour.add(kmRetour);

		dateDébut = new JTextField();
		dateDébut.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dateDébut.setColumns(10);
		dateDébut.setBounds(451, 208, 151, 33);
		formulaireRetour.add(dateDébut);

		dateRetour = new JTextField();
		dateRetour.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dateRetour.setColumns(10);
		dateRetour.setBounds(488, 404, 114, 33);
		formulaireRetour.add(dateRetour);

		heureRetour = new JTextField();
		heureRetour.setFont(new Font("Times New Roman", Font.BOLD, 18));
		heureRetour.setColumns(10);
		heureRetour.setBounds(488, 450, 114, 33);
		formulaireRetour.add(heureRetour);

		étatVéhicule = new JTextField();
		étatVéhicule.setFont(new Font("Times New Roman", Font.BOLD, 18));
		étatVéhicule.setColumns(10);
		étatVéhicule.setBounds(177, 450, 114, 33);
		formulaireRetour.add(étatVéhicule);

		JLabel lblFicheinspection = new JLabel("Heure de retour :");
		lblFicheinspection.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFicheinspection.setBounds(333, 456, 159, 27);
		formulaireRetour.add(lblFicheinspection);
		
		listLocation = new JList<Object>();
		listLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String value = listLocation.getSelectedValue().toString();
				String [] parts = value.split("\\|");
				String part1 = parts[0];
				String part2 = parts[1];
				String part3 = parts[2];
				String part4 = parts[3];
				String part5 = parts[4];
				String part6 = parts[5];
				
				numéroContrat.setText(part1);
				dateDébut.setText(part6);
				adresse.setText(part4);
				kmDépart.setText(part5);
				immaVéhicule.setText(part3);
				nomClient.setText(part2);
			}		
		});
		listLocation.setBounds(12, 28, 634, 50);
		listLocation.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		listLocation.setFont(new Font("Times New Roman", Font.BOLD, 18));
		listLocation.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listLocation.setVisibleRowCount(-1);

		JScrollPane scrollPane1 = new JScrollPane(listLocation);
		scrollPane1.setBounds(12, 73, 634, 110);
		formulaireRetour.add(scrollPane1);
		
		numéroContrat = new JTextField();
		numéroContrat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		numéroContrat.setColumns(10);
		numéroContrat.setBounds(152, 300, 139, 33);
		formulaireRetour.add(numéroContrat);
		
		JLabel lblContratid = new JLabel("Contrat Id :");
		lblContratid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContratid.setBounds(43, 306, 145, 27);
		formulaireRetour.add(lblContratid);
		
		immaVéhicule = new JTextField();
		immaVéhicule.setFont(new Font("Times New Roman", Font.BOLD, 18));
		immaVéhicule.setColumns(10);
		immaVéhicule.setBounds(451, 300, 151, 33);
		formulaireRetour.add(immaVéhicule);
		
		JLabel lblImmavhicule = new JLabel("ImmaV\u00E9hicule:");
		lblImmavhicule.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblImmavhicule.setBounds(321, 306, 145, 27);
		formulaireRetour.add(lblImmavhicule);
		
		JLabel lblDtalisDeLinspection = new JLabel("D\u00E9tails inspection du v\u00E9hicule");
		lblDtalisDeLinspection.setForeground(Color.BLUE);
		lblDtalisDeLinspection.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblDtalisDeLinspection.setHorizontalAlignment(SwingConstants.CENTER);
		lblDtalisDeLinspection.setBounds(205, 356, 245, 27);
		formulaireRetour.add(lblDtalisDeLinspection);
		
		JLabel lblCotDommages = new JLabel("Co\u00FBt dommages:");
		lblCotDommages.setToolTipText("");
		lblCotDommages.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCotDommages.setBounds(333, 498, 159, 27);
		formulaireRetour.add(lblCotDommages);
		
		coûtDommages = new JTextField();
		coûtDommages.setFont(new Font("Times New Roman", Font.BOLD, 18));
		coûtDommages.setColumns(10);
		coûtDommages.setBounds(488, 496, 114, 33);
		formulaireRetour.add(coûtDommages);
		
		JLabel lblLitreCarburant = new JLabel("Litre carburant:");
		lblLitreCarburant.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLitreCarburant.setBounds(43, 498, 159, 27);
		formulaireRetour.add(lblLitreCarburant);
		
		niveauCarburant = new JTextField();
		niveauCarburant.setFont(new Font("Times New Roman", Font.BOLD, 18));
		niveauCarburant.setColumns(10);
		niveauCarburant.setBounds(177, 492, 114, 33);
		formulaireRetour.add(niveauCarburant);
		
		JLabel labelIdLocation = new JLabel("Identifiant location :");
		labelIdLocation.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelIdLocation.setBounds(120, 33, 171, 27);
		formulaireRetour.add(labelIdLocation);
		
		filtreLocation = new JTextField();
		filtreLocation.setToolTipText("Entrez le num\u00E9ro de la location");
		filtreLocation.setHorizontalAlignment(SwingConstants.LEFT);
		filtreLocation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		filtreLocation.setColumns(15);
		filtreLocation.setBounds(300, 32, 202, 27);
		formulaireRetour.add(filtreLocation);
		
		JButton buttonFiltreLocation = new JButton("Rechercher");
		buttonFiltreLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		buttonFiltreLocation.setFont(new Font("Times New Roman", Font.BOLD, 18));
		buttonFiltreLocation.setBounds(514, 32, 132, 27);
		formulaireRetour.add(buttonFiltreLocation);
	}
}
