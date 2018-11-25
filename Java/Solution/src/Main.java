import alv.lib.Personne;
import alv.lib.Reservation;
import alv.lib.Reservations;

public class Main {
	public static void main(String[] args) {
		Test_Reservations();
		Test_Reservation();
		Test_Personne();
	}
	
	private static void Test_Reservations() {

		System.out.println("Test_Reservations");
		
		Reservations col = Reservations.load();
		col.getItems().forEach(item -> {
			System.out.println(item.getEndDt());
			;
		});
	}

	private static void Test_Reservation() {

		System.out.println("Test_Reservation");
		
		Reservation res = Reservation.load(1);
		System.out.println(res.getId());
		System.out.println(res.getCategoryId());		
	}

	private static void Test_Personne() {

		System.out.println("Test_Personne");
		
		//NEW
		Personne per = Personne.create();
		per.setNom("name");
		per.getAdresse().setAdresse("new address value");
		per.save();
		System.out.println(per.getId());
		System.out.println(per.getNom());
		System.out.println(per.getAdresse().getId());
		System.out.println(per.getAdresse().getAdresse());
		
		
//		int personeId = per.getId();
//
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
//		per = Personne.load(personeId);
//		per.delete();
//		System.out.println(per.getId());
	}
}
