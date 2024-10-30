package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;
import org.junit.jupiter.api.Test;

public class NonConsecutiveFlagGeneratorTest {

    @Test
    public void 연속된_값을_반환해서는_안된다() {
        NonConsecutiveFlagGenerator generator = new NonConsecutiveFlagGenerator() {
            @Override
            protected List<Boolean> createResult() {
                return List.of(true, true);
            }
        };

        assertThatIllegalStateException().isThrownBy(generator::create);
    }

    @Test
    public void 연속되지_않은_값을_반환한다() {
        List<Boolean> result = List.of(true, false);
        NonConsecutiveFlagGenerator generator = new NonConsecutiveFlagGenerator() {
            @Override
            protected List<Boolean> createResult() {
                return result;
            }
        };

        assertThat(generator.create()).isEqualTo(result);
    }
}
