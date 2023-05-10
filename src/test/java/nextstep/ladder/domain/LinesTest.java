package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @Test
    @DisplayName("높이만큼 lines 리스트를 생성한다.")
    void test01() {
        int height = 5;
        Lines lines = Lines.create(height, 2);

        assertThat(lines.getRows()).hasSize(height);
    }

    @Test
    @DisplayName("사용자 수보다 하나작은 points 를 생성한다.")
    void test02() {
        int height = 5;
        int userCount = 5;
        Lines lines = Lines.create(height, userCount);

        assertThat(lines.getRows().get(0).getConnectionStatuses()).hasSize(userCount - 1);
    }

}
