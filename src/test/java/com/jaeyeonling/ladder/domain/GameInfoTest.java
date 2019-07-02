package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndResultSizeException;
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
    void should_throw_NotEqualsUserSizeAndResultSizeException_when_notEqualsSize() {
        // given
        final Users users = Users.ofSeparator("a,b,c");
        final LadderResults ladderResults = LadderResults.ofSeparator("a,b");

        // when, then
        assertThatExceptionOfType(NotEqualsUserSizeAndResultSizeException.class)
                .isThrownBy(() -> {
                    GameInfo.withUsersAndLadderResults(users, ladderResults);
                });
    }

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + GameInfo.FINISH_CHARACTER + "' 일 경우 true를 return 한다.")
    @Test
    void should_return_true_when_isShowAll_by_finishCharacter() {
        // given
        final GameInfo gameInfo = Fixture.gameInfo;

        // when
        final boolean isShowAll = gameInfo.isShowAll(GameInfo.FINISH_CHARACTER);

        // then
        assertThat(isShowAll).isTrue();
    }

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + GameInfo.FINISH_CHARACTER + "' 이 아닐 경우 false를 return 한다.")
    @Test
    void should_return_false_when_isShowAll_by_notFinishCharacter() {
        // given
        final GameInfo gameInfo = Fixture.gameInfo;

        // when
        final boolean isShowAll = gameInfo.isShowAll(GameInfo.FINISH_CHARACTER + "!");

        // then
        assertThat(isShowAll).isFalse();
    }

    @DisplayName("사다리가 전부 아래로 가는 경우 유저의 당첨되는 결과는 같은 위치에 있는 값과 같다.")
    @Test
    void should_return_matchResult_when_findWinningResult_by_username_with_allStraightLines() {
        // given
        final GameInfo gameInfo = Fixture.gameInfo;
        final LadderGame ladderGame = LadderGame.of(Fixture.allStraightLines);

        final String[] splitUsers = Fixture.rawUsers.split(Users.SEPARATOR);
        final String[] splitLadderResults = Fixture.rawLadderResults.split(LadderResults.SEPARATOR);

        for (int i = 0; i < splitUsers.length; i++) {
            final String username = splitUsers[i];
            final String expectLadderResult = splitLadderResults[i];

            // when
            final String foundWinningResult = gameInfo.findWinningResult(username, ladderGame);

            // then
            assertThat(foundWinningResult).isEqualTo(expectLadderResult);
        }
    }
}
