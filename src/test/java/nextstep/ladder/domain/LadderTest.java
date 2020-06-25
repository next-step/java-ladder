package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    public void Ladder() {
        //given
        int height = 3;
        int countOfPerson = 5;

        //when
        Ladder ladder = new Ladder(height,countOfPerson);

        //then
        System.out.println(ladder);
        assertThat(ladder.getLadderHeight()).isEqualTo(height);
    }
}