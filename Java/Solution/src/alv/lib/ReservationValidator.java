package alv.lib;

public class ReservationValidator {
	
	//Can't create this object
	private ReservationValidator() {}
	
	public static boolean Validate() {
		return false;
		
		
		
		
//		PARAMETERS VehicleCategoryId Short, StartDt DateTime, EndDt DateTime;
//		SELECT * FROM tblVehicule 
//		INNER JOIN tblDescVehicule ON tblVehicule.DescriptionId = tblDescVehicule.Id
//		INNER JOIN tblVehicleCategory ON tblDescVehicule.CategoryId = tblVehicleCategory.Id
//		INNER JOIN tblReservation ON tblReservation.CategoryId = tblVehicleCategory.Id
//		WHERE tblReservation.CategoryId = VehicleCategoryId
//		AND StartDt IS NOT BETWEEN tblReservation.StartDt AND tblReservation.EndDt
//
//		;

	}
}
