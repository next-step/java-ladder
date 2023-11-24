package nextstep.step4.responsibility.domain;

public class LeftMover implements IndexHorizontalMover {
    @Override
    public int moveHorizontal(final int index) {
        return index - 1;
    }
}
