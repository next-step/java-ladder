package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    private static final Boolean PREVIOUS_STEP_FOR_FIRST = false;
    private final RandomLineGenerator randomLineGenerator;
    private final int count;

    private LineFactory(RandomLineGenerator randomLineGenerator, int count) {
        this.randomLineGenerator = randomLineGenerator;
        this.count = count;
    }

    public static LineFactory from(RandomLineGenerator randomLineGenerator, int count){
        return new LineFactory(randomLineGenerator, count);
    }

    public Line line(){
        List<Step> line = new ArrayList<>();
        line.add(Step.of(randomLineGenerator.randomStep(), false));

        for (int i=1; i<count; i++){
            Boolean previousStep = line.get(i - 1).currentStep();
            line.add(Step.of(randomLineGenerator.randomStep(), previousStep));
        }
        lineNeverOverlap(line);

        return new Line(line);
    }

    private static void lineNeverOverlap(List<Step> collect) {
        for (int i = 1; i < collect.size(); i++) {
            collect.set(i, collect.get(i).overlapStepReplace());
        }
    }

}


