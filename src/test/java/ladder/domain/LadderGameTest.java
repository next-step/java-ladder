package ladder.domain;

import ladder.pattern.CustomValueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {
    @ParameterizedTest
    @NullSource
    @DisplayName("참가자 리스트가 null 일 경우 예외가 발생한다.")
    void LadderGame_참가자_null(List<Participant> participants) {
        List<Score> scores = List.of(new Score("꽝"), new Score("5000"));
        assertThatThrownBy(() -> new LadderGame(participants, scores)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("점수 리스트가 null 일 경우 예외가 발생한다.")
    void LadderGame_점수_null(List<Score> scores) {
        List<Participant> participants = List.of(new Participant("wu2ee"), new Participant("pobi"));
        assertThatThrownBy(() -> new LadderGame(participants, scores)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 리스트와 점수 리스트 길이가 같지 않을 경우 예외가 발생한다.")
    void LadderGame_참가자_점수_사이즈_예외() {
        List<Participant> participants = List.of(new Participant("wu2ee"), new Participant("pobi"));
        List<Score> scores = List.of(new Score("꽝"), new Score("5000"), new Score("3000"));
        assertThatThrownBy(() -> new LadderGame(participants, scores)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 이름 최대 길이 보다 점수 최대 길이가 클 경우 예외가 발생한다.")
    void LadderGame_참가자_점수_최대_길이_예외() {
        List<Participant> participants = List.of(new Participant("wu2e"), new Participant("pobi"));
        List<Score> scores = List.of(new Score("꽝"), new Score("50000"), new Score("3000"));
        assertThatThrownBy(() -> new LadderGame(participants, scores)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("사다리가 null 일 경우 예외가 발생한다.")
    void ladderResult_사다리_null(Ladder ladder) {
        List<Participant> participants = List.of(new Participant("wu2ee"));
        List<Score> scores = List.of(new Score("꽝"));
        LadderGame ladderGame = new LadderGame(participants, scores);
        assertThatThrownBy(() -> ladderGame.ladderResult(ladder)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전달 받은 사다리에 대한 사다리 결과를 반환한다.")
    void ladderResult_사다리_결과() {
        // given
        CustomValueGenerator customValueGenerator = new CustomValueGenerator(List.of(
                true, true,
                false, true,
                true, false));
        Ladder ladder = Ladder.create(3, 3, customValueGenerator);
        List<Participant> participants = List.of(new Participant("wu2ee"), new Participant("pobi"), new Participant("honux"));
        List<Score> scores = List.of(new Score("5000"), new Score("3000"), new Score("꽝"));
        LadderGame ladderGame = new LadderGame(participants, scores);

        Map<Participant, Score> expectedResult = Map.of(
                new Participant("wu2ee"), new Score("꽝"),
                new Participant("pobi"), new Score("3000"),
                new Participant("honux"), new Score("5000")
        );
        LadderResult expectedLadderResult = new LadderResult(expectedResult);

        // when
        LadderResult actualLadderResult = ladderGame.ladderResult(ladder);

        // then
        assertThat(actualLadderResult).isEqualTo(expectedLadderResult);
    }
}