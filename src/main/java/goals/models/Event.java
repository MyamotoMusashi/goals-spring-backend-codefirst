package goals.models;

import java.time.Instant;

public class Event {
	private String summary;
	private Start start;
	private End end;

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Start getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = new Start(start);
	}

	public End getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = new End(end);
	}
	
	public class Start {
		private String date;
		
		public Start(String start) {
			this.setDate(start);
		}

		public String getDate() {
			return this.date;
		}

		public void setDate(String date) {
			this.date = date;
		}
	}
	
	public class End {
		private String date;
		
		public End(String end) {
			this.setDate(end);
		}

		public String getDate() {
			return this.date;
		}

		public void setDate(String date) {
			this.date = date;
		}
	}
}
