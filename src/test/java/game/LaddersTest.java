package game;

import game.domain.ladder.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LaddersTest {
    private List<String> people;
    private List<String> results;

    @BeforeEach
    public void 사다리_가로줄_생성() {
        people = List.of("test1", "test2", "test3", "test4");
        results = List.of("당첨", "꽝", "꽝", "꽝");
    }

    @Test
    @Order(1)
    public void 사다리타기_결과확인_all() {
        List<LadderResult> expect =
                List.of(new LadderResult("test1", "당첨"), new LadderResult("test2", "꽝"),
                        new LadderResult("test3", "꽝"), new LadderResult("test4", "꽝"));
        Ladders ladders = new Ladders(List.of(new Line(List.of(new Point(0, Direction.right(false)), new Point(1, Direction.next(false, false)),
                new Point(2, Direction.next(false, false)), new Point(3, Direction.next(false, false))))));

        assertAll(
                () -> assertThat(ladders.findAllLadderResults(people, results).get(0).person()).isEqualTo(expect.get(0).person()),
                () -> assertThat(ladders.findAllLadderResults(people, results).get(0).result()).isEqualTo(expect.get(0).result()),
                () -> assertThat(ladders.findAllLadderResults(people, results).get(1).person()).isEqualTo(expect.get(1).person()),
                () -> assertThat(ladders.findAllLadderResults(people, results).get(1).result()).isEqualTo(expect.get(1).result()),
                () -> assertThat(ladders.findAllLadderResults(people, results).get(2).person()).isEqualTo(expect.get(2).person()),
                () -> assertThat(ladders.findAllLadderResults(people, results).get(2).result()).isEqualTo(expect.get(2).result()),
                () -> assertThat(ladders.findAllLadderResults(people, results).get(3).person()).isEqualTo(expect.get(3).person()),
                () -> assertThat(ladders.findAllLadderResults(people, results).get(3).result()).isEqualTo(expect.get(3).result())
        );
    }

    @Test
    @Order(2)
    public void 사다리타기_결과확인_1명() {
        LadderResult expect = new LadderResult("test1", "당첨");
        Ladders ladders = new Ladders(List.of(new Line(List.of(new Point(0, Direction.right(false)), new Point(1, Direction.next(false, false)),
                new Point(2, Direction.next(false, false)), new Point(3, Direction.next(false, false))))));

        assertAll(
                () -> assertThat(ladders.findOneLadderResult("test1", 0, results).person()).isEqualTo(expect.person()),
                () -> assertThat(ladders.findOneLadderResult("test1", 0, results).result()).isEqualTo(expect.result())
        );
    }
}
