package alv.lib;

public class ReservationValidator {
	
	//Can't create this object
	private ReservationValidator() {}
	
//	public static boolean FindVehicles(int id, date date1, date date2) {
//		
//		String val = "SELECT * FROM ((((tblVehicule LEFT JOIN tblReservation ON tblVehicule.Id = tblReservation.VehiculeId) INNER JOIN tblDescVehicule ON tblVehicule.DescriptionId = tblDescVehicule.Id) INNER JOIN tblVehicleCategory ON tblDescVehicule.CategoryId = tblVehicleCategory.ID) LEFT JOIN tblLocation ON tblVehicule.Id = tblLocation.VehicleId) LEFT JOIN tblRetourLocation ON tblLocation.Id = tblRetourLocation.LocationId WHERE (((tblReservation.StartDt)<=[StartDt]) AND ((tblReservation.EndDt)>=[EndDt]) AND ((tblVehicleCategory.ID)=[CategoryId])) OR (((tblReservation.StartDt)>=[StartDt]) AND ((tblReservation.EndDt)<=[EndDt])) OR (((tblReservation.StartDt)>Date()) AND ((tblReservation.EndDt)>=[StartDt] And (tblReservation.EndDt)<=[EndDt]) AND ((tblReservation.Id) Is Null) AND ((tblRetourLocation.Id) Is Not Null) AND ((tblLocation.Id) Is Null));";
//		return false;
//	}
}
