package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {

    @Test
    void create_이름_5글자_이상_불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Person("kimjooho"));
    }
}