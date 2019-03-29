package generator.impl;

import generator.BooleansGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BooleanSupplier;

public class NonContinuousGenerator implements BooleansGenerator {

    private final BooleanSupplier booleanGenerator;

    private final boolean shouldNotBeContinuous;

    public NonContinuousGenerator(BooleanSupplier booleanGenerator, boolean shouldNotBeContinuous) {
        this.booleanGenerator = booleanGenerator;
        this.shouldNotBeContinuous = shouldNotBeContinuous;
    }

    @Override
    public List<Boolean> generate(int size) {
        Stack<Boolean> stack = new Stack<>();
        stack.push(booleanGenerator.getAsBoolean());

        for (int i = 1; i < size; i++) {
            addNonContinuous(stack);
        }
        return new ArrayList<>(stack);
    }

    private void addNonContinuous(Stack<Boolean> stack) {
        Boolean prevPoint = stack.peek();
        Boolean thisPoint = booleanGenerator.getAsBoolean();
        if (prevPoint == shouldNotBeContinuous && prevPoint == thisPoint) {
            stack.push(!shouldNotBeContinuous);
            return;
        }

        stack.push(thisPoint);
    }
}
