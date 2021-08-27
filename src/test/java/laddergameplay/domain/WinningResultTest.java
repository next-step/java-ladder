package laddergameplay.domain;

import laddergameplay.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class WinningResultTest {

    @Test
    @DisplayName("특정 Person 의 Result 조회")
    void findBy() {
        // given
        Map<Person, Result> winningResultMap = new LinkedHashMap<>();

        Person person1 = new Person("hwan");
        Person person2 = new Person("kook");

        Result result1 = new Result("3000");
        Result result2 = new Result("lose");

        winningResultMap.put(person1, result1);
        winningResultMap.put(person2, result2);

        WinningResult winningResult = new WinningResult(winningResultMap);

        // when
        Result findedResult = winningResult.findBy(person1);

        //then
        assertThat(findedResult).isEqualTo(result1);
    }

    @Test
    @DisplayName("특정 Person 의 Result 조회 : 실패")
    void findBy_fail() {
        // given
        Map<Person, Result> winningResultMap = new LinkedHashMap<>();

        Person person1 = new Person("hwan");
        Person person2 = new Person("kook");

        Result result1 = new Result("3000");
        Result result2 = new Result("lose");

        winningResultMap.put(person1, result1);
        winningResultMap.put(person2, result2);

        WinningResult winningResult = new WinningResult(winningResultMap);

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
        Map<Person, Result> winningResultMap = new LinkedHashMap<>();

        Person person1 = new Person("hwan");
        Person person2 = new Person("kook");

        Result result1 = new Result("3000");
        Result result2 = new Result("lose");

        winningResultMap.put(person1, result1);
        winningResultMap.put(person2, result2);

        WinningResult winningResult = new WinningResult(winningResultMap);

        // when
        Map<Person, Result> findAllWinningResult = winningResult.findAll();
        Person person3 = new Person("check");

        //then
        assertThat(findAllWinningResult.containsKey(person1)).isTrue();
        assertThat(findAllWinningResult.containsKey(person3)).isFalse();
    }
}
