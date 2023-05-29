package p3;

public class Crime {

	String month;	
	String reportedBy;	
	String fallsWithin;	
	double longitude;	
	double latitude;	
	String location;		
	private String crimeType;
	
	
	
	/**
	 * @param month
	 * @param reportedBy
	 * @param fallsWithin
	 * @param longitude
	 * @param latitude
	 * @param location
	 * @param crimeType
	 */
	public Crime(String month, String reportedBy, String fallsWithin, double longitude, double latitude, String location,
			String crimeType) {
		
		setMonth(month);
		setReportedBy(reportedBy); 
		setFallsWithin(fallsWithin);
		setLongitude(longitude);  
	    setLatitude(latitude);	
		setLocation(location);
		setCrimeType(crimeType);	
	}
	
	public Crime() {
		
	}
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the reportedBy
	 */
	public String getReportedBy() {
		return reportedBy;
	}
	/**
	 * @param reportedBy the reportedBy to set
	 */
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}
	/**
	 * @return the fallsWithin
	 */
	public String getFallsWithin() {
		return fallsWithin;
	}
	/**
	 * @param fallsWithin the fallsWithin to set
	 */
	public void setFallsWithin(String fallsWithin) {
		this.fallsWithin = fallsWithin;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the crimeType
	 */
	public String getCrimeType() {
		return crimeType;
	}
	/**
	 * @param crimeType the crimeType to set
	 */
	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	@Override
	public String toString() {
		return "Month: " + month + "\nReported By: " + reportedBy + "\nFalls Within: " + fallsWithin + "\nLongitude: "
				+ longitude + "\nLatitude: " + latitude + "\nLocation: " + location + "\nCrime Type: " + crimeType + "\n";
	}
	
	public void displayLocationCrimeLatLong() {
		System.out.printf("\nLocation: \t"+location);
		System.out.printf("\nCrime Type: \t"+crimeType);
		System.out.printf("\nLongitiude: \t"+longitude);
		System.out.printf("\nLatitude: \t"+latitude);
		System.out.println();
	}
	
	

	
}
