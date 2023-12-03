package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultTest {

    @Test
    void 입력_결과_저장() {
        Result result = new Result(Arrays.asList("꽝", "5000", "꽝", "3000"));
        List<String> results = result.getResults();

        assertThat(results.get(0)).isEqualTo("꽝");
    }

    @Test
    void 입력_결과_길이예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Result(Arrays.asList("100000")));
    }

    @Test
    void 입력_결과_갯수예외() {
        String[] personData = {"a", "b"};
        String[] resultData = {"1", "2", "3"};

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Result(resultData, personData));
    }

    @Test
    void 게임_결과_찾기() {
        PersonList personList = new PersonList(Arrays.asList(new Person("p1", 0), new Person("p2", 1)));
        Result result = new Result(Arrays.asList("꽝", "10000"));
        List<LineCondition> conditions = List.of(() -> true, () -> true);
        Game game = new Game(personList, conditions);
        game.playGame();

        List<String> findResult1 = result.findResult(game, "p1");
        List<String> findResult2 = result.findResult(game, "p2");
        List<String> findResult3 = result.findResult(game, "p3");
        List<String> findResultAll = result.findResult(game, "all");

        assertThat(findResult1.get(0)).isEqualTo("꽝");
        assertThat(findResult2.get(0)).isEqualTo("10000");
        assertThat(findResult3.get(0)).isEqualTo("일치하는 이름이 없습니다.");
        assertThat(findResultAll.get(0)).isEqualTo("p1 : 꽝");
        assertThat(findResultAll.get(1)).isEqualTo("p2 : 10000");
    }
}