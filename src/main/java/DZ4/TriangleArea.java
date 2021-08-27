package DZ4;

import org.decimal4j.util.DoubleRounder;

public class TriangleArea {
    public static void main(String[] args) {
        TriangleArea test = new TriangleArea();
        double ar =  test.triangleAreaNormData(6.3,2.0,7.0);
        double scale = Math.pow(10, 2);
        double result = Math.ceil(ar * scale) / scale;


        System.out.println(result);
    }

    public double triangleAreaNormData(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double buffer = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double scale = Math.pow(10, 2);
        double area = Math.ceil(buffer * scale) / scale;
        return area;
    }

    public boolean checkData(double a, double b, double c) throws NegativSideException, ShortSideException {
        if(a <= 0 | b <= 0 | c <= 0){
            throw new NegativSideException();
        }
        if(a + b <= c | a + c <= b | b + c <= a){
            throw new ShortSideException();
        }
        return true;
    }
}
