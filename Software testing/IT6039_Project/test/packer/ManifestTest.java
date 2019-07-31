/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
/**
 *
 * @author 90053221
 */
public class ManifestTest {
    
    //test data
    Product p1 = new Product("Hammer", 3, false, false);
    Product p2 = new Product("Nails", 1, false, false);
    Product p3 = new Product("Ladder", 15, false, false);
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    //test how manifest behaves
    @Test
    public void testProducts(){
        System.out.println("Testing testProducts...");
        Manifest manifest = new Manifest();
        
        //add products
        assertEquals(true, manifest.isEmpty());
        manifest.addProduct(p1, 1);
        manifest.addProduct(p2, 12);
        manifest.addProduct(p3, 2);
        //test if manifest is empty
        assertEquals(false, manifest.isEmpty());
        //test weight return
        assertEquals(45, manifest.getTotalWeight(), 0);
        //test getHeaviestUnder
        assertEquals(p1, manifest.getHeaviestUnder(4));
        assertEquals(p2, manifest.getHeaviestUnder(2));
        assertEquals(p3, manifest.getHeaviestUnder(20));
        //test containsProduct
        assertEquals(true, manifest.containsProduct(p1));
        assertEquals(true, manifest.containsProduct(p2));
        assertEquals(true, manifest.containsProduct(p3));
        //fragile and hazard test
        assertEquals(false, manifest.hasFragileItems());
        assertEquals(false, manifest.hasHazardousItems());
    }
    @Test
    public void testRemoveProduct(){
        System.out.println("Testing testRemoveProduct...");
        Manifest manifest = new Manifest();
        manifest.addProduct(p1, 2);
        manifest.addProduct(p3, 5);
        //test remove product
        manifest.removeProduct(p1);
        manifest.removeProduct(p2);
        assertEquals(75, manifest.getTotalWeight(), 0);
        manifest.removeProduct(p3);
        assertEquals(false, manifest.containsProduct(p1));
        
        assertEquals(true, manifest.isEmpty());
    }
    
    //testing manifest converting products to string
    @Test
    public void testToString(){
        System.out.println("Testing testToString...");
        Manifest manifest = new Manifest();
        manifest.addProduct(p1);
        manifest.addProduct(p2, 12);
        //now test the string builder
        assertEquals("Nails x 12\nHammer x 1\n", manifest.toString());
        manifest.removeProduct(p1);
        manifest.removeProduct(p2);
        assertEquals("", manifest.toString());
    }
}
