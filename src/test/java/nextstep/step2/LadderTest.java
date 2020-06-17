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

//    @ParameterizedTest
//    @ValueSource(ints = {3, 4, 5, 6})
//    @DisplayName("사다리 높이 입력받아서 사다리 값 셋팅되는지 테스트")
//    void inputLadderHeightValueTest(int inputLadderHeight) {
//        Ladder ladder = new Ladder(inputLadderHeight);
//        List<List<Boolean>> ladders = ladder.getLadders();
//        assertThat(ladders).hasSize(inputLadderHeight);
//    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("사다리타기 참여자, 사다리 높이 입력받아서 참여자 x 사다리높이 만큼 셋팅되는지 테스트")
    void inputNamesAndLadderHeightTest(int inputLadderHeight) {
        String names = "pobi,honux,crong,jk";
        Ladder ladder = new Ladder(names, inputLadderHeight);
        int joinedPeopleCount = ladder.getNames().size();
        List<List<Boolean>> ladders = ladder.getLadders();
        assertThat(ladders).hasSize(inputLadderHeight);
        ladders.forEach(booleans -> assertThat(booleans).hasSize(joinedPeopleCount));

    }

}
