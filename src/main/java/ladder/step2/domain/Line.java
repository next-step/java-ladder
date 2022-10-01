package ladder.step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final String LINE_OVERLAPPING_EXCEPTION_MESSAGE = "부분 라인이 겹칩니다.";
    private static final String FIRST_PART_LINE_EXIST_EXCEPTION_MESSAGE = "첫번째 부분 라인이 존재합니다.";
    
    private final List<PartLine> partLines;
    
    public Line(List<PartLine> partLines) {
        checkPartLinesException(partLines);
        this.partLines = partLines;
    }
    
    private void checkPartLinesException(List<PartLine> partLines) {
        checkFirstPartLineExistException(partLines);
    
        for (int index = 0; index < partLines.size() - 1; index++) {
            checkPartLineOverlappingException(partLines, index);
        }
    }
    
    private void checkFirstPartLineExistException(List<PartLine> partLines) {
        if (partLines.get(0).equals(new PartLine(true))) {
            throw new IllegalArgumentException(FIRST_PART_LINE_EXIST_EXCEPTION_MESSAGE);
        }
    }
    
    private void checkPartLineOverlappingException(List<PartLine> partLines, int index) {
        if (partLines.get(index).equals(new PartLine(true)) && partLines.get(index + 1).equals(new PartLine(true))) {
            throw new IllegalArgumentException(LINE_OVERLAPPING_EXCEPTION_MESSAGE);
        }
    }
    
    @Override
    public String toString() {
        return partLines.stream()
                .map(PartLine::toString)
                .collect(Collectors.joining());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(partLines, line.partLines);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(partLines);
    }
}
