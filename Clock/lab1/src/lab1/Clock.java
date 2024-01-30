package lab1;

public class Clock 
{
	private int hours;		// store hours
	private int minutes;		// store minutes
	private int seconds;	// store seconds
	
	public Clock(){
		setTime(0, 0, 0);
	}
	
	public Clock(int hours, int minutes, int seconds){
		setTime(hours, minutes, seconds);
	}
	
	public void setTime(int hours, int minutes, int seconds){
		if (0 <= hours && hours < 24){
			this.hours = hours;
		}
		
		else{
			System.out.println("\nInvalid time! Program terminating.");
			System.exit(0);
		}
		
		if (0 <= minutes && minutes < 60){
			this.minutes = minutes;
		}
		
		else{
			System.out.println("\nInvalid time! Program terminating.");
			System.exit(0);
		}
		
		if (0 <= seconds && seconds < 60){
			this.seconds = seconds;
		}
		
		else{
			System.out.println("\nInvalid time! Program terminating.");
			System.exit(0);
		}
	}
	
	public int getHours(){
		return hours;
	}
	
	public int getMinutes(){
		return minutes;
	}
	
	public int getSeconds(){
		return seconds;
	}
	
	public void printTime(){
		if (hours < 10){
			System.out.print("0");			
		}
		
		System.out.print(hours + ":");
		
		if (minutes < 10){
			System.out.print("0");
		}
		
		System.out.print(minutes + ":");
		
		if (seconds < 10){
			System.out.print("0");
		}
		
		System.out.print(seconds);
	}
	
	public void incrementHours(){
		hours++;			// increment the value of hours by 1
		
		if (hours > 23){ // if hours is greater than 23
			hours = 0;		// set hours to 0
		}
	}
	
	public void incrementMinutes(){
		minutes++;				// increment the value of minutes by 1
		
		if (minutes > 59){		// if minutes is greater than 59
			minutes = 0;		// set minutes to 0
			incrementHours();	// increment hours
		}
	}
	
	public void incrementSeconds(){
		seconds++;				// increment the value of seconds by 1
		
		if (seconds > 59){		// if seconds is greater than 59
			seconds = 0;		// set seconds to 0
			incrementMinutes();	// increment minutes
		}
	}
	
	public boolean equals(Clock otherClock){
		return (hours == otherClock.hours 
			&& minutes == otherClock.minutes
			&& seconds == otherClock.seconds );
	}
	
	public void makeCopy(Clock otherClock){
		hours = otherClock.hours;
		minutes = otherClock.minutes;
		seconds = otherClock.seconds;
	}
	
	public Clock getCopy(){
		Clock temp = new Clock();
		
		temp.hours = hours;
		temp.minutes = minutes;
		temp.seconds = seconds;
		
		return temp;
	}
	
	public String toString(){
		String str = "";
		
		if (hours < 10){
			str = "0";
		}
		
		str = str + hours + ":";
		
		if (minutes < 10){
			str += "0";
		}
		
		str += minutes + ":";
		
		if (seconds < 10){
			str += "0";
		}
		
		str += seconds;
		
		return str;
	}
	
	public void printTimeInAMPM(){
		if (hours > 0 && hours <= 11){
			printTime();
			System.out.println(" AM");
		}
			
		else if (hours >= 13 && hours <= 23){
			hours = hours - 12;
			printTime();
			System.out.println(" PM");
		}
		
		else if (hours == 0){
			hours = 12;
			printTime();
			System.out.println(" AM");
		}
		
		else if (hours == 12){
			printTime();
			System.out.println(" PM");
		}
	}
}
