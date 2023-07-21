package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PersonTest {

    @Test
    void 이름_유효성_체크() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Person(null)
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Person("           ")
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Person("")
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Person("fiveover")
                )
        );
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"kbc:.   kbc", "kang:.  kang", "kbc12:. kbc12"})
    void 이름_출력_테스트(String name, String expected) {
        String personName = new Person(name).toString();

        assertThat(personName).isEqualTo(expected.replace(".", ""));
    }


}
