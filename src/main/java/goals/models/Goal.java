package goals.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name="goal")
@JsonIgnoreProperties 
public class Goal {
		
	@Id
	@GeneratedValue
	@Column(name="goal")

	private int id;
	
	@Column(name="goal_title")
	private String title;
	
	@Column(name="goal_description")
	private String description;
	
	@Column(name="goal_parentGoal")
	private Integer parentid;
	
	@Column(name="goal_dueDate")
	private String dueDate;
	
	@Column(name="goal_estimatedWork")
	private int estimatedWork;
	
	@Column(name="goal_remainingWork")
	private int remainingWork;
	
	@Column(name="goal_progress")
	private String progress;
	
	@Column(name="goal_justification")
	private String justification;
	
	@Column(name="goal_phase")
	private String phase;
	
	@Column(name="goal_isCompleted")
	private Boolean isCompleted;
	
	@Column(name="goal_isReoccuring")
	private Boolean isReoccuring;
	
	@Column(name="goal_priority")
	private int priority;
	
	@Column(name="goal_idealOutcome")
	private String idealOutcome;
	
	@Column(name="goal_scope")
	private String scope;
	
	@Column(name="goal_blockingReason")
	private String blockingReason;
	
	@Column(name="goal_replacement")
	private String replacement;
	
	@Column(name="goal_isDaily")
	private Boolean isDaily;
	
	@OneToMany(mappedBy="parentid")
	private List<Goal> children;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public int getEstimatedWork() {
		return estimatedWork;
	}
	public void setEstimatedWork(int estimatedWork) {
		this.estimatedWork = estimatedWork;
	}
	public int getRemainingWork() {
		return remainingWork;
	}
	public void setRemainingWork(int remainingWork) {
		this.remainingWork = remainingWork;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public Boolean getIsReoccuring() {
		return isReoccuring;
	}
	public void setIsReoccuring(Boolean isReoccuring) {
		this.isReoccuring = isReoccuring;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getIdealOutcome() {
		return idealOutcome;
	}
	public void setIdealOutcome(String idealOutcome) {
		this.idealOutcome = idealOutcome;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getBlockingReason() {
		return blockingReason;
	}
	public void setBlockingReason(String blockingReason) {
		this.blockingReason = blockingReason;
	}
	public String getReplacement() {
		return replacement;
	}
	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}
	public Boolean getIsDaily() {
		return isDaily;
	}
	public void setIsDaily(Boolean isDaily) {
		this.isDaily = isDaily;
	}
	public List<Goal> getChildren() {
		return children;
	}
	public void setChildren(List<Goal> children) {
		this.children = children;
	}
}
