package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderRewords;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndRewordSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameInfoTest {

    @DisplayName("게임 정보 생성에 성공한다.")
    @Test
    void should_create() {
        final GameInfo gameInfo = Fixture.gameInfo;

        assertThat(gameInfo).isNotNull();
    }

    @DisplayName("유저와 결과의 숫자가 같지 않다면 에러를 발생한다.")
    @Test
    void should_throw_NotEqualsUserSizeAndRewordSizeException_when_notEqualsSize() {
        // given
        final Users users = Users.ofSeparator("a,b,c");
        final LadderRewords ladderRewords = LadderRewords.ofSeparator("a,b");

        // when, then
        assertThatExceptionOfType(NotEqualsUserSizeAndRewordSizeException.class)
                .isThrownBy(() -> {
                    GameInfo.withUsersAndLadderRewords(users, ladderRewords);
                });
    }
}
