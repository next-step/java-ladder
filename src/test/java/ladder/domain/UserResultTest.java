package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserResultTest {
    @Test
    @DisplayName("userResult 객체를 비교하면 startIndex 에 따라 정렬된다 - 1")
    void compareTo_ReturnsNegative() {
        UserResult userResult1 = new UserResult(1, "Alice", "Win");
        UserResult userResult2 = new UserResult(2, "Bob", "Lose");

        int comparisonResult = userResult1.compareTo(userResult2);

        assertThat(comparisonResult).isLessThan(0);
    }

    @Test
    @DisplayName("userResult 객체를 비교하면 startIndex 에 따라 정렬된다 - 2")
    void compareTo_ReturnsZero() {
        UserResult userResult1 = new UserResult(1, "Alice", "Win");
        UserResult userResult2 = new UserResult(1, "Bob", "Lose");

        int comparisonResult = userResult1.compareTo(userResult2);

        assertThat(comparisonResult).isEqualTo(0);
    }

    @Test
    @DisplayName("userResult 객체를 비교하면 startIndex 에 따라 정렬된다 - 3")
    void compareTo_ReturnsPositive() {
        UserResult userResult1 = new UserResult(3, "Charlie", "Win");
        UserResult userResult2 = new UserResult(2, "Bob", "Lose");

        int comparisonResult = userResult1.compareTo(userResult2);

        assertThat(comparisonResult).isGreaterThan(0);
    }
}
