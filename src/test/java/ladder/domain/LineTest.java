package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    @DisplayName("참여자 만큼 라인 포인트 생성")
    public void createLinePointTest(int countOfPerson) throws Exception {
        //given

        //when
        Line line = new Line(countOfPerson);
        int size = line.readOnlyPoints().size();

        //then
        assertThat(size).isEqualTo(countOfPerson);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1})
    @DisplayName("참여자 2명 미만 일시 에러")
    public void personTwoUnderException(int countOfPersion) throws Exception {
        //given

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(countOfPersion);
        });

        //then
    }
}
