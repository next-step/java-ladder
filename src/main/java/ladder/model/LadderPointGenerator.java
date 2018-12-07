package ladder.model;

public class LadderPointGenerator {
    Difficult difficult;

    private LadderPointGenerator(Difficult difficult) {
        this.difficult = difficult;
    }

    public LadderPointGenerator from(String level) {
        return new LadderPointGenerator(Difficult.of(level));
    }

    public boolean generatePoint() {
        return difficult.generatePoint();
    }
}
