package it.univaq.mwt.j2ee.market4you.business;

import java.util.List;

import it.univaq.mwt.j2ee.market4you.business.model.Section;
import it.univaq.mwt.j2ee.market4you.business.model.Shop;


public interface SectionService {
	
	// LE SEZIONI ESISTONO GIÀ, BISOGNA SOLO MODIFICARLE PER METTERCI IL TESTO CHE VUOI
	
	void updateSection(Section section) throws BusinessException; 
	
	Section findSectionByPK(Integer id) throws BusinessException;
	
	List<Section> findAllSectionsByShop(Shop shop) throws BusinessException;

}
