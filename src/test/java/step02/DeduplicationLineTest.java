package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.ladder.DeduplicationLineStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class DeduplicationLineTest {

    @Test
    @DisplayName("중복 라인이 만들어지지 않는 테스트")
    void makeLine() {
        DeduplicationLineStrategy deduplicationLine = new DeduplicationLineStrategy();
        assertThat(deduplicationLine.makeLine(10,1, true)).isEqualTo(false);
    }
}
