package ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.exception.InvalidCountOfPersonException;

public abstract class Line {

    protected final List<Bar> bars;
    protected final int countOfPerson;

    protected Line(int countOfPerson) {
        this.bars = new ArrayList<>();
        this.countOfPerson = validateCountOfPerson(countOfPerson);
        initBars();
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

    public boolean validate() {
        if (bars.size() != countOfPerson) {
            return false;
        }

        return IntStream.range(0, bars.size())
                .noneMatch(i -> isFirstBarInvalid(i) || isBarInvalid(i));
    }

    private boolean isBarInvalid(int index) {
        return index != 0 && getBar(index - 1).isAvailable() && getBar(index).isAvailable();
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

    protected abstract void initBars();

}
