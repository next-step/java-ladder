package ladder.domain;

public class LadderFactory {
    public static Ladder of(LadderData ladderData) {
        return new Ladder(ladderData);
    }
}
