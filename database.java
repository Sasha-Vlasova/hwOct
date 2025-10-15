import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database<T> { 
    private ArrayCollection<T> allMarkers = new ArrayCollection<T>();
    

        double x;
        double y;
        int objectId;
        String signRegion;
        String signCounty;
        String signRoute;
        String signTravelDirection;
        String signPosition;
        double signLatitude;
        double signLongitude;
        double mileMarkerDisplay;
        String mileMarkerLabel;
        String lastRefreshDate;


    public Database(String fileName)
    {        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
        {
        String line = "";
        String splitSign = ",";
        reader.readLine();// skip header
            
            while ((line = reader.readLine()) != null) 
            {
                 
                String[] splitVal = line.split( splitSign); // by commas         

                x = Double.parseDouble(splitVal[0]);
                y = Double.parseDouble(splitVal[1]);
                objectId            = Integer.valueOf(splitVal[2]);
                signRegion          = splitVal[3];
                signCounty          = splitVal[4];
                signRoute           = splitVal[5];
                signTravelDirection = splitVal[6];
                signPosition        = splitVal[7];
                signLatitude        = Double.parseDouble(splitVal[8]);
                signLongitude       = Double.parseDouble(splitVal[9]);
                mileMarkerDisplay   = Double.parseDouble(splitVal[10]);
                mileMarkerLabel     = splitVal[11];
                lastRefreshDate     = splitVal[12];
                
                Marker markerPopulation = new Marker(x, y, objectId, signRegion, signCounty, signRoute, signTravelDirection, signPosition, signLatitude, signLongitude, mileMarkerDisplay, mileMarkerLabel, lastRefreshDate);
                allMarkers.add((T) markerPopulation);
                //System.out.println(allMarkers.size()); <- debugging
            }
        } catch (IOException e) {
            e.getMessage(); // error case
        } 
        
    }

    // Given some location, return an int of the number of signs in the given location. 
    public int NumberOfSignsInLocation(String location){
       int numberOfSigns = 0;
        for (int i =0; i< allMarkers.size(); i++)
        {
            T markerPopulation = allMarkers.elements[i];
            if (markerPopulation!=null)
                if (( ((Marker ) markerPopulation).getSignCounty()).equals( location))
                    numberOfSigns++;
        }
        return numberOfSigns;
    }

    // Given some location and direction, return the number of matching signs 
    public int LocationAndDirection(String location, String direction) // is location our county name or region??? -> since we don't know if we are given region or county we can check both?
    {
        int count=0;
        for (int i=0; i<allMarkers.size(); i++)
        {
            T marker = allMarkers.elements[i];
            if (((Marker) marker).getSignCounty().equals(location)  && ((Marker) marker).getSignTravelDirection().equals(direction) )
                count++; // ask about region and county
        }
       
        
        return count;
    }
    // Top-N counties by sign count
    public List<Map.Entry<String,Integer>> topNCounties(int n)// I had to do a huge research on how to do this method, 
    //especially becasue of the return type which I never used before samee with the topNRoute method below 
    
    {
        if (n<=0)
            return null;

        Map<String, Integer> countyCounts = new HashMap<>(); 
        List<Map.Entry<String,Integer>> countyTopList = new ArrayList<>();
        //String priveousCounty = "";
        int preCounty = 0;

        for (int i = 0; i < allMarkers.size(); i++)
        {
            
            T marker = allMarkers.elements[i];
            Marker elementMarker = (Marker) marker; /// cast to Marker type
            String county = elementMarker.getSignCounty();
            
            if (!countyCounts.containsKey(county)) // if my map does not contain this county (method containsKey is included in the import package)
            {
                countyCounts.put(county,  NumberOfSignsInLocation(county)); // then we have every county and its count once (no repetition) - put is included in the import package
                if (countyTopList.size() < n) 
                {    
                    countyTopList.add(new AbstractMap.SimpleEntry<>(county, countyCounts.get(county)));
                    
                    
                    preCounty = countyTopList.get(0).getValue();
                    for (int a = 1; a < countyTopList.size(); a++) {
                        int val = countyTopList.get(a).getValue();
                        if (val < preCounty) {
                            preCounty = val;
                        }
                    }
                    
                    
                    //preCounty =  getLowestCount(countyTopList);
                }
                else if (countyCounts.get(county) > preCounty && countyTopList.size() >= n)
                {
                    Map.Entry<String, Integer> lowestEntry = countyTopList.get(0); 

                    for (int k=1; k<countyTopList.size(); k++)
                    {
                        Map.Entry<String, Integer> entry = countyTopList.get(k);
                        if (entry.getValue() < lowestEntry.getValue()) 
                        {
                            lowestEntry = entry;
                        }
                    }
                    countyTopList.remove(lowestEntry);
                    countyTopList.add(new AbstractMap.SimpleEntry<>(county, countyCounts.get(county)));
                    
                    preCounty = countyTopList.get(0).getValue();
                    for (int a = 1; a < countyTopList.size(); a++) {
                        int val = countyTopList.get(a).getValue();
                        if (val < preCounty) {
                            preCounty = val;
                        }
                    }
                    //preCounty = NumberOfSignsInLocation(county);
                }
                else
                    continue;

                    
            }
                
        }
        
        return countyTopList;
    }

    // Top-N routes by sign count
    public List<Map.Entry<String,Integer>> topNRoutes(int n) // I had to do a huge research on how to do this method, 
    //especially becasue of the return type which I never used before samee with the topNCounties method
    {
      /*  if (n<=0)
            return null;
        
        Map<String, Integer> countyRoute = new HashMap<>();
        
        for (int i = 0; i< allMarkers.size(); i++)
        {
            T marker = allMarkers.elements[i];
            Marker elementMarker = (Marker) marker; /// cast to Marker type
            String route = elementMarker.getSignRoute();            
            //countyRoute.put(route,  ????);
        }
        
        List<Map.Entry<String,Integer>> routeTopList = new ArrayList<>();
        
        for (int i = 0; i<countyRoute.size(); i++)
        {
        }
        
        return routeTopList;
    
    */
        if (n<=0)
            return null;

        Map<String, Integer> routeCounts = new HashMap<>(); 
        List<Map.Entry<String,Integer>> countyTopList = new ArrayList<>();
        //String priveousCounty = "";
        int preCounty = 0;

        for (int i = 0; i < allMarkers.size(); i++)
        {
            
            T marker = allMarkers.elements[i];
            Marker elementMarker = (Marker) marker; /// cast to Marker type
            String county = elementMarker.getSignRoute();
            routeCounts.put(county,  NumberOfSignsInLocation(county));
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(routeCounts.entrySet());

        for (int i = 0; i < entries.size(); i++)
        {
            Map.Entry<String, Integer> entry = entries.get(i);
            String route = entry.getKey();
            int count = entry.getValue();

            if (countyTopList.size() < n) 
            {    
                countyTopList.add(new AbstractMap.SimpleEntry<>(route, count));
                
                
                preCounty = countyTopList.get(0).getValue();

                
                for (int a = 1; a < countyTopList.size(); a++) {
                    int val = countyTopList.get(a).getValue();
                    if (val < preCounty) {
                        preCounty = val;
                    }
                }
                
                
                //preCounty =  getLowestCount(countyTopList);
            }
            else if (count > preCounty)
            {
                Map.Entry<String, Integer> lowestEntry = countyTopList.get(0); 

                for (int k=1; k<countyTopList.size(); k++)
                {
                    Map.Entry<String, Integer> entry2 = countyTopList.get(k);
                    if (entry2.getValue() < lowestEntry.getValue()) 
                    {
                        lowestEntry = entry2;
                    }
                }

                countyTopList.remove(lowestEntry);
                countyTopList.add(new AbstractMap.SimpleEntry<>(route, count));
                
                preCounty = countyTopList.get(0).getValue();
                for (int a = 1; a < countyTopList.size(); a++) {
                    int val = countyTopList.get(a).getValue();
                    if (val < preCounty) {
                        preCounty = val;
                    }
                }
                //preCounty = NumberOfSignsInLocation(county);
            }
            else
                continue;
            
        }
        
        return countyTopList;
    }    


    // check if the user wants to see the existant county //like if there is this county we can show it..???
    public boolean contains(String county) {
        for (int i = 0; i < allMarkers.size(); i++)
        {           
            T markerPopulation = allMarkers.elements[i];
            if (markerPopulation!=null)
                if (( ((Marker ) markerPopulation).getSignCounty()).equals( county))
                    return true;
        }
        return false;
        
    }
}
