package nextstep.step4.responsibility.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("UserData와 LadderHeight를 입력으로, Ladder 객체를 생성할 수 있다.")
    void testLadderConstructorWithUserDataAndLadderHeight() {
        //given
        final UserData userData = new UserData(
                new UserNames("pobi,honux,crong,jk"),
                new UserResults("꽝,5000,꽝,3000")
        );
        final int ladderHeight = 5;

        //when
        final Ladder ladder = new Ladder(userData, ladderHeight);

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("UserData와 IndexHorizontalMover 2차원 배열을 입력으로, Ladder 객체를 생성할 수 있다.")
    void testLadderConstructorWithUserDataAndIndexHorizontalMovers() {
        //given
        final UserData userData = new UserData(
                new UserNames("pobi,honux,crong,jk"),
                new UserResults("꽝,5000,꽝,3000")
        );
        final List<Row> rows = buildRows();

        //when
        final Ladder ladder = new Ladder(userData, rows);

        //then
        assertThat(ladder).isNotNull();
    }

    @RepeatedTest(10)
    @DisplayName("run 메서드를 실행하면, 게임 실행결과가 생성된다.")
    void testRun() {
        //given
        final UserData userData = new UserData(
                new UserNames("pobi,honux,crong,jk"),
                new UserResults("꽝,5000,꽝,3000")
        );

        final Ladder ladder = new Ladder(userData, 5);

        //when
        final GameResultProvider ladderResult = ladder.run();

        //then
        assertThat(ladderResult).isNotNull();
    }

    @Test
    @DisplayName("run 메서드를 실행하면, 정상적으로 사다리를 타고 내려가서 결과를 구한다.")
    void testRunWithRightResult() {
        //given
        final UserData userData = new UserData(
                new UserNames("pobi,honux,crong,jk"),
                new UserResults("꽝,5000,꽝,3000")
        );

        final List<Row> movers = buildRows();

        final Ladder ladder = new Ladder(userData, movers);

        //when
        final GameResultProvider ladderResult = ladder.run();
        final Map<String, String> result = ladderResult.getAllResult();

        //then
        assertThat(result).isEqualTo(
                Map.of(
                        "pobi", "5000",
                        "honux", "꽝",
                        "crong", "3000",
                        "jk", "꽝")
        );
    }

    private List<Row> buildRows() {
        final List<Row> movers = new ArrayList<>();

        for (int row = 0; row < 5; row++) {
            final List<IndexHorizontalMover> tempMover = List.of(Mover.RIGHT, Mover.LEFT, Mover.RIGHT, Mover.LEFT);
            movers.add(new Row(tempMover));
        }

        return movers;
    }
}
