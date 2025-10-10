import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class database<T> {
    private ArrayCollection<T> allMarkers = new ArrayCollection<T>();
    
    public database(){
        
    }

    // Given some location, return an int of the number of signs in the given location. 
    public int NumberOfSignsInLocation(String location){
        return 0;
    }

    // Given some location and direction, return the number of matching signs 
    public int LocationAndDirection(String location, String direction){
        return 0;
    }
    // Top-N counties by sign count
    public List<Map.Entry<String,Integer>> topNCounties(int n){
        return null;
    }

    // Top-N routes by sign count
    public List<Map.Entry<String,Integer>> topNRoutes(int n){
      return null;
    }    
}
