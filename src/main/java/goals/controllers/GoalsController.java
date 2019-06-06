package goals.controllers;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import goals.models.Goals;
import goals.utils.IdGenerator;
import goals.repositories.GoalsRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GoalsController {
	
	List<Goals> goals;
	IdGenerator idGenerator;
	
	
	private GoalsRepository goalRepository;
	
	
	public GoalsController(GoalsRepository goalRepository) {
		this.goalRepository = goalRepository;
//		this.goals = new ArrayList<Goals>();
//		this.idGenerator = new IdGenerator();
//		
//		int count = 10;
//		
//		for (int i = 0; i < 10; i++) {
//			
//			Goal goal = new Goal();
//			
//			goal.setId(this.idGenerator.getNextId());
//			goal.setTitle("Goal#" + i+1);
//			goal.setDescription("Description for goal #" + i+1);
//			
//			goals.add(goal);
//			
//		}
	}
	
	
	@GetMapping("/goals")
	public List<Goals> getAll(@RequestParam(value="state", required=false) String state){
		if(state !=null) {
			switch(state) {
				case "waiting":
					return this.goalRepository.findGoalsByPhase(state);
				case "active":
					return this.goalRepository.findGoalsByPhaseIsNotNullAndPhaseNotLike("waiting");
				case "inbox":
					return this.goalRepository.findGoalsByPhaseIsNull();
				case "daily":
					return this.goalRepository.findGoalsByIsDailyIsTrue();
				default:
					return this.goalRepository.findAll();			
			}
		}
		else {
			return this.goalRepository.findAll();
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
        fileOut.close();
	}
	
	@PostMapping("/goals")
	public List<Goals> AddGoal(@RequestBody Goals newGoal) {
		this.goalRepository.save(newGoal);
		
		return this.goalRepository.findGoalsByParentid(0);
	}
	
	@GetMapping("/goals/{id}")
	public Optional<Goals> getGoalById(@PathVariable(value="id") int id){
		return this.goalRepository.findById(id);
	}
		
	@PutMapping("/goals/{id}")
	public List<Goals> updateGoalById(@PathVariable(value="id") int id, @RequestBody Goals goals){
		Goals updatedGoal =  this.goalRepository.findById(id).get();
		
		if (goals.getTitle() != null){
			updatedGoal.setTitle(goals.getTitle());
		}
		
		if (goals.getDescription() != null){
			updatedGoal.setDescription(goals.getDescription());
		}
		
		updatedGoal.setParentid(goals.getParentid());
		updatedGoal.setDueDate(goals.getDueDate());
		updatedGoal.setPhase(goals.getPhase());
		updatedGoal.setEstimatedWork(goals.getEstimatedWork());
		updatedGoal.setRemainingWork(goals.getRemainingWork());
		updatedGoal.setProgress(goals.getProgress());
		updatedGoal.setJustification(goals.getJustification());
		updatedGoal.setIsCompleted(goals.getIsCompleted());
		updatedGoal.setIsReoccuring(goals.getIsReoccuring());
		if (goals.getPriority() != updatedGoal.getPriority()) {
			Goals otherGoal = this.goalRepository.findGoalByPriority(goals.getPriority());
			if (otherGoal != null) {
				otherGoal.setPriority(updatedGoal.getPriority());
				this.goalRepository.save(otherGoal);
			}
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
		
		this.goalRepository.save(updatedGoal);
		
		return this.goalRepository.findAll();
	}
	
	@DeleteMapping("/goals/{id}")
	public List<Goals> deleteGoalById(@PathVariable(value="id") int id){
		
		this.goalRepository.deleteById(id);
		
		return this.goalRepository.findAll();
	}
	
//	@RequestMapping(value="/gosho", method=RequestMethod.GET)
//	public ResponseEntity<String> gosho(Principal principal) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		OAuth2AuthenticationDetails auth = (OAuth2AuthenticationDetails) authentication.getDetails();
//		
//		 
//		String accessToken = auth.getTokenValue();
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		String query = "Bearer " + accessToken;
//		headers.set("Authorization",query);
//		
//		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//		response = restTemplate.exchange("https://www.googleapis.com/calendar/v3/calendars/knifed313@gmail.com/events",HttpMethod.GET,entity, String.class);
//		return response;
//	}
//	
//	@RequestMapping(value="/addEvent", method=RequestMethod.GET)
//	public ResponseEntity<String> addEventToGoogleCalendar() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		OAuth2AuthenticationDetails auth = (OAuth2AuthenticationDetails) authentication.getDetails();
//		String accessToken = auth.getTokenValue();
//		
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		String query = "Bearer " + accessToken;
//		headers.set("Authorization",query);
//		
//		Event event = new Event();
//		event.setSummary("Finally! My First Event");
//		
//		String start = "2019-03-04";
//		event.setStart(start);
//		
//		String end = "2019-03-04";
//		event.setEnd(end);
//		
//		HttpEntity<Event> entity = new HttpEntity<Event>(event, headers);
//		
//		response = restTemplate.exchange("https://www.googleapis.com/calendar/v3/calendars/knifed313@gmail.com/events",HttpMethod.POST,entity, String.class);
//		
//		return response;
//	}
	
}
