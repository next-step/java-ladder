package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static nextstep.ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

public class BridgesTest {

    @DisplayName("사다리의 x축인 다리가 연속으로 존재(true)하면 예외를 발생시킨다.")
    @Test
    void createBridgesWhenTruInARow() {
        assertThatThrownBy(() -> new Bridges(List.of(true, true, false))).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NOT_TRUE_STRAIGHT.message());
    }

    @DisplayName("Bridges의 boolean값을 사다리의 다리모양(String)으로 변환해 반환한다.")
    @Test
    void toBooleans() {
        // given
        Bridges bridges = new Bridges(List.of(true, false, true));

        // when
        String stringBridges = bridges.toString();

        // then
        assertThat(stringBridges).isEqualTo("-----|     |-----");
    }

    @DisplayName("인자로 사다리의 다리 위치 값을 전달 받아 해당 다리가 이동 가능한 지 확인한다.")
    @ParameterizedTest
    @CsvSource({"0,true", "1,false", "3,false"})
    void isMovable(int x, boolean expectedReuslt) {
        Bridges bridges = new Bridges(List.of(true, false, true));

        // when & then
        assertThat(bridges.isMovable(x)).isEqualTo(expectedReuslt);
    }

    @DisplayName("사다리 위치 값을 인자로 받아 다음 위치로 이동한다.")
    @ParameterizedTest
    @CsvSource({"0,0", "1,2", "2,1", "3,3"})
    void move(int position, int expectedReuslt) {
        // given
        Bridges bridges = new Bridges(List.of(false, true, false));

        // when & then
        assertThat(bridges.move(position)).isEqualTo(expectedReuslt);
    }
}
