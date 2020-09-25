package com.example.demo.datapopulate;

import java.util.*;

public class PopulateEntries {
	
	private static String sourceCity;
	private static String  destinationCity;
    private static boolean isFound;
    
    private static PopulateEntries entries;
    
    private static Map<String, LinkedHashSet<String>> routeMap = new HashMap<String, LinkedHashSet<String>>();
    public static List<String> cityList;
    
    public PopulateEntries() {
    	this.isFound = false;
    }
    
    public void setSourceCity(String sourceCity) {
    	this.sourceCity = sourceCity;
    }
    
    public void setDestinationCity(String destinationCity) {
    	this.destinationCity = destinationCity;
    }
	
	// Method to create route between two cities
    public static void addRoute(String city1, String city2) {

        LinkedHashSet<String> nextCity = routeMap.get(city1);

        if (nextCity == null) {
        	nextCity = new LinkedHashSet<String>();
            routeMap.put(city1, nextCity);
        }

        nextCity.add(city2);

    }
	
    // Method to get adjacent/neighbor cities
    public LinkedList<String> neighborCities(String finalCity) {

        LinkedHashSet<String> nextCity = routeMap.get(finalCity);

        if (nextCity == null) {
            return new LinkedList<String>();
        }

        return new LinkedList<String>(nextCity);
    }
    
    // Given the problem statement, assuming if City A -> City B exists then City B -> City A also exists
    public static void addDuplexPath(String city1, String city2) {
    	
    	addRoute(city1, city2);
    	addRoute(city2, city1);

    }
    
    public static boolean isCityValid(String city) {
    	
    	if (cityList.contains(city)) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
    // This method will be called first after main() to populate the entries
	public static void populateEntries() {
		
		entries = new PopulateEntries();
		
		entries.addDuplexPath("Boston", "New York");
		entries.addDuplexPath("Philadelphia", "Newark");
		entries.addDuplexPath("Newark", "Boston");
		entries.addDuplexPath("Trenton", "Albany");

		cityList = new ArrayList<String>();
		cityList.add("Boston");
		cityList.add("New York");
		cityList.add("Philadelphia");
		cityList.add("Newark");
		cityList.add("Trenton");
		cityList.add("Albany");
	}
	
	public static String retrieveFinalOutput() {

        LinkedList<String> traversedList = new LinkedList<String>();
		
		traversedList.add(sourceCity);
		
		// passing populated data to traversal algorithm
		return new PopulateEntries().traverseAlgorithm(entries, traversedList);

	}
	
    private String traverseAlgorithm(PopulateEntries entries, LinkedList<String> traversedList) { 

        LinkedList<String> cities = entries.neighborCities(traversedList.getLast());

        for (String city : cities) {

            if (traversedList.contains(city)) {
                continue;
            }

            if (city.equals(destinationCity)) {
            	traversedList.add(city);
                isFound = true;
                traversedList.removeLast();
                break;
            }

        }

        for (String city : cities) {

        	if (traversedList.contains(city) || city.equals(destinationCity)) {
        		continue;
            }

        	traversedList.addLast(city);
        	
        	// Call method recursively
        	traverseAlgorithm(entries, traversedList);
        	traversedList.removeLast();

        }

        return getFinalResult();

    }
    
    // If path is found this method returns "yes" or else it returns "no" 
    private String getFinalResult() {
    	
    	if (isFound) {
    		return "yes";
    	} else {
    		return "no";
    	}
    	
    }   
}
