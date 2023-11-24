package ladder.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomPathStrategy implements PathStrategy {

    private static final Random random = new Random();

    private boolean checked;

    public RandomPathStrategy() {
        this.checked = false;
    }

    @Override
    public List<Boolean> generate(long size) {
        return Stream.generate(() -> randomIfPreviousNotChecked())
                .limit(size)
                .collect(Collectors.toList());
    }

    private boolean randomIfPreviousNotChecked() {
        checked = notChecked() ? random() : false;
        return checked;
    }

    private boolean notChecked() {
        return !checked;
    }


    private Boolean random() {
        return random.nextBoolean();
    }
}
