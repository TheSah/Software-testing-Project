package packer;

/**
 * Depot class to hold a depot for the company
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;
    /**
     * Constructor to instantiate Depot object
     * @param name name of the depot
     * @param address address of the depot
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     * get the name of the depot
     * @return the name of the depot
     */
    public String getName() {
        return name;
    }
    
    /**
     * get the coordinate of the depot
     * @return the coordinate of the depot
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    public String toString() {
        return this.getName();
    }
    
}
