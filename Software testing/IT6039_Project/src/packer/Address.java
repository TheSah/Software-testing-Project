package packer;

/**
 * Class handles address keeping and returning coordinates to be used
 * @author I.M.Bad
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;
    
    /**
     * Constructor method to input parameters and instantiate Address object
     * with parameters enlisted below
     * @param street
     * @param suburb
     * @param city
     * @param postcode
     * @param coordinates Takes the x, y coordinates of a coordinate object
     */

    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }
    
    /**
     * Place information into string
     * @return string with street, suburb, city and postcode
     */
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
}
