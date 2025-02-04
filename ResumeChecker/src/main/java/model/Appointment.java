package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
	private int id;
	private String date;
	private String title;
	private int price;
	private int jobSeekerID;
	private int mentorID;
}

