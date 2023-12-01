package nextstep.ladder.domain;

import nextstep.ladder.domain.line.RowLinePositions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("가로 선 위치 테스트")
public class RowLinePositionsTest {

    @DisplayName("가로선의 위치가 연속적으로 true인지 확인한다.")
    @Test
    void printRowLinePositionsList() {
        System.out.println("START");
        RowLinePositions positions = new RowLinePositions(3);
        positions.getPositionList()
                .stream()
                .forEach(element -> System.out.println("result : " + element));
        System.out.println("END");
    }

    @DisplayName("모든 값이 거짓일 때 참을 반환한다.")
    @Test
    void lastCheck() {
        List<Boolean> givenValues = Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
        boolean result = givenValues.stream()
                .allMatch(e -> e.equals(Boolean.FALSE));
        Assertions.assertThat(result).isTrue();
    }
}
