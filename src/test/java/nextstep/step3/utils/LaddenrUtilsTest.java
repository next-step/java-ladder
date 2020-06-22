package nextstep.step3.utils;

import nextstep.step3.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Ladder 유틸")
class LadderUtilsTest {

    @DisplayName("문자열 분리")
    @Test
    void splitString() {
        String input = "a,b,c";
        assertThat(LadderUtils.splitString(input)).isEqualTo(Arrays.asList("a", "b", "C"));
    }

    @DisplayName("문자열 공백 체크")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {":true", "value:false", " :true"})
    void isBlank(String input, boolean result) {
        assertThat(LadderUtils.isBlank(input)).isEqualTo(result);
    }

    @DisplayName("사다리 결과 조합 체크")
    @Test
    void getMappingResult() {
        List<User> users = Arrays.asList(new User("name1"), new User("name2"), new User("name3"));
        List<String> playResult = Arrays.asList("1등", "꽝", "2등");
        List<Integer> ladderGameResult = Arrays.asList(2, 0, 1);

        Map<String, User> result = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            user.setResult(playResult.get(ladderGameResult.get(i)));
            result.put(user.getUserName(), user);
        }

        assertThat(LadderUtils.getMappingResult(users, playResult, ladderGameResult)).isEqualTo(result);
    }
}
