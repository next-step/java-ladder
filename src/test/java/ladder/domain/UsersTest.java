package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
    Users users;

    @BeforeEach
    void before() {
        String names = "pobi, hano, zero";
        users = new Users(names);
    }

    @Test
    void validNameCheck() {
        String names = "pobi, hano, zero, zero";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users(names));
    }


}