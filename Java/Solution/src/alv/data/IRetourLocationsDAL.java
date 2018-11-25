package alv.data;

import java.util.List;
import java.util.Map;

public interface IRetourLocationsDAL {
	List<Map<String, Object>> fetch();
}
