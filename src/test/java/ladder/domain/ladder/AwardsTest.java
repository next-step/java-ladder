package ladder.domain.ladder;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AwardsTest {

    @Test
    @DisplayName("상금 일급 컬렉션 객체 생성")
    void construct() throws Exception {
        //given
        String namesOfAwards = "fail,5000,fail,3000";

        //when
        Awards actual = Awards.from(namesOfAwards);

        //then
        assertThat(actual).isEqualTo(Awards.from(namesOfAwards));

    }

    @ParameterizedTest(name = "상금 이름 없음 {index} [{arguments}]")
    @MethodSource
    @DisplayName("객체 생성 실패")
    void construct_exception(String namesOfAwards) throws Exception {
        //given

        //when
        ThrowableAssert.ThrowingCallable actual = () -> Awards.from(namesOfAwards);

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
        String namesOfAwards = "fail,5000,fail,3000";

        //when
        Awards awards = Awards.from(namesOfAwards);
        int actual = awards.size();

        //then
        assertThat(actual).isEqualTo(4);

    }


}
