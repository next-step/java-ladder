package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipatePeopleTests {
    @DisplayName("생성 테스트")
    @Test
    void create(){
        List<String> participatePersonList = new ArrayList<>(Arrays.asList("pobi","honux","crong","jk"));
        ParticipatePeople participatePeople = ParticipatePeople.of(participatePersonList);

        assertThat(participatePeople).isEqualTo(ParticipatePeople.of(Arrays.asList("pobi","honux","crong","jk")));
    }
}
