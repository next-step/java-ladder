package nextstep.ladder.domain.strategy;

import java.util.List;

public class ManualGeneratePointStrategy implements GeneratePointStrategy {

    private List<Boolean> points;

    public ManualGeneratePointStrategy(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public List<Boolean> generate() {
        return points;
    }
}
