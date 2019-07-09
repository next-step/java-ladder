package nextstep.step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameResultsTest {

    @Test
    @DisplayName("GameResults 생성")
    void create() {
        GameResults results = GameResults.create(List.of("1000","꽝","꽝","2000"));
        assertAll(
            () -> assertThat(results.findByPosition(0)).isEqualTo(new Result(0, "1000")),
            () -> assertThat(results.findByPosition(0).equalsPosition(0)).isTrue()
        );
    }
}
