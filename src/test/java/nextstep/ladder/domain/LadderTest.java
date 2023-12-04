package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @Test
    void 참가자명_excpetion() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Ladder(List.of("abcdescd", "b", "c", "d", "e"), 5, () -> true));
    }

    @Test
    void lines_생성() {
        Ladder ladder = new Ladder(List.of("a", "b", "c", "d", "e"), 5, () -> true);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}