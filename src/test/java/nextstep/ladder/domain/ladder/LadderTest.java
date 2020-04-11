package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    void of() {
        Ladder ladder = Ladder.of(4, 5);
        System.out.println(ladder);
    }

    @Test
    void ofException() {
        assertThatThrownBy(() -> Ladder.of(1, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getResultNumber() {
        Ladder ladder = Ladder.of(4, 5);

        System.out.println("ladder result : " + ladder.getResultNumber(0));
    }

    @Test
    void sizeOfPerson() {
        Ladder ladder = Ladder.of(4, 5);

        assertThat(ladder.sizeOfPerson())
                .isEqualTo(4);
    }

}