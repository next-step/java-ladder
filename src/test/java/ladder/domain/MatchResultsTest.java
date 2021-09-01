package ladder.domain;

import ladder.exception.NotFoundUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchResultsTest {
    private List<Result> results = new ArrayList<>();

    @BeforeEach
    void setUp() {
        User a = new User("a");
        User b = new User("b");
        User c = new User("c");

        WinningItem one = new WinningItem("1");
        WinningItem two = new WinningItem("2");
        WinningItem three = new WinningItem("3");

        results.add(new Result(a, one));
        results.add(new Result(b, two));
        results.add(new Result(c, three));
    }

    @Test
    @DisplayName("MatchResults 생성 테스트")
    void createMatchResults() {
        MatchResults matchResults = new MatchResults(results);
        assertThat(matchResults.getResults()).isEqualTo(results);
    }

    @Test
    @DisplayName("찾는 유저가 없을때, NotFoundUserException")
    void notFoundUser() {
        User user = new User("no");
        MatchResults matchResults = new MatchResults(results);
        assertThatThrownBy(() -> matchResults.resultToUser(user))
                .isInstanceOf(NotFoundUserException.class);
    }
}