package domain;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class StoryResultTest {

    @Test
    public void move() {
        // Given
        final int countOfUsers = 3;
        final Line line = new Line(Arrays.asList(true, false));
        final StoryResult storyResult = new StoryResult(
            IntStream
                .range(0, countOfUsers)
                .boxed()
                .collect(Collectors.toList()));

        // When
        StoryResult result = storyResult.move(line);

        // Then
        assertThat(result).isEqualTo(new StoryResult(Arrays.asList(1, 0, 2)));
    }
}