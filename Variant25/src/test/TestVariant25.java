package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant25;


public class TestVariant25 {
    static void Main(String[] args){}
    @Test(dataProvider = "intProvider")
    public void intTest(int K, int d) {
        assertEquals(new Variant25().IntTask(K), d );
    }
    @DataProvider
    public Object[][] intProvider() {
        return new Object[][] { { 31, 6 }, { 59, 6}, { 365, 4 } };
    }

    @Test(dataProvider = "BooleanProvider")
    public void BooleanTest(double x, double y, boolean b) {
        assertEquals(new Variant25().BooleanTask(x,y), b );
    }
    @DataProvider
    public Object[][] BooleanProvider() {
        return new Object[][] { { -2 , -6, false }, { 5,-1, false}, { -2.6, 6, true } };
    }

    @Test(dataProvider = "IFProvider")
    public void IfTest(int x, int f) {
        assertEquals(new Variant25().IfTask(x), f );
    }
    @DataProvider
    public Object[][] IFProvider() {
        return new Object[][] { { 0,0 }, { 8, 16}, { -4, -8 }, { 1, -3} };
    }
    //switchTask(double A, double B , int N)
    @Test(dataProvider = "SwitchProvider")
    public void SwitchTest(double a, double b, int n, double r) {
        assertEquals(new Variant25().switchTask(a,b,n), r );
    }
    @DataProvider
    public Object[][] SwitchProvider() {
        return new Object[][] { { 5, 2, 1, 7 }, { 9, 4, 2, 5}, { 7, 3, 3, 21 }, { 32, 2 , 4, 16} };
    }
//forTask(int n, double x)
    @Test(dataProvider = "ForProvider")
    public void forTest(int n,double x, int f ) {
        assertEquals(new Variant25().forTask(n,x), f );
    }
    @DataProvider
    public Object[][] ForProvider() {
        return new Object[][] { {1, 10, 10}, { 2,20, -180}  };
    }
    @Test(dataProvider = "WhileProvider")
    public void forTest(int n, int fab ) {
        assertEquals(new Variant25().whileTask(n), fab );
    }
    @DataProvider
    public Object[][] WhileProvider() {
        return new Object[][] { { 230,233}, {  600, 610}  , {9888, 10946}};
    }

    @Test(dataProvider = "MinMaxProvider")
    public void forTest( int[] arr , int[] res) {
        assertEquals(new Variant25().minMax(arr), res);
    }
    @DataProvider
    public Object[][] MinMaxProvider() {
        int[] case1 = {1, 5, 4, 7, 9, 11},
                case2 = {1, 1, 1, 4, 1, 1};
        int[] res = {0,1};
        int[] res2 = {0,1};
        return new Object[][] { {case1 ,res },{case2 ,res2 } };
    }

    @Test(dataProvider = "matrixTaskSumProvider")
    public void forTest( int[][] arr , int n , int m, int[] res) {
        assertEquals(new Variant25().matrixTaskSum(arr, n ,m), res);
    }
    @DataProvider
    public Object[][] matrixTaskSumProvider() {
        int[][] case1 = {{1, 5, 4, 7, 9, 11},
                { 99 ,5, 3533,5,5,23},
                {1,2,3,4,5,6}};

        int[] res2 = {3670, 1};
        return new Object[][] { {case1, 3,6,res2 } };
    }

    @Test(dataProvider = "ArrSumProvider")
    public void ArrTask( int[] arr ,int res) {
        assertEquals(new Variant25().ArrTask(arr), res);
    }
    @DataProvider
    public Object[][] ArrSumProvider() {
        int[] case1 = {1, 2, 4, 8, 16};
        int[] case2 = {1, 8, 0, 1, 16};

        return new Object[][] { {case1, 2} ,{case2,0 }  };
    }
}
