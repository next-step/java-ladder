package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 생성() {
        Ladder ladder = Ladder.create(5, 4);
        assertThat(ladder).isNotNull();
        assertThat(ladder.size()).isEqualTo(5);
    }

    @Test
    public void 끝점() {
        Ladder ladder = Ladder.create(5, 4);
        System.out.println(ladder);
        System.out.println(ladder.endpoint(2));
    }
}