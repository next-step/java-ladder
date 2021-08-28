package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    @DisplayName("이름의 길이가 5자가 넘으면 IllegalArgumentException이 발생한다.")
    void nameLengthException(){
        String name = "harris";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name))
                .withMessage("이름은 최대 5자까지 입력할 수 있습니다. name : " + name);
    }

    @Test
    @DisplayName(",가 아닌 다른 Delimiter를 사용하면 IllegalArgumentException이 발생한다.")
    void delimiter(){
        String nameList = "harr;hurr;aurr;jurr";
        String[] split = nameList.split(",");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.of(split))
                .withMessage("이름 리스트에 유효하지 않은 특수문자가 포함되어 있습니다.");

    }
}