package megafono.services;

import megafono.dao.implementacion.CampañaDAONeodatis;
import megafono.domain.model.Campaña;

public class CamapañaServices {

	private CampañaDAONeodatis campañaDAO;
	private static CamapañaServices CampañaService;
	
	private CamapañaServices(){
		campañaDAO = new CampañaDAONeodatis();
	}
	
	public static CamapañaServices getCampañaServices(){
		if(CampañaService == null){
			CampañaService = new CamapañaServices();
		}
		return CampañaService;
	}
	
	public void guardar (Campaña campaña){
		campañaDAO.guardar(campaña);
	}
	
	public void borrar (Campaña campaña){
		campañaDAO.borrar(campaña);
	}
}
