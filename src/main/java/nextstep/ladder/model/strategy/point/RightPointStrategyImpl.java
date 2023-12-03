package nextstep.ladder.model.strategy.point;

public class RightPointStrategyImpl implements PointStrategy{
    @Override
    public int move(int index) {
        return index + 1;
    }
}
