package alv.data;

import java.sql.Date;

public interface IReservationValidatorDAL {
	public int fetch(int categoryId, Date startDt, Date endDt);
}
