package alv.data;

public interface IPermisConduireDAL {
	public PermisConduireDto fetch(int id);
	public int insert(PermisConduireDto dto);
	public void update(PermisConduireDto dto);
	public boolean delete(int id);
}
