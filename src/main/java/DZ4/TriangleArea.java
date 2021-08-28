package DZ4;



public class TriangleArea {

    public double a;
    public double b;
    public double c;

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

    public boolean checkDataBoolean(double a, double b, double c) {
        if(a <= 0 | b <= 0 | c <= 0 | a + b <= c | a + c <= b | b + c <= a ) return false;
        return true;
    }

}
