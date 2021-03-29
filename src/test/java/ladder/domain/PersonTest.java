package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("참여자 입력")
public class PersonTest {

    @Test
    @DisplayName("Name 길이 5 초과 예외 테스트")
    public void validNameLengthTest() throws Exception {
        //given
        String inputPerson = "person,6";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Persons(inputPerson);
        });

        //then
    }
}
