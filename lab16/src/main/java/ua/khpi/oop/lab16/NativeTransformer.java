package ua.khpi.oop.lab16;

public class NativeTransformer {

    static {
        System.loadLibrary("transformer");
    }


    public double[] transformJava(double[] array, double a, double b) {
        if (array == null) return null;
        
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = a * array[i] + b;
        }
        return result;
    }

    public native double[] transformNative(double[] array, double a, double b);
}