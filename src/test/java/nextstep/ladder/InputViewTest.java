package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class InputViewTest {

    private InputView inputView = new InputView();
    String userNames = "pobi,honux,crong,jk";

    @DisplayName("참여할 사람 이름을 입력하지 않는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateUserNames(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validateUserNames(names);
        });
    }

    @DisplayName("입력받은 이름을 ,로 자른다.")
    @Test
    void splitUserNamesByComma() {
        String[] names = inputView.splitUserNames(userNames);
        assertThat(names).hasSize(4);
    }

    @DisplayName("입력받은 이름으로 Users 를 생성한다.")
    @Test
    void createUsers() {
        Users users = inputView.createUsers(inputView.splitUserNames(userNames));
        List<User> userList = users.getUsers();
        assertThat(userList).hasSize(4);
    }
}
