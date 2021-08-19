package ladder.domain.ladder;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AwardsTest {

    private String namesOfAwards = "fail,5000,fail,3000";

    @Test
    @DisplayName("상금 일급 컬렉션 객체 생성")
    void construct() throws Exception {
        //given

        //when
        Awards actual = Awards.of(namesOfAwards);

        //then
        assertThat(actual).isEqualTo(Awards.of(namesOfAwards));

    }

    @ParameterizedTest(name = "상금 이름 없음 {index} [{arguments}]")
    @MethodSource
    @DisplayName("객체 생성 실패")
    void construct_exception(String namesOfAwards) throws Exception {
        //given

        //when
        ThrowableAssert.ThrowingCallable actual = () -> Awards.of(namesOfAwards);

        //then
        assertThatThrownBy(actual).isInstanceOf(AwardsSizeException.class);
    }

    private static Stream<Arguments> construct_exception() {
        return Stream.of(
                Arguments.of((String) null),
                Arguments.of("")
        );
    }

    @Test
    @DisplayName("상금 일급 컬렉션의 크기")
    void validate_size() throws Exception {
        //given
        Awards awards = Awards.of(namesOfAwards);

        //when
        int actual = awards.size();

        //then
        assertThat(actual).isEqualTo(4);

    }

    @ParameterizedTest(name = "상금 찾기 {index} [{arguments}]")
    @CsvSource(value = {
            "0,fail",
            "1,5000",
            "2,fail",
            "3,3000"
    })
    @DisplayName("index 값으로 상금 찾기")
    void find_name_with_index(int indexOfAward, String expected) throws Exception {
        //given
        Awards awards = Awards.of(namesOfAwards);

        //when
        String actual = awards.name(indexOfAward);

        //then
        assertThat(actual).isEqualTo(expected);

    }


}
