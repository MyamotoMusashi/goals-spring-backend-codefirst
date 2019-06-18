package goals.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import goals.models.Goal;

@CrossOrigin(origins = "http://localhost:4200")
public interface GoalRepository extends JpaRepository<Goal, Integer>{
	
	@Query("SELECT g FROM goal g where g.id = :id")
	public List<Goal> findQuery(@Param("id") int id);
	
	@Query("SELECT g FROM goal g where g.parentid = 0")
	public List<Goal> findGoalsWithoutParent();
	
	public List<Goal> findGoalsByParentid(int parentid);
	
	public List<Goal> findGoalsByPhase(String phase);
	
	public List<Goal> findGoalsByPhaseIsNull();
	
	public List<Goal> findGoalsByPhaseIsNotNullAndPhaseNotLike(String phase);
	
	public List<Goal> findGoalsByIsDailyIsTrue();
	
	public Goal findGoalByPriority(int priority);
	
	
}
