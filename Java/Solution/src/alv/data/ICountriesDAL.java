package alv.data;

import java.util.List;
import java.util.Map;

public interface ICountriesDAL {
	List<Map<String, Object>> fetch();
}
