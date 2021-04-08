package nextstep.ladder.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineConnectionStrategyTest {

    @DisplayName("이전 사다리가 이어져 있을 경우 사다리 생성 테스트")
    @Test
    void beforeConnectTrue_createLine() {
        LineConnectionStrategy lineConnectionStrategy = new LineConnectionRandomStrategy();
        boolean previousLine = true;
        assertThat(lineConnectionStrategy.createLine(previousLine)).isFalse();
    }

    @DisplayName("[항상] 사다리 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"false:true", "true:true"}, delimiter = ':')
    void createLine(boolean previousLine, boolean expected) {
        LineConnectionStrategy lineConnectionStrategy = new LineConnectionMoveStrategy();
        assertThat(lineConnectionStrategy.createLine(previousLine)).isEqualTo(expected);
    }
}