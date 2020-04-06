package ladder.domain.ladder;

import ladder.domain.Gamers;
import ladder.domain.ladder.maker.MakeLadderStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {

    private int height;
    private Ladder testLadder;

    @BeforeEach
    void setTestLadder() {
        height = 5;
        testLadder = Ladder.of(Gamers.ofComma("a,b,c"), MakeLadderStrategy.getRandomMaker(3,height));
    }

    @Test
    @DisplayName("기본 생성 테스트")
    void constructorTest() {
        assertThatCode(() -> Ladder.of(Gamers.ofComma("a,b,c"), MakeLadderStrategy.getRandomMaker(3,height)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("라인 수 가져오는 테스트")
    void getLinesTest() {
        assertThat(testLadder.getLines())
                .hasSize(height);
    }
}
