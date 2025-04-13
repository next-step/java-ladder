package nextstep.ladder.domain.edge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderUsersTest {

    @DisplayName("LadderUsers 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderUsers(List.of("pobi", "honux", "crong", "jk")));
    }

    @DisplayName("중복된 이름이 존재하면 예외를 반환한다.")
    @Test
    public void testConstructor_throwExceptionByDuplicatedName() {
        assertThatThrownBy(() -> new LadderUsers(List.of("pobi", "pobi")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 이름이 존재합니다.");
    }

    @DisplayName("유저 수가 1명 이하이면 예외를 반환한다.")
    @Test
    public void testConstructor_throwExceptionByUserCount() {
        assertThatThrownBy(() -> new LadderUsers(List.of("pobi")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유저는 2명 이상이여야 합니다.");
    }

}
