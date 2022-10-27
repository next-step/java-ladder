package ladder.line;

import java.util.ArrayList;
import java.util.List;
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
        if(bars.size() != countOfPerson) {
            return false;
        }

        for (int i = 0; i < bars.size(); i++) {
            if (i == 0 && bars.get(i)) {
                return false;
            }

            if (i != 0 && bars.get(i - 1) && bars.get(i)) {
                return false;
            }
        }
        return true;
    }

    private int validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new InvalidCountOfPersonException();
        }
        return countOfPerson;
    }

    protected abstract void initBars();

}
