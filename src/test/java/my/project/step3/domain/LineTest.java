package my.project.step3.domain;

import my.project.common.domain.Symbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-12-10 오전 11:55
 * Developer : Seo
 */
class LineTest {
    int countOfPerson;
    int lineWithEmptyPoint;
    Line line;

    @BeforeEach
    void setUp() {
        countOfPerson = 5;
        lineWithEmptyPoint = 9;
        line = new Line(countOfPerson);
    }

    @DisplayName("생성")
    @Test
    void construct() {
        assertThat(line.getPoints()).hasSize(lineWithEmptyPoint);
    }

    @DisplayName("짝수는 직선")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6, 8})
    void isEvenNumberVertical(int input) {
        assertThat(line.getPoints().get(input)).isEqualTo(Symbol.VERTICAL);
    }

    @DisplayName("홀수는 직선 없음")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    void isOddNumberBridge(int input) {
        assertThat(line.getPoints().get(input)).isNotEqualTo(Symbol.VERTICAL);
    }

    @DisplayName("연결된 다리는 있으면 안됨")
    @Test
    void isValid() {
        Line line = new Line(3);
        String s1 = line.getPoints().get(1).getSymbol();
        String s2 = line.getPoints().get(3).getSymbol();
        assertThat(s1 + s2).isNotEqualTo(Symbol.BRIDGE.getSymbol() + Symbol.BRIDGE.getSymbol());
    }
}