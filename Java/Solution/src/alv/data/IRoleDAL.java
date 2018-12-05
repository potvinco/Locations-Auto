package alv.data;

public interface IRoleDAL {
	public RoleDto fetch(int id);
	public int insert(RoleDto dto);
	public void update(RoleDto dto);
	public boolean delete(int id);
}
