package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PersonResultTest {

    @Test
    void isExist() {
        PersonResult personResult = new PersonResult(new Person("hyeon"), new Result("3000"));

        assertAll(
                () -> assertThat(personResult.isExist("hyeon")).isTrue(),
                () -> assertThat(personResult.isExist("12334")).isFalse()
        );
    }

}
