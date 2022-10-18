package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PeopleTest {
    @Test
    @DisplayName("이름에 중복된 값이 들어오면 IllegalArgumentException")
    void when_duplicate() {
        //given
        String[] names = "name, name, abc".split(",");
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People(names));
    }

    @Test
    @DisplayName("이릅에 중복된 값이 잆으면 정상")
    void when_not_duplicate() {
        //given
        String[] names = "name, kkk, abc".split(",");
        //then
        assertThatNoException()
                .isThrownBy(() -> new People(names));
    }

}