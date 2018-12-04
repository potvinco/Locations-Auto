package alv.data;

public interface ICountryDAL {
	public CountryDto fetch(int id);
	public int insert(CountryDto dto);
	public void update(CountryDto dto);
	public boolean delete(int id);
}
