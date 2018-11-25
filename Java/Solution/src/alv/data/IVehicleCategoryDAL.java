package alv.data;

public interface IVehicleCategoryDAL {
	public VehicleCategoryDto fetch(int id);
	public int insert(VehicleCategoryDto dto);
	public void update(VehicleCategoryDto dto);
	public boolean delete(int id);
}
