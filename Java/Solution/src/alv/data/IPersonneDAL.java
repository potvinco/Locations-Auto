package alv.data;

public interface IPersonneDAL {	
	public PersonneDto fetch(int id);
	public int insert(PersonneDto dto);
	public void update(PersonneDto dto);
	public boolean delete(int id);
}
