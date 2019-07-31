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
import packer.Packer;
/**
 *
 * @author 90053221
 */
public class PackerTest {
    //test data
     Coordinates testCoordinates0 = new Coordinates(0,0);
     Address testAddress0 = new Address("111 Emerge Rd", "Really", "Inn Town", "D444", testCoordinates0);
     Depot testDepot0 = new Depot("Test Depot", testAddress0);
     
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class...");
    }
     
     //test if packer can function appropriately
     @Test
     public void testPacker(){
        System.out.println("Testing testPacker...");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress0);
        
        Manifest contents = new Manifest();
        contents.addProduct(new Product("Hammer", 3, false, false), 1);
        
        List<Box> done = Packer.packProducts(testCustomer, testDepot0, contents);
        
        
     }

}
