package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {
    @DisplayName("사람 수와 높이에 맞는 사다리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = { "4,5", "1,2" }, delimiter = ',')
    void lines(int countOfPerson, int height) {
        assertThat(createLadder(countOfPerson, height).getLines()).hasSize(height);
    }

    @DisplayName("사람 수 또는 높이가 1보다 작으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = { "0,5", "1,-1", "-1,0" }, delimiter = ',')
    void constructor_when_invalid_value(int countOfPerson, int height) {
        assertThatThrownBy(() -> createLadder(countOfPerson, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of people or height is greater than 1.");
    }

    private static Ladder createLadder(int countOfPerson, int height) {
        List<User> users = copies(countOfPerson, () -> new User("name"));
        return Ladder.of(new Users(users), height, new Results(2, copies(2, () -> "result")));
    }
    
    private static <T> List<T> copies(int count, Supplier<T> item) {
        if (count < 1) {
            return Collections.emptyList();
        }
        return Collections.nCopies(count, item.get());
    }
}
