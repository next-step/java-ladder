package ladder.domain.ladder;

import ladder.strategy.LineStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LadderRowTest {

    private LineStrategy pointTrue;
    private LineStrategy pointFalse;

    private LadderRow randomLadderRow;
    private int countOfPlayer;

    private LadderRow fixedLadderRow;

    @BeforeEach
    void setUp() {
        pointTrue = () -> true;
        pointFalse = () -> false;

        countOfPlayer = 4;
        randomLadderRow = new LadderRow(countOfPlayer);

        /**
         * 참가자 4명(point 4개), 너비가 3인 사다리.
         *
         * A  B   C  D ==> 참가자
         * ㅣ-ㅣ   ㅣ- ㅣ ==> 사다리
         */
        List<Point> pointList = new ArrayList<>();
        pointList.add(Point.first(pointTrue));
        pointList.add(Point.first(pointTrue).next(pointFalse));
        pointList.add(Point.first(pointTrue).next(pointFalse).next(pointTrue));
        pointList.add(Point.first(pointTrue).next(pointFalse).next(pointTrue).last());
        fixedLadderRow = new LadderRow(pointList);
    }

    @Test
    @DisplayName("라인의 제일 첫번째 Point의 left는 항상 false이다.")
    void leftOfFirst_IsFalse_True() {
        Assertions.assertThat(randomLadderRow.getLines().get(0)
                .left()).isEqualTo(false);
    }

    @Test
    @DisplayName("라인의 제일 첫번째 Point의 left는 항상 false이다.")
    void rightOfLast_IsFalse_True() {
        Assertions.assertThat(randomLadderRow.getLines().get(countOfPlayer - 1)
                .right()).isEqualTo(false);
    }

    @Test
    @DisplayName("라인의 제일 첫번째 Point의 left는 false이다.")
    void create_Width_Line() {
        LadderRow ladderRow = new LadderRow(countOfPlayer);
        Assertions.assertThat(ladderRow.size()).isEqualTo(countOfPlayer);
    }

    /**
     * A  B   C  D ==> 참가자
     * ㅣ-ㅣ   ㅣ- ㅣ ==> 사다리
     */
    @Test
    @DisplayName("지정된 곳에서 이동을 했을 시 도착지점을 결정한다.")
    void move_StartFromPosition_ArriveExactly() {
        Assertions.assertThat(fixedLadderRow.move(0)).isEqualTo(1);
        Assertions.assertThat(fixedLadderRow.move(1)).isEqualTo(0);
        Assertions.assertThat(fixedLadderRow.move(2)).isEqualTo(3);
        Assertions.assertThat(fixedLadderRow.move(3)).isEqualTo(2);
    }
}
