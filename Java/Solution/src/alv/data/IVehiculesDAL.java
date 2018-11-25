package alv.data;

import java.util.List;
import java.util.Map;

public interface IVehiculesDAL {
	List<Map<String, Object>> fetch();
}
