package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("결과를 입력받을 사람 이름이 all이면 no exception")
    void result_name_when_all() {
        //given
        PersonName all = new PersonName("all");
        Ladder ladder = new Ladder(new People("aaa,bbb,ccc".split(",")), 5, null);
        //then
        assertThatNoException().isThrownBy(() -> ladder.getResult(all));
    }


    @Test
    @DisplayName("결과를 입력받을 사람 이름이 all도 아니고, 사다리 게임에 참여한 사람 이름도 아니면 오류")
    void result_name_when_not_contain_people() {
        //given
        PersonName ddd = new PersonName("ddd");
        Ladder ladder = new Ladder(new People("aaa,bbb,ccc".split(",")), 5, null);
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> ladder.getResult(ddd));
    }

    @Test
    @DisplayName("실행결과")
    void result_reward_one() {
        //given
        Rewards rewards = new Rewards("꽝,5000,꽝,3000".split(","));
        People people = new People("pobi,honux,crong,jk".split(","));

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(false, true, false, true)));
        lines.add(new Line(Arrays.asList(false, false, true, false)));
        lines.add(new Line(Arrays.asList(false, true, false, false)));
        lines.add(new Line(Arrays.asList(false, false, true, false)));
        lines.add(new Line(Arrays.asList(false, true, false, true)));

        Ladder ladder = new Ladder(lines, people, rewards);
        //then
        PersonName pobi = new PersonName("pobi");
        Map<PersonName, Reward> result = ladder.getResult(pobi);
        //when
        assertThat(result).containsEntry(pobi, new Reward("꽝"));
    }

    @Test
    @DisplayName("실행결과")
    void result_reward_all() {
        //given
        Rewards rewards = new Rewards("꽝,5000,꽝,3000".split(","));
        People people = new People("pobi,honux,crong,jk".split(","));

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(false, true, false, true)));
        lines.add(new Line(Arrays.asList(false, false, true, false)));
        lines.add(new Line(Arrays.asList(false, true, false, false)));
        lines.add(new Line(Arrays.asList(false, false, true, false)));
        lines.add(new Line(Arrays.asList(false, true, false, true)));

        Ladder ladder = new Ladder(lines, people, rewards);
        //then
        PersonName all = new PersonName("all");
        Map<PersonName, Reward> result = ladder.getResult(all);
        //when
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(result).containsEntry(new PersonName("pobi"), new Reward("꽝")),
                () -> assertThat(result).containsEntry(new PersonName("honux"), new Reward("3000")),
                () -> assertThat(result).containsEntry(new PersonName("crong"), new Reward("꽝")),
                () -> assertThat(result).containsEntry(new PersonName("jk"), new Reward("5000"))
        );

    }

}