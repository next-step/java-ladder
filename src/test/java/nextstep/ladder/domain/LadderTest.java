package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.IntFunction;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("UserInput과 사다리 생성 전략을 이용하여 Ladder 객체를 만들 수 있다.")
    void testLadderConstructor() {
        //given
        final String userNamesText = "1,2,3";
        final UserInput userInput = new UserInput(new UserNames(userNamesText), new LadderHeight(5));
        final IntFunction<Boolean> lineBuilderStrategy = idx -> new Random().nextBoolean();

        //when
        final Ladder ladder = new Ladder(userInput, lineBuilderStrategy);

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("toString을 사용하면, 사다리가 출력된다.")
    void testLadderToString() {
        //given
        final String userNamesText = "1,2,3,4";
        final UserInput userInput = new UserInput(new UserNames(userNamesText), new LadderHeight(5));
        final IntFunction<Boolean> lineBuilderStrategy = idx -> idx % 2 == 0;

        //when
        final Ladder ladder = new Ladder(userInput, lineBuilderStrategy);
        final String ladderString = ladder.toString();

        //then
        assertThat(ladderString)
                .isEqualTo(
                        "1     2     3     4    \n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n" +
                                "    |-----|     |-----|\n"
                );
    }
}
