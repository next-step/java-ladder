package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @Test
    public void 생성() {
        Game game = new Game("aa,bb,cc,dd", 5);
        assertThat(game).isEqualTo(new Game("aa,bb,cc,dd", 5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ,aa,bb"})
    public void 생성_실패_user명_문제(String failNames){
        assertThatThrownBy(() -> {
            new Game(failNames, 5);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 생성_실패_user숫자_문제(){
        assertThatThrownBy(() -> {
            new Game("aa", 5);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void 생성_실패_사다리높이_문제(int totalStep){
        assertThatThrownBy(() -> {
            new Game("aa,bb,cc", totalStep);
        }).isInstanceOf(RuntimeException.class);
    }



}