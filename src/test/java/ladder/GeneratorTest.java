package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    void 수평선_생성() {
        FixedLineGenerator fixedLineGenerator = new FixedLineGenerator();
        List<Boolean> result = fixedLineGenerator.run(false, true, false, true);

        assertThat(result).isEqualTo(List.of(false, true, false, true));
    }
}
