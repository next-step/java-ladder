package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonsTest {
    @Test
    @DisplayName("한명 결과 검색")
    void test1() {
        // given
        Person pobi = new Person("pobi");
        Person honux = new Person("honux");
        Persons persons = new Persons(List.of("pobi", "honux"));
        Ladder ladder = new Ladder(1, 2, () -> false);
        // when
        int result0 = persons.findResultOf(pobi, ladder);
        int result1 = persons.findResultOf(honux, ladder);
        // then
        assertThat(result0).isEqualTo(0);
        assertThat(result1).isEqualTo(1);
    }

    @Test
    @DisplayName("전체 결과 검색")
    void test2() {
        // given
        Person pobi = new Person("pobi");
        Person honux = new Person("honux");
        Persons persons = new Persons(List.of("pobi", "honux"));
        Ladder ladder = new Ladder(1, 2, () -> false);
        // when
        Map<Person, Integer> indexs = persons.findAllFinalIndex(ladder);
        // then
        assertThat(indexs.get(pobi)).isEqualTo(0);
        assertThat(indexs.get(honux)).isEqualTo(1);
    }
}
