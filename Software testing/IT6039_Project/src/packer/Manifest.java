package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The manifest class holds the products and is essential for multiple classes
 * such as Box and Packer.
 * @author I.M.Bad
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;
    /**
     * Constructor instantiate object
     * holds quantities of each product
     * and list of all products ordered by weight
     */
    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    /**
     * Add a product to the object
     * @param p Product to add
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     * Override add a product and it's quantity to the object
     * @param p product to add
     * @param quantity the quantity to add
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)*quantity);
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    
    /**
     * remove a product from Manifest
     * @param p product to remove
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) >= 0) {
            quantities.remove(p);
            byWeight.remove(p);
        }
        else {
            System.out.println("Product doesn't exist");
        }
    }
    
    /**
     * Get the total weight of all items in manifest.
     * @return 
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += quantities.get(p) * p.getWeight();
        }
        return weight;
    }
    
    /**
     * Get the heaviest product under or equal to a given compare weight
     * @param weight the weight to compare
     * @return the heaviest product in Manifest that is equal or under the weight
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * check if there are items in Manifest
     * @return boolean there are items in Manifest
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }
    
    /**
     * check if manifest contains a given product
     * @param p product to check if it is in Manifest
     * @return boolean the product exists in Manifest or the Hashmap
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     * creates a string out of all the contents in Manifest
     * @return String of all contents in Manifest
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0);
    }
    
    /**
     * Check if manifest contains fragile items
     * @return boolean Manifest contains fragile items
     */
    public boolean hasFragileItems() {
        boolean f = false;
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                f = true;
            }
        }
        return f;
    }
    
    /**
     * check if Manifest contains hazardous items
     * @return boolean Manifest contains hazardous items
     */
    public boolean hasHazardousItems(){
        boolean h = false;
        for (Product p : quantities.keySet()){
            if (p.isHazardous()){
                h = true;
            }
        }
        return h;
    }
    
}
