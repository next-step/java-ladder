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
        List<LadderUser> ladderUsers = List.of(
            new LadderUser("pobi", new Position(0)),
            new LadderUser("honux", new Position(1))
        );
        assertDoesNotThrow(() -> new LadderUsers(ladderUsers));
    }

    @DisplayName("중복된 이름이 존재하면 예외를 반환한다.")
    @Test
    public void testConstructor_throwExceptionByDuplicatedName() {
        List<LadderUser> ladderUsers = List.of(
            new LadderUser("pobi", new Position(0)),
            new LadderUser("pobi", new Position(1))
        );
        assertThatThrownBy(() -> new LadderUsers(ladderUsers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 이름이 존재합니다.");
    }

    @DisplayName("중복된 위치가 존재하면 예외를 반환한다.")
    @Test
    public void testConstructor_throwExceptionByDuplicatedPosition() {
        List<LadderUser> ladderUsers = List.of(
            new LadderUser("pobi", new Position(0)),
            new LadderUser("jk", new Position(0))
        );
        assertThatThrownBy(() -> new LadderUsers(ladderUsers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 위치가 존재합니다.");
    }

    @DisplayName("유저 수가 1명 이하이면 예외를 반환한다.")
    @Test
    public void testConstructor_throwExceptionByUserCount() {
        List<LadderUser> ladderUsers = List.of(
            new LadderUser("pobi", new Position(0))
        );
        assertThatThrownBy(() -> new LadderUsers(ladderUsers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유저는 2명 이상이여야 합니다.");
    }
}
