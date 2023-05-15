package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private Height height;
    private Users users;

    @BeforeEach
    void setUp() {
        height = new Height(5);
        users = new Users(List.of("pobi", "honux", "crong", "jk"));
    }

    @Test
    @DisplayName("Ladder 생성")
    void create() {
        // given
        DrawStrategy drawStrategy = () -> true;
        List<LadderRow> ladderRows = IntStream.range(0, height.getHeight())
                .mapToObj(i -> LadderRow.of(users.numberOfUsers(), drawStrategy))
                .collect(Collectors.toList());

        // when
        Ladder ladder = new Ladder(users, ladderRows);

        // then
        assertThat(ladder).isEqualTo(new Ladder(users, ladderRows));
        assertThat(ladder.width()).isEqualTo(users.numberOfUsers());
        assertThat(ladder.height()).isEqualTo(height.getHeight());
    }

    @Test
    @DisplayName("전략에 따라 사다리 생성")
    void create2() {
        // given
        Ladder ladder = Ladder.of(users, height, () -> true);

        // then
        assertThat(ladder).isEqualTo(Ladder.of(users, height, () -> true));
    }

    @Test
    @DisplayName("유저 이름 확인")
    void userNames() {
        // given
        Ladder ladder = Ladder.of(users, height, () -> true);
        List<String> userNames = List.of("pobi", "honux", "crong", "jk");

        // then
        assertThat(ladder.getUserNames()).isEqualTo(userNames);
    }

    @Test
    @DisplayName("라인의 오른쪽 연결 확인")
    void hasRightConnections() {
        // given
        Ladder ladder = Ladder.of(users, height, () -> true);
        List<Boolean> hasRightConnections = List.of(true, false, true, false);

        // then
        assertThat(ladder.hasRightConnections(0)).isEqualTo(hasRightConnections);
    }

    @Test
    @DisplayName("실행 결과 - 특정 유저")
    void climb() {
        // given
        Ladder ladder = Ladder.of(users, height, () -> true);
        Result result = new Result("꽝, 5000, 꽝,3000");

        // when
        int actual = ladder.climbUser("pobi");
        int actual2 = ladder.climbUser("crong");

        // then
        assertThat(result.getResultByPosition(actual)).isEqualTo("5000");
        assertThat(result.getResultByPosition(actual2)).isEqualTo("3000");
    }
}