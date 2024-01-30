package lab1;

public class ClockDriver 
{
	public static void main(String[] args) 
	{
		Clock defaultClock = new Clock();
		defaultClock.printTime();
		
		System.out.println();
		Clock clockWithTime = new Clock (23, 24, 48);
		clockWithTime.printTime();
		int hour = clockWithTime.getHours();
		int minute = clockWithTime.getMinutes();
		int second = clockWithTime.getSeconds();
		
		System.out.println("\n\nShowing the different members of the clock:");
		System.out.println("Hours: " + hour);
		System.out.println("Minutes: " + minute);
		System.out.println("Seconds: " + second);
		
		Clock clockCopy = clockWithTime.getCopy();
		System.out.println("\nAre the 2 clocks equal? " + clockCopy.equals(clockWithTime) );
		
		System.out.println("\nChanging the clock...");
		clockCopy.setTime(1, 58, 59);
		
		System.out.println("Are the 2 clocks equal? " + clockCopy.equals(clockWithTime) );
		System.out.println("\nIncrementing time...");
		
		clockCopy.incrementHours();
		clockCopy.printTime();
		System.out.println();
		
		clockCopy.incrementSeconds();
		clockCopy.printTime();
		System.out.println();
		
		clockCopy.incrementMinutes();
		clockCopy.printTime();
		
		System.out.println("\n\nFinal time of the 3 clocks:");
		System.out.println(defaultClock);
		System.out.println(clockWithTime);
		System.out.println(clockCopy);
		
		System.out.println("\nFinal time of the 3 clocks in AM/PM Format:");
		defaultClock.printTimeInAMPM();
		clockWithTime.printTimeInAMPM();
		clockCopy.printTimeInAMPM();
	}
}
