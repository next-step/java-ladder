package nextstep.ladder.domain;

public class LinesFactory {
    private static final RandomBooleanGenerator RANDOM_BOOLEAN_GENERATOR;

    static {
        RANDOM_BOOLEAN_GENERATOR = new RandomBooleanGenerator();
    }

    public static Lines create(Members members, MaxHeightOfLadder maxHeightOfLadder) {
        return maxHeightOfLadder.getLines(members, RANDOM_BOOLEAN_GENERATOR);
    }
}
