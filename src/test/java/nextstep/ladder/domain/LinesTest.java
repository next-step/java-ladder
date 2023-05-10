package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    @DisplayName("높이만큼 가로라인 리스트를 생성한다.")
    void test01() {
        int height = 5;
        Lines lines = Lines.create(height, 5);

        assertThat(lines.getRows()).hasSize(height);
    }

}
