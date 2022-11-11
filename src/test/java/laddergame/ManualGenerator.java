package laddergame;

import java.util.LinkedList;
import java.util.Queue;

public class ManualGenerator implements Generator {
    private final Queue<Boolean> states;

    public ManualGenerator(boolean... inputs) {
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
