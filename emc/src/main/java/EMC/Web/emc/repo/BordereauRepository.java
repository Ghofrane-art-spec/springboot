package EMC.Web.emc.repo;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import EMC.Web.emc.entities.Bordereau;


public interface BordereauRepository extends JpaRepository<Bordereau, Long> {
	 @Query("SELECT b FROM Bordereau b WHERE b.dateBordereau = :date")
	   Set<Bordereau> listeBordereau(@Param("date") Date date);


}
