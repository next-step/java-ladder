package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    void LadderResult_creation_test() {
        String names = "pobi,honux,crong,jk";
        LadderResult result = LadderResult.of();

        int expected = 1;

        Arrays.stream(names.split(","))
                .map(Name::of)
                .forEach(name -> result.addResult(name, expected));

        int actualSize = result.getAllNames().size();
        int expectedSize = names.split(",").length;
        assertThat(actualSize).isEqualTo(expectedSize);

        Arrays.stream(names.split(","))
                .map(Name::of)
                .forEach(name -> assertThat(result.findResultByName(name)).isEqualTo(expected));
    }
}