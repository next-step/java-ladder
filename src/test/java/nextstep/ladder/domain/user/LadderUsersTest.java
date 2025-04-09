package nextstep.ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class LadderUsersTest {
    public static LadderUsers LadderUSERS1 = new LadderUsers("pobi,honux,crong,jk");


    @DisplayName("Users 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderUsers("pobi,honux,crong,jk"));
    }

    @DisplayName("유저 수가 1명 이하이면 예외를 반환한다.")
    @Test
    public void testConstructor_throwException() {
        assertThatThrownBy(() -> new LadderUsers("pobi"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유저는 2명 이상이여야 합니다.");
    }
}
