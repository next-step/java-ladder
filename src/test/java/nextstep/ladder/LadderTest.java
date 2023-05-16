package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.strategy.RandomLadderPointGenerateStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리타기 테스트")
public class LadderTest {

    @Test
    @DisplayName("참가자 이름이 최대 길이를 초과하면 예외를 던진다.")
    void validateParticipantNameLength_test() {
        String name = "NewJeans";

        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("참가자의 이름이 null이거나 빈 문자일 경우 예외를 던진다.")
    void validateParticipantNameNullAndEmpty_test(String name) {
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사다리 결과의 입력이 null이거나 빈 문자일 경우 예외를 던진다.")
    void validateLadderResultNullAndEmpty_test(String result) {
        assertThatThrownBy(() -> new LadderResult(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 수와 결과 수가 일치하지 않으면 예외를 던진다.")
    void validateLadderResults_test() {
        Participants participants = new Participants(List.of(new Participant("a")));
        List<LadderResult> inputLadderResults = List.of(new LadderResult("꽝"), new LadderResult("1000"));

        assertThatThrownBy(
                () -> new LadderGame(participants, new Lines(1, 1, new RandomLadderPointGenerateStrategy()), inputLadderResults)
        );
    }

    @Test
    @DisplayName("존재 하지 않는 참가자의 결과를 요구하면 예외를 던진다.")
    void ladderResultByParticipantThrow_test() {
        Participants participants = new Participants(List.of(new Participant("a")));
        List<LadderResult> inputLadderResults = List.of(new LadderResult("꽝"));
        LadderGame ladderGame = new LadderGame(participants, new Lines(1, 1, new RandomLadderPointGenerateStrategy()), inputLadderResults);

        LadderResults ladderResults = ladderGame.play();

        assertThatThrownBy(() -> ladderResults.getResultForParticipant(new Participant("b")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라인이 겹치게 생성되었으면 예외를 던진다.")
    void shouldNotOverlapLines_test() {
        int height = 5;
        int numberOfParticipants = 4;

        assertThatThrownBy(() -> new Lines(numberOfParticipants, height, size -> List.of(true, true, true, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리는 높이만큼 라인이 생성되어야 한다.")
    void tests() {
        int height = 5;
        int numberOfParticipants = 4;
        Lines lines = new Lines(numberOfParticipants, height, new RandomLadderPointGenerateStrategy());

        Assertions.assertThat(height).isEqualTo(lines.getLines().size());
    }

    @Test
    @DisplayName("사다리의 라인은 (참가자 수 -1) 만큼 생성되어야 한다.")
    void testSI() {
        int height = 5;
        int numberOfParticipants = 4;
        Lines lines = new Lines(numberOfParticipants, height, new RandomLadderPointGenerateStrategy());

        lines.getLines().forEach(line -> Assertions.assertThat(numberOfParticipants - 1).isEqualTo(line.getPoints().size()));
    }

}
