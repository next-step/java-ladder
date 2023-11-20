package nextstep.ladder.domain;

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
        final UserResults userResults = new UserResults("꽝,1000,5000", userNames.size());

        //when
        UserInput userInput = new UserInput(new UserData(userNames, userResults), ladderHeight);

        //then
        assertThat(userInput.userNames()).isEqualTo(userNames);
        assertThat(userInput.ladderHeight()).isEqualTo(ladderHeight);
    }
}
