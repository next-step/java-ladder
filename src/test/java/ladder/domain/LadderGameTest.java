package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private Users users;
    private Height height;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("pobi", "crong", "jk", "honux", "test");
        users = new Users(names);
        height = new Height(5);
    }

    @Test
    @DisplayName("사다리 게임에 참여할 사람들의 목록을 입력하면 그 수만큼 사다리를 생성한다.")
    void create() {
        // when
        LadderGame ladderGame = new LadderGame(users, height);

        // then
        assertThat(ladderGame.width()).isEqualTo(users.size());
        assertThat(ladderGame.height()).isEqualTo(height.getHeight());
    }

    @Test
    @DisplayName("사다리 게임에서는 랜덤하게 가로 라인을 그릴 수 있다.")
    void draw() {
        // given
        LadderGame ladderGame = new LadderGame(users, height);

        // when
        ladderGame.drawAll(() -> true);
        List<Integer> connectedCounts = ladderGame.connectedCounts();

        // then
        assertThat(connectedCounts).containsExactly(5, 5, 5, 5, 0);
    }

    @Test
    @DisplayName("사다리 게임에서 특정 인덱스의 오른쪽 라인 연결 여부 확인")
    void checkRightConnections() {
        // given
        LadderGame ladderGame = new LadderGame(users, height);
        ladderGame.drawAll(() -> true);

        // when
        List<Boolean> actual = ladderGame.checkRightConnections(0);

        // then
        assertThat(actual).containsExactly(true, false, true, false, false);
    }
}