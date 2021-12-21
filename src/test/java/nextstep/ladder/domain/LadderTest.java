package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    Ladder ladder;

    @BeforeEach
    private void before() {
        ladder = new Ladder(Arrays.asList(
            Line.createWithVariables(false, true, false),
            Line.createWithVariables(false, false, true),
            Line.createWithVariables(false, true, false)
        ));
    }

    @Test
    void 생성_확인() {
        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @ParameterizedTest(name="{displayName} | 현재위치: {0} | 결과값: {1}")
    @CsvSource(value = {"0:2", "1:1", "2:0"}, delimiter = ':')
    void 위치_확인(int param, int result) {
        assertThat(ladder.getPosition(param)).isEqualTo(result);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 4})
    void 위치_오입력_IllegalArgumentException(int param) {
        assertThatThrownBy(() -> {
            ladder.getPosition(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라인마다_포인트_개수가_다른경우_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            Ladder ladder = new Ladder(Arrays.asList(
                Line.createWithVariables(false, true, false),
                Line.createWithVariables(false, false),
                Line.createWithVariables(false, true, false)
            ));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
