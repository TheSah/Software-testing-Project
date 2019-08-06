package packer;

/**
 * Class is for box calculations accordingly to the business logic.
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 
    
    /**
     * Constructor to instantiate Box object with parameters
     * @param customer
     * @param depot 
     */

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
     * Add a single product to the box if it can fit
     * @param product 
     * @return string notifying that product is added or not
     */
    
    public String addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
            return "added";
        }
        else {
            return "denied";
        }
        
        
    }
    
    /**
     * Override method to add a product into a box if it can fit in
     * @param product Product to add
     * @param quantity quantity of the product to add
     * @return string notifying that product is added or not
     */
    
    public String addProduct(Product product, int quantity) {
        if (canFit(product,quantity)) {
            contents.addProduct(product, quantity);
            return "added";
        }
        else {
            return "denied";
        }
    }

    /**
     * Creates a string series to create a label for the box
     * @return string with information about items in a box
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.isHazardous()){
            label.append("HAZARDOUS\n");
        }
        return label.toString();
    }
    
    public String toString() {
        return getLabel();
    }
    
    /**
     * Get the weight of the box
     * @return weight of box in Manifest Object in double
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }
    

    /**
     * Check if a product can fit according to weight, max 20kg
     * @param p 
     * @return boolean whether or not the product fits or not
     */
    public boolean canFit(Product p) {
        return (p.getWeight() <= 20) && (this.remainingCapacity() >= p.getWeight());
    }
    /**
     * Override check if product and it's quantity can fit into box
     * @param p the product 
     * @param quantity quantity of the product 
     * @return boolean if product fits or not
     */
    public boolean canFit(Product p, int quantity) {
        return ((p.getWeight() * quantity) <= 20) && (this.remainingCapacity() >= (p.getWeight() * quantity));
    }
    /**
     * Get the remaining weight in which the box has
     * @return the remaining weight that the box can fit
     */
    public double remainingCapacity() {
        return 20 - this.getWeight();
    }
    
    /**
     * check if box contains fragile items
     * @return boolean content contains fragile items
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    /**
     * check if box contains hazardous items
     * @return boolean content contains hazardous items
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
    
}
