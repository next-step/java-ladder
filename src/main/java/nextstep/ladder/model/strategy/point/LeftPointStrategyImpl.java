package nextstep.ladder.model.strategy.point;

public class LeftPointStrategyImpl implements PointStrategy{
    @Override
    public int move(int index) {
        return index - 1;
    }
}
