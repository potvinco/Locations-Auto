package alv.data;

public interface IVehicleDescriptionDAL {
	public VehicleDescriptionDto fetch(int id);
	public int insert(VehicleDescriptionDto dto);
	public void update(VehicleDescriptionDto dto);
	public boolean delete(int id);
}
