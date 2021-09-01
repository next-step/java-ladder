package nextstep.ladder;

import nextstep.ladder.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderGameTest {
    @DisplayName("사람들 생성 테스트")
    @ParameterizedTest
    @CsvSource({"'crong, ap, cdd', 3", "'test', 1", "'a, b, c, d, ew, e', 6"})
    public void makePeopleTest(String input, int expected) {
        //when
        List<Person> people = LadderGame.makePeople(input);

        //then
        assertThat(people.size()).isEqualTo(expected);
    }

    @DisplayName("잘못 된 입력값을 받았을 때  사람들 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "", "abcdef", "abc, abce, abcdef", "abc, , ad"})
    public void wrongInputMakePeopleTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGame.makePeople(input));
    }

    @DisplayName("잘못된 입력값에 의한 사다리 테스트")
    @ParameterizedTest
    @CsvSource({"-5,3", "3,-2", "0,2", "3,0", "0,0"})
    public void wrongInputMakeLadderTest(int numberOfPeople, int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGame.makeLines(numberOfPeople, height));
    }


    @Test
    public void test() {
        Map<Foo, Integer> map = new HashMap<>();

        Foo b = new Foo("b");
        map.put(new Foo("a"), 1);
        map.put(b, 2);
        System.out.println(map.size());  // (1)
        map.put(new Foo("b"), 3);
        System.out.println(map.size());  //(2)

        b.setTest("c");
        Foo c = new Foo("c");
        System.out.println(map.get(c));  //(3)
    }

    class Foo {
        String test;

        public Foo(String test) {
            this.test = test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Foo test1 = (Foo) o;
            return Objects.equals(test, test1.test);
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "test='" + test + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(test);
        }
    }
}
