package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {
    @Test
    @DisplayName("사다리 객체를 생성한다.")
    void LadderResult_사다리_결과_생성() {
        Map<Participant, Score> results = Map.of(new Participant("wu2ee"), new Score("꽝"));
        assertThat(new LadderResult(results)).isNotNull().isInstanceOf(LadderResult.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("사다리 결과가 null 일 경우 예외가 발생한다.")
    void LadderResult_사다리_결과_null(Map<Participant, Score> results) {
        assertThatThrownBy(() -> new LadderResult(results)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "wu2ee, 꽝",
            "pobi, 5000"
    })
    @DisplayName("사다리 결과에서 특정 참가자에 해당하는 점수를 반환한다.")
    void getScore_사다리_결과_점수_반환(String name, String scoreValue) {
        Map<Participant, Score> results = Map.of(
                new Participant("wu2ee"), new Score("꽝"),
                new Participant("pobi"), new Score("5000")
        );
        LadderResult ladderResult = new LadderResult(results);
        assertThat(ladderResult.getScore(name)).isEqualTo(scoreValue);
    }

    @Test
    @DisplayName("찾고자 하는 참가자가 없는 경우 예외가 발생한다.")
    void getScore_사다리_참가자_예외() {
        Map<Participant, Score> results = Map.of(
                new Participant("wu2ee"), new Score("꽝"),
                new Participant("pobi"), new Score("5000")
        );
        LadderResult ladderResult = new LadderResult(results);
        assertThatThrownBy(() -> ladderResult.getScore("honux")).isInstanceOf(IllegalArgumentException.class);
    }
}