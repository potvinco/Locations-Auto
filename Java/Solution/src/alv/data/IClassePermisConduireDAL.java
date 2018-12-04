package alv.data;

public interface IClassePermisConduireDAL {
	public ClassePermisConduireDto fetch(int id);
	public int insert(ClassePermisConduireDto dto);
	public void update(ClassePermisConduireDto dto);
	public boolean delete(int id);
}
