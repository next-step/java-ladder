package ladder.domain.player;

import ladder.exception.TooLongNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa" , "bbbbbbbbbbbbbbbbb", "ccccccccccccccccccccccc"})
    @DisplayName("이름이 5글자가 넘으면 예외를 던진다.")
    public void TooLongNameExceptionTest(String name) {
        Assertions.assertThrows(TooLongNameException.class , () ->
                new Name(name)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"kim:kim", "hong:hong", "pobi:pobi"}, delimiter = ':')
    public void NameTest(String name, String result)
    {
        org.assertj.core.api.Assertions.assertThat(new Name(name).toString()).isEqualTo(result);
    }
}
