package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    @DisplayName("index를 기준으로 이름을을 알 수 있다")
    void name() {
        Names names = new Names(List.of(
                new Name("pobi"),
                new Name("honux")));

        Name actual = names.name(0);
        Name expected = new Name("pobi");

        assertThat(actual).isEqualTo(expected);
    }
}
