package ladder.domain;

import ladder.domain.result.Result;
import ladder.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("사다리게임 결과 테스트")
class LadderGameResultTest {

    LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        Map<User, Result> resultMap = new HashMap<>();
        resultMap.put(User.valueOf("user1"), Result.valueOf("100"));
        resultMap.put(User.valueOf("user2"), Result.valueOf("1000"));
        resultMap.put(User.valueOf("user3"), Result.valueOf("0"));
        ladderGameResult = new LadderGameResult(resultMap);
    }

    @Test
    @DisplayName("전체 참여자 조회하는 키워드 입력인지 확인")
    void inputFindAllKeywordCheck() {
        // given
        // when
        boolean actual = ladderGameResult.isShowAll(LadderGameResult.FINISH_STRING);

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"user1=100", "user2=1000", "user3=0"}, delimiter = '=')
    void matchLadderGameResult(String userName, Result result) {
        // given
        // when
        Result actual = ladderGameResult.getLadderGameResult(userName);

        // then
        assertThat(actual).isEqualTo(result);
    }

    @Test
    void matchLadderGameResults() {
        // given
        Map<User, Result> ladderGameResults = ladderGameResult.getLadderGameResults();

        // when
        // then
        assertAll(
                () -> assertThat(ladderGameResults.get(User.valueOf("user1"))).isEqualTo(Result.valueOf("100")),
                () -> assertThat(ladderGameResults.get(User.valueOf("user2"))).isEqualTo(Result.valueOf("1000")),
                () -> assertThat(ladderGameResults.get(User.valueOf("user3"))).isEqualTo(Result.valueOf("0"))
        );
    }
}