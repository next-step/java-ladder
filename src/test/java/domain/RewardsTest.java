package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    public static final Rewards RS1 = new Rewards(List.of(RewardTest.R1, RewardTest.R2, RewardTest.R3, RewardTest.R4));

    @DisplayName("특정 보상의 위치를 구한다.")
    @Test
    void test01() {
        assertThat(RS1.position(RewardTest.R1)).isEqualTo(new Position(0, 0));
    }

    @DisplayName("순서를 입력받아 보상을 구한다.")
    @Test
    void test02() {
        assertThat(RS1.findByOrder(0)).isEqualTo(RewardTest.R1);
    }
}
