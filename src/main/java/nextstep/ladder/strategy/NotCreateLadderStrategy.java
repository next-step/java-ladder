package nextstep.ladder.strategy;

public class NotCreateLadderStrategy implements LadderStrategy {

    @Override
    public boolean creatable() {
        return false;
    }
}
