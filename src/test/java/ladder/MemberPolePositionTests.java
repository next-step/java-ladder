package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 라인 별 멤버 위치 테스트")
public class MemberPolePositionTests {

    @DisplayName("생성 테스트")
    @Test
    public void generateMemberPolePositionTest () {
        assertThatCode(MemberPolePosition.newInstance("pobi, jk, crong, honux")).doesNotThrowAnyException();
    }

    @DisplayName("생성 비정상 테스트")
    @NullAndEmptySource
    @ParameterizedTest
    public void generateAbnormalMemberPolePositionTest (String[] input) {
        assertThatIllegalArgumentException()
                .isThrownBy(MemberPolePosition.newInstance(input))
                .withMessageContaining("Member pole position size must greater than zero.");
    }
}
