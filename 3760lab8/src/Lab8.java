import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Read file and rank in order by start time, length and end time.
 */

/**
 * @author Zihan Li
 * Student number: A01282005
 * Set: O
 */
public class Lab8 {

    /** list of meetings */
    private static List<Meeting> meetings = new ArrayList<Meeting>();
    
    /** clone of list of meetings */
    private static List<Meeting> newMeetings = new ArrayList<Meeting>();
    
    /** list of meetings by start time order */
    private static List<Meeting> startMeetings = new ArrayList<Meeting>();

    /** list of meetings by length order */
    private static List<Meeting> lengthMeetings = new ArrayList<Meeting>();

    /** list of meetings by end time order */
    private static List<Meeting> endMeetings = new ArrayList<Meeting>();
    
    /**
     * Read file
     * @string filename
     * @throws FileNotFoundException 
     */
    public static void readFile(String filename) throws FileNotFoundException {
        try{
            File f0 = new File(filename);
            Scanner scan = new Scanner(f0);
            String name = "";
            int start;
            int end;

            while (scan.hasNext()) {
                name = scan.nextLine();
                start = scan.nextInt(); 
                end = Integer.valueOf(scan.nextLine().split(" ")[1]);              
                meetings.add(new Meeting(name,start,end));
                newMeetings.add(new Meeting(name,start,end));
            }

            scan.close();
        } catch (Exception e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        }
    }
    
    /**
     * Requests are ranked in order by start time 
     * (earliest start time is chosen first).
     * @throws FileNotFoundException 
     */
    public static void start(String file) throws FileNotFoundException {
        readFile(file);
        String name = "";
        int start = 2400;
        int end = 2400;
        Meeting meeting = new Meeting(name,start,end);
        Meeting last = new Meeting(" ", 0, 0);

         
//        for(int i = 0; i < meetings.size(); i++) {
//            for (Meeting newM : newMeetings){
//                if (newM.getStart() < start) {
//                    meeting = newM;
//                    start = meeting.getStart();
//                    
//                }
//            }
//            
//            if (!last.overlapsWith(meeting)){
//                last = meeting;
//                startMeetings.add(meeting);
//                //System.out.println(meeting.getStart());
//            } 
//            //last = meeting;
//            newMeetings.remove(meeting);
//            start = 2400;
//        }
        System.out.println("names of the meetings scheduled with "
                + "Greedy Algorithm #1 is " + startMeetings.size());
        List<String> listOfStrings = new ArrayList<String>();
        for(Meeting m : startMeetings) {
            listOfStrings.add(m.getName());
        }
        System.out.println(listOfStrings);
            
    }
    
    /**
     * Requests are ranked in order by length
     * (shortest meeting is chosen first)
     * @throws FileNotFoundException 
     */
    public static void length(String file) throws FileNotFoundException {
        readFile(file);
        String name = "";
        int start = 0;
        int end = 2400;
        int length = 2400;
        Meeting meeting = new Meeting(name,start,end);
        Meeting last = new Meeting(" ", 0, 0);

        
        for(int i = 0; i < meetings.size(); i++) {
            for (Meeting newM : newMeetings){
                if (newM.getLength() < length) {
                    meeting = newM;
                    length = meeting.getLength();
                    
                }
            }
            
            if (!last.overlapsWith(meeting)){
                last = meeting;
                lengthMeetings.add(meeting);
                
            } 
            newMeetings.remove(meeting);
            length = 2400;
        }
        System.out.println("names of the meetings scheduled with "
                + "Greedy Algorithm #2 is " + lengthMeetings.size());
        List<String> listOfStrings = new ArrayList<String>();
        for(Meeting m : lengthMeetings) {
            listOfStrings.add(m.getName());
        }
        System.out.println(listOfStrings);
            
            
    }
    
    
    
    /**
     * Requests are ranked in order by end time 
     * (earliest end time is chosen first).
     * @throws FileNotFoundException 
     */
    public static void end(String file) throws FileNotFoundException {
        readFile(file);
        String name = "";
        int start = 2400;
        int end = 2400;
        Meeting meeting = new Meeting(name,start,end);
        Meeting last = new Meeting(" ", 0, 0);

        
        for(int i = 0; i < meetings.size(); i++) {
            for (Meeting newM : newMeetings){
                if (newM.getEnd() < end) {
                    meeting = newM;
                    end = meeting.getEnd();
                    
                }
            }
            
            if (!last.overlapsWith(meeting)){
                last = meeting;
                endMeetings.add(meeting);
                
            } 
            newMeetings.remove(meeting);
            end = 2400;
        }
        System.out.println("names of the meetings scheduled with "
                + "Greedy Algorithm #3 is " + endMeetings.size());
        List<String> listOfStrings = new ArrayList<String>();
        for(Meeting m : endMeetings) {
            listOfStrings.add(m.getName());
        }
        System.out.println(listOfStrings);
            
            
    }
    
    
    
    
    

    /**
     * Print the number and name of meetings scheduled with 
     * Greedy Algorithm #1,2,3
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("data3:");
        start("data3.txt");
        length("data3.txt");
        end("data3.txt");
    }

}
