package nextstep.ladder.domain;

import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserGenerator;
import nextstep.ladder.utils.LadderValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UserTest {

    private String names;

    @BeforeEach
    void setUp() {
        names = "pobi,honux,crong,jk";
    }

    @Test
    @DisplayName("참여하는 유저 split")
    void userSplit() {
        String[] users = User.splitByUserName(names);
        assertThat(users).contains("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("유저 List Size")
    void userListSize() {
        List<User> users = UserGenerator.generateUsers(names);
        assertThat(users).hasSize(4);
    }

    @ParameterizedTest
    @DisplayName("유저의 이름이 공백 또는 null인지 확인")
    @NullAndEmptySource
    void validateLadderNameIsBlank(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->{
                    LadderValidation.validateUserNameIsBlank(name);
                });
    }

    @Test
    @DisplayName("유저의 이름이 6자 이상이면 Exception 발생")
    void validateLadderNameLength() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    LadderValidation.validateUserNameLength("hangyeol");
                });
    }

}
