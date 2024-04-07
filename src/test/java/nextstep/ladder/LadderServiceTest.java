package nextstep.ladder;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderServiceTest {
    private String inputNames = "pobi,honux,crong,jk";


    @Test
    void splitNameTest() {
        List<String> expected = List.of(inputNames.split(","));

        Assertions.assertThat(LadderService.splitNames(inputNames))
                .containsExactly(expected.toArray(new String[0]));
    }

    @Test
    void countNamesTest() {
        List<String> nameList = List.of(inputNames.split(","));

        int expected = nameList.size();

        Assertions.assertThat(LadderService.countUsers(nameList))
                .isEqualTo(expected);
    }
}
