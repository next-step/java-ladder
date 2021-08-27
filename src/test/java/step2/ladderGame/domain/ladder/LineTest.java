package step2.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineRandomGenerationStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LineTest {

    @DisplayName("생성")
    @Test
    void create_최초생성() {
        assertThat(new Line(5)).isInstanceOf(Line.class);
    }

    @DisplayName("추후생성")
    @Test
    void create_추후생성() {
        assertThat(new Line(5, new horizontalLineRandomGenerationStrategy())).isInstanceOf(Line.class);
    }

}
