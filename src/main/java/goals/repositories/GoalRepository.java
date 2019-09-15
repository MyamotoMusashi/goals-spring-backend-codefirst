package goals.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import goals.models.Goal;

@CrossOrigin(origins = "http://localhost:4200")
public interface GoalRepository extends JpaRepository<Goal, Integer>{
		
	public List<Goal> findGoalsByParentId(int parentid);
	
	public List<Goal> findGoalsByPhase(String phase);
	
	public List<Goal> findGoalsByParentIdIsNull();
	
	public List<Goal> findGoalsByPhaseIsNotNullAndPhaseNotLike(String phase);
	
	public List<Goal> findGoalsByIsDailyIsTrue();
	
	public Goal findGoalByPriority(int priority);
	
	
}
