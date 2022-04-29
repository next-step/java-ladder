package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineGeneratorTest {

    @Test
    @DisplayName("사람의 수 만큼 사다리에 해당하는 한 Row 를 만듭니다. (이 Line 은 연속되서 이어지지 않습니다.)")
    void create() {
        List<Boolean> line = LineGenerator.createLine(4);
        assertThat(line).hasSize(4);
    }

}