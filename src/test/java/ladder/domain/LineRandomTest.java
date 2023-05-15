package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class LineRandomTest {

    LineRandom random = new LineRandom(new Random());

    @Test
    void 랜덤리스트() {
        List<Boolean> actual = random.randomList(3);
        assertAll(
            () -> assertThat(actual).hasSize(3),
            () -> {
                for (int i = 1; i < actual.size(); i++) {
                    assertThat(actual.get(i-1) && actual.get(i)).isFalse();
                }
            }
        );
    }

    @Test
    void 다음포인트() {
        assertThat(random.nextPoint(Boolean.TRUE)).isEqualTo(Boolean.FALSE);
    }

}
