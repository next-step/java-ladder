package camp.nextstep.edu.rebellion.view;

import java.util.Collections;
import java.util.List;

public class PrintableLadder {
    private final List<? extends PrintableHorizonLineResolver> lines;
    private final int sizeOfPoints;

    public PrintableLadder(List<? extends PrintableHorizonLineResolver> lines, int sizeOfPoints) {
        this.lines = lines;
        this.sizeOfPoints = sizeOfPoints;
    }

    public List<PrintableHorizonLineResolver> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getSizeOfPoints() {
        return sizeOfPoints;
    }
}
