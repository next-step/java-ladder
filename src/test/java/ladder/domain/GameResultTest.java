package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {

    @Test
    @DisplayName("결과 보고싶은 유저 이름 입력 시 결과가 반환된다.")
    void findOne() {
        List<UserRecord> userRecords = Arrays.asList(
                new UserRecord("a", "1"),
                new UserRecord("b", "2"),
                new UserRecord("c", "3")
        );

        GameResult gameResult = new GameResult(userRecords);

        List<String> results = gameResult.findOutcome("a");

        assertThat(results).hasSize(1);
        assertThat(results.get(0)).isEqualTo("1");
    }

    @Test
    @DisplayName("all 입력 시 전체 결과가 반환된다.")
    void findAll() {
        List<UserRecord> userRecords = Arrays.asList(
                new UserRecord("a", "1"),
                new UserRecord("b", "2"),
                new UserRecord("c", "3")
        );

        GameResult gameResult = new GameResult(userRecords);

        List<String> results = gameResult.findOutcome("all");

        assertThat(results).hasSize(3);
        assertThat(results.get(0)).isEqualTo("a : 1");
    }

    @Test
    @DisplayName("결과를 찾을 수 없는 유저 입력 시 에러 반환")
    void findOneThrowException() {
        List<UserRecord> userRecords = Arrays.asList(
                new UserRecord("a", "1"),
                new UserRecord("b", "2"),
                new UserRecord("c", "3")
        );

        GameResult gameResult = new GameResult(userRecords);


        assertThatThrownBy(() -> {
            gameResult.findOutcome("d");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과를 찾을 수 없습니다.");
    }
}
