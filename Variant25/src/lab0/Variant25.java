package lab0;



public class Variant25 {
    static void Main(String[] args) {

        System.out.println("Hello World");
        System.out.println(IntTask(31));


    }

    /*Integer25. Дни недели пронумерованы следующим образом: 0 — воскресенье, 1 — понедельник,
     2 — вторник, … , 6 — суббота. Дано целое число K, лежащее в диапазоне 1–365. Определить номер дня
     недели для K-го дня года, если известно, что в этом году 1 января было четвергом.*/
    public static int IntTask(int K) {

        return (((K + 4 - 2) % 7) + 1);
    }
/*Boolean25. Даны числа x, y. Проверить истинность высказывания:
 «Точка с координатами (x, y) лежит во второй координатной четверти».*/

    public boolean BooleanTask(double x, double y) {

        if (x < 0 && y > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*If25. Для данного целого x найти значение следующей функции f, принимающей значения целого типа:

    f(x)	 = 	2·x,	если x < –2 или x > 2,
              –3·x,	в противном случае.*/
    public int IfTask(int x) {

        if (x < -2 || x > 2) {
            return 2 * x;
        } else {
            return -3 * x;
        }
    }
/*Case5. Арифметические действия над числами пронумерованы следующим образом:
1 — сложение, 2 — вычитание, 3 — умножение, 4 — деление. Дан номер действия N
(целое число в диапазоне 1–4) и вещественные числа A и B
(В не равно 0). Выполнить над числами указанное действие и вывести результат.*/

    public double switchTask(double A, double B, int N) {

        switch (N) {
            case (1):
                return A + B;

            case (2):
                return A - B;

            case (3):
                return A * B;
            case (4):
                return A / B;
            default:
                System.out.println("Wrong data");
                return 0;
        }

    }
    /*For25. Дано вещественное число X (|X| < 1) и целое число N (> 0). Найти значение выражения

X – X^2/2 + X3/3 – … + (–1)^N–1·XN/N.
Полученное число является приближенным значением функции ln в точке 1 + X.*/

    public double forTask(int n, double x) {
        double result = 0;
        double step = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                step = (x * step) / i;
            } else step = -(x * step) / (i);
            result += step;
        }
        return result;
    }
    /*While25. Дано целое число N (> 1).
    Найти первое число Фибоначчи, большее N.
     (определение чисел Фибоначчи дано в задании While24).*/

    public int whileTask(int n) {
        int f1 = 1, f2 = 1, f = 0;

        while (f < n + 1) {
            f = f2 + f1;
            f2 = f1;
            f1 = f;
        }
        return f;
    }

    public int[] minMax(int[] a) {

        int ix = 0;
        for (int i = 1; i < a.length - 1; i++)
            if (a[i] * a[i + 1] < a[ix] * a[ix + 1]) ix = i;
        //cout << ix << ix+1;
        int[] arr = {0, 0};

        arr[0] = ix;
        arr[1] = ix + 1;
        return arr;


    }

    public int[] matrixTaskSum(int arr[][], int n, int m) {
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i] += arr[i][j];
            }
        }
        int[] rs = {0, 0};
        int j = 0;
        for (int i = 1; i < n; i++) {

            if (res[j] > res[i])
                rs[0] = res[j];
            rs[1] = j;
            j++;

        }


        return rs;
    }

    public float ArrTask(int a[]) {

        int i;
        float z = (float) a[1] / (float) a[0];
        for (i = 1; i < a.length; ++i) {
            if (z != (float) a[i] / (float) a[i - 1]) {
                z = 0;
            }
        }
        return z;
    }

    //     printf("%f\n: ",z);


}