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
        assertThatIllegalArgumentException().isThrownBy(() -> Names.of(
                Arrays.asList(Name.of("test"))
        ));
    }

    @DisplayName("Null or Empty input illegal exception")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.of(input));
    }

    @DisplayName("size() 메서드는 Name의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"abc,dasd,sadas,d:4", "abc,ddd:2"}, delimiter = ':')
    void sizeTest(String input, int expect) {
        Names names = Names.of(input);

        assertThat(names.size()).isEqualTo(expect);
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        assertThat(Names.of(Arrays.asList(Name.of("miz"), Name.of("mi"))))
                .isEqualTo(Names.of(Arrays.asList(Name.of("miz"), Name.of("mi"))));
    }

    @DisplayName("정상 ','로 구분 된 String 도 생성 할 수 있다.")
    @Test
    void createWithStringTest() {
        assertThat(Names.of("miz,mi"))
                .isEqualTo(Names.of(Arrays.asList(Name.of("miz"), Name.of("mi"))));
    }

    @DisplayName("equalsSize() 메서드는 갯수가 같은지 판별한다.")
    @ParameterizedTest
    @CsvSource(value = {"abc,dasd,sadas,d:4:true", "abc,ddd:3:false"}, delimiter = ':')
    void sizeTest(String input, int size, boolean expect) {
        Names names = Names.of(input);

        assertThat(names.equalsSize(size)).isEqualTo(expect);
    }

    @DisplayName("contains() 메서드로 name 존재여부 반환")
    @Test
    void containsTest() {
        Names names = Names.of("miz,bi");

        assertThat(names.contains(Name.of("miz"))).isTrue();
        assertThat(names.contains(Name.of("bi"))).isTrue();
        assertThat(names.contains(Name.of("bik"))).isFalse();
    }

    @DisplayName("indexOf() names에서 name의 인덱스 반환")
    @Test
    void findIndexWithName() {
        Names names = Names.of("miz,bi");

        assertThat(names.indexOf(Name.of("miz"))).isEqualTo(0);
        assertThat(names.indexOf(Name.of("bi"))).isEqualTo(1);
    }
}
