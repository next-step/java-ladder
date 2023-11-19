package nextstep.ladder.domain;

import nextstep.ladder.input.LadderHeight;
import nextstep.ladder.input.UserNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    @Test
    @DisplayName("UserNames와 LadderHeight을 입력으로 UserInput을 만들면, UserInput은 UserNames와 LadderHeight을 가지고 있다")
    void testUserInputConstructor() {
        //given
        final UserNames userNames = new UserNames("A,B,C");
        final LadderHeight ladderHeight = new LadderHeight(5);

        //when
        UserInput userInput = new UserInput(userNames, ladderHeight);

        //then
        assertThat(userInput.userNames()).isEqualTo(userNames);
        assertThat(userInput.ladderHeight()).isEqualTo(ladderHeight);
    }
}
