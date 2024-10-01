package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;
	
	public HourContract() {
		
	}
	public HourContract(String date, Double valuePerHour, Integer hours) {
		this.date = LocalDate.parse(date, format);
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = LocalDate.parse(date, format);
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public Double totalValue() {
		return valuePerHour * hours;
	}
}
