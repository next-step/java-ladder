package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserResultTest {
    public static final UserResult CRONG_USER_RESULT_WITH_BANG = new UserResult(UserTest.CRONG, LadderResultTest.BANG);
    public static final UserResult POBI_USER_RESULT_WITH_2000_WON = new UserResult(UserTest.POBI, LadderResultTest.WON_2000);

    @Test
    void createTest() {
        // then
        assertThat(CRONG_USER_RESULT_WITH_BANG).isNotNull();
    }

    @Test
    void checkExceptionWithNullUserTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new UserResult(null, LadderResultTest.BANG)
        );
    }

    @Test
    void checkExceptionWithNullLadderResultTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new UserResult(UserTest.POBI, null)
        );
    }

    @Test
    void getUserTest() {
        // when & then
        assertThat(CRONG_USER_RESULT_WITH_BANG.getUser()).isNotNull();
    }

    @Test
    void getResultTest() {
        // when & then
        assertThat(CRONG_USER_RESULT_WITH_BANG.getResult()).isNotNull();
    }

    @Test
    void userNameTest() {
        // when & then
        assertThat(CRONG_USER_RESULT_WITH_BANG.userName()).isEqualTo(UserTest.CRONG.getName());
    }

    @Test
    void ladderResultTest() {
        // when & then
        assertThat(CRONG_USER_RESULT_WITH_BANG.ladderResult()).isEqualTo(LadderResultTest.BANG.getValue());
    }
}
