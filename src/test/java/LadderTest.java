import domain.Ladder;
import domain.LadderLine;
import domain.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 사다리그리기() {
        int depth = 5;
        int countOfPerson = 4;
        Ladder ladder = Ladder.from(depth, countOfPerson);
        System.out.println(ladder.drawLadder());
    }

    @Test
    public void 사다리타기결과() {
        int depth = 3;
        int countOfPerson = 4;
        Ladder ladder = Ladder.from(depth, countOfPerson);
        System.out.println(ladder.drawLadder());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        IntStream.range(0, countOfPerson).forEach(i -> list.add(i));

        for (LadderLine ladderLine : ladder.getLadder()) {
            int position = 0;
            for (Point point : ladderLine.getPoints()) {
                if(!list2.isEmpty()) {
                    int num = 0;
                    if (point.lineDirection().isRight()) {
                        num = 1;
                    }
                    if (point.lineDirection().isLeft()) {
                        num = -1;
                    }
                    int res = list2.get(position + num);
                    list.set(position, res);
                }
                if(list2.isEmpty()) {
                    list.set(position, point.move());
                }
                position++;
            }
            list2 = new ArrayList<>(list);
        }
        System.out.println(list);
    }
}
