package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("결과를 입력받을 사람 이름이 all이면 no exception")
    void result_name_when_all() {
        //given
        PersonName all = new PersonName("all");
        Ladder ladder = new Ladder(new People("aaa,bbb,ccc".split(",")), 5);
        //then
        assertThatNoException().isThrownBy(() -> ladder.getResult(all, null));
    }


    @Test
    @DisplayName("결과를 입력받을 사람 이름이 all도 아니고, 사다리 게임에 참여한 사람 이름도 아니면 오류")
    void result_name_when_not_contain_people() {
        //given
        PersonName ddd = new PersonName("ddd");
        Ladder ladder = new Ladder(new People("aaa,bbb,ccc".split(",")), 5);
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> ladder.getResult(ddd, null));
    }

}