package ladder.user;

import ladder.domain.constant.ErrorMessages;
import ladder.domain.content.user.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    @DisplayName("[fail] 이름에 \"\" 나 null 이 들어온 경우 exception 발생")
    void makeNameWithEmptyTest() {
        //Given
        String empty = "";
        String nullStr = null;
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Name.newEnglishNumericOf(empty))
          .withMessage(ErrorMessages.EMPTY_INPUT.message());
        
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Name.newEnglishNumericOf(nullStr))
          .withMessage(ErrorMessages.EMPTY_INPUT.message());
    }

    @Test
    @DisplayName("[fail] 알파벳이나 숫자가 아닌 이름은 exception 발생")
    void makeNameWithNotEnglishTest() {
        //Given
        String nameKorean = "유저";

        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Name.newEnglishNumericOf(nameKorean))
          .withMessage(ErrorMessages.REQUIRE_NOT_KOREAN.message());
    }
    
    @Test
    @DisplayName("[fail] 5자 초과 입력시 exception 발생")
    void makeNameWithOverLengthStringTest() {
        //Given
        String lengthSix = "abcedf";
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Name.newEnglishNumericOf(lengthSix))
          .withMessage(ErrorMessages.REQUIRE_NOT_KOREAN.message());
    }
}
