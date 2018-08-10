package nonda.cardata.model.dao;

import nonda.cardata.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportsDao extends JpaRepository<Reports,String> {
}
