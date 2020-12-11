package nextstep.ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("참여자 이름 입력시 5글자 초과 예외처리")
    void checkNameLengthExceed() {
        String name = "python";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> User.from(name)
        );
    }

    @Test
    @DisplayName("참여자 이름이 빈칸일 경우 예외처리")
    void checkEmptyName() {
        String name = "";

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> User.from(name)
        );
    }

}