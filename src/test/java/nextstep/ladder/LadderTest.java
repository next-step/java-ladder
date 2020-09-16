package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("ladder 생성 테스트")
    public void createLadderTest(){
        int countOfUser = 5;
        int height = 5;

        Ladder ladder = Ladder.of(countOfUser, height);

        assertThat(ladder.getLines().size()).isEqualTo(countOfUser);
    }
}