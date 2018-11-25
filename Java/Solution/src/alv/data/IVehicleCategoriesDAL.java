package alv.data;

import java.util.List;
import java.util.Map;

public interface IVehicleCategoriesDAL {
	List<Map<String, Object>> fetch();
}
