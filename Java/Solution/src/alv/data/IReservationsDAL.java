package alv.data;

import java.util.List;
import java.util.Map;

public interface IReservationsDAL {
	List<Map<String, Object>> fetch();
}
