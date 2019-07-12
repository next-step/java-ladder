package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.reword.LadderRewords;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndRewordSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameInfoTest {

    @DisplayName("유저와 결과의 숫자가 같지 않다면 에러를 발생한다.")
    @Test
    void throwNotEqualsUserSizeAndRewordSizeException() {
        // given
        final Users users = Users.ofSeparator("a,b,c");
        final LadderRewords ladderRewords = LadderRewords.ofSeparator("a,b");

        // when, then
        assertThatExceptionOfType(NotEqualsUserSizeAndRewordSizeException.class)
                .isThrownBy(() -> GameInfo.with(users, ladderRewords));
    }
}
