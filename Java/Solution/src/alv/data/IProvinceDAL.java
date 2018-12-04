package alv.data;

public interface IProvinceDAL {
	public ProvinceDto fetch(int id);
	public int insert(ProvinceDto dto);
	public void update(ProvinceDto dto);
	public boolean delete(int id);

}
