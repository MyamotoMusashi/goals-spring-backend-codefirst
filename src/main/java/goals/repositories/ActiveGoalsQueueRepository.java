package goals.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import goals.models.ActiveGoalsQueue;


public interface ActiveGoalsQueueRepository extends JpaRepository<ActiveGoalsQueue, Integer>{
		
	@Query(value="SELECT * FROM active_goal INNER JOIN goal as g1 ON active_goal.goal = g1.goal", nativeQuery=true)
	public List<ActiveGoalsQueue> findActiveQuery();
	
	//@Query(value="SELECT * FROM inbox_goal INNER JOIN goal as g2 ON inbox_goal.goal = g2.goal", nativeQuery=true)
	//public List<InboxGoalsQueue> findInboxQuery();
	
	//@Query(value="SELECT * FROM backlog_goal INNER JOIN goal as g3 ON backlog_goal.goal = g3.goal", nativeQuery=true)
	//public List<BacklogGoalsQueue> findBacklogQuery();
}
