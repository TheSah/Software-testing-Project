package packer;

/**
 * Coordinate class holds the x and y values for an address
 * @author I.M.Bad
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
     * Constructor to instantiate coordinate object
     * @param x
     * @param y 
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Get the x value of the coordinate
     * @return the x value in double
     */
    public double getX() {
        return x;
    }
    
    /**
     * Get the y values of the coordinate
     * @return the y value in double
     */
    public double getY() {
        return y;
    }
    
    /**
     * Get the euclidean distance to the other coordinate
     * @param other the comparing coordinate
     * @return the distance between this coordinate and other coordinate in double
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    /**
     * Get the manhattan distance to the other coordinate
     * @param other the comparing coordinate
     * @return the distance between this coordinate and other coordinate in double
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    /**
     * Get the company distance between the other coordinate
     * @param other the comparing coordinate
     * @return the distance between this coordinate and other coordinate in double
     */
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1),0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return (dist1 + dist2)/2 + 1;
    }

}
