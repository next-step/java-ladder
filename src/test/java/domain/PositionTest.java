package domain;

import org.junit.Test;

public class PositionTest {
    @Test(expected = IllegalArgumentException.class)
    public void 이름이_한글자_미만일_경우_예외가_발생한다() {
        new Position("", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름이_다섯글자를_초과할_경우_예외가_발생한다() {
        new Position("123456", 0);
    }


}
