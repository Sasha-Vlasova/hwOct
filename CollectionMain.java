import java.util.*;

public class CollectionMain {
    public static void main(String[] args) {
        //database mileMarkerCSV = new database();
        String fileName = "Mile_Markers_.csv";
        Scanner keyboard = new Scanner(System.in);

        Database<Marker> mileMarkerCSV = new Database<>(fileName);
        
        System.out.println(mileMarkerCSV);
        // interact with user, getting County name
        System.out.println("Welcome to the Mile Marker Database!");
        System.out.println("What county would you like to see?");

        String userCounty = keyboard.next();

        if (mileMarkerCSV.contains(userCounty)) {
            System.out.println("There are " + mileMarkerCSV.NumberOfSignsInLocation(userCounty)+ " signs in " + userCounty + " county.");

        } 
        else {
            System.out.println("There are no signs in " + userCounty + " county.");
        }

        System.out.println("Would you like to search by direction as well? (yes/no)");
        String answer ="";
        answer = keyboard.next();
       
        if (answer.equalsIgnoreCase("yes"))
        {
            System.out.println("What direction would you like to see for this county? (Northbound, Southbound, Eastbound, Westbound)");
            String direction = keyboard.next();
            
            if (direction.equals("Northbound") || direction.equals("Southbound") || direction.equals("Eastbound") || direction.equals("Westbound"))
            {
                System.out.println("There are " + mileMarkerCSV.LocationAndDirection(userCounty, direction));
                
            }
            else
            {
                System.out.println("Invalid direction. Please enter Northbound, Southbound, Eastbound, or Westbound.");
            }
            
        }
        else
            System.out.println("Thank you for using the Mile Marker Database!");


        System.out.println("Out of all the counties, how many top ones would you like to see? ");
        int topN = 0;
        topN = keyboard.nextInt();
        
        System.out.println( "top "+topN+" are "+mileMarkerCSV.topNCounties(topN) );

        System.out.println("Out of all the routes, how many top ones would you like to see? ");
        
        topN = keyboard.nextInt();
        
        System.out.println( "top "+topN+" are "+mileMarkerCSV.topNRoutes(topN) );
        //System.out.println( mileMarkerCSV.topNRoutes(topN) );
        //List<Map.Entry<String,Integer>> topCounties = mileMarkerCSV.topNCounties(topN);

    }


}
