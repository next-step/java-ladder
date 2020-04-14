package nextstep.optional.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class OptionalMethodUseTest {
    Optional<String> opt;
    String nullName;

    @BeforeEach
    void setUp() {
        String name = "optional";
        opt = Optional.of(name);
        nullName = null;
    }

    @Test
    void orElseTest() {
        String nullName = null;
        String name = opt.ofNullable(nullName).orElse("john");
        assertThat("john").isEqualTo(name);
    }

    @Test
    void orElseGetTest() {
        String nullName = null;
        String name = opt.ofNullable(nullName).orElseGet(() -> "peter");
        assertThat(name).isEqualTo("peter");

        opt.ofNullable(nullName).orElseGet(() -> new String("peter2"));
    }

    @Test
    void orElseThrowTest() {
//        String name = opt.ofNullable(nullName).orElseThrow(NullPointerException::new);
        assertThatThrownBy(() -> System.out.println(
                opt.ofNullable(nullName).orElseThrow(NullPointerException::new)
        )).isInstanceOf(NullPointerException.class);
    }

    @Test
    void getTest() {
        String name = opt.ofNullable("peter").get();
        assertThat(name).isEqualTo("peter");

        assertThatThrownBy(() -> opt.ofNullable(null).get()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void filterTest() {
        Integer year = 2020;
        Optional<Integer> yearOpt = Optional.of(year);
        boolean is2020 = yearOpt.filter(x -> x == 2020).isPresent();
        assertThat(is2020).isTrue();

        boolean is2019 = yearOpt.filter(x -> x == 2019).isPresent();
        assertThat(is2019).isFalse();
    }

}
