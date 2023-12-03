package nextstep.ladder.model.strategy.point;

public class NoPointStrategyImpl implements PointStrategy{
    @Override
    public int move(int index) {
        return index;
    }
}
