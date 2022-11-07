package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {
    @DisplayName("사람 수와 높이에 맞는 사다리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = { "4,5", "1,2" }, delimiter = ',')
    void lines(int countOfPerson, int height) {
        assertThat(createLadder(countOfPerson, height).getLines()).hasSize(height);
    }

    @DisplayName("사람 수가 1보다 작으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -10 })
    void constructor_when_invalid_count_of_people(int countOfPerson) {
        assertThatThrownBy(() -> createLadder(countOfPerson, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of people is greater than 1.");
    }

    @DisplayName("높이가 1보다 작으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -10 })
    void constructor_when_invalid_height(int height) {
        assertThatThrownBy(() -> createLadder(3, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of height is greater than 1.");
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
