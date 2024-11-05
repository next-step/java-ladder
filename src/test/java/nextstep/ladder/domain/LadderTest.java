package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("참여자 수와 결과 수가 다른 경우 예외가 잘 발생하는지")
    @Test
    void createLadderWithDifferentParticipantsAndResults() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.createLadder(
                        new Participants(List.of(new Participant("pobi"), new Participant("honux"))),
                        new LadderResult(List.of("꽝", "5000", "3000")),
                        3,
                        new RandomLineDecisionStrategy()));
    }

    @DisplayName("사다리 높이가 1 미만인 경우 예외가 잘 발생하는지")
    @Test
    void createLadderWithInvalidHeight() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.createLadder(
                        new Participants(List.of(new Participant("pobi"), new Participant("honux"))),
                        new LadderResult(List.of("꽝", "5000")),
                        0,
                        new RandomLineDecisionStrategy()));
    }

    @DisplayName("사다리가 예상대로 잘 생성되는지")
    @Test
    void createLadderTest() {
        Participants participants = new Participants(List.of(new Participant("pobi"), new Participant("honux"), new Participant("crong")));
        LadderResult result = new LadderResult(List.of("꽝", "5000", "3000"));
        LineDecisionStrategy testStrategy = new TestLineDecisionStrategy(
                true, false,
                false, true,
                true, false
        );
        Ladder ladder = Ladder.createLadder(participants, result, 3, testStrategy);
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
        LadderResult result = new LadderResult(List.of("꽝", "5000", "3000"));
        LineDecisionStrategy testStrategy = new TestLineDecisionStrategy(
                true, true,
                true, true,
                true, true
        );

        Ladder ladder = Ladder.createLadder(participants, result, 3, testStrategy);

        ladder.lines().forEach(line -> {
            Points points = line.points();
            for (int i = 0; i < points.size() - 1; i++) {
                assertThat(points.isConnected(i) && points.isConnected(i + 1)).isFalse();
            }
        });
    }

    @DisplayName("결과를 잘 찾아서 반환하는지")
    @Test
    void findResultTest() {
        Participants participants = new Participants(List.of(
                new Participant("pobi"),
                new Participant("honux"),
                new Participant("crong")
        ));
        LadderResult results = new LadderResult(List.of("꽝", "5000", "3000"));
        LineDecisionStrategy testStrategy = new TestLineDecisionStrategy(
                true, false,  // 첫 줄: pobi -> honux
                false, true   // 둘째 줄: honux -> crong
        );

        Ladder ladder = Ladder.createLadder(participants, results, 2, testStrategy);

        assertThat(ladder.findResult("pobi")).isEqualTo("3000");
        assertThat(ladder.findResult("honux")).isEqualTo("꽝");
        assertThat(ladder.findResult("crong")).isEqualTo("5000");
    }

    @DisplayName("모든 결과를 조회했을 때 결과를 잘 반환하는지")
    @Test
    void findAllResults() {
        Participants participants = new Participants(List.of(
                new Participant("pobi"),
                new Participant("honux")
        ));
        LadderResult results = new LadderResult(List.of("꽝", "5000"));
        LineDecisionStrategy testStrategy = new AllLineDecisionStrategy();

        Ladder ladder = Ladder.createLadder(participants, results, 1, testStrategy);
        GameResult allResults = ladder.findAllResults();

        assertThat(allResults.getAllResults())
                .containsEntry("pobi", "5000")
                .containsEntry("honux", "꽝");
    }
}

