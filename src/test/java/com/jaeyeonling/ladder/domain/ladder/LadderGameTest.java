package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.Fixture;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.view.format.Formatters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + LadderGame.FINISH_CHARACTER + "' 일 경우 true를 return 한다.")
    @Test
    void should_return_true_when_isShowAll_by_finishCharacter() {
        // given
        final LadderGame ladderGame = Fixture.ladderGame;

        // when
        final boolean isShowAll = ladderGame.isShowAll(LadderGame.FINISH_CHARACTER);

        // then
        assertThat(isShowAll).isTrue();
    }

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + LadderGame.FINISH_CHARACTER + "' 이 아닐 경우 false를 return 한다.")
    @Test
    void should_return_false_when_isShowAll_by_notFinishCharacter() {
        // given
        final LadderGame ladderGame = Fixture.ladderGame;

        // when
        final boolean isShowAll = ladderGame.isShowAll(LadderGame.FINISH_CHARACTER + "!");

        // then
        assertThat(isShowAll).isFalse();
    }

    @DisplayName("사다리가 전부 아래로 가는 경우 유저의 당첨되는 결과는 같은 위치에 있는 값과 같다.")
    @Test
    void should_return_matchResult_when_findWinningResult_by_username_with_allStraightLines() {
        // given
        final LadderGame ladderGame = Fixture.ladderGame;

        final String[] splitUsers = Fixture.rawUsers.split(Users.SEPARATOR);
        final String[] splitLadderResults = Fixture.rawLadderResults.split(LadderResults.SEPARATOR);

        for (int i = 0; i < splitUsers.length; i++) {
            final String username = splitUsers[i];
            final String expectLadderResult = splitLadderResults[i];

            // when
            final LadderResult foundWinningResult = ladderGame.findWinningResult(username);
            final String formattedFoundWinningResult = Formatters.ladderResultFormatter.format(foundWinningResult);

            // then
            assertThat(formattedFoundWinningResult).isEqualTo(expectLadderResult);
        }
    }
}
