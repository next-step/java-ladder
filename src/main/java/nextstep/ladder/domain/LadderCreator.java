package nextstep.ladder.domain;

public class LadderCreator {

    private LadderCreator() {
    }

    public static LadderHeight readLadderHeight(int height) {
        return new LadderHeight(height);
    }

}
