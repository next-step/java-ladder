package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {


    @DisplayName("결과를 보고 싶은 사람을 볼 수 있다.")
    @Test
    void person() {
        // given

        Persons persons = PersonsFactory.personsFixture();

        Line line = Line.of(Arrays.asList(true, false));

        Ladder ladder = Ladder.of(line, persons);

        List<String> results = new ArrayList<>();
        results.add("꽝");
        results.add("5000");
        results.add("2000");

        // when
        LadderResult ladderResult = LadderResult.of(ladder, results);

        // then
        assertThat(ladderResult.person("Pobi1")).isEqualTo("5000");
        assertThat(ladderResult.person("Pobi2")).isEqualTo("꽝");
        assertThat(ladderResult.person("Pobi3")).isEqualTo("2000");
    }
}

