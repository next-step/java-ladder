package com.jaeyeonling.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + GameResult.FINISH_CHARACTER + "' 일 경우 true를 return 한다.")
    @Test
    void should_return_true_when_isShowAll_by_finishCharacter() {
        // given
        final GameResult gameResult = Fixture.ladderGame.play();

        // when
        final boolean isShowAll = gameResult.isShowAll(GameResult.FINISH_CHARACTER);

        // then
        assertThat(isShowAll).isTrue();
    }

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + GameResult.FINISH_CHARACTER + "' 이 아닐 경우 false를 return 한다.")
    @Test
    void should_return_false_when_isShowAll_by_notFinishCharacter() {
        // given
        final GameResult gameResult = Fixture.ladderGame.play();

        // when
        final boolean isShowAll = gameResult.isShowAll(GameResult.FINISH_CHARACTER + "!");

        // then
        assertThat(isShowAll).isFalse();
    }

}
