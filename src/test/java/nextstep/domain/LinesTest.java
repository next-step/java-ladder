package nextstep.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinesTest {


    @DisplayName("높이 만큼 라인리스트을 생성할 수 있다.")
    @Test
    void create() {

        Lines lines = Lines.create(3, 5);
        Assertions.assertThat(lines.size()).isEqualTo(5);
    }
}
