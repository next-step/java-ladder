package ladder.domain.data;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void add() {
        Ladder ladder = new Ladder();
        ladder.add(new Line("|-| |"));
        assertThat(ladder.lines()).hasSize(1);
    }

    @Test
    void 개인_결과_계산() {
        Ladder ladder = ladder();
        Person a = new Person("a", 0);
        Person b = new Person("b", 1);
        Person c = new Person("c", 2);
        assertThat(ladder.run(a)).isEqualTo(new Result(a, new Goal("3000")));
        assertThat(ladder.run(b)).isEqualTo(new Result(b, new Goal("꽝")));
        assertThat(ladder.run(c)).isEqualTo(new Result(c, new Goal("5000")));
    }


    @Test
    void 전체_결과_계산() {
        //new Persons
        //Ladder ladder = ladder();
        //assertThat(ladder.runAll())
    }

    private static Ladder ladder() {
        return new Ladder(
            List.of(
                new Line("|-| |"),
                new Line("| |-|")
            ),
            new Goals(List.of("꽝", "5000", "3000"))
        );
    }
}
