package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {
    
    
    private Manifest contents;
    private Customer customer;
    private Depot depot; 

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    public String addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
            return "added";
        }
        else {
            return "denied";
        }
        
        
    }
    
    
    
    public String addProduct(Product product, int quantity) {
        if (canFit(product,quantity)) {
            contents.addProduct(product, quantity);
            return "added";
        }
        else {
            return "denied";
        }
    }
   
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
    
    public double getWeight() {
        return contents.getTotalWeight();
    }
    

    
    public boolean canFit(Product p) {
        return (p.getWeight() <= 20) && (this.remainingCapacity() >= p.getWeight());
    }
    
    public boolean canFit(Product p, int quantity) {
        return ((p.getWeight() * quantity) <= 20) && (this.remainingCapacity() >= (p.getWeight() * quantity));
    }
    
    public double remainingCapacity() {
        return 20 - this.getWeight();
    }
    
    public boolean isFragile() {
        return contents.hasFragileItems();
    }
    
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
}
