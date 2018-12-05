package alv.data;

import java.util.List;
import java.util.Map;

public interface IUsagersDAL {
	List<Map<String, Object>> fetch();
}
