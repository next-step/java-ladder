package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    static class TestLineFactory implements LineFactory {

        int size;

        public TestLineFactory(int size) {
            this.size = size;
        }

        @Override
        public List<Line> generateLines(Point point) {
            ArrayList<Line> lines = new ArrayList<>();
            for(int i =0; i < size; i++){
                lines.add(new Line());
            }
            return lines;
        }
    }

    @ParameterizedTest
    @DisplayName("라인들은 사다리 높이 개만큼 존재(5 => 5)")
    @ValueSource(ints = {5, 6})
    void lines_size(int heightSize) {
        Lines lines = new Lines(new TestLineFactory(heightSize), new Participant("a,b"));
        assertThat(lines).isEqualTo(new Lines(generateLineBySize(heightSize)));
    }

    private List<Line> generateLineBySize(int size){
        ArrayList<Line> lines = new ArrayList<>();
        for(int i =0; i < size; i++){
            lines.add(new Line());
        }
        return lines;
    }
}
