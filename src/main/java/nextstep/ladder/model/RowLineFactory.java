package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RowLineFactory {

    private final RandomLineGenerator randomLineGenerator;
    private final StepFactory stepFactory;
    private final int count;

    private RowLineFactory(RandomLineGenerator randomLineGenerator, int count) {
        this.randomLineGenerator = randomLineGenerator;
        this.stepFactory = new StepFactory();
        this.count = count;
    }

    public static RowLineFactory from(RandomLineGenerator randomLineGenerator, int count) {
        return new RowLineFactory(randomLineGenerator, count);
    }

    public RowLine line() {
        List<Step> line = new ArrayList<>();
        line.add(stepFactory.firstStep(randomLineGenerator));

        IntStream.range(1, count).forEach(i -> {
            Boolean previousStep = line.get(i - 1).previousStep();
            if (isItLastLine(i)) {
                line.add(stepFactory.lastStep(previousStep));
            } else {
                line.add(stepFactory.createStep(previousStep, randomLineGenerator));
            }
        });

        return new RowLine(line);
    }

    private boolean isItLastLine(int i) {
        return i == count - 1;
    }


}
