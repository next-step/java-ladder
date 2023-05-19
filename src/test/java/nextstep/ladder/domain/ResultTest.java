package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    private Participants participants;
    private Result result;
    private List<Line> lines;

    @BeforeEach
    void setUp() {
        this.participants = new Participants(List.of("pobi", "honux", "crong", "jk"));
        this.result = Result.of(participants, "꽝,5000,꽝,3000");
        this.lines = List.of(
                new Line(List.of(true, false, true)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(true, false, true))
        );
    }

    @DisplayName("참여자 수와 실행 결과 수가 일치하지 않으면 예외를 발생한다")
    @Test
    void when_ParticipantsNumIsNotEqualToResultsCount_Expects_ThrowException() {
        assertThatThrownBy(() -> Result.of(participants, "꽝,5000,꽝,3000,꽝"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수와 실행 결과 수가 일치하면 예외를 발생하지 않는다")
    @Test
    void when_ParticipantsNumEqualToResultsCount_Expects_DoesNotThrowException() {
        assertThatNoException()
                .isThrownBy(() -> Result.of(participants, "꽝,5000,꽝,3000"));
    }

    @DisplayName("참여자 리스트에 존재하지 않는 이름을 입력하면 예외가 발생한다")
    @Test
    void when_InputInvalidName_Expects_ThrowException() {

        assertThatThrownBy(() -> result.gameResult(participants, "INVALID_NAME", lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 리스트에 존재하는 이름을 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
    void when_InputValidName_Expects_DoesNotThrowException(String name) {

        assertThatNoException()
                .isThrownBy(() -> result.gameResult(participants, name, lines));
    }

    @DisplayName("pobi의 실행 결과는 꽝이다")
    @Test
    void gameResultTest_1() {
        String expected = "꽝";

        String gameResult = result.gameResult(participants, "pobi", lines);

        assertThat(gameResult).isEqualTo(expected);
    }

    @DisplayName("honux의 실행 결과는 3000이다")
    @Test
    void gameResultTest_2() {
        String expected = "3000";

        String gameResult = result.gameResult(participants, "honux", lines);

        assertThat(gameResult).isEqualTo(expected);
    }

    @DisplayName("crong의 실행 결과는 꽝이다")
    @Test
    void gameResultTest_3() {
        String expected = "꽝";

        String gameResult = result.gameResult(participants, "crong", lines);

        assertThat(gameResult).isEqualTo(expected);
    }

    @DisplayName("jk의 실행 결과는 5000이다")
    @Test
    void gameResultTest_4() {
        String expected = "5000";

        String gameResult = result.gameResult(participants, "jk", lines);

        assertThat(gameResult).isEqualTo(expected);
    }

    @DisplayName("all을 입력하면 모든 실행 결과를 반환한다")
    @Test
    void gameResultTest_all() {
        String expected = "pobi : 꽝\n" +
                "honux : 3000\n" +
                "crong : 꽝\n" +
                "jk : 5000\n";

        String gameResult = result.gameResult(participants, "all", lines);

        assertThat(gameResult).isEqualTo(expected);
    }
}