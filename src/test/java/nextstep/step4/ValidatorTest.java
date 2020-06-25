package nextstep.step4;

import nextstep.step4.domain.User;
import nextstep.step4.resource.LadderStringResource;
import nextstep.step4.utils.LadderUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Validator 테스트")
class ValidatorTest {

    private Validator validator = new Validator();

    @DisplayName("사다리 높이 체크 - 성공")
    @ParameterizedTest
    @ValueSource(ints = {10,9,30,20})
    void checkLadderHeight_성공(int height) {
        assertThat(validator.checkLadderHeight(height)).isEqualTo(height);
    }

    @DisplayName("사다리 높이 체크 - 실패")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -999})
    void checkLadderHeight_실패(int height) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkLadderHeight(height))
                .withMessage(LadderStringResource.LADDER_HEIGHT_EXCEPTION_TEXT);
    }

    @DisplayName("유저이름 길이 체크 - 성공")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"nm1,nm2,nm3:3", "name1,name2,name3,name4:4"})
    void checkUserNameLength_성공(String names, int namesSize) {
        assertThat(validator.checkUserNameLength(LadderUtils.splitString(names)).size()).isEqualTo(namesSize);
        assertThat(validator.checkUserNameLength(LadderUtils.splitString(names))).isNotEmpty();
        assertThat(validator.checkUserNameLength(LadderUtils.splitString(names)).get(0)).isInstanceOf(String.class);
    }

    @DisplayName("유저이름 길이 체크 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"name01,name02,name03", "userNames1,userNames2,userNames3"})
    void checkUserNameLength_실패(String names) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkUserNameLength(LadderUtils.splitString(names)))
                .withMessage(LadderStringResource.USER_NAME_EXCEPTION_TEXT);
    }

    @DisplayName("실행결과 입력 체크 - 성공")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"name1,name2,name3:100,꽝,5000","name1,name2:꽝,5000"})
    void checkPlayResult_성공(String names, String results) {
        List<String> userNames = validator.checkUserNameLength(LadderUtils.splitString(names));
        List<String> playResult = LadderUtils.splitString(results);

        assertThat(validator.checkPlayResult(userNames, playResult)).isEqualTo(playResult);
    }

    @DisplayName("실행결과 입력 체크 - 실패(빈값)")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"name1,name2,name3:100,,5000","name1,name2:,꽝"})
    void checkPlayResult_실패1(String names, String results) {
        List<String> userNames = validator.checkUserNameLength(LadderUtils.splitString(names));
        List<String> playResult = LadderUtils.splitString(results);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkPlayResult(userNames, playResult))
                .withMessage(LadderStringResource.PLAY_RESULT_BLANK_EXCEPTION);
    }

    @DisplayName("실행결과 입력 체크 - 실패(길이)")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"name1,name2,name3:100,5000","name1,name2:꽝"})
    void checkPlayResult_실패2(String names, String results) {
        List<String> userNames = validator.checkUserNameLength(LadderUtils.splitString(names));
        List<String> playResult = LadderUtils.splitString(results);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkPlayResult(userNames, playResult))
                .withMessage(LadderStringResource.PLAY_RESULT_LENGTH_EXCEPTION);
    }

    @DisplayName("결과 확인을 위한 유저 입력값 체크 - 성공")
    @ParameterizedTest
    @ValueSource(strings = {"a","b","c","all"})
    void checkUserNameForResult_성공(String name) {
        Map<String, User> resultMap = new HashMap<>();
        resultMap.put("a", new User("a", "1등"));
        resultMap.put("b", new User("b", "2등"));
        resultMap.put("c", new User("c", "3등"));

        assertThat(validator.checkUserNameForResult(name, resultMap)).isEqualTo(name);
    }

    @DisplayName("결과 확인을 위한 유저 입력값 체크 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"e","f","g"})
    void checkUserNameForResult_실패(String name) {
        Map<String, User> resultMap = new HashMap<>();
        resultMap.put("a", new User("a", "1등"));
        resultMap.put("b", new User("b", "2등"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validator.checkUserNameForResult(name, resultMap))
                .withMessage(LadderStringResource.USER_NAME_FOR_RESULT_EXCEPTION);
    }
}
