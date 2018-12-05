package alv.data;

import java.util.List;
import java.util.Map;

public interface IUsagerRolesDAL {
	List<Map<String, Object>> fetch(int id);
}
