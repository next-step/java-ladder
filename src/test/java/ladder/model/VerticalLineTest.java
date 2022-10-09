package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class VerticalLineTest {

    @Test
    void shouldMapToVertical() {
        HorizontalLine horizontalLine = new HorizontalLine(List.of(new LineUnit()));

        VerticalLine verticalLine = VerticalLine.mapHorizontalLineToVertical(List.of(horizontalLine), 0);

        assertThat(verticalLine.getLineUnits().size()).isEqualTo(1);
    }

}
