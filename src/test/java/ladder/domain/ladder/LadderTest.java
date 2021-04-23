package ladder.domain.ladder;

import ladder.domain.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("Ladder 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int sizeOfPerson = 5;
        LineGenerateStrategy strategy = () -> true;

        // when
        Line line = Line.of(sizeOfPerson, strategy);

        // then
        assertThat(line).isNotNull();
    }
}