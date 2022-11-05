package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPlayerTest {
    @Test
    void test1() {
        // given
        Persons persons = new Persons(List.of("a", "b", "c", "d"));
        Results results = new Results(List.of("1", "2", "3", "4"));
        int ladderHeight = 1;
        int countOfPerson = 4;
        Ladder ladder = new Ladder(ladderHeight, countOfPerson);
        LadderPlayer ladderPlayer = new LadderPlayer(persons, results);
        // when
        Map<Person, Result> result1 = ladderPlayer.getResultOf("a", ladder);
        Map<Person, Result> result2 = ladderPlayer.getResultOf("b", ladder);
        Map<Person, Result> result3 = ladderPlayer.getResultOf("c", ladder);
        Map<Person, Result> result4 = ladderPlayer.getResultOf("d", ladder);
        // then
        System.out.println("result1 = " + result1.get(new Person("a")).getResult());
        System.out.println("result2 = " + result2.get(new Person("b")).getResult());
        System.out.println("result3 = " + result3.get(new Person("c")).getResult());
        System.out.println("result4 = " + result4.get(new Person("d")).getResult());
    }

    @Test
    @DisplayName("전체 결과 찾기")
    void test() {
        // given
        Persons persons = new Persons(List.of("a", "b", "c", "d"));
        Results results = new Results(List.of("1", "2", "3", "4"));
        int ladderHeight = 1;
        int countOfPerson = 4;
        Ladder ladder = new Ladder(ladderHeight, countOfPerson);
        LadderPlayer ladderPlayer = new LadderPlayer(persons, results);
        // when
        Map<Person, Result> resultOfAll = ladderPlayer.getResultOf("all", ladder);
        // then
        System.out.println("result1 = " + resultOfAll.get(new Person("a")).getResult());
        System.out.println("result2 = " + resultOfAll.get(new Person("b")).getResult());
        System.out.println("result3 = " + resultOfAll.get(new Person("c")).getResult());
        System.out.println("result4 = " + resultOfAll.get(new Person("d")).getResult());
    }
}
