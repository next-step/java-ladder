package laddergame.util;

import java.util.LinkedList;
import java.util.Queue;

public class ManualValueGenerator implements ValueGenerator {
    private final Queue<Boolean> states;

    public ManualValueGenerator(boolean... inputs) {
        this.states = new LinkedList<>();
        for (boolean input : inputs) {
            states.add(input);
        }
    }

    @Override
    public boolean generate() {
        return states.poll();
    }
}
