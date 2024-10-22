package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.MemberTest.m1;
import static ladder.domain.MemberTest.m2;
import static ladder.domain.MemberTest.m3;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MembersTest {
    public static final Members ms1 = new Members(List.of(m1, m2));

    @ParameterizedTest
    @DisplayName("인덱스가 객체 범위를 초과한 경우, 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 2})
    void 맴버_인덱스_범위초과(int index) {
        assertThatThrownBy(() -> ms1.getMember(index))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인덱스에 대한 맴버 객체를 반환한다.")
    void 맴버_반환() {
        assertThat(ms1.getMember(0)).isEqualTo(m1);
    }

    @Test
    @DisplayName("맴버에 대한 사이즈를 반환한다.")
    void 맴버_사이즈() {
        assertThat(ms1.getSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("멤버에 이름 중복이 있을 경우, 예외를 발생시킨다.")
    void 맴버_중복() {
        assertThatThrownBy(() -> new Members(List.of(m2, m3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
