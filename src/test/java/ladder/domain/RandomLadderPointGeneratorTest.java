package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderPointGeneratorTest {

    @Test
    @DisplayName("랜덤 번호 생성 테스트")
    void generate() {
        AtomicInteger count = new AtomicInteger();
        new RandomLadderPointGenerator().generate(5, 100, (lineNumber) -> {
            count.incrementAndGet();
            assertThat(lineNumber).isBetween(0, 5);
        });
        assertThat(count.get()).isEqualTo(100);
    }
}
