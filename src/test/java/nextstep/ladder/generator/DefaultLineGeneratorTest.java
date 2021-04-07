package nextstep.ladder.generator;

import nextstep.ladder.wrapper.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultLineGeneratorTest {

    @DisplayName("참여자에 따른 Line 생성 테스트")
    @Test
    void lineGenerator_생성_테스트() {
        // given
        DefaultLineGenerator defaultLineGenerator = new DefaultLineGenerator();
        // when
        Line line = defaultLineGenerator.createLine(3);
        // then
        assertThat(line).isEqualTo(defaultLineGenerator.createLine(3));
    }
}
