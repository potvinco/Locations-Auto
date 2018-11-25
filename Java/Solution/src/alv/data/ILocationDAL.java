package alv.data;

public interface ILocationDAL {
	public LocationDto fetch(int id);
	public int insert(LocationDto dto);
	public void update(LocationDto dto);
	public boolean delete(int id);

}
