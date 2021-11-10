package test;

import lab2.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestLab2 {
    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testEmailNegativeDataProvider")
    public void testEmailNegative(int id, String mail, String name, int Age){
        Worker obj = new Worker.Builder().addEmail( mail).addFirstName(name).addAge(Age).Build();
        assertEquals(obj.getEmail(),mail);
    }

    @DataProvider
    public Object[][] testEmailNegativeDataProvider(){
        return new Object[][] {{1,"worker","Darem ",28}};
    }

    @Test(dataProvider = "testEmailPositiveDataProvider")
    public void testEmailPositive(int id, String mail, String name, int Age){
        Worker obj = new Worker.Builder().addEmail( mail).addFirstName(name).addAge(Age).Build();
        assertEquals(obj.getEmail(),mail);
    }

    @DataProvider
    public Object[][] testEmailPositiveDataProvider(){
        return new Object[][] {{2,"a.dynde@gmail.com","Andry",25}};
    }


    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testAgeNegativeDataProvider")
    public void testAgeNegative(String lname,int Age){
        Worker obj = new Worker.Builder().addLastName( lname).addAge(Age).Build();
        assertEquals(obj.getAge(),Age);
    }

    @DataProvider
    public Object[][] testAgeNegativeDataProvider(){
        return new Object[][] {{"Karenby",16}};
    }

    @Test(dataProvider = "testAgePositiveDataProvider")
    public void testAgePositive(String lname,int Age){
        Worker obj = new Worker.Builder().addLastName( lname).addAge(Age).Build();
        assertEquals(obj.getAge(),Age);
    }

    @DataProvider
    public Object[][] testAgePositiveDataProvider(){
        return new Object[][] {{"Daniella",28}};
    }



    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testLNameNegativeDataProvider")
    public void testLNameNegative(String lname,int Age){
        Worker obj = new Worker.Builder().addLastName( lname).addAge(Age).Build();
        assertEquals(obj.getLastName(),lname);
    }

    @DataProvider
    public Object[][] testLNameNegativeDataProvider(){
        return new Object[][] {{"",25}};
    }

    @Test(dataProvider = "testLNamePositiveDataProvider")
    public void testLNamePositive(String lname,int Age){
        Worker obj = new Worker.Builder().addLastName( lname).addAge(Age).Build();
        assertEquals(obj.getLastName(),lname);
    }

    @DataProvider
    public Object[][] testLNamePositiveDataProvider(){
        return new Object[][] {{"Daniella",28}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testFNameNegativeDataProvider")
    public void testFNameNegative(String lname,int Age){
        Worker obj = new Worker.Builder().addLastName( lname).addAge(Age).Build();
        assertEquals(obj.getLastName(),lname);
    }

    @DataProvider
    public Object[][] testFNameNegativeDataProvider(){
        return new Object[][] {{"",25}};
    }

    @Test(dataProvider = "testFNamePositiveDataProvider")
    public void testFNamePositive(String lname,int Age){
        Worker obj = new Worker.Builder().addLastName( lname).addAge(Age).Build();
        assertEquals(obj.getLastName(),lname);
    }

    @DataProvider
    public Object[][] testFNamePositiveDataProvider(){
        return new Object[][] {{"Daniella",28}};
    }
}
