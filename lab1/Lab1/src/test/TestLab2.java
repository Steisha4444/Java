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
    @DataProvider
    public Object[][] equalsProvider(){
        Worker w = new Worker.Builder()
                .addFirstName("Julia")
                .addLastName("Smith")
                .addAge(35)
                .addEmail("j.smith@gmail.com")
                .Build();

        Worker w1 = new Worker.Builder()
                .addFirstName("Daniel")
                .addLastName("Shelest")
                .addAge(29)
                .addEmail("d.shelest@gmail.com")
                .Build();

        Worker w2 = new Worker.Builder()
                .addFirstName("Julia")
                .addLastName("Smith")
                .addAge(35)
                .addEmail("j.smith@gmail.com")
                .Build();

        Worker w3 = new Worker.Builder()
                .addFirstName("Krista")
                .addLastName("Agrest")
                .addAge(38)
                .addEmail("k.agrest@gmail.com")
                .Build();

        Worker w4 = new Worker.Builder()
                .addFirstName("Anastasiia")
                .addLastName("Li")
                .addAge(26)
                .addEmail("a.li@gmail.com")
                .Build();

        return new Object[][]{{w, w1, false},
                {w, w2, true}, {w3, w4, false}};
    }
    @Test(dataProvider = "equalsProvider")
    public void testEquals(Worker s1, Worker s2, boolean res) {
        assertEquals(s1.equals(s2), res);
    }

    @DataProvider
    public Object[][] equalsProviderT(){
        Worker c1 = new Teacher.Builder()
                .addAge(31).addLastName("Daniluk")
                .addFirstName("Tatiana")
                .addEmail("a.t@gmail.com")
                .addSalary(3000)
                .addShift(1)
                .addPosition()
                .addSubject("Math").Build();

        Worker c2 = c1;

        Worker c3 = new Teacher.Builder()
                .addAge(31).addLastName("Dandi")
                .addFirstName("Tatiana")
                .addEmail("a.t@gmail.com")
                .addSalary(3000)
                .addShift(1)
                .addPosition()
                .addSubject("Math").Build();
        return new Object[][]{{c2, c1, true}, {c2, c3, false}};
    }
    @Test(dataProvider = "equalsProviderT")
    public void testEqualsT(Worker s1, Worker s2, boolean res) {
        assertEquals(s1.equals(s2), res);
    }

    @DataProvider
    public Object[][] equalsProviderA(){
        Worker t1 = new Assistant
                .Builder()
                .addAge(34)
                .addLastName("Kim")
                .addFirstName("Daria")
                .addEmail("k.daria@gmail.com")
                .addSalary(2500)
                .addShift(1)
                .addPosition()
                .addSubject("Biology")
                .addTerm(2.5)
                .addUniversity("CHNU").Build();

        Worker t2 = new Assistant
                .Builder()
                .addAge(30)
                .addLastName("Shved")
                .addFirstName("Vladyslav")
                .addEmail("v.shved@gmail.com")
                .addSalary(2400)
                .addShift(2)
                .addPosition()
                .addSubject("Literature")
                .addTerm(1.5)
                .addUniversity("CHNU").Build();



        return new Object[][]{{t1, t2, false}};
    }
    @Test(dataProvider = "equalsProviderA")
    public void testEqualsA(Worker s1, Worker s2, boolean res) {
        assertEquals(s1.equals(s2), res);
    }
}
