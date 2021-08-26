package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인 생성 길이체크")
    void create1() {
        RandomPoint random = () -> true;
        Line line = Line.of(5, random);

        assertThat(line.getSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("라인 생성 리스트 확인")
    void create2() {
        RandomPoint random = () -> true;
        Line line = Line.of(2, random);

        assertThat(line.getList()).containsExactly(true,true);
    }


}