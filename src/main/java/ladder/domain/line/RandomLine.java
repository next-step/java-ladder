package ladder.domain.line;

import java.util.Random;

public class RandomLine extends Line {

    private static final Random random = new Random();

    public RandomLine(int countOfPerson) {
        super(countOfPerson);
    }

    protected void initBars() {
        for (int i = 0; i < countOfPerson; i++) {
            bars.add(initBar(i));
        }
    }

    private boolean initBar(int index) {
        if (index == 0 || bars.get(index - 1)) {
            return false;
        }
        return random.nextBoolean();
    }

}
