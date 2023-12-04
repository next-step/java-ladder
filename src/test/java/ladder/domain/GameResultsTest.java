package ladder.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameResultsTest {

    @Test
    void 입력한_실행_결과_갯수와_참여_인원수가_다르면_에러() {
        String[] inputResults = new String[]{"꽝", "5000", "꽝", "3000"};
        String[] memberNames = {"aaaa", "bbb", "ccc"};
        assertThatThrownBy(
            () -> new GameResults(inputResults, memberNames)).isInstanceOf(
            IllegalArgumentException.class).hasMessage("실행 결과 갯수는 참여 인원수와 동일해야합니다.");
    }
}
