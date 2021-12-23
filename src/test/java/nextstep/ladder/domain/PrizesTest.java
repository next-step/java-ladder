package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizesTest {
    @Test
    public void create() {
        final List<String> results = List.of("result1", "result2", "result3");
        assertThat(Prizes.fromString(results)).isEqualTo(Prizes.fromString(results));
    }

    @ParameterizedTest(name = "create failed : [{arguments}]")
    @NullAndEmptySource
    public void createFailed(List<String> results) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Prizes.fromString(results));
    }

    @Test
    public void mapByIndex() {
        final Prizes prizes = rs("r1", "r2", "r3");
        assertThat(prizes.mapByIndex(List.of(1, 0, 2))).isEqualTo(rs("r2", "r1", "r3"));
    }

    public static Prizes rs(String ... results) {
        return Prizes.fromString(Arrays.asList(results));
    }

    public static Prizes rs(List<String> results) {
        return Prizes.fromString(results);
    }
}
