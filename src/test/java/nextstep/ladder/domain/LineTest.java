package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void 사다리_한_줄_생성테스트() {
        List<Boolean> lines = List.of(true, false, true, false);
        assertThat(new Lines(createFakeGenerator(lines)))
                .isEqualTo(new Lines(createFakeGenerator(lines)));
    }

    @Test
    public void 사다리는_연속_되면안된다() {
        assertThatIllegalStateException().isThrownBy(() -> new Lines(createFakeGenerator(List.of(true, true))));
    }

    private static NonConsecutiveFlagGeneratorFake createFakeGenerator(List<Boolean> lines) {
        return new NonConsecutiveFlagGeneratorFake(lines);
    }
}
