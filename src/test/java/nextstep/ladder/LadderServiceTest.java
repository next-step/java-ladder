package nextstep.ladder;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderServiceTest {
    @Test
    void splitNameTest() {
        String inputNames = "pobi,honux,crong,jk";

        List<String> expected = List.of(inputNames.split(","));

        Assertions.assertThat(LadderService.splitNames(inputNames))
                .containsExactly(expected.toArray(new String[0]));

    }
}
