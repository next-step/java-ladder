package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    void 성공테스트() {
        Person person = new Person(new String[]{"num1","num2"});

        assertThat(person).isEqualTo(new Person(new String[]{"num1", "num2"}));
    }

    @Test
    void 중복오류_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Person(new String[]{"num1", "num1"})
        );
    }

    @Test
    void 이름_길이_5자초과_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Person(new String[]{"123456"})
        );
    }
}
