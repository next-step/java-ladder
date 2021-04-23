package ladder.domain.ladder;

import ladder.domain.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("Line 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int sizeOfPerson = 5;
        LineGenerateStrategy strategy = () -> true;

        // when
        Line line = Line.from(sizeOfPerson, strategy);

        // then
        assertThat(line).isNotNull();
    }

}