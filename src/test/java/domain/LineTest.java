package domain;

import org.junit.Test;

public class LineTest {
    private Line line;

    @Test
    public void 라인_생성() {
        this.line = new Line(5);
        this.line.printLine();
    }

}
