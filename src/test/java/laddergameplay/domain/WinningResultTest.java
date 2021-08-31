package laddergameplay.domain;

import laddergameplay.domain.data.Person;
import laddergameplay.domain.data.Result;
import laddergameplay.domain.datas.People;
import laddergameplay.domain.datas.Results;
import laddergameplay.domain.ladder.Ladder;
import laddergameplay.exception.CustomException;
import laddergameplay.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class WinningResultTest {

    @Test
    @DisplayName("winningResult 반환 사다리 true 1칸")
    void makeWinningResult_true_one_line() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,5000".split(",")), people);
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        });

        // when
        WinningResult winningResult = new WinningResult(ladder, people, results);

        // then
        assertThat(winningResult.findBy(new Person("hwan"))).isEqualTo(new Result("lose"));
        assertThat(winningResult.findBy(new Person("kook"))).isEqualTo(new Result("3000"));
        assertThat(winningResult.findBy(new Person("hyun"))).isEqualTo(new Result("5000"));
        assertThat(winningResult.findBy(new Person("bo"))).isEqualTo(new Result("2000"));
    }

    @Test
    @DisplayName("winningResult 반환 사다리 false 1칸")
    void makeWinningResult_false_one_line() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,5000".split(",")), people);
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, () -> false);

        // when
        WinningResult winningResult = new WinningResult(ladder, people, results);

        // then
        assertThat(winningResult.findBy(new Person("hwan"))).isEqualTo(new Result("3000"));
        assertThat(winningResult.findBy(new Person("kook"))).isEqualTo(new Result("lose"));
        assertThat(winningResult.findBy(new Person("hyun"))).isEqualTo(new Result("2000"));
        assertThat(winningResult.findBy(new Person("bo"))).isEqualTo(new Result("5000"));
    }

    @Test
    @DisplayName("특정 Person 의 Result 조회")
    void findBy() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,5000".split(",")), people);
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, () -> false);
        WinningResult winningResult = new WinningResult(ladder, people, results);

        // when
        Person person = new Person("hwan");
        Result result = new Result("3000");
        Result findedResult = winningResult.findBy(person);

        //then
        assertThat(findedResult).isEqualTo(result);
    }

    @Test
    @DisplayName("특정 Person 의 Result 조회 : 실패")
    void findBy_fail() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,5000".split(",")), people);
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        });

        WinningResult winningResult = new WinningResult(ladder, people, results);

        // when
        Person person3 = new Person("check");


        //then
        assertThatThrownBy(() -> winningResult.findBy(person3))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(WinningResult.NOT_EXIST_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("전체 Result 조회")
    void findAll() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));
        Results results = new Results(Arrays.asList("3000,lose,2000,5000".split(",")), people);
        Ladder ladder = new Ladder(people.subtractNumberFromSize(1), 1, new RandomLineStrategy(){
            @Override
            protected boolean currentPoint() {
                return true;
            }
        });
        WinningResult winningResult = new WinningResult(ladder, people, results);

        // when
        Map<Person, Result> findAllWinningResult = winningResult.findAll();
        Person person1 = new Person("hwan");
        Person person3 = new Person("check");

        //then
        assertThat(findAllWinningResult.containsKey(person1)).isTrue();
        assertThat(findAllWinningResult.containsKey(person3)).isFalse();
    }
}
