package nextstep.ladder.generator;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultLineGeneratorTest {

    @DisplayName("참여자에 따른 Line 생성 테스트")
    @Test
    void lineGenerator_생성_테스트() {
        // given
        DefaultLineGenerator defaultLineGenerator = new DefaultLineGenerator();
        // when
        List<Point> line = defaultLineGenerator.createLine(3);
        // then
        assertThat(line.get(0).isExist()).isFalse(); // 첫 번째 값은 false로 고정
        assertThat(line.size()).isEqualTo(3);
    }
}
