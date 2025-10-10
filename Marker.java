public class Marker {
    private double x;
    private double y;
    private int objectId;
    private String signRegion;
    private String signCounty;
    private String signRoute;
    private String signTravelDirection;
    private String signPosition;
    private double signLatitude;
    private double signLongitude;
    private double mileMarkerDisplay;
    private String mileMarkerLabel;
    private String lastRefreshDate;

    public Marker() {
    }

    public Marker(double x, double y, int objectId, String signRegion, String signCounty, 
                  String signRoute, String signTravelDirection, String signPosition, 
                  double signLatitude, double signLongitude, double mileMarkerDisplay, 
                  String mileMarkerLabel, String lastRefreshDate) {
        this.x = x;
        this.y = y;
        this.objectId = objectId;
        this.signRegion = signRegion;
        this.signCounty = signCounty;
        this.signRoute = signRoute;
        this.signTravelDirection = signTravelDirection;
        this.signPosition = signPosition;
        this.signLatitude = signLatitude;
        this.signLongitude = signLongitude;
        this.mileMarkerDisplay = mileMarkerDisplay;
        this.mileMarkerLabel = mileMarkerLabel;
        this.lastRefreshDate = lastRefreshDate;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getObjectId() {
        return objectId;
    }

    public String getSignRegion() {
        return signRegion;
    }

    public String getSignCounty() {
        return signCounty;
    }

    public String getSignRoute() {
        return signRoute;
    }

    public String getSignTravelDirection() {
        return signTravelDirection;
    }

    public String getSignPosition() {
        return signPosition;
    }

    public double getSignLatitude() {
        return signLatitude;
    }

    public double getSignLongitude() {
        return signLongitude;
    }

    public double getMileMarkerDisplay() {
        return mileMarkerDisplay;
    }

    public String getMileMarkerLabel() {
        return mileMarkerLabel;
    }

    public String getLastRefreshDate() {
        return lastRefreshDate;
    }

    // Setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public void setSignRegion(String signRegion) {
        this.signRegion = signRegion;
    }

    public void setSignCounty(String signCounty) {
        this.signCounty = signCounty;
    }

    public void setSignRoute(String signRoute) {
        this.signRoute = signRoute;
    }

    public void setSignTravelDirection(String signTravelDirection) {
        this.signTravelDirection = signTravelDirection;
    }

    public void setSignPosition(String signPosition) {
        this.signPosition = signPosition;
    }

    public void setSignLatitude(double signLatitude) {
        this.signLatitude = signLatitude;
    }

    public void setSignLongitude(double signLongitude) {
        this.signLongitude = signLongitude;
    }

    public void setMileMarkerDisplay(double mileMarkerDisplay) {
        this.mileMarkerDisplay = mileMarkerDisplay;
    }

    public void setMileMarkerLabel(String mileMarkerLabel) {
        this.mileMarkerLabel = mileMarkerLabel;
    }

    public void setLastRefreshDate(String lastRefreshDate) {
        this.lastRefreshDate = lastRefreshDate;
    }
}
