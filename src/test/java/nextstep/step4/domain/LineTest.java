package nextstep.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void initLine() {
        int numberOfUsers = 3;
        Line line = Line.init(numberOfUsers);

        Assertions.assertThat(line.getIndexList().size()).isEqualTo(numberOfUsers);
    }

}