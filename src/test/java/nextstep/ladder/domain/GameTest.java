package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @Test
    public void 생성() {
        Game game = new Game("aa,bb,cc,dd", "0,500,0,500", 5);
        assertThat(game).isEqualTo(new Game("aa,bb,cc,dd", "0,500,0,500", 5));
    }

    @ParameterizedTest
    @ValueSource(strings = {",,aa", " ,aa,bb"})
    public void 생성_실패_spot명_문제(String failNames) {
        assertThatThrownBy(() -> {
            new Game(failNames, "0,500,1000", 5);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa", "aa,bb,cc,dd"})
    public void 생성_실패_spot숫자_문제(String userString) {
        assertThatThrownBy(() -> {
            new Game(userString, "0,500,1000", 5);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 생성_실패_사다리높이_문제(int totalStep) {
        assertThatThrownBy(() -> {
            new Game("aa,bb,cc", totalStep);
        }).isInstanceOf(RuntimeException.class);
    }


}