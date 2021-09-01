package newladder;

import newladder.model.Direction;
import newladder.model.MyLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private static final int USER_COUNT = 3;

    private static final int LEFT_VALUE = -1;
    private static final int RIGHT_VALUE = 1;
    private static final int STOP_VALUE = 0;

    MyLine myLine;
    List<Direction> directionList = new ArrayList<>();
    @BeforeEach
    void setting() {
        Direction firstDirection = new Direction(false);
        directionList.add(firstDirection);
        Direction secondDirection = firstDirection.next(true);
        directionList.add(secondDirection);
        Direction lastDirection = secondDirection.last();
        directionList.add(lastDirection);
        myLine = new MyLine(directionList);
        directionList = myLine.directionInfo();
    }

    @Test
    void 라인_생성테스트() {
        assertThat(directionList.size()).isEqualTo(USER_COUNT);
    }

    @Test
    void 라인_첫번째방향_움직임_테스트() {
        Direction firstDirection = directionList.get(0);
        assertThat(firstDirection.move()).isEqualTo(STOP_VALUE);
    }

    @Test
    void 라인_두번째방향_움직임_테스트() {
        Direction secondDirection = directionList.get(1);
        assertThat(secondDirection.move()).isEqualTo(RIGHT_VALUE);
    }


    @Test
    void 라인_마지막방향_움직임_테스트() {
        Direction lastDirection = directionList.get(2);
        assertThat(lastDirection.move()).isEqualTo(LEFT_VALUE);
    }

}
