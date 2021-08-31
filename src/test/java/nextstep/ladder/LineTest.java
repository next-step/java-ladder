package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("참여자의 수에 맞는 사다리 라인 생성")
    void create() {
        assertThat(new Line(5).size()).isEqualTo(5);
    }
}