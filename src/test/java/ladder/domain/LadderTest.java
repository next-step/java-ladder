package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

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
        Lines lines = Ladder.createLines(countOfPerson,1,() -> true);
        Line actual = lines.getLines().get(0);

        List<Boolean> pointList = Arrays.stream(points.split(","))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());
        Line expected = new Line(pointList);

        assertThat(actual).isEqualTo(expected);
    }
}
