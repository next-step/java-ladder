package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final String INPUT_HEIGHT_ERROR = "오류:: 사다리의 높이는 최소 1개 이상이어야 합니다.\n\n";
    private static final int MIN_HEIGHT = 1;
    private final int countOfPerson;
    private final int height;

    public Ladder(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = heightValidationCheck(height);
    }

    public Lines createLines() {
        return Lines.of(IntStream.range(0,height)
                .mapToObj(e -> generateLine())
                .map(Line::of)
                .collect(Collectors.toList()));
    }

    public MoveStrategy moveRule() {
        return new LadderMoveStrategy();
    }

    private int heightValidationCheck(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INPUT_HEIGHT_ERROR);
        }
        return height;
    }

    private List<Boolean> generateLine() {
        AtomicReference<Boolean> previous = new AtomicReference<>(false);
        return IntStream.rangeClosed(1,countOfPerson)
                .mapToObj(position -> positionCheck(previous.get(),position))
                .map(condition -> previous.getAndSet(isMovable(condition,moveRule())))
                .map(e -> previous.get())
                .collect(Collectors.toList());
    }

    private boolean positionCheck(boolean previous, int position) {
        return previous || (position == countOfPerson);
    }

    private boolean isMovable(boolean condition, MoveStrategy strategy) {
        if(condition) {
            return false;
        }
        return strategy.isMovable();
    }
}
