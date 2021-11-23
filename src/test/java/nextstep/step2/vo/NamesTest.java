package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @DisplayName("List<Name> 의 크기가 2 보다 작을 경우 illegal exception")
    @Test
    void lessThanOneTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.create(
                Arrays.asList(Name.create("test"))
        ));

        assertThatIllegalArgumentException().isThrownBy(() -> Names.create(
                null
        ));
    }

    @DisplayName("Null or Empty input illegal exception")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.createWithString(input));
    }

    @DisplayName("size() 메서드는 Name의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"abc,dasd,sadas,d:4", "abc,ddd:2"}, delimiter = ':')
    void sizeTest(String input, int expect) {
        Names names = Names.createWithString(input);

        assertThat(names.size()).isEqualTo(expect);
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        assertThat(Names.create(Arrays.asList(Name.create("miz"), Name.create("mi"))))
                .isEqualTo(Names.create(Arrays.asList(Name.create("miz"), Name.create("mi"))));
    }

    @DisplayName("정상 ','로 구분 된 String 도 생성 할 수 있다.")
    @Test
    void createWithStringTest() {
        assertThat(Names.createWithString("miz,mi"))
                .isEqualTo(Names.create(Arrays.asList(Name.create("miz"), Name.create("mi"))));
    }
}
