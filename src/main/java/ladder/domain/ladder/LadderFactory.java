package ladder.domain.ladder;

public abstract class LadderFactory {
    public abstract RandomLadder createLadder(int height, int intervalCount);
}
