package alv.data;


public interface IAdresseDAL {
	public AdresseDto fetch(int id);
	public int insert(AdresseDto dto);
	public void update(AdresseDto dto);
	public boolean delete(int id);
}
