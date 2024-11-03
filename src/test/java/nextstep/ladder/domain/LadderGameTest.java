package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @DisplayName("Persons와 Results 사이즈 같지 않으면 예외")
    @Test
    void size_exception() {
        Persons persons = new Persons(new String[]{
                "a", "b", "c"
        });
        Results results = new Results(new String[]{
                "꽝", "1000"
        });

        assertThatThrownBy(
                () -> LadderGame.start(persons, results, 5)
        );
    }
}
