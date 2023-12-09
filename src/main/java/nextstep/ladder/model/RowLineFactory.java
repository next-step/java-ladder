package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class RowLineFactory {

    private final RandomLineGenerator randomLineGenerator;
    private final int count;

    private RowLineFactory(RandomLineGenerator randomLineGenerator, int count) {
        this.randomLineGenerator = randomLineGenerator;
        this.count = count;
    }

    public static RowLineFactory from(RandomLineGenerator randomLineGenerator, int count) {
        return new RowLineFactory(randomLineGenerator, count);
    }

    public RowLine line() {
        List<Step> line = new ArrayList<>();
        line.add(Step.first(randomLineGenerator.randomStep()));

        for (int i = 1; i < count; i++) {
            Boolean previousStep = line.get(i - 1).currentStep();
            if (i == count - 1) {
                line.add(Step.last(previousStep));
            } else {
                if (previousStep) {
                    line.add(Step.of(false, previousStep));
                } else {
                    line.add(Step.of(randomLineGenerator.randomStep(), previousStep));
                }
            }
        }
        return new RowLine(line);
    }
}


