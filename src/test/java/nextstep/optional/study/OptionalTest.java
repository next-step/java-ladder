package nextstep.optional.study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OptionalTest {

    @Test
    @DisplayName("empty 메소드로 빈 Optional을 생성할 수 있다.")
    void empty() {
        // given
        Optional<Object> empty = Optional.empty();

        // when
        boolean result = empty.isPresent();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isPresent 메소드로 optional 내 객체의 존재 여부를 판단할 수 있다.")
    void is_present() {
        // given
        String name = "suchan";

        // when
        Optional<String> optionalName = Optional.of(name);

        // then
        assertThat(optionalName.isPresent()).isTrue();
    }

    @Test
    @DisplayName("optional의 of 메소드의 인자에 null을 넣으면 예외가 발생한다.")
    void if_optional_contains_null() {
        // given
        String name = null;

        // when // then
        assertThatThrownBy(() -> Optional.of(name))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Optional에 넣을 객체의 값이 null이 예상되는 경우 ofNullable 메소드를 사용할 수 있다.")
    void if_use_of_nullable_method_with_null() {
        // given
        String name = null;

        // when // then
        assertThatCode(() -> Optional.ofNullable(name).isPresent())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("isEmpty 메소드로 isPresent와 반대되는 작업인 값이 비어있음을 확인할 수 있다.")
    void is_empty() {
        // given
        String name = null;

        // when
        boolean result = Optional.ofNullable(name).isEmpty();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("NullPointerException이 나오지 않도록 코드 작성 테스트")
    void no_null_pointer_exception_with_null() {
        // given
        Optional<String> given = Optional.ofNullable(null);

        // when // then
        assertThatCode(() -> testMethod(given))
                .doesNotThrowAnyException();
    }

    private void testMethod(Optional<String> given) {
        given.ifPresent((name) -> System.out.println(name.length()));
    }

    @Test
    @DisplayName("orElse를 사용해 Optional안에 값이 존재하지 않으면 다른 값을 반환한다.")
    void orElse() {
        // given
        Optional<String> name = Optional.ofNullable(null);

        // when
        String result = name.orElse("suchan");

        // then
        assertThat(result).isEqualTo("suchan");
    }

    @Test
    @DisplayName("null이 나올 경우 공급자 인터페이스를 호출한다.")
    void orElseGet() {
        // given
        Optional<String> name = Optional.ofNullable(null);

        // when
        String result = name.orElseGet(() -> createName("suchan"));

        // then
        assertThat(result).isEqualTo("suchan");
    }

    private String createName(String name) {
        System.out.println("createName method");
        return name;
    }

    @Test
    @DisplayName("값이 null이면 예외를 던진다.")
    void orElseThrow() {
        // given
        Optional<String> name = Optional.ofNullable(null);

        // when // then
        assertThatThrownBy(name::orElseThrow)
                .isExactlyInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("Optional에 값이 없으면 꺼낼 때 예외가 발생한다.")
    void get() {
        // given
        Optional<String> name = Optional.ofNullable(null);

        // when // then
        assertThatThrownBy(name::get)
                .isExactlyInstanceOf(NoSuchElementException.class);
    }

    static class Student {
        private final String name;

        Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    @DisplayName("map은 Optional의 내부 값이 null이어도 객체를 만들 수 있다.")
    void map() {
        // given
        Student student = null;

        // when
        Optional<Student> optionalStudent = Optional.ofNullable(student);

        // then
        assertThatCode(() -> optionalStudent.map(Student::getName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("filter는 Optional의 내부 값이 null이어도 객체를 필터링할 수 있다.")
    void filter() {
        // given
        Student student = null;

        // when
        Optional<Student> optionalStudent = Optional.ofNullable(student);

        // then
        assertThatCode(() -> optionalStudent.filter(student1 -> student1.getName().equals("suchan")))
                .doesNotThrowAnyException();
    }
}
