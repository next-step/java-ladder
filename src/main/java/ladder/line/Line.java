package ladder.line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ladder.exception.InvalidCountOfPersonException;

public abstract class Line {

    protected final List<Boolean> bars;
    protected final int countOfPerson;

    protected Line(int countOfPerson) {
        this.bars = new ArrayList<>();
        this.countOfPerson = validateCountOfPerson(countOfPerson);
        initBars();
    }

    public List<Boolean> getBars() {
        return this.bars;
    }

    public boolean validate() {
        if (bars.size() != countOfPerson) {
            return false;
        }

        long invalidCount = IntStream.range(0, bars.size())
                .filter(i -> isFirstBarInvalid(i) || isBarInvalid(i))
                .count();

        return invalidCount == 0;
    }

    private boolean isBarInvalid(int i) {
        return i != 0 && bars.get(i - 1) && bars.get(i);
    }

    private boolean isFirstBarInvalid(int i) {
        return i == 0 && bars.get(i);
    }

    private int validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new InvalidCountOfPersonException();
        }
        return countOfPerson;
    }

    protected abstract void initBars();

}
