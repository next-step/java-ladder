package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {
    @Test
    @DisplayName("기본 생성 테스트")
    void constructorTest() {
        int height = 5;
        int size = 4;
        assertThatCode(() -> Ladder.of(height,size))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("라인 수 가져오는 테스트")
    void getLinesTest() {
        int height = 5;
        int size = 4;
        assertThat(Ladder.of(height,size).getLines())
                .hasSize(height);
    }
}
