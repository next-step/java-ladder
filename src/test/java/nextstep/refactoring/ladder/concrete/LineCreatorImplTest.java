package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.LineCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineCreatorImplTest {

    @Test
    @DisplayName("참가자 수 만큼의 지점을 가진 라인을 생성한다.")
    void generateLine() {
        LineCreator lineCreator = new LineCreatorImpl();

        assertThat(lineCreator.create(5).getWidth()).isEqualTo(5);
    }
    
}
