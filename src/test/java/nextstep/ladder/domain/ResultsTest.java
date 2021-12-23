package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {
    @Test
    public void create() {
        final List<String> results = List.of("result1", "result2", "result3");
        assertThat(Results.fromString(results)).isEqualTo(Results.fromString(results));
    }

    @ParameterizedTest(name = "create failed : [{arguments}]")
    @NullAndEmptySource
    public void createFailed(List<String> results) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Results.fromString(results))
                .withMessageContaining("cannot be null or empty");
    }

    @Test
    public void mapByIndex() {
        final Results results = rs("r1", "r2", "r3");
        assertThat(results.mapByIndex(List.of(1, 0, 2))).isEqualTo(rs("r2", "r1", "r3"));
    }

    public static Results rs(String ... results) {
        return Results.fromString(Arrays.asList(results));
    }

    public static Results rs(List<String> results) {
        return Results.fromString(results);
    }
}
