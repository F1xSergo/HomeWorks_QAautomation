package Sergei_Hotynyuk_HW_2;

public class Calculator {

    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Calculator(int a) {
        this.a = a;
    }

    public float getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public float calculate(char operation) {
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                return a - b;
            }
            case '+': {
                return a + b;
            }
            case '/': {
                return a / b;
            }
            case '*': {
                return a * b;
            }
            case '^': {
                float g = 1;
                for (double i = 1; i <= b; i++) {    //формула возведения в степень
                    g = g * a;
                }
                return g;
            }
            case '№': {

                return (float) Math.sqrt(a);
            }

        }
    }

    public int varMethod(int... ints) {
        int result = 0;
        for (int x : ints) {
            result += x;
        }
        return result;
    }
}

