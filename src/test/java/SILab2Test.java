import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {


    SILab2 siLab2 = new SILab2();
    List<Time> testResult = new ArrayList<>();
    Time time1 = new Time(12,45,30);
    Time time2 = new Time(16,60,20);
    Time time3 = new Time(8,20,60);
    Time time4 = new Time(24,00,00);
    Time time5 = new Time(-1,00,00);
    Time time6 = new Time(25,00,00);


    @Test
    void f0a() {
        System.out.println("==== TEST CASE 0a +++ HR > 25 || HR < 0 (HR = -1)");
        testResult.add(0,time5);
        //List<Integer> testCHeck = siLab2.function(testResult);
      /*  try{
            siLab2.function(testResult);
        }catch(RuntimeException ex){
            assertEquals("The hours are smaller than the minimum",ex.getMessage(),"Optional Message");
            System.out.println("==== TEST CASE 0a +++ The hours are smaller than the minimum");

        }*/
        assertThrows(RuntimeException.class,()->siLab2.function(testResult));
        testResult.remove(0);
    }

    @Test
    @Disabled
    void FUNCTION(){
        System.out.println("ALL THE HOURS");
        testResult.add(0,time2);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,()->siLab2.function(testResult));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        testResult.remove(0);
        testResult.add(0,time3);
        ex = assertThrows(RuntimeException.class,()->siLab2.function(testResult));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
        testResult.remove(0);
        testResult.add(0,time1);
        List<Integer> testCHeck = siLab2.function(testResult);
        assertEquals(45930,testCHeck.get(0));
        testResult.remove(0);
    }
    @Test
    void f0b() {
        System.out.println("==== TEST CASE 0b +++ HR > 25 || HR < 0 (HR = 25)");
        testResult.add(0,time6);
        //List<Integer> testCHeck = siLab2.function(testResult);
       /* try{
            siLab2.function(testResult);
        }catch(RuntimeException ex){
            assertEquals("The hours are grater than the maximum",ex.getMessage(),"Optional Message");
            System.out.println("==== TEST CASE 0b +++ The hours are grater than the maximum");

        }*/
        assertThrows(RuntimeException.class,()->siLab2.function(testResult));
        testResult.remove(0);
    }


   @Test
    void f1a() {
       System.out.println("==== TEST CASE 1a +++ HR < 24 (12:45:30)");
       testResult.add(0,time1);
       List<Integer> testCHeck = siLab2.function(testResult);
       assertEquals(45930,testCHeck.get(0));
       System.out.println("==== TEST CASE 1a +++ PASSED seconds:45930");
       testResult.remove(0);
    }
    @Test
    void f1b() {
        System.out.println("==== TEST CASE 1b+++ HR < 24 (16:60:20)");
        testResult.add(0,time2);
        //List<Integer> testCHeck = siLab2.function(testResult);
       /* try{
            siLab2.function(testResult);
        }catch(RuntimeException ex){
            assertEquals("The minutes are not valid!",ex.getMessage(),"Optional Message");
            System.out.println("==== TEST CASE 1b +++ The minutes are not valid!");

        }*/
        assertThrows(RuntimeException.class,()->siLab2.function(testResult));
        testResult.remove(0);
    }
    @Test
    void f1c() {
        System.out.println("==== TEST CASE 1c +++ HR < 24 (08:20:60)");
        testResult.add(0,time3);
        /*try{
            siLab2.function(testResult);
        }catch(RuntimeException ex){
            assertEquals("The seconds are not valid",ex.getMessage(),"Optional Message");
            System.out.println("==== TEST CASE 1c +++ The seconds are not valid");

        }*/
        assertThrows(RuntimeException.class,()->siLab2.function(testResult));
        testResult.remove(0);
    }
    @Test
    void f2a() {
        System.out.println("==== TEST CASE 2a +++ hr == 24 && min == 0 && sec == 0 (24:00:00)");
        testResult.add(0,time4);
        List<Integer> testCHeck = siLab2.function(testResult);
        assertEquals(86400,testCHeck.get(0));
        System.out.println("==== TEST CASE 2a +++ PASSED seconds:86400");
        testResult.remove(0);
    }


}
