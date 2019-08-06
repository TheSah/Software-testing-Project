package packer;

/**
 * Product class will hold the information for a product
 * @author I.M.Bad
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     * Constructor to instantiate Product object
     * @param name name of the product
     * @param weight weight of the product
     * @param hazardous contents of product hazardous
     * @param fragile contents of product fragile
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * get the weight of the product
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * get the name of the product
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * check if product is hazardous
     * @return the hazardous
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * check if product is fragile
     * @return the fragile
     */
    public boolean isFragile() {
        return fragile;
    }

    public String toString() {
        return this.getName();
    }
    /**
     * check if the product is the same 
     * @param o
     * @return boolean if the product is the same
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
