package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("UserInput과 사다리 생성 전략을 이용하여 Ladder 객체를 만들 수 있다.")
    void testLadderConstructor() {
        //given
        final UserNames userNames = new UserNames("1,2,3");
        final UserResults userResults = new UserResults("꽝,1000,5000", userNames.size());
        final UserInput userInput = new UserInput(new UserData(userNames, userResults), new LadderHeight(5));
        final BooleanSupplier lineBuilderStrategy = () -> new Random().nextBoolean();

        //when
        final Ladder ladder = new Ladder(userInput, lineBuilderStrategy);

        //then
        assertThat(ladder).isNotNull();
    }
}
