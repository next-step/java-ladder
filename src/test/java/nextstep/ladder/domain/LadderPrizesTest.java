package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

import nextstep.ladder.engine.Prizes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderPrizesTest {
    @Test
    public void create() {
        final List<String> results = List.of("result1", "result2", "result3");
        assertThat(LadderPrizes.fromString(results)).isEqualTo(LadderPrizes.fromString(results));
    }

    @ParameterizedTest(name = "create failed : [{arguments}]")
    @NullAndEmptySource
    public void createFailed(List<String> results) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPrizes.fromString(results));
    }

    @Test
    public void mapByIndex() {
        final LadderPrizes ladderPrizes = LadderPrizes.fromString(List.of("r1", "r2", "r3"));
        assertThat(ladderPrizes.mapByIndex(List.of(1, 0, 2))).isEqualTo(pzs("r2", "r1", "r3"));
    }

    public static Prizes pzs(String ... results) {
        return LadderPrizes.fromString(Arrays.asList(results));
    }

    public static Prizes pzs(List<String> results) {
        return LadderPrizes.fromString(results);
    }
}
