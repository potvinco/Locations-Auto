package alv.data;

public interface IRetourLocationDAL {
	public RetourLocationDto fetch(int id);
	public int insert(RetourLocationDto dto);
	public void update(RetourLocationDto dto);
	public boolean delete(int id);

}
