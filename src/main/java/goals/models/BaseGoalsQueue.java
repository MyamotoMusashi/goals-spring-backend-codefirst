package goals.models;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@MappedSuperclass
public class BaseGoalsQueue {

	@OneToOne()
	@JoinColumn(name="goal")
	private Goal goal;
	
	public Goal getGoal() {
		return goal;
	}
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	@Transient
	private int id;
	
	@Transient
	private String title;
	
	@Transient
	private String description;

	@Transient
	private Integer parentid;

	@Transient
	private String dueDate;

	@Transient
	private int estimatedWork;

	@Transient
	private int remainingWork;
	
	@Transient
	private String progress;
	
	@Transient
	private String justification;
	
	@Transient
	private String phase;
	
	@Transient
	private Boolean isCompleted;
	
	@Transient
	private Boolean isReoccuring;
		
	@Transient
	private String idealOutcome;
	
	@Transient
	private String scope;
	
	@Transient
	private String blockingReason;
	
	@Transient
	private String replacement;
	
	@Transient
	private Boolean isDaily;
	
	@Transient
	private List<Goal> children;
	
	public int getId() {
		return this.goal.getId();
	}
	
	public void setId(int id) {
		this.goal.setId(id);
	}
	
	public String getTitle() {
		return this.goal.getTitle();
	}
	public void setTitle(String title) {
		this.goal.setTitle(title);
	}

	public String getDescription() {
		return this.goal.getDescription();
	}
	public void setDescription(String description) {
		this.goal.setDescription(description);
	}
	
	public Integer getParentid() {
		return this.goal.getParentid();
	}
	public void setParentid(Integer parentid) {
		this.goal.setParentid(parentid);
	}
	
	public String getDueDate() {
		return this.goal.getDueDate();
	}
	public void setDueDate(String dueDate) {
		this.goal.setDueDate(dueDate);
	}
	
	public int getEstimatedWork() {
		return this.goal.getEstimatedWork();
	}
	public void setEstimatedWork(int estimatedWork) {
		this.goal.setEstimatedWork(estimatedWork);
	}
	
	public int getRemainingWork() {
		return this.goal.getRemainingWork();
	}
	public void setRemainingWork(int remainingWork) {
		this.goal.setRemainingWork(remainingWork);
	}
	
	public String getProgress() {
		return this.goal.getProgress();
	}
	public void setProgress(String progress) {
		this.goal.setProgress(progress);
	}
	
	public String getJustification() {
		return this.goal.getJustification();
	}
	public void setJustification(String justification) {
		this.goal.setJustification(justification);
	}
	
	public String getPhase() {
		return this.goal.getPhase();
	}
	public void setPhase(String phase) {
		this.goal.setPhase(phase);
	}
	
	public Boolean getIsCompleted() {
		return this.goal.getIsCompleted();
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.goal.getIsCompleted();
	}
	
	public Boolean getIsReoccuring() {
		return this.goal.getIsReoccuring();
	}
	public void setIsReoccuring(Boolean isReoccuring) {
		this.goal.setIsReoccuring(isReoccuring);
	}
		
	public String getIdealOutcome() {
		return this.goal.getIdealOutcome();
	}
	public void setIdealOutcome(String idealOutcome) {
		this.goal.setIdealOutcome(idealOutcome);
	}
	
	public String getScope() {
		return this.goal.getScope();
	}
	public void setScope(String scope) {
		this.goal.setScope(scope);
	}
	
	public String getBlockingReason() {
		return this.goal.getBlockingReason();
	}
	public void setBlockingReason(String blockingReason) {
		this.goal.setBlockingReason(blockingReason);
	}
	
	public String getReplacement() {
		return this.goal.getReplacement();
	}
	public void setReplacement(String replacement) {
		this.goal.setReplacement(replacement);
	}
	
	public Boolean getIsDaily() {
		return goal.getIsDaily();
	}
	
	public void setIsDaily(Boolean isDaily) {
		this.goal.setIsDaily(isDaily);
	}
	public List<Goal> getChildren() {
		return this.goal.getChildren();
	}
	public void setChildren(List<Goal> children) {
		this.goal.setChildren(children);
	}
}
