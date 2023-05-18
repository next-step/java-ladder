package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultUsersTest {
    private static final Users users = Users.of("pobi,crong,honux,jk");
    private static final Ladder ladder = Ladder.of(users, new Height(5), () -> true);

    @ParameterizedTest
    @CsvSource(value = {"pobi,5000", "crong,꽝", "honux,3000", "jk,꽝"})
    @DisplayName("유저 이름으로 결과 확인")
    void create(String userName, String expected) {
        // given
        ResultInput resultInput = ResultInput.of("꽝,5000,꽝,3000");
        ResultUsers resultUsers = ResultUsers.of(ladder, resultInput);

        // when
        String actual = resultUsers.getResultByUser(userName);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("유저 이름으로 결과 확인 - 유저 이름과 결과의 길이가 다른 경우")
    void createException() {
        // given
        ResultInput resultInput = ResultInput.of("꽝,5000,꽝");


        // when
        assertThatThrownBy(() -> ResultUsers.of(ladder, resultInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사용자 수와 결과 수가 일치하지 않습니다.");
    }
}
