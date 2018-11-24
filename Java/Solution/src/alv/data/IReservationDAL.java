package alv.data;

public interface IReservationDAL {
	public ReservationDto fetch(int id);
	public int insert(ReservationDto dto);
	public void update(ReservationDto dto);
	public boolean delete(int id);
}
