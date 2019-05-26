package goals.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import goals.models.Goals;

@CrossOrigin(origins = "http://localhost:4200")
public interface GoalsRepository extends JpaRepository<Goals, Integer>{
	
	@Query("SELECT g FROM Goals g where g.id = :id")
	public List<Goals> findQuery(@Param("id") int id);
	
	@Query("SELECT g FROM Goals g where g.parentid = 0")
	public List<Goals> findGoalsWithoutParent();
	
	public List<Goals> findGoalsByParentid(int parentid);
	
	public List<Goals> findGoalsByPhase(String phase);
	
	public List<Goals> findGoalsByPhaseIsNull();
	
	public List<Goals> findGoalsByPhaseIsNotNullAndPhaseNotLike(String phase);
	
	public List<Goals> findGoalsByIsDailyIsTrue();
	
	public Goals findGoalByPriority(int priority);
	
	
}
