package goals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import goals.models.ActiveGoalsQueue;

public interface ActiveGoalsQueueRepository extends JpaRepository<ActiveGoalsQueue, Integer>{

}
