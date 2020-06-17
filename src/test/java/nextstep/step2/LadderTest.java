package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 클래스 테스트")
public class LadderTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi","honux","crong","jk"})
    @DisplayName("이름을 입력받아 확인하는 테스트")
    void inputStringNameTest(String name) {
        String names = "pobi,honux,crong,jk";
        Ladder ladder = new Ladder(names);
        List<String> nameList = ladder.getNames();
        assertThat(nameList).contains(name);
    }

    @Test
    @DisplayName("이름이 5자가 넘으면 에러가 나는 테스트")
    void validateNameLengthTest() {
        String names = "pobi12,honux1,crong1,jk1234";
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(names));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("사다리 높이 입력받아서 사다리 값 셋팅하기")
    void inputLadderHeightValueTest(int inputLadderHeight) {
        Ladder ladder = new Ladder(inputLadderHeight);
        List<Boolean> ladders = ladder.getLadders();
        assertThat(ladders).hasSize(inputLadderHeight);
    }

}
