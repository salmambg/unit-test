package info.leanix.unittest.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BusinessImpTest {

     @Test
     public void calculateSum() {
         BusinessImp business = new BusinessImp();
         int actualResult = business.calculateSum(new int [] {1,2,3});
         int expectedResult = 6;
         assertEquals(expectedResult,actualResult);
     }

     @Test
     public void calculateSumEmpty() {
         BusinessImp business = new BusinessImp();
         int actualResult = business.calculateSum(new int [] {});
         int expectedResult = 0;
         assertEquals(expectedResult,actualResult);
     }
     @Test
     public void calculateSum_oneValue() {
         BusinessImp business = new BusinessImp();
         int actualResult = business.calculateSum(new int [] {5});
         int expectedResult = 5;
         assertEquals(expectedResult,actualResult);
     }


}