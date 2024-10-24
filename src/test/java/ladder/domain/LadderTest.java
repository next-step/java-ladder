package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.LineTest.l1;
import static ladder.domain.LineTest.l2;
import static ladder.domain.LineTest.l3;
import static ladder.domain.MemberTest.m1;
import static ladder.domain.MemberTest.m2;
import static ladder.domain.MembersTest.ms1;
import static ladder.domain.RewordTest.r1;
import static ladder.domain.RewordTest.r2;
import static ladder.domain.RewordsTest.rs1;
import static ladder.domain.RewordsTest.rs2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    public static final Ladder ld1 = new Ladder(List.of(l1, l2));
    public static final Ladder ld2 = new Ladder(List.of(l3));

    @Test
    @DisplayName("멤버와 보상의 수가 다를 때 예외를 발생시킨다.")
    void 사다리게임_예외() {
        assertThatThrownBy(() -> ld2.playLadders(ms1, rs2))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("사다리 게임을 진행한다.")
    void 사다리게임_진행() {
        LadderResult results = ld2.playLadders(ms1, rs1);
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(results.getSize()).isEqualTo(2),
                () -> assertThat(results.getReword(m1)).isEqualTo(r2),
                () -> assertThat(results.getReword(m2)).isEqualTo(r1)
        );
    }

    @Test
    @DisplayName("생성된 사이즈만큼 사이즈 반환")
    void 객체_사이즈_반환() {
        assertThat(ld1.getSize()).isEqualTo(2);
    }
}