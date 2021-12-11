package ladder.util.function;

import java.util.function.IntPredicate;

public class MathFunction {

    private MathFunction() {}

    public static final IntPredicate EVEN_NUMBER = number -> number % 2 == 0;

}
