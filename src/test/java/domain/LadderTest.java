package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class LadderTest {

    @Test
    public void getResult_three_positions() {
        // Given
        final Line line1 = new Line(Arrays.asList(true, false));
        final Line line2 = new Line(Arrays.asList(false, true));
        final Line line3 = new Line(Arrays.asList(false, true));
        final Line line4 = new Line(Arrays.asList(false, true));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2, line3, line4));

        // When
        StoryResult storyResult = ladder.getResult();

        // Then
        assertThat(storyResult).isEqualTo(new StoryResult(Arrays.asList(2, 0, 1)));
    }

    @Test
    public void getResult_four_positions() {
        // Given
        final Line line1 = new Line(Arrays.asList(true, false, true));
        final Line line2 = new Line(Arrays.asList(false, true, false));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2));

        // When
        StoryResult storyResult = ladder.getResult();

        // Then
        assertThat(storyResult).isEqualTo(new StoryResult(Arrays.asList(2, 0, 3, 1)));
    }
}