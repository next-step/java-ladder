package generator.bools.impl;

import generator.bools.BooleansGenerator;

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
        boolean prevPoint = stack.peek();
        if (prevPoint == shouldNotBeContinuous) {
            pushCanBeContinuous(stack);
            return;
        }

        boolean thisPoint = booleanGenerator.getAsBoolean();
        if (prevPoint == thisPoint) {
            pushCanBeContinuous(stack);
            return;
        }

        stack.push(thisPoint);
    }

    private void pushCanBeContinuous(Stack<Boolean> stack) {
        stack.push(!shouldNotBeContinuous);
    }
}
