package nextstep.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalFlatMapTest {

    @Test
    void test1() {
        String aString = Optional.of("a")
                .flatMap(it -> Optional.of("b"))
                .orElse("c");

        assertThat(aString).isEqualTo("b");
    }

    @Test
    void test2() {
        String aString = Optional.of("a")
                .flatMap(it -> Optional.empty())
                .map(Object::toString)
                .orElse("c");

        assertThat(aString).isEqualTo("c");
    }

    @Test
    void test3() {
        String aString = Optional.empty()
                .flatMap(it -> Optional.of("b"))
                .orElse("c");

        assertThat(aString).isEqualTo("c");
    }

    @Test
    void test4() {
        String aString = Optional.of("a")
                .map(it -> Optional.empty())
                .flatMap(it -> Optional.of("c"))
                .map(Object::toString)
                .orElse("d");

        assertThat(aString).isEqualTo("c");
    }

    @Test
    void test5() {
        String aString = Optional.of("a")
                .map(it -> Optional.of("b"))
                .flatMap(it -> Optional.empty()) // empty !!!
                .map(Object::toString)
                .orElse("d");

        assertThat(aString).isEqualTo("d");
    }
}
