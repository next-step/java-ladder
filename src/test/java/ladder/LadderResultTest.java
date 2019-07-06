package ladder;

import ladder.domain.LadderResult;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderResultTest {
    private LadderResult result;

    @Before
    public void setUp() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);

        result = new LadderResult(map);
    }

    @Test
    public void move_case_1() {
        assertThat(result.move(0)).isEqualTo(0);
    }

    @Test
    public void move_case_2() {
        assertThat(result.move(1)).isEqualTo(1);
    }

    @Test
    public void move_input_invalid() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            result.move(2);
        });
    }
}
