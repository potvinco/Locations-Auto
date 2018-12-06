package alv.data;

import java.util.List;
import java.util.Map;

public interface IVehicleReservationsDAL {
	List<Map<String, Object>> fetch(int vehicleId);
}
