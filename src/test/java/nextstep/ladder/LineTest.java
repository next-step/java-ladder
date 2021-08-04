package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class LineTest {
    private static final Random random = new Random();
    @Test
    @DisplayName("사다리 줄 생성")
    void makeLineTest() {
        int height = 5;
        List<String> list = LadderMaker.of("pobi,honux,crong,jk");
        String line;

        for(int i = 0; i < height; i++) {
            line = Line.drawLine(list.size());
            System.out.println(line);
        }
    }

}
