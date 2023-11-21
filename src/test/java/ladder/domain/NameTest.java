package ladder.domain;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @Test
    @DisplayName("이름은 최대 5가질 수 있다.")
    void lengthCheck(){
        assertThatIllegalArgumentException().isThrownBy(()->new Name("rocket"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","]","{","}",";",":",
            "'","\"",",",".","<",">","/","?"})
    @DisplayName("이름에 특수 기호나 숫자가 들어갈 수 없다")
    void characterCheck(String input){
        assertThatIllegalArgumentException().isThrownBy(()->new Name("jack"+input));
    }
}
