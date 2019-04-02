package domain;

import org.junit.Test;

public class UserTest {
    @Test(expected = IllegalArgumentException.class)
    public void 이름이_한글자_미만일_경우_예외가_발생한다() {
        new User("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름이_다섯글자를_초과할_경우_예외가_발생한다() {
        new User("123456");
    }
}
