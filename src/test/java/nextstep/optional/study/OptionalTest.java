package nextstep.optional.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    void createOptionalTest() {
        Optional<String> empty = Optional.empty();
        assertThat(empty).isEmpty();
        assertThat(empty.isPresent()).isFalse();
    }

    @Test
    void createOptionalTest2() {
        String name = null;
        //Optional<String> isNull = Optional.of(name);
        Optional<String> isNullable = Optional.ofNullable(name);
    }

    @Test
    void isPresentTest() {
        Optional<String> optional = Optional.of("Present");
        assertThat(optional.isPresent()).isTrue();

        optional = Optional.ofNullable(null);
        assertThat(optional.isPresent()).isFalse();
    }

    @DisplayName("java11 부터는 isEmpty() 사용 가능")
    @Test
    void isEmptyTest() {
        Optional<String> opt = Optional.of(null);
//        assertThat(opt.isEmpty()).isTrue();
    }

    @Test
    void ifPresentTest() {
        Optional<String> opt = Optional.of("optional");
        opt.ifPresent(name -> System.out.println(name));
    }
}
