package nextstep.ladder.model.strategy;

public class DontDrawLine implements LineStrategy{
    public DontDrawLine() {
    }

    @Override
    public boolean drawLine() {
        return false;
    }
}
