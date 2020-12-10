package domain;

import ladder.domain.LadderMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderMoveTest {
    private static List<Integer> positionTestDataList = new ArrayList<>();
    private static List<Boolean> directionTestDataList = new ArrayList<>();

    static {
        addTestPosition();
        addTestDirectionList();
    }

    @Test
    @DisplayName("사다리 한줄내려왔을 때 나온결과가 맞는지")
    void checkLadderMove() {
        LadderMove ladderMove = new LadderMove(positionTestDataList, directionTestDataList);
        assertThat(ladderMove.getPositionList()).isEqualTo(successList());
    }

    public List<Integer> successList(){
        List<Integer> returnList = new ArrayList<>();
        returnList.add(0);
        returnList.add(2);
        returnList.add(1);
        returnList.add(4);
        returnList.add(3);

        return returnList;
    }

    static void addTestPosition() {
        for (int i = 0; i < 5; i++) {
            positionTestDataList.add(i);
        }
    }

    static void addTestDirectionList() {
        directionTestDataList.add(false);
        directionTestDataList.add(true);
        directionTestDataList.add(false);
        directionTestDataList.add(true);
    }
}
