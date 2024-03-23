package nextstep.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Baeldung 학습 테스트 예제
 * https://www.baeldung.com/java-optional
 */
public class OptionalTest {

    @Test
    void empty() {
        Optional<String> empty = Optional.empty();
        assertThat(empty.isPresent()).isFalse();
    }

    @Test
    void of() {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        assertThat(opt.isPresent()).isTrue();
    }

    @Test
    void of에_null을_넘기면_예외를_던진다() {
        assertThatThrownBy(() -> Optional.of(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void ofNullable() {
        String name = "baeldung";
        Optional<String> opt = Optional.ofNullable(name);
        Optional<String> empty = Optional.ofNullable(null); // 클래스 인스턴스 EMPTY 할당됨

        assertThat(opt.isPresent()).isTrue();
        assertThat(empty).isEqualTo(Optional.empty());
    }

    @Test
    void isPresent() {
        Optional<String> opt = Optional.of("Baeldung");
        assertThat(opt.isPresent()).isTrue();

        Optional<String> empty = Optional.ofNullable(null);
        assertThat(empty.isPresent()).isFalse();
    }

    @Test
    void isEmpty() {
        Optional<String> opt = Optional.of("Baeldung");
        assertThat(opt.isEmpty()).isFalse();

        Optional<String> empty = Optional.ofNullable(null);
        assertThat(empty.isEmpty()).isTrue();
    }

    @DisplayName("값이 null이 아닌 경우 Consumer.accept()실행 ")
    @Test
    void ifPresent() {
        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @DisplayName("값이 null이면 orElse 값을 반환(기본값)")
    @Test
    void orElse() {
        String name = (String) Optional.ofNullable(null).orElse("john");
        assertThat(name).isEqualTo("john");
    }

    @DisplayName("값이 null이면 Supplier 실행한 값을 반환(지연실행)")
    @Test
    void orElseGet() {
        String name = (String) Optional.ofNullable(null).orElseGet(() -> "john");
        assertThat(name).isEqualTo("john");
    }

    @DisplayName("값이 null이면 Supplier.get() 실행한 예외를 던진다")
    @Test
    void orElseThrow() {
        assertThatThrownBy(() -> Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 null이면 예외 NoSuchElementException 던짐")
    @Test
    void orElseThrow_기본() {
        assertThatThrownBy(() -> Optional.ofNullable(null).orElseThrow())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void get() {
        Optional<String> opt = Optional.of("baeldung");
        assertThat(opt.get()).isEqualTo("baeldung");
    }

    @Test
    void get_값이없으면_예외를던진다() {
        Optional<String> empty = Optional.ofNullable(null);
        assertThatThrownBy(() -> empty.get())
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("Predicate를 실행한 결과에 따라 자신이나 empty 반환, null인경우 자신 반환")
    @Test
    void filter() {
        Optional<Integer> yearOptional = Optional.of(2016);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();

        assertThat(is2016).isTrue();
        assertThat(is2017).isFalse();
    }

    @Test
    void priceIsRange2() {
        assertThat(Modem.priceIsInRange2(new Modem(10.0))).isTrue();
        assertThat(Modem.priceIsInRange2(new Modem(9.9))).isFalse();
        assertThat(Modem.priceIsInRange2(new Modem(null))).isFalse();
        assertThat(Modem.priceIsInRange2(new Modem(15.5))).isFalse();
        assertThat(Modem.priceIsInRange2(null)).isFalse();
    }

    @Test
    void map() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional.map(List::size).orElse(0);
        assertThat(size).isEqualTo(6);
    }

    @Test
    void map2() {
        Optional<String> nameOptional = Optional.of("baeldung");

        int len = nameOptional.map(String::length).orElse(0);
        assertThat(len).isEqualTo(8);
    }

    @Test
    void map3() {
        String password = " password ";
        Optional<String> passOptional = Optional.of(password);
        boolean correctPassword = passOptional.filter(p -> p.equals("password")).isPresent();

        assertThat(correctPassword).isFalse();

        correctPassword = passOptional.map(p -> p.trim())
                .filter(p -> p.equals("password"))
                .isPresent();
        assertThat(correctPassword).isTrue();
    }

    @Test
    void flatMap() {
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
        Optional<String> nameOptional = personOptional.flatMap(Person::getName);

        assertThat(nameOptional.orElse("")).isEqualTo("john"); // flatMap이 수월
        assertThat(nameOptionalWrapper.orElseThrow().orElse("")).isEqualTo("john"); // 두번이나 wrapper를 벗겨야 하네
    }

    private Optional<String> getEmpty() {
        return Optional.empty();
    }

    private Optional<String> getHello() {
        return Optional.of("hello");
    }

    private Optional<String> getBye() {
        return Optional.of("bye");
    }

    private Optional<String> createOptional(String input) {
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }

    @Test
    void streamOptional() {
        Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

        assertThat(found).isEqualTo(getHello());
    }

    @Test
    void streamOptional2() {
        String found = Stream.<Supplier<Optional<String>>>of(() -> createOptional("empty"), () -> createOptional("empty"))
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseGet(() -> "default");

        assertThat(found).isEqualTo("default");
    }
}
