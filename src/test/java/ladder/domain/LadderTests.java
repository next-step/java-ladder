package ladder.domain;

import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTests {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Ladder ladder = getLadder(true, false);

        assertThat(ladder).isEqualTo(
                Ladder.of(
                        Arrays.asList(
                                Line.of(
                                        Arrays.asList(
                                                Point.first(true), Point.first(true).next(false), Point.first(true).next(false).next(false)
                                        )))));
    }

    @DisplayName("왼쪽 이동 테스트")
    @Test
    void moveLeftTest() {
        Ladder ladder = getLadder(true, false);

        assertThat(ladder.movedPosition(1)).isEqualTo(0);
    }

    @DisplayName("오른쪽 이동 테스트")
    @Test
    void moveRightTest() {
        Ladder ladder = getLadder(false, true);

        assertThat(ladder.movedPosition(1)).isEqualTo(2);
    }

    @DisplayName("Ladder 의 높이, 폭 가져올 수 있는지 테스트")
    @Test
    void getLadderHeightWidthTest() {
        Ladder ladder = getParticipantLadder();

        ResultView.drawLadder(ladder);

        assertThat(ladder.getLadderHeight()).isEqualTo(5);
        assertThat(ladder.getLadderWidth()).isEqualTo(4);
    }

    private Ladder getLadder(boolean first, boolean second) {
        Line line = Line.of(Arrays.asList(Point.first(first), Point.first(first).next(second), Point.first(first).next(second).last()));
        return Ladder.of(Arrays.asList(line));
    }

    private Ladder getParticipantLadder() {
        List<String> participatePerson = new ArrayList<>(Arrays.asList("poi", "honux", "crong", "jk"));
        int ladderMaxLength = 5;
        int countOfPerson = participatePerson.size();

        NextStrategy nextStrategy = new RandomNextStrategy();
        return Ladder.of(ladderMaxLength, countOfPerson, nextStrategy);
    }

}
