package com.jaeyeonling.ladder2.domain.ladder;

import com.jaeyeonling.ladder2.domain.reword.LadderRewords;
import com.jaeyeonling.ladder2.domain.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {

    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        final Users users = Users.ofSeparator("a,b,c");
        final LadderRewords ladderRewords = LadderRewords.ofSeparator("1,2,3");
        final LadderGame ladderGame = LadderGame.builder(users, ladderRewords).build();

        ladderGameResult = ladderGame.play();
    }

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + LadderGameResult.FINISH_CHARACTER + "' 일 경우 true 를 return 한다.")
    @Test
    void showAllTrue() {
        // when
        final boolean isShowAll = ladderGameResult.isShowAll(LadderGameResult.FINISH_CHARACTER);

        // then
        assertThat(isShowAll).isTrue();
    }

    @DisplayName("전체 출력 확인 시 입력받은 값이 '" + LadderGameResult.FINISH_CHARACTER + "' 이 아닐 경우 false 를 return 한다.")
    @Test
    void showAllFalse() {
        // when
        final boolean isShowAll = ladderGameResult.isShowAll("ㅁㄴㅇ");

        // then
        assertThat(isShowAll).isFalse();
    }
}
