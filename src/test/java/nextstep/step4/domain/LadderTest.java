package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("UserData와 Line List를 입력으로, Ladder 객체를 생성할 수 있다.")
    void testLadderConstructorWithUserDataAndLineList() {
        //given
        final UserData userData = new UserData(
                new UserInputTexts("pobi,honux,crong,jk"),
                new UserInputTexts("꽝,5000,꽝,3000")
        );
        final Line line = new Line(
                List.of(
                        Point.first(true).next(false),
                        Point.first(true).next(false)
                )
        );

        //when
        final Ladder ladder = new Ladder(userData, List.of(line));

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("UserData와 LadderHeight를 입력으로, Ladder 객체를 생성할 수 있다.")
    void testLadderConstructorWithUserDataAndLadderHeight() {
        //given
        final UserData userData = new UserData(
                new UserInputTexts("pobi,honux,crong,jk"),
                new UserInputTexts("꽝,5000,꽝,3000")
        );
        final LadderHeight ladderHeight = new LadderHeight(5);

        //when
        final Ladder ladder = new Ladder(userData, ladderHeight);

        //then
        assertThat(ladder).isNotNull();
    }
}
