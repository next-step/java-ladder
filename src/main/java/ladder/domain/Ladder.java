package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private Ladder() {}

    public static Lines createLines(int countOfPerson, int height, MoveStrategy strategy) {
        List<Line> lines = IntStream.range(0,height)
                .mapToObj(e -> generateLine(countOfPerson,strategy))
                .map(Line::new)
                .collect(Collectors.toList());
        return new Lines(lines);
    }

    private static List<Boolean> generateLine(int countOfPerson, MoveStrategy strategy) {
        AtomicReference<Boolean> previous = new AtomicReference<>(false);
        return IntStream.rangeClosed(1,countOfPerson)
                .peek(position -> previous.getAndSet(movable(previous.get(),position,countOfPerson,strategy)))
                .mapToObj(e -> previous.get())
                .collect(Collectors.toList());
    }

    private static boolean movable(boolean previous, int position, int countOfPerson, MoveStrategy strategy) {
        if(previous || (position == countOfPerson)) {
            return false;
        }
        return strategy.isMovable();
    }
}
