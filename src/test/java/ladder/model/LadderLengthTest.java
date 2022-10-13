package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderLengthTest {

    @Test
    void shouldVaidateLadderLegnth(){
        assertThrows(IllegalArgumentException.class,()->new LadderLength(-1));
    }

    @Test
    void shouldIncreaseLength(){
        LadderLength length = new LadderLength(1);

        length.increase();

        assertThat(length).isEqualTo(new LadderLength(2));
    }

}
