
import domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    private Random random;

    @BeforeEach
    void setUp() {
        random = new Random();
    }

    @Test
    void getNextPosition_whenOnBridge_movesRight() {
        int width = 5;
        Line line = Line.generate(width, random);
        int position = 2; // 중간 위치에서 시작
        assertTrue(line.getNextPosition(position) == position + 1 || line.getNextPosition(position) == position);
    }

    @Test
    void getNextPosition_whenOnLeftBridge_movesLeft() {
        int width = 5;
        Line line = Line.generate(width, random);
        int position = 1; // 왼쪽 끝에서 시작
        assertTrue(line.getNextPosition(position) == position - 1 || line.getNextPosition(position) == position);
    }

    @Test
    void move_whenOnBridge_movesCorrectly() {
        int width = 5;
        Line line = Line.generate(width, random);
        int position = 2;
        int nextPosition = line.move(position);
        assertTrue(nextPosition == position + 1 || nextPosition == position);
    }

    @Test
    void toString_outputsCorrectStringRepresentation() {
        int width = 5;
        Line line = Line.generate(width, random);
        String result = line.toString();
        assertNotNull(result);
        assertTrue(result.contains("|-----") || result.contains("|    "));
    }
}