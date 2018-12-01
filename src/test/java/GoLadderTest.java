import domain.Ladder;
import domain.Line;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GoLadderTest {
    @Test
    public void 어디로갈까로직테스트() {
        int depth = 5;
        int length = 4;

        ArrayList<Boolean> list1 = new ArrayList<>(Arrays.asList(true, false, true, false));
        ArrayList<Boolean> list2 = new ArrayList<>(Arrays.asList(false, true, false, false));
        ArrayList<Boolean> list3 = new ArrayList<>(Arrays.asList(true, false, false, false));
        ArrayList<Boolean> list4 = new ArrayList<>(Arrays.asList(false, true, false, false));
        ArrayList<Boolean> list5 = new ArrayList<>(Arrays.asList(true, false, true, false));

        ArrayList<ArrayList<Boolean>> check = new ArrayList<>();
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            arr.add(i);
        }
        for(int i = 0; i < depth; i++) {
            int dot = 0;
            for(int j : arr) {
                if(check.get(i).get(j)) {
                    arr.set(dot, arr.get(dot)+1);
                }
                if(j != 0) {
                    if (check.get(i).get(j - 1)) {
                        arr.set(dot, arr.get(dot)-1);
                    }
                }
                dot++;
            }
        }

        assertThat(arr).isEqualTo(Arrays.asList(0, 3, 2, 1));

        Ladder ladder = Ladder.from(depth, length);
        ArrayList<Integer> arr2 = ladder.followLadder();
        for(int i : arr2) {
            System.out.println(i);
        }
    }
}
