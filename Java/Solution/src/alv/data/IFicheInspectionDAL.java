package alv.data;

public interface IFicheInspectionDAL {
	public FicheInspectionDto fetch(int id);
	public int insert(FicheInspectionDto dto);
	public void update(FicheInspectionDto dto);
	public boolean delete(int id);
}
