package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;
import nextstep.ladder.generator.LadderWidthSize;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;
import org.junit.jupiter.api.Test;

public class NonConsecutiveFlagGeneratorTest {

    @Test
    public void 연속된_값을_반환해서는_안된다() {
        List<Boolean> result = List.of(true, true);
        NonConsecutiveFlagGenerator generator = createFakeGenerator(result);

        assertThatIllegalStateException().isThrownBy(() -> generator.create(new LadderWidthSize(2)));
    }

    @Test
    public void 연속되지_않은_값을_반환한다() {
        List<Boolean> result = List.of(true, false);
        NonConsecutiveFlagGenerator generator = createFakeGenerator(result);

        assertThat(generator.create(new LadderWidthSize(2))).isEqualTo(result);
    }

    private static NonConsecutiveFlagGeneratorFake createFakeGenerator(List<Boolean> result) {
        return new NonConsecutiveFlagGeneratorFake(result);
    }
}
