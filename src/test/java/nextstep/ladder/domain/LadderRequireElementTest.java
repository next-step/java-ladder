package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:55
 */
public class LadderRequireElementTest {
    @Test
    void 생성() {
        List<String> participant = Arrays.asList("kim", "park", "lee");
        List<String> executeResult = Arrays.asList("꽝", "5000", "10000");
        LadderRequireElement ladderRequireElement = new LadderRequireElement(participant, executeResult);
        assertThat(ladderRequireElement).isEqualTo(new LadderRequireElement(participant, executeResult));
    }

    @Test
    void 참여자_실행결과_수가_다른경우_테스트() {
        assertThatThrownBy(() -> {
            List<String> participant = Arrays.asList("kim", "park");
            List<String> executeResult = Arrays.asList("꽝", "5000", "10000");
            LadderRequireElement ladderRequireElement = new LadderRequireElement(participant, executeResult);
        }).isInstanceOf(InputMismatchException.class);
    }
}
