package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RewardsTest {

    @Test
    @DisplayName("사람 명수와 보상 개수가 같으면 정상")
    void number_person_equal_number_rewards() {
        //given
        People people = new People("aaa,bbb,ccc,ddd".split(","));
        Rewards rewards = new Rewards("꽝,5000,꽝,3000".split(","));
        //then
        assertThatNoException().isThrownBy(() -> rewards.validate(people));
    }

    @Test
    @DisplayName("사람 명수와 보상 개수가 다르면 오류")
    void number_person_not_equal_number_rewards() {
        //given
        People people = new People("aaa,bbb,ccc".split(","));
        Rewards rewards = new Rewards("꽝,5000,꽝,3000,꽝".split(","));
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> rewards.validate(people));
    }

    @Test
    @DisplayName("인덱스 조회")
    void get_reward_by_index() {
        //given
        Rewards rewards = new Rewards("꽝,5000,꽝,3000,꽝".split(","));
        //then
        assertThat(rewards.getReward(1)).isEqualTo(new Reward("5000"));
    }

}