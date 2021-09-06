package nextstep.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static MiddleLadder random;

    @Test
    @BeforeAll
    static void setRandom() {
        random = new MiddleLadder() {
            @Override
            public boolean makeBoolean() {
                return true;
            }

            @Override
            public void resetLine() {

            }
        };
    }

    @Test
    @DisplayName("라인 생성 길이체크")
    void create1() {
        Line line = Line.of(5, random);
        assertThat(line.getSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("라인 생성 리스트 확인")
    void create2() {
        Line line = Line.of(2, random);
        assertThat(line.pointLists()).containsExactly(true, true);
    }


}