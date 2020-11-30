package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {
            "5:true,false,true,false,false",
            "4:true,false,true,false",
            "3:true,false,false",
            "2:true,false"
    }, delimiter = ':')
    @DisplayName("이동가능 여부를 참으로 할 경우 결과값 확인(첫번째 무조건 true, 마지막 무조건 false)")
    void ladder_createLines(int countOfPerson, String points) {
        Lines lines = new LadderStub(countOfPerson,1).createLines();
        Line actual = lines.getLines().get(0);

        List<Boolean> pointList = Arrays.stream(points.split(","))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());
        Line expected = Line.of(pointList);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 높이값이 최소값에 못미치는 경우 IllegalArgumentException 발생")
    void ladder_heightValidation_ThrowArgumentException() {
        assertThatThrownBy(() -> new Ladder(5,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 최소 1개 이상");
    }
}
