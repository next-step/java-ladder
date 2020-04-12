package nextstep.ladder.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

class InputViewTest {

    private static InputView inputView = InputView.getInputView();
    private String userNames = "pobi,honux,crong,jk";

    @DisplayName("참여할 사람 이름을 입력하지 않는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "all" })
    @NullAndEmptySource
    void validateUserNames(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.splitByComma(names);
        });
    }

    @DisplayName("입력받은 이름을 ,로 자른다.")
    @Test
    void splitUserNamesByComma() {
        String[] names = inputView.splitByComma(userNames);
        assertThat(names).hasSize(4);
    }

    @DisplayName("입력 받은이름으로 Users 를 생성한다.")
    @Test
    void createUsers() {
        Users users = inputView.createUsers(inputView.splitByComma(userNames));
        List<User> userList = users.getUsers();
        assertThat(userList).hasSize(4);
    }

    @DisplayName("입력 받은값으로 Results 를 생성한다.")
    @Test
    void createResults() {
        String inputText = "꽝,5000,꽝,3000";
        Results results = inputView.createResults(inputView.splitByComma(inputText));
        List<Result> resultList = results.getResults();
        assertThat(resultList).hasSize(4);
    }

    @DisplayName("결과를 보고싶은 사람을 입력받을 경우 유저에 포함되는지 확인해본다. "
                 + "아닐경우 exception 발생시킨다.")
    @Test
    void validateResultUser() {
        Users users = new Users(new ArrayList<>(
                Stream.of(new User("pobi"),
                          new User("honux"),
                          new User("crong"),
                          new User("jk")
                )
                      .collect(Collectors.toList())));

        String userName = "soo";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validateResultUser(users, userName);
        });

    }
}
