package goals.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties 
public class Goals {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="parentid")
	private int parentid;
	
	@Column(name="dueDate")
	private String dueDate;
	
	@Column(name="estimatedWork")
	private int estimatedWork;
	
	@Column(name="remainingWork")
	private int remainingWork;
	
	@Column(name="progress")
	private String progress;
	
	@Column(name="justification")
	private String justification;
	
	@Column(name="phase")
	private String phase;
	
	@Column(name="isCompleted")
	private Boolean isCompleted;
	
	@Column(name="isReoccuring")
	private Boolean isReoccuring;
	
	@Column(name="priority")
	private int priority;
	
	@Column(name="idealOutcome")
	private String idealOutcome;
	
	@Column(name="scope")
	private String scope;
	
	@Column(name="blockingReason")
	private String blockingReason;
	
	@Column(name="replacement")
	private String replacement;
	
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
	
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
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
}
