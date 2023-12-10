package ladder.gilbert;

import java.util.*;
import java.util.stream.Collectors;

public class CustomBooleanGenerator implements BooleanGenerator {

    private final Queue<Boolean> queue;

    public CustomBooleanGenerator(Boolean... booleans) {
        this.queue = Arrays.stream(booleans)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public boolean generate() {
        if (queue.isEmpty()) {
            throw new NullPointerException("");
        }
        return Boolean.TRUE.equals(queue.poll());
    }
}
