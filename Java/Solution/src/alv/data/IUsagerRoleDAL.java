package alv.data;

public interface IUsagerRoleDAL {
	public UsagerRoleDto fetch(int id);
	public int insert(UsagerRoleDto dto);
	public void update(UsagerRoleDto dto);
	public boolean delete(int id);
}
