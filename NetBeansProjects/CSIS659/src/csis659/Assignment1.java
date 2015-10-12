/*
 * This program takes two state codes that can be uppercase or lowercase and calculates
 * the airfare depending on what zone the state falls in. Zone fares calculated by Delta SkyMiles.
 */
package csis659;

import java.util.*;

/**
 *
 * @author lizhealy
 */
public class Assignment1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //All state codes
        String[] destinations = {"AL", "FL", "GA", "MS", "NC", "SC", 
            "TN", "CT", "DC", "DE", "MA", "MD", "ME", "NH", "NJ", "NY", 
            "PA", "RI", "VA", "VT", "WV", "IA", "IL", "IN", "KS", "KY", 
            "MI", "MN", "MO", "NE", "OH", "WI", "AR", "LA", "NM", "OK", 
            "TX", "CO", "ID", "MT", "ND", "SD", "UT", "WY", "AZ", "CA", 
            "NV", "OR", "WA"};
        
        //State codes by zone
        String[] zone1 = {"AL", "FL", "GA", "MS", "NC", "SC", "TN"};
        String[] zone2 = {"CT", "DC", "DE", "MA", "MD", "ME", "NH", "NJ", "NY", "PA", "RI", "VA", "VT", "WV"};
        String[] zone3 = {"IA", "IL", "IN", "KS", "KY", "MI", "MN", "MO", "NE", "OH", "WI"};
        String[] zone4 = {"AR", "LA", "NM", "OK", "TX"};
        String[] zone5 = {"CO", "ID", "MT", "ND", "SD", "UT", "WY"};
        String[] zone6 = {"AZ", "CA", "NV", "OR", "WA"};
        
        //Command line
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first state code: ");
        String code1 = in.nextLine().toUpperCase();
        System.out.println("Enter second state code: ");
        String code2 = in.nextLine().toUpperCase();
        
        //If user enters something other than a state code
        if (!(Arrays.asList(destinations).contains(code1)) || !(Arrays.asList(destinations).contains(code2)))
            System.out.println("Please enter a state abbreviation.");
        
        //If user enters a state code
        else if(Arrays.asList(zone5).contains(code1) && Arrays.asList(zone6).contains(code2))
            System.out.println("Airfare: $238");
        else if(Arrays.asList(zone6).contains(code1) && Arrays.asList(zone5).contains(code2))
            System.out.println("Airfare: $238");
        
        else if(Arrays.asList(zone1).contains(code1) && Arrays.asList(zone2).contains(code2))
            System.out.println("Airfare: $278");
        else if(Arrays.asList(zone2).contains(code1) && Arrays.asList(zone1).contains(code2))
            System.out.println("Airfare: $278");
        else if(Arrays.asList(zone1).contains(code1) && Arrays.asList(zone3).contains(code2))
            System.out.println("Airfare: $278");
        else if(Arrays.asList(zone3).contains(code1) && Arrays.asList(zone1).contains(code2))
            System.out.println("Airfare: $278");
        else if(Arrays.asList(zone2).contains(code1) && Arrays.asList(zone3).contains(code2))
            System.out.println("Airfare: $278");
        else if(Arrays.asList(zone3).contains(code1) && Arrays.asList(zone2).contains(code2))
            System.out.println("Airfare: $278");
        
        else if(Arrays.asList(zone1).contains(code1) && Arrays.asList(zone4).contains(code2))
            System.out.println("Airfare: $318");
        else if(Arrays.asList(zone4).contains(code1) && Arrays.asList(zone1).contains(code2))
            System.out.println("Airfare: $318");
        else if(Arrays.asList(zone2).contains(code1) && Arrays.asList(zone4).contains(code2))
            System.out.println("Airfare: $318");
        else if(Arrays.asList(zone4).contains(code1) && Arrays.asList(zone2).contains(code2))
            System.out.println("Airfare: $318");
        else if(Arrays.asList(zone3).contains(code1) && Arrays.asList(zone4).contains(code2))
            System.out.println("Airfare: $318");
        else if(Arrays.asList(zone4).contains(code1) && Arrays.asList(zone3).contains(code2))
            System.out.println("Airfare: $318");
        
        else if(Arrays.asList(zone5).contains(code1) && Arrays.asList(zone1).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone5).contains(code1) && Arrays.asList(zone2).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone5).contains(code1) && Arrays.asList(zone3).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone5).contains(code1) && Arrays.asList(zone4).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone6).contains(code1) && Arrays.asList(zone1).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone6).contains(code1) && Arrays.asList(zone2).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone6).contains(code1) && Arrays.asList(zone3).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone6).contains(code1) && Arrays.asList(zone4).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone1).contains(code1) && Arrays.asList(zone5).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone2).contains(code1) && Arrays.asList(zone5).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone3).contains(code1) && Arrays.asList(zone5).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone4).contains(code1) && Arrays.asList(zone5).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone1).contains(code1) && Arrays.asList(zone6).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone2).contains(code1) && Arrays.asList(zone6).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone3).contains(code1) && Arrays.asList(zone6).contains(code2))
            System.out.println("Airfare: $398");
        else if(Arrays.asList(zone4).contains(code1) && Arrays.asList(zone6).contains(code2))
            System.out.println("Airfare: $398");
            
    }
    
}
