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
		
		Personne per = Personne.create();
		per.getDto().setNom("name");
		per.save();
		System.out.println(per.getDto().getId());
		System.out.println(per.getDto().getNom());
		
		
		int personeId = per.getDto().getId();

		per = Personne.load(personeId);
		System.out.println(per.getDto().getNom());
		per.getDto().setNom("updated nom 2");
		per.save();
		per = null;
		
		per = Personne.load(personeId);
		System.out.println(per.getDto().getNom());
		per = null;
		
		per = Personne.load(personeId);
		per.delete();
		System.out.println(per.getDto().getId());
	}
}
