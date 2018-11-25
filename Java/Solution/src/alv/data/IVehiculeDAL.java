package alv.data;

public interface IVehiculeDAL {
	public VehiculeDto fetch(int id);
	public int insert(VehiculeDto dto);
	public void update(VehiculeDto dto);
	public boolean delete(int id);
}
