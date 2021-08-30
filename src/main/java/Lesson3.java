import java.util.Random;

public class Lesson3 {
    public static void main(String[] args) {
        Lesson3_1();
        Lesson3_2();
        Lesson3_3();
        Lesson3_4();
        int[] m1 = Lesson3_5(5,11);
        Lesson3_6();

        int[] m2 = {2, 2, 2, 1, 2, 2, 10, 1};
        boolean result = Lesson3_7(m2);

        Lesson3_8(m2, 2);

    }

    public static void Lesson3_1(){
        int[] m = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for( int i=0; i<m.length; i++)
            if (m[i] == 0) m[i] = 1;
            else m[i] = 0;
    }

    public static void Lesson3_2(){
        int[] m = new int[100];

        for( int i=0; i<m.length; i++)
            m[i] = i+1;
    }

    public static void Lesson3_3(){
        int[] m = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for( int i=0; i<m.length; i++)
            if (m[i] < 6)
                m[i] *= 2;
    }

    public static void Lesson3_4(){
        int[][] m = new int[5][5];

        for( int i=0; i<m.length; i++)
            for( int j=0; j<m[0].length; j++){
                if(i==j) m[i][j] = 1;
                m[i][(m[0].length-1)-i] = 1;
            }
    }

    public static int[] Lesson3_5(int len, int initialValue){

        int[] m = new int[len];

        for( int i=0; i<m.length; i++)
            m[i] = initialValue;

        return m;
    }

    public static void Lesson3_6(){

        int[] m = new int[100];
        Random random = new Random();

        for( int i=0; i<m.length; i++)
            m[i] = random.nextInt(100);

        int min = m[0];
        int max = m[0];

        for( int i=1; i<m.length; i++){
            if(m[i] > max) max = m[i];
            if(m[i] < min) min = m[i];
        }
    }

    public static boolean Lesson3_7(int [] m) {
        int sleft = 0;
        int srighr;

        for(int i=0;i<m.length;i++) {
            sleft += m[i];

            srighr = 0;

            for (int j = i + 1; j<m.length;j++)
                srighr += m[j];

            if (sleft == srighr)
                return true;
        }
        return false;
    }

    public static void Lesson3_8(int [] m, int n){

        int shift = Math.abs(n);

        shift %= m.length;
        int temp;

        for(int i=0; i < shift; i++){
            if(n > 0)
                temp = m[m.length-1];
            else
                temp = m[0];

            for(int j=0; j < m.length-1; j++){
                if(n > 0)
                    m[m.length-j-1] = m[m.length-j-2];
                else
                    m[j] = m[j+1];
            }
            if(n > 0)
                m[0] = temp;
            else
                m[m.length-1] = temp;
            
        }
    }
}
