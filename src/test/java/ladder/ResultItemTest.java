package ladder;

import ladder.domain.Players;
import ladder.domain.ResultItems;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ResultItemTest {
    @Test
    void Given_InsufficientInput_When_New_Then_Exception() {
        int numberOfPlayers = 4;
        List<String> items = Arrays.asList("1", "2", "3");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ResultItems(items, numberOfPlayers));
    }
}
