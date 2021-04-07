package nextstep.ladder.generator;

import nextstep.ladder.domain.Bar;
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
        List<Bar> actual = defaultLineGenerator.createLine(3).points().bars();
        List<Bar> expected = defaultLineGenerator.createLine(3).points().bars();
        // then
        assertThat(actual.size()).isEqualTo(expected.size());
    }
}
