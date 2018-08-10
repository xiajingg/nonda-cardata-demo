package nonda.cardata.model.dao;

import nonda.cardata.model.Tire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITireDao extends JpaRepository<Tire,String> {

}
