package ladder.domain.player;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @ParameterizedTest(name = "참가자 이름 길이 미달 또는 초과 {index} [{arguments}]")
    @CsvSource(value = {
            "over length name,16",
            ",0"
    })
    @DisplayName("참가자 이름 길이 미달 또는 초과")
    void construct_exception(String name, int lengthOfName) throws Exception {
        //given
        //when
        ThrowableAssert.ThrowingCallable actual = () -> new Player(name);

        //then
        assertThatThrownBy(actual).isInstanceOf(PlayerNameException.class)
                .hasMessage("참가자의 이름은 1~5글자만 허용됩니다. 이름 길이 : " + lengthOfName);
    }

    @Test
    @DisplayName("참가자 생성")
    void construct() throws Exception {
        //given
        String name = "pro";

        //when
        Player player = new Player(name);

        //then
        assertThat(player).isEqualTo(new Player(name));
    }

}
