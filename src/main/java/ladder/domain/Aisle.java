package ladder.domain;

import ladder.service.RandomBoolean;
import ladder.view.ResultView;

import java.util.stream.IntStream;

public class Aisle {
    private final boolean aisle;

    public Aisle(boolean aisle) {
        this.aisle = aisle;
    }

    public String printAisle() {
        StringBuilder sb = new StringBuilder();

        if (aisle) {
            IntStream.rangeClosed(0, ResultView.AISLE_WIDTH)
                    .forEach(i -> sb.append("-"));
            return sb.toString();
        }
        IntStream.rangeClosed(0, ResultView.AISLE_WIDTH)
                .forEach(i -> sb.append(" "));
        return sb.toString();
    }

    public boolean isExistAisle() {
        return aisle;
    }

    public static Aisle generateAisle(Aisle previousAisle, RandomBoolean randomBoolean) {
        if (randomBoolean.randomBoolean() && !previousAisle.isExistAisle()) {
            return new Aisle(true);
        }
        return new Aisle(false);
    }

}
