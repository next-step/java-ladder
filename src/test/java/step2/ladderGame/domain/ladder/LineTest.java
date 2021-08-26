package step2.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.ladderGame.domain.ladder.pointGenerationStrategy.LadderRandomGenerationStrategy;

import java.util.List;

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
//        Line preLine = new Line(5);
//        assertThat(new Line(5, new LadderRandomGenerationStrategy(), preLine)).isInstanceOf(Line.class);

        Line line1 = new Line(5);
        Line line2 = new Line(5, new LadderRandomGenerationStrategy(), line1);
        Line line3 = new Line(5, new LadderRandomGenerationStrategy(), line2);
        Line line4 = new Line(5, new LadderRandomGenerationStrategy(), line3);

        List<Point> points1 = line1.getPoints();
        List<Point> points2 = line2.getPoints();
        List<Point> points3 = line3.getPoints();
        List<Point> points4 = line4.getPoints();

        for (Point point : points1) {
            System.out.print(point.getStatus() + " | ");
        }
        System.out.println();
        for (Point point : points2) {
            System.out.print(point.getStatus() + " | ");
        }
        System.out.println();
        for (Point point : points3) {
            System.out.print(point.getStatus() + " | ");
        }
        System.out.println();
        for (Point point : points4) {
            System.out.print(point.getStatus() + " | ");
        }
    }

}
