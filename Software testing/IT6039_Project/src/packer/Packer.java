package packer;

import java.util.ArrayList;
import java.util.List;

/**
 * Packer packs the boxes 
 * @author bunta
 */
public class Packer {
    /**
     * Keeps a list of boxes with packed items
     * @param c Customer object
     * @param d Depot object
     * @param m Manifest object
     * @return boxes that are packed
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c, d);
            }
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            }
            else {
                b.addProduct(prodToAdd);
                m.removeProduct(prodToAdd);
            }  
        }
        if (b != null) {
            packedBoxes.add(b);
            packedBoxes.add(b);
        }
        return packedBoxes;
    }
    
}
