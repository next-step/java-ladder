package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.result.ResultCollection;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LadderInputTest {

    @Test
    @DisplayName("만약 입력한 유저와, 결과의 수가 일치하지 않으면 에러 발생")
    void validate() {
        UserCollection users = UserCollection.of(Arrays.asList("jyami", "jyami1", "jyami2"));
        ResultCollection results = ResultCollection.of(Arrays.asList("1", "2", "3", "4"));

        assertThrows(IllegalArgumentException.class, () -> new LadderInput(users, results));
    }

    @Test
    @DisplayName("만약 입력한 유저수가 2명이하면 게임을 진행할 수 없어 에러 발생")
    void validateUserSize() {
        UserCollection users = UserCollection.of(Collections.singletonList("jyami"));
        ResultCollection results = ResultCollection.of(Collections.singletonList("1"));

        assertThrows(IllegalArgumentException.class, () -> new LadderInput(users, results));
    }
}