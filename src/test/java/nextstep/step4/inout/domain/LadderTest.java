package nextstep.step4.inout.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.step4.inout.common.Common.buildTrueFalseTrueLine;
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

    @Test
    @DisplayName("run 메서드를 실행하면, 게임 실행결과가 생성된다.")
    void testRun() {
        //given
        final UserData userData = new UserData(
                new UserInputTexts("pobi,honux,crong,jk"),
                new UserInputTexts("꽝,5000,꽝,3000")
        );
        final List<Line> lines = List.of(
                new Line(buildTrueFalseTrueLine()),
                new Line(buildTrueFalseTrueLine()),
                new Line(buildTrueFalseTrueLine())
        );

        final Ladder ladder = new Ladder(userData, lines);

        //when
        final LadderResult ladderResult = ladder.run();
        final String result = ladderResult.get("all");

        //then
        assertThat(result).isEqualTo(
                "pobi : 5000\n" +
                        "honux : 꽝\n" +
                        "crong : 3000\n" +
                        "jk : 꽝"
        );
    }
}
