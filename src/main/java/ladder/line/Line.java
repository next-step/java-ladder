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

    public int move(int index) {
        if (isMovementAvailable(index)) {
            return -1;
        }

        if (isMovementAvailable(index + 1)) {
            return 1;
        }

        return 0;
    }

    private Boolean isMovementAvailable(int index) {
        try {
            return this.bars.get(index);
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
        return index != 0 && bars.get(index - 1) && bars.get(index);
    }

    private boolean isFirstBarInvalid(int index) {
        return index == 0 && bars.get(index);
    }

    private int validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new InvalidCountOfPersonException();
        }
        return countOfPerson;
    }

    protected abstract void initBars();

}
