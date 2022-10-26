package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPlayerTest {
    @Test
    @DisplayName("한명 결과 찾기")
    void test1() {
        // given
        Persons persons = new Persons("a", "b", "c", "d");
        Results results = new Results("1", "2", "3", "4");
        int ladderHeight = 1;
        int countOfPerson = 4;
        Ladder ladder = new Ladder(ladderHeight, countOfPerson, () -> false);
        LadderPlayer ladderPlayer = new LadderPlayer(persons, results, ladder);
        // when
        Result result1 = ladderPlayer.getResultOf(new Person("a"));
        Result result2 = ladderPlayer.getResultOf(new Person("b"));
        Result result3 = ladderPlayer.getResultOf(new Person("c"));
        Result result4 = ladderPlayer.getResultOf(new Person("d"));
        // then
        assertThat(result1).isEqualTo(new Result("1"));
        assertThat(result2).isEqualTo(new Result("2"));
        assertThat(result3).isEqualTo(new Result("3"));
        assertThat(result4).isEqualTo(new Result("4"));
    }

    @Test
    @DisplayName("전체 결과 찾기")
    void test() {
        // given
        Persons persons = new Persons("a", "b", "c", "d");
        Results results = new Results("1", "2", "3", "4");
        int ladderHeight = 1;
        int countOfPerson = 4;
        Ladder ladder = new Ladder(ladderHeight, countOfPerson, () -> false);
        LadderPlayer ladderPlayer = new LadderPlayer(persons, results, ladder);
        // when
        Map<Person, Result> resultOfAll = ladderPlayer.getResultOfAll();
        // then
        assertThat(resultOfAll).containsEntry(new Person("a"), new Result("1"))
                .containsEntry(new Person("b"), new Result("2"))
                .containsEntry(new Person("c"), new Result("3"))
                .containsEntry(new Person("d"), new Result("4"));
    }
}
