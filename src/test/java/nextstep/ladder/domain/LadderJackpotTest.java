package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LadderJackpotTest {
    @Test
    void create() {
        int[][] arr = new int[0][0];
        int[] arr2 = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2;
        }

        System.out.println(arr[0][2]);

        Arrays.stream(arr).forEach(ar -> {
            Arrays.stream(ar).forEach(System.out::print);
            System.out.println();
        });
    }

    @Test
    void create2() {
        Lines lines = Lines.of(5, new RandomCreationStrategy());
        Arrays.stream(lines.toArray()).forEach(System.out::println);
    }

    @Test
    void select() {
        Boolean[][] results = {
            {false, true, false, true},
            {false, false, true, false},
            {false, true, false, false},
            {false, false, true, false},
        };
        LadderJackpot ladderJackpot = LadderJackpot.of(results);

        Position position = ladderJackpot.select(LadderNames.of("a,b,c,d"), 1);
        String[] arr = ladderJackpot.jackpot("a,b,c,d");

        System.out.println(arr[position.toInt()]);
    }

}