package packer;

import java.util.Comparator;

/**
 * class to compare the weight of the products
 * @author I.M.Bad
 * 
 * This is used when we need to sort by product weight descending
 */
public class ProductWeightComparator implements Comparator<Product> {
    
    /**
     * Compare the weight of two products
     * @param a product a
     * @param b product b
     * @return 1 or -1 if less than or greater than
     */
    public int compare(Product a, Product b) {
        if (a.getWeight() < b.getWeight()) {return 1;}
        else if (a.getWeight() > b.getWeight()) {return -1;}
        else return a.getName().compareTo(b.getName());
    }
                
}
