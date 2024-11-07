package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {
    @Test
    @DisplayName("같은 높이에 참가자 수 만큼의 라인을 생성한다")
    void 같은_높이_참가자_수의_라인_생성() {
        Lines lines = new Lines(4);

        Assertions.assertThat(lines.getLineCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("홀수 라인 생성 테스트")
    /**
     * 홀수라인이라 하면은 콘솔 창으로 보이는 홀수라인을 의미한다
     * 즉 인덱스로는 짝수인 셈이다
     * 오른쪽으로 연결하므로 isRightConnect가 true여야 한다
     */
    void 홀수_라인_연결_테스트() {
        Lines lines = new Lines(4);

        lines.generateConnections(i -> true, i -> false);

        Line oddLine1 = lines.getLineOfSpecificLocation(0);
        Line oddLine2 = lines.getLineOfSpecificLocation(2);

        Assertions.assertThat(oddLine1.isRightConnected()).isTrue();
        Assertions.assertThat(oddLine2.isRightConnected()).isTrue();
    }

    @Test
    @DisplayName("짝수 라인 생성 테스트")
    /**
     * 짝수라인이라 하면은 콘솔 창으로 보이는 짝수라인을 의미한다
     * 즉 인덱스로는 홀수인 셈이다
     * 오른쪽으로 연결하므로 isRightConnect가 true여야 한다
     */
    void 짝수_라인_연결_테스트() {
        Lines lines = new Lines(5);

        lines.generateConnections(i -> false, i -> true);

        Line evenLine1 = lines.getLineOfSpecificLocation(1);
        Line evenLine2 = lines.getLineOfSpecificLocation(3);

        Assertions.assertThat(evenLine1.isRightConnected()).isTrue();
        Assertions.assertThat(evenLine2.isRightConnected()).isTrue();
    }
}
