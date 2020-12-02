package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameResultsTest {

    @Test
    void test_create_success() {
        // Given
        List<String> inputs = Arrays.asList("꽝");
        GameResults gameResults = null;

        // When
        gameResults = new GameResults(inputs);

        // Then
        assertNotNull(gameResults);
    }

    @ParameterizedTest
    @EmptySource
    void test_create_fail_empty(String input) {
        assertThrows(IllegalArgumentException.class
                , () -> new GameResults(Arrays.asList(input)));
    }
    @ParameterizedTest
    @NullSource
    void test_create_fail_null(String input) {
        assertThrows(IllegalArgumentException.class
                , () -> new GameResults(Arrays.asList(input)));
    }

    @Test
    void test_getGameResult() {
        // Given
        GameResults gameResults = new GameResults(Arrays.asList("꽝"));
        
        // When
        String gameResult = gameResults.getGameResult(1);
        
        assertEquals(gameResult, "꽝");
    }

}