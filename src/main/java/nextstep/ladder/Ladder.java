package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ladder {
    private final List<Line> lines;

    private Ladder(NumberOfParticipants numberOfParticipants, Height height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height.value; i++) {
            lines.add(new Line(numberOfParticipants));
        }
    }

    public static Ladder of(NumberOfParticipants numberOfParticipants, Height height) {
        return new Ladder(numberOfParticipants, height);
    }

    public void repeatAsHeight(Runnable runnable, Consumer<Boolean> consumer) {
        lines.forEach(line -> {
            line.repeatAsPoints(consumer);
            runnable.run();
        });
    }
}
