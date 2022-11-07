package ladder.domain.line;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.exception.InvalidCountOfPersonException;
import ladder.domain.exception.InvalidLineException;
import ladder.domain.exception.MismatchPersonBarsException;

public class Line {

    private final List<Bar> bars;
    private final int countOfPerson;

    public Line(int countOfPerson, List<Bar> bars) {
        this.bars = bars;
        this.countOfPerson = validateCountOfPerson(countOfPerson);
        validateBar();
    }

    public List<Bar> getBars() {
        return this.bars;
    }

    public Bar getBar(int index) {
        return bars.get(index);
    }

    public boolean isMovementAvailable(int index) {
        try {
            return this.bars.get(index).isAvailable();
        } catch (Exception e) {
            return false;
        }
    }

    private void validateBar() {
        if (bars.size() != countOfPerson) {
            throw new MismatchPersonBarsException();
        }

        if (isAnyMatchBarInvalid()) {
            throw new InvalidLineException();
        }
    }

    private boolean isAnyMatchBarInvalid() {
        return IntStream.range(0, bars.size())
                .anyMatch(i -> isFirstBarInvalid(i) || isBarInvalid(i));
    }

    private boolean isBarInvalid(int index) {
        return index != 0
                && getBar(index - 1).isAvailable()
                && getBar(index).isAvailable();
    }

    private boolean isFirstBarInvalid(int index) {
        return index == 0 && getBar(index).isAvailable();
    }

    private int validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new InvalidCountOfPersonException();
        }
        return countOfPerson;
    }

}
