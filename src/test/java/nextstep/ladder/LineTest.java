package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LineTest {

    @Test
    @DisplayName("사다리 가로줄 담당 역할 생성")
    void createLine() {
        List<Connection> connectionList = Arrays.asList(new Connection(0), new Connection(2));
        Line line = new Line(connectionList, 3);
    }
}
