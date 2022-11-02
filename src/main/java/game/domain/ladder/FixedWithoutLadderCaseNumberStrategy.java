package game.domain.ladder;

public class FixedWithoutLadderCaseNumberStrategy implements NumberStrategy {
    @Override
    public int generateNumber() {
        return 1;
    }
}
