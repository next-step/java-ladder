package newladder;


import newladder.model.Direction;
import newladder.model.MyLadder;
import newladder.model.MyLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    MyLadder myLadder;
    List<MyLine> myLineList = new ArrayList<>();

    @BeforeEach
    void before() {
        List<Direction> directionList = new ArrayList<>();
        Direction firstDirection = new Direction(false);
        directionList.add(firstDirection);
        Direction secondDirection = firstDirection.next(true);
        directionList.add(secondDirection);
        Direction lastDirection = secondDirection.last();
        directionList.add(lastDirection);
        MyLine myLine = new MyLine(directionList);
        myLineList.add(myLine);
        myLadder = new MyLadder(myLineList);
    }


    @Test
    void 첫번째_사다리_내려가기() {
        assertThat(myLadder.downLadder(0)).isEqualTo(0);
    }

    @Test
    void 두번째_사다리_내려가기() {
        assertThat(myLadder.downLadder(1)).isEqualTo(2);
    }

    @Test
    void 마지막째_사다리_내려가기() {
        assertThat(myLadder.downLadder(2)).isEqualTo(1);
    }
}
