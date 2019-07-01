package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class PersonTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "박원영",
            "박소현",
            "pobi",
            "honux",
            "crong",
            "jk"
    })
    void name(String name) {
        Person person = new Person(name);

        assertThat(person.getName()).isEqualTo(name);
    }

    @Test
    void 이름이_같으면_같은_사람이다() {
        final String name = "박원영";
        Person person1 = new Person(name);
        Person person2 = new Person(name);

        assertThat(person1).isEqualTo(person2);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void 공백_또는_null_이름을_가질수없다(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Person(name));
    }

    @Test
    void 이름은_다섯글자_이상불가() {
        final String name = "다섯글자넘다";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Person(name));
    }
}
