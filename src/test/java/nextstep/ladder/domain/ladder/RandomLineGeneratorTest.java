package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RandomLineGeneratorTest {

    @Test
    @DisplayName("랜덤 라인 생성기 생성 테스트")
    void create() {
        assertThatCode(() -> new RandomLineGenerator(0, 1)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("랜덤 라인 generate 테스트")
    void generate() {
        int position = 1;
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator(0, 1);
        Line line = randomLineGenerator.generate(1);
        assertThat(line).isNotNull();
    }
}
