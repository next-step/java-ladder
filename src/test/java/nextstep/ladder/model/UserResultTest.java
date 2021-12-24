package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserResultTest {
    public static final UserResult USER_RESULT_WITH_BANG = new UserResult(UserTest.USER, LadderResultTest.BANG);
    public static final UserResult USER_RESULT_WITH_2000_WON = new UserResult(UserTest.USER, LadderResultTest.WON_2000);
}
