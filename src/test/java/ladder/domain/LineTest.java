package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private Line line;

    @BeforeEach
    public void setUp(){
        line = new Line(4);
    }

    @DisplayName("입력받은 list만큼의  line생성")
    @Test
    public void createLines(){
        int userSize = 4;
        line = new Line(userSize);
        assertThat(line.getLineRow().size()).isEqualTo(userSize);

    }

    @DisplayName("랜덤으로 생성된 list사이즈 만큼의 line생성")
    @Test
    public void createLinesWithRandom(){
        MakeLineWithRandom makeLineWithRandom= new MakeLineWithRandom();

        List<Boolean> lines = new ArrayList<>();
        lines.add(makeLineWithRandom.createLine(false));
        lines.add(makeLineWithRandom.createLine(true));

    }

    @DisplayName("Line출력")
    @Test
    public void printLine(){
        System.out.println(line);
    }

}