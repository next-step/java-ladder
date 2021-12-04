package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class NameTest {

    @Test
    @DisplayName("이름 길이확인")
    public void checkNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name("aaaaaa");

            fail("이름길이 에러가 발생해야한다.");
        });
    }

    @Test
    @DisplayName("공백만 입력한 경우 에러가 발생해야 한다.")
    public void checkNameEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name("   ");

            fail("공백 에러가 발생해야한다.");
        });
    }


}
