package nextstep.step4.responsibility.domain;

public class NoneMover implements IndexHorizontalMover {
    @Override
    public int moveHorizontal(final int index) {
        return index;
    }
}
