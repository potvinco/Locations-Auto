import java.time.*;

import alv.lib.CurrentUser;
import alv.lib.Personne;
import alv.lib.Reservation;
import alv.lib.Reservations;

public class Main {
	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.name"));
//		System.out.println(System.getProperty("user.home"));

//		String string = "004 | 034556";
//		String[] parts = string.split("\\|");
//		String part1 = parts[0]; // 004
//		String part2 = parts[1]; // 034556
//		
//
//		System.out.println(part1.trim());
//		System.out.println(part2.trim());
//		Test_CurrentUser();
	
//		Test_Reservations();
//		Test_Reservation();
	//	Test_Personne();
		
		
		
		alv.ui.Acceuil frm = new alv.ui.Acceuil();
		frm.main(null);
	}
	
	private static void Test_CurrentUser() {
		System.out.println(CurrentUser.Login("Owner", "password"));
		System.out.println(CurrentUser.getIdentity().isInRole("admin"));
		System.out.println(CurrentUser.getIdentity().isInRole("ssss"));
		CurrentUser.Logout();
		System.out.println(CurrentUser.Login("OTHER", "password"));
		System.out.println(CurrentUser.getIdentity());
	}
	
	private static void Test_Reservations() {

		System.out.println("Test_Reservations");
		Reservations col = Reservations.load();
		col.getItems().get(0).getEndDt();
		
		col.getItems().forEach(item -> {
			System.out.println(item.getEndDt());
			System.out.println(item.getPersonne().getDateNaissance());
			;
		});
	}

	private static void Test_Reservation() {

		System.out.println("Test_Reservation");
		
		Reservation res = Reservation.load(1);
		System.out.println(res.getId());
		System.out.println(res.getCategoryId());
		
		
		
		
		
		Reservation newRes = Reservation.create();
		newRes.getPersonne().setNom("Ali");
		newRes.setStartDt(LocalDate.now());
		newRes.setEndDt(LocalDate.now());
		
		
		newRes.save();
	}

	private static void Test_Personne() {

		System.out.println("Test_Personne");
		
		//NEW
		Personne per = Personne.create();
		per.setNom("name");
		per.getAdresse().setAdresse("new address value");
		LocalDate date = LocalDate.now();
		per.setDateNaissance(date);
		per.setEmail("email address");
		per.save();
		System.out.println(per.getId());
		System.out.println(per.getNom());
		System.out.println(per.getAdresse().getId());
		System.out.println(per.getAdresse().getAdresse());
		
		
		int personeId = per.getId();

//		per = Personne.load(personeId);
//		System.out.println(per.getNom());
//		per.setNom("updated nom 2");
//		per.save();
//		per = null;
//		
//		per = Personne.load(personeId);
//		System.out.println(per.getNom());
//		per = null;
//		
////		per = Personne.load(personeId);
////		per.delete();
////		System.out.println(per.getId());
	}
}
