package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("사다리 높이가 1 미만인 경우 예외가 잘 발생하는지")
    @Test
    void createLadderWithInvalidHeight() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.createLadder(
                        new Participants(List.of(new Participant("pobi"), new Participant("honux"))),
                        0,
                        new RandomLineDecisionStrategy()));
    }

    @DisplayName("사다리가 예상대로 잘 생성되는지")
    @Test
    void createLadderTest() {
        Participants participants = new Participants(List.of(new Participant("pobi"), new Participant("honux"), new Participant("crong")));
        LineDecisionStrategy testStrategy = new TestLineDecisionStrategy(
                true, false,
                false, true,
                true, false
        );
        Ladder ladder = Ladder.createLadder(participants, 3, testStrategy);
        List<Line> lines = ladder.lines();

        // 첫 번째 줄 검증
        assertThat(lines.get(0).points().isConnected(0)).isTrue();
        assertThat(lines.get(0).points().isConnected(1)).isFalse();

        // 두 번째 줄 검증
        assertThat(lines.get(1).points().isConnected(0)).isFalse();
        assertThat(lines.get(1).points().isConnected(1)).isTrue();

        // 세 번째 줄 검증
        assertThat(lines.get(2).points().isConnected(0)).isTrue();
        assertThat(lines.get(2).points().isConnected(1)).isFalse();
    }

    @DisplayName("사다리가 생성되었을 때 연속된 선이 생기지 않는지")
    @Test
    void createLadderTest_NoContinuousLine() {
        Participants participants = new Participants(List.of(new Participant("pobi"), new Participant("honux"), new Participant("crong")));
        LineDecisionStrategy testStrategy = new TestLineDecisionStrategy(
                true, true,
                true, true,
                true, true
        );

        Ladder ladder = Ladder.createLadder(participants, 3, testStrategy);

        ladder.lines().forEach(line -> {
            Points points = line.points();
            for (int i = 0; i < points.size() - 1; i++) {
                // 연속된 두 지점이 모두 연결되어 있지 않아야 함
                assertThat(points.isConnected(i) && points.isConnected(i + 1)).isFalse();
            }
        });
    }
}
