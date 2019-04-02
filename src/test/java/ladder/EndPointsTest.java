package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EndPointsTest {
    @Test
    public void 엔드포인트4개_입력() {
        // given
        String names = "몽총이,멍충이,바보,천재";
        // when
        EndPoints endPoints = new EndPoints(names);
        // then
        assertThat(endPoints.getCount()).isEqualTo(4);
    }
}
