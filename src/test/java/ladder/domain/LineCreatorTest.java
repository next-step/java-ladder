package ladder.domain;

import ladder.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineCreatorTest {

    @DisplayName("LineCreator 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LineCreator lineCreator = LineCreator.getInstance();

        // then
        assertThat(lineCreator).isNotNull();
    }


}