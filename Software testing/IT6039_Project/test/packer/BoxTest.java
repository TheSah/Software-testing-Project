/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
/**
 *
 * @author 90053221
 */
public class BoxTest {
    //test data
    Coordinates testCoordinates0 = new Coordinates(0,0);
    Coordinates testCoordinates1 = new Coordinates(3,4);
    
    Address testAddress0 = new Address("111 Emerge Rd", "Really", "Inn Town", "D444", testCoordinates0);

    
    Depot testDepot0 = new Depot("Test Depot", testAddress0);
    
    Product a2 = new Product("Alpha", 2, true, true);
    Product a3 = new Product("Alpha", 3, false, true);
    
    Product b1 = new Product("Beta", 0, true, true);

    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    
    /*
        test of canFit and main methods of class
    */
    @Test
    public void testItemsCanFit() {
        System.out.println("testItemsCanFit");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress0);
        Box testBox;
        testBox = new Box(testCustomer ,testDepot0);
        //it should not be able to fit more than 20kg
        assertEquals(true, testBox.canFit(b1, 999999));
        assertEquals(true, testBox.canFit(a2, 10));
        //assertEquals(false, testBox.canFit(a3, 7));
        
    }
    
    /*
    Test to see if adding product works correctly and remaining weight works too
    */
    @Test
    public void testContents(){
        System.out.println("testContents");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress0);
        Box testBox;
        testBox = new Box(testCustomer ,testDepot0);
        //it should give the correct remaining weight and only fit limit 20kg
        testBox.addProduct(b1, 9999999);
        assertEquals(0, testBox.getWeight(), 0);
        testBox.addProduct(a2, 2);
        assertEquals(4, testBox.getWeight(), 0);
        assertEquals("added", testBox.addProduct(a3, 4));
        assertEquals(16, testBox.getWeight(), 0);
        //test if we can add product if it exceeds limit of 20kg considering other contents already in box
        assertEquals("denied", testBox.addProduct(a3, 10)); 
        //test to see if there are hazardous items in the box
        assertEquals(true, testBox.isHazardous());
        //test if fragile
        assertEquals(true, testBox.isFragile());
        //test remaining capacity
        assertEquals(4, testBox.remainingCapacity(), 0);
        
    }
    
    //This is to test the label function
    @Test
    public void testLabel(){
        System.out.println("testLabel");
        Customer testCustomer;
        testCustomer = new Customer("Test Customer", testAddress0);
        Box testBox;
        testBox = new Box(testCustomer ,testDepot0);
        //it should give the correct remaining weight and only fit limit 20kg
        testBox.addProduct(b1, 9999999);
        assertEquals(0, testBox.getWeight(), 0);
        testBox.addProduct(a2, 2);
        assertEquals("Test Customer\n111 Emerge Rd\nReally\nInn Town\nD444\nBeta x 9999999\nAlpha x 2\nFRAGILE\nHAZARDOUS\n", 
                testBox.getLabel());
    }
    
}
