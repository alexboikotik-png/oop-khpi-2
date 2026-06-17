package ua.khpi.oop.lab16;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NativeTransformerTest {

    private final NativeTransformer transformer = new NativeTransformer();
    private final double DELTA = 0.0001;

    @Test
    void testEquality_Between_Java() {
        double[] input = {1.5, -2.0, 0.0, 42.1};
        double a = 2.5;
        double b = -10.0;
        
        double[] resultJava = transformer.transformJava(input, a, b);
        double[] resultNative = transformer.transformNative(input, a, b);
        
        assertArrayEquals(resultJava, resultNative, DELTA, "Результати мають бути однаковими");
    }

    @Test
    void testLogicCorrectness() {
        double[] input = {1.0, 2.0, 3.0};
        double[] expected = {5.0, 7.0, 9.0};
        
        assertArrayEquals(expected, transformer.transformJava(input, 2.0, 3.0), DELTA);
        assertArrayEquals(expected, transformer.transformNative(input, 2.0, 3.0), DELTA);
    }

    @Test
    void testEdgeCaseNull() {
        assertNull(transformer.transformJava(null, 1.0, 1.0));
        assertNull(transformer.transformNative(null, 1.0, 1.0));
        
        double[] emptyInput = {};
        double[] expected = {};
        assertArrayEquals(expected, transformer.transformJava(emptyInput, 2.0, 2.0), DELTA);
        assertArrayEquals(expected, transformer.transformNative(emptyInput, 2.0, 2.0), DELTA);
    }
}