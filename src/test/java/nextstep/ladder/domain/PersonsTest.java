package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonsTest {

    @Test
    void 문자열_입력_시_리스트_검증() {
        Persons persons = new Persons(new String[]{"pobi", "honux", "crong", "jk"});

        Persons target = new Persons(
                List.of(
                        new Person("pobi"),
                        new Person("honux"),
                        new Person("crong"),
                        new Person("jk")
                )
        );

        assertThat(persons).isEqualTo(target);

    }

    @Test
    void 문자열_입력_시_최대_길이() {

        Persons persons = new Persons(new String[]{"pobi", "honux", "crong", "jk"});
        int maxLength = persons.getMaxLength();

        assertThat(maxLength).isEqualTo(5);

    }
}
