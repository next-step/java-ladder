package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        users = Users.of(List.of("pobi", "honux", "crong", "jk"));
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

    @ParameterizedTest(name = "{0}, {1}")
    @CsvSource(value = {"pobi, 1", "honux, 0", "crong, 3", "jk, 2"})
    @DisplayName("실행 결과 - 특정 유저의 결과")
    void climb(String userName, int expected) {
        // given
        Ladder ladder = Ladder.of(users, height, () -> true);
        ResultInput resultInput = ResultInput.of("꽝, 5000, 꽝,3000");

        // when
        int actual = ladder.climbUser(userName);

        // then
        assertThat(resultInput.getResultByPosition(actual)).isEqualTo(resultInput.getResultByPosition(expected));
    }
}