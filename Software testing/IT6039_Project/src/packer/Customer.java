package packer;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class holds the customer name and address
 * @author I.M.Bad
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;
    
    /**
     * Constructor method to instantiate the object
     * @param name name of the customer
     * @param address address of the customer
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * add a customer address
     * @param address customer address
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * get the name of the customer
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }
    
    /**
     * get the closest address to a depot
     * @param d a Depot 
     * @return the address that is closest to a depot
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestDistance = distance;
                bestAddress = a;
            }
        }
        return bestAddress;
    }

    public String toString() {
        return this.getName();
    }
}
