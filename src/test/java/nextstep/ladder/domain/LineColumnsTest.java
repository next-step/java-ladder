package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineColumnsTest {

    @Test
    @DisplayName("높이만큼 가로라인 리스트를 생성한다.")
    void test01() {
        int height = 5;
        LineColumns lineColumns = LineColumns.create(height, 5);
        
        assertThat(lineColumns.getColumns()).hasSize(height);
    }

}
