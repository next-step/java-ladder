package nextstep.ladder.strategy;

public class AlwaysAddLadderStrategy implements LadderStrategy {
    @Override
    public boolean creatable() {
        return true;
    }
}
