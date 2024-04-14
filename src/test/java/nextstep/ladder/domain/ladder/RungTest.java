package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RungTest {

    @DisplayName("사다리 발판 생성 규칙은 이전 발판에 영향을 받는다.")
    @ParameterizedTest
    @CsvSource(value = {"EMPTY,NONE,EXIST,RIGHT", "EXIST,RIGHT,EXIST,LEFT", "EXIST,LEFT,EXIST,RIGHT"})
    void generate(Connection originConnection, Direction originDirection, Connection expectedConnection, Direction expectedDirection) {
        assertThat(new Rung(originConnection, originDirection).generate(() -> true))
                .isEqualTo(new Rung(expectedConnection, expectedDirection));
    }

    @DisplayName("rightConnected는 발판이 우측으로 연결되었는지 여부를 반환한다.")
    @Test
    void rightConnected() {
        assertThat(new Rung(Connection.EXIST, Direction.RIGHT).rightConnected())
                .isTrue();
    }

    @DisplayName("leftConnected는 발판이 우측으로 연결되었는지 여부를 반환한다.")
    @Test
    void leftConnected() {
        assertThat(new Rung(Connection.EXIST, Direction.LEFT).leftConnected())
                .isTrue();
    }

    @DisplayName("notConnected는 발판이 우측으로 연결되었는지 여부를 반환한다.")
    @Test
    void notConnected() {
        assertThat(new Rung(Connection.EMPTY, Direction.NONE).notConnected())
                .isTrue();
    }
}
