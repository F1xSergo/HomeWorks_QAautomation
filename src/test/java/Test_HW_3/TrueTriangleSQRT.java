package Test_HW_3;

public class TrueTriangleSQRT {
    private double a;
    private double b;
    private double c;


    public TrueTriangleSQRT(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getSquareTRUE() {
        double p;
        p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
