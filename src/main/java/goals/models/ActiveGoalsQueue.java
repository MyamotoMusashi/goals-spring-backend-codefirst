package goals.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="active_goal")
@JsonIgnoreProperties
public class ActiveGoalsQueue {
	
	@Id
	@GeneratedValue
	@Column(name="active")
	private int id;
	
	@Transient
	private String title;
	
	@OneToOne
	@JoinColumn(name="goal")
	private Goal goal;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public String getTitle() {
		return this.goal.getTitle();
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
