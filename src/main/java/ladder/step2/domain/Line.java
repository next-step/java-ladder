package ladder.step2.domain;

import ladder.step2.dto.LineDTO;

import java.util.List;
import java.util.Objects;

public class Line {
    private static final String LINE_OVERLAPPING_EXCEPTION_MESSAGE = "부분 라인이 겹칩니다.";
    private static final String FIRST_PART_LINE_EXIST_EXCEPTION_MESSAGE = "첫번째 부분 라인이 존재합니다.";
    
    private final List<PartLine> partLines;
    
    public Line(List<PartLine> partLines) {
        checkFirstPartLineExistException(partLines);
        checkPartLinesOverlappingException(partLines);
        this.partLines = partLines;
    }
    
    private void checkFirstPartLineExistException(List<PartLine> partLines) {
        if (partLines.get(0).isExist()) {
            throw new IllegalArgumentException(FIRST_PART_LINE_EXIST_EXCEPTION_MESSAGE);
        }
    }
    
    private void checkPartLinesOverlappingException(List<PartLine> partLines) {
        for (int index = 0; index < partLines.size() - 1; index++) {
            checkPartLineOverlappingException(partLines, index);
        }
    }
    
    private void checkPartLineOverlappingException(List<PartLine> partLines, int index) {
        if (partLines.get(index).isExist() && partLines.get(index + 1).isExist()) {
            throw new IllegalArgumentException(LINE_OVERLAPPING_EXCEPTION_MESSAGE);
        }
    }
    
    public LineDTO lineInformation() {
        return new LineDTO(partLines);
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
