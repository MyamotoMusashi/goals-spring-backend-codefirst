package goals.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import goals.models.ActiveGoalsQueue;
import goals.models.Goal;
import goals.repositories.ActiveGoalsQueueRepository;
import goals.repositories.GoalRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GoalsController {
	
	List<Goal> goals;
	
	private GoalRepository goalsRepository;
	
	public GoalsController(GoalRepository goalsRepository) {
		this.goalsRepository = goalsRepository;
	}
	
	
	@GetMapping("/goals")
	public List<Goal> getAll(@RequestParam(value="state", required=false) String state){
		if(state !=null) {
			switch(state) {
				case "waiting":
					return this.goalsRepository.findGoalsByPhase(state);
				case "active":
					return this.goalsRepository.findGoalsByPhaseIsNotNullAndPhaseNotLike("waiting");
				case "inbox":
					return this.goalsRepository.findGoalsByParentIdIsNull();
				case "daily":
					return this.goalsRepository.findGoalsByIsDailyIsTrue();
				default:
					return this.goalsRepository.findAll();			
			}
		}
		else {
			return this.goalsRepository.findAll();
		}

	}
		
	@GetMapping("/goals/download")
	public void getDownload(HttpServletResponse response) throws IOException {
	    
	    Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("All Applications List");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("DESC");
        header.createCell(2).setCellValue("ACTIVE");
        header.createCell(3).setCellValue("LINK_NOTES");

        workbook.write(response.getOutputStream());
     
	    
	    // xls file
	    response.addHeader("Content-disposition", "attachment;filename=sample.xlsx");
	    response.setContentType("application/xlsx");

	    // Copy the stream to the response's output stream.
	 
	    FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
        workbook.write(fileOut);
        workbook.close();
        fileOut.close();
	}
	
	@PostMapping("/goals")
	public List<Goal> AddGoal(@RequestBody Goal newGoal) {
		this.goalsRepository.save(newGoal);
		
		//return this.goalRepository.findGoalsByParentid(0);
		return this.goalsRepository.findAll();
	}
	
	@GetMapping("/goals/{id}")
	public Optional<Goal> getGoalById(@PathVariable(value="id") int id){
		return this.goalsRepository.findById(id);
	}
		
	@PutMapping("/goals/{id}")
	public List<Goal> updateGoalById(@PathVariable(value="id") int id, @RequestBody Goal goals){
		Goal updatedGoal =  this.goalsRepository.findById(id).get();
		
		if (goals.getTitle() != null){
			updatedGoal.setTitle(goals.getTitle());
		}
		
		if (goals.getDescription() != null){
			updatedGoal.setDescription(goals.getDescription());
		}
		
		updatedGoal.setParentId(goals.getParentId());
		updatedGoal.setDueDate(goals.getDueDate());
		updatedGoal.setPhase(goals.getPhase());
		updatedGoal.setEstimatedWork(goals.getEstimatedWork());
		updatedGoal.setRemainingWork(goals.getRemainingWork());
		updatedGoal.setProgress(goals.getProgress());
		updatedGoal.setJustification(goals.getJustification());
		updatedGoal.setIsCompleted(goals.getIsCompleted());
		updatedGoal.setIsReoccuring(goals.getIsReoccuring());
		if (goals.getPriority() != updatedGoal.getPriority()) {
			//Goals otherGoal = this.goalRepository.findGoalByPriority(goals.getPriority());
			//if (otherGoal != null) {
				//otherGoal.setPriority(updatedGoal.getPriority());
				//this.goalRepository.save(otherGoal);
			//}
			updatedGoal.setPriority(goals.getPriority());
		}
		updatedGoal.setPriority(goals.getPriority());
		updatedGoal.setIdealOutcome(goals.getIdealOutcome());
		updatedGoal.setScope(goals.getScope());
		updatedGoal.setBlockingReason(goals.getBlockingReason());
		updatedGoal.setReplacement(goals.getReplacement());
		if(goals.getIsDaily() != null) {
			updatedGoal.setIsDaily(goals.getIsDaily());
		}
		
		this.goalsRepository.save(updatedGoal);
		
		return this.goalsRepository.findAll();
	}
	
	@DeleteMapping("/goals/{id}")
	public List<Goal> deleteGoalById(@PathVariable(value="id") int id){
		
		this.goalsRepository.deleteById(id);
		
		return this.goalsRepository.findAll();
	}	
}
