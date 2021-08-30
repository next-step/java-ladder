package nextstep.ladder.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ResultsTest {

    @Test
    @DisplayName("플레이어 수와 실행결과수가 다른 경우")
    public void invalidResultCount() {
        // given
        Players players = new Players("a,b,c");
        String message = String.format("실행 결과 개수는 참여자 수와 같아야 합니다 (플레이어수: %d / 실행 결과 수: %d)", 3, 2);

        // when
        ThrowableAssert.ThrowingCallable throwingCallable;
        throwingCallable = () -> new Results(players, "1,2");

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getResultNames 테스트")
    public void getResultNames() {
        // given
        Results results = new Results(new Players("a,b,c,d"), "꽝,5000,꽝,3000");

        // when
        List<String> resultNames = results.getResultNames();

        // then
        assertThat(resultNames).containsExactly("꽝", "5000", "꽝", "3000");
    }

}