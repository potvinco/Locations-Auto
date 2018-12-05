package alv.data;

public interface IUsagerDAL {
	public UsagerDto fetch(int id);
	public int insert(UsagerDto dto);
	public void update(UsagerDto dto);
	public boolean delete(int id);
}
