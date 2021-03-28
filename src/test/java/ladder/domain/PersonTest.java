package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("참여자")
public class PersonTest {

    @ParameterizedTest
    @CsvSource(value = {"povi,study,3,4,5,6:6", "12,13:2"}, delimiter = ':')
    @DisplayName("문자열 split 확인")
    public void createPersonTest(String inputPerson, int check) throws Exception {
        //given
        Person person = new Person(inputPerson);

        //when
        int countOfPerson = person.countOfPerson();

        //then
        assertThat(countOfPerson).isEqualTo(check);
    }

    @Test
    @DisplayName("참여자 1명 이하 예외 테스트")
    public void personUnderTwoTest() throws Exception {
        //given
        String inputPerson = "1";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Person(inputPerson);
        });

        //then
    }

    @Test
    @DisplayName("Name 길이 5 초과 예외 테스트")
    public void validNameLengthTest() throws Exception {
        //given
        String inputPerson = "person,6";

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Person(inputPerson);
        });

        //then
    }
}
