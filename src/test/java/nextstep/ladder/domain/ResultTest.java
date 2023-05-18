package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @DisplayName("참여자 수와 실행 결과 수가 일치하지 않으면 예외를 발생한다")
    @Test
    void when_ParticipantsNumIsNotEqualToResultsCount_Expects_ThrowException() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        assertThatThrownBy(() -> Result.of(participants, "꽝,5000,꽝,3000,꽝"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수와 실행 결과 수가 일치하면 예외를 발생하지 않는다")
    @Test
    void when_ParticipantsNumEqualToResultsCount_Expects_DoesNotThrowException() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        assertThatNoException()
                .isThrownBy(() -> Result.of(participants, "꽝,5000,꽝,3000"));
    }

    @DisplayName("해당하는 결과를 출력한다")
    @Test
    void test() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        Result result = Result.of(participants, "꽝,5000,꽝,3000");
        List<Line> lines = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        );

        String gameResult = result.calculateResult(participants, "pobi", lines);

        assertThat(gameResult).isEqualTo("꽝");
    }

    @Test
    void test2() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        Result result = Result.of(participants, "꽝,5000,꽝,3000");
        List<Line> lines = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        );

        String gameResult = result.calculateResult(participants, "honux", lines);

        assertThat(gameResult).isEqualTo("3000");
    }

    @Test
    void test3() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        Result result = Result.of(participants, "꽝,5000,꽝,3000");
        List<Line> lines = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        );

        String gameResult = result.calculateResult(participants, "crong", lines);

        assertThat(gameResult).isEqualTo("꽝");
    }

    @Test
    void test4() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        Result result = Result.of(participants, "꽝,5000,꽝,3000");
        List<Line> lines = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        );

        String gameResult = result.calculateResult(participants, "jk", lines);

        assertThat(gameResult).isEqualTo("5000");
    }
}