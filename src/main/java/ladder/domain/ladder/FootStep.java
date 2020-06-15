package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FootStep {
    private final List<Boolean> steps = new ArrayList<>();

    public FootStep(int countOfUser) {
        for (int i = 1; i < countOfUser; i++) {
            steps.add(new Random().nextBoolean());
        }
    }

    public List<Boolean> getSteps() {
        return steps;
    }
}
