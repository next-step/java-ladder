package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HorizontalLines {
    private final List<HorizontalLine> horizontalLines;

    private HorizontalLines(List<HorizontalLine> horizontalLines) {
        /*
        if (!isValid()) {
            throw new IllegalArgumentException("유효하지 않은 HorizontalLines 입니다");
        }
        */
        this.horizontalLines = horizontalLines;
    }

    /*
    이쪽의 private 메서드들을 통해서, 주어진 HorizontalLines 가 모두 valid 한지 검사하고 싶습니다.
    그런데 람다를 사용하려니, index 를 사용할 수 없어서 특정 위치의 HorizontalLine 이 이웃한 라인이 있는지 없는지
    체크하기가 어려운것 같습니다.
    indexOf 로 위치를 찾아보려 했으나, 정적 팩토리 메서드 사용으로 인해 true 인 HorizontalLine 은
    모두 같은 인스턴스이기 때문에 찾을 수 없는것 같습니다.
    자바에 익숙하지 못하여 제대로 사용하지 못하고 있는것 같은데 뭔가 좋은 방법이 없는지 궁금합니다..
     */
    private static boolean hasNeighborLine(List<HorizontalLine> horizontalLines, int index) {
        if (index < 0 || index > horizontalLines.size()) {
            throw new IllegalArgumentException("올바르지 않은 index 값입니다.");
        }
        int nextIndex = index + 1;
        int previousIndex = index - 1;

        if (index < 1) {
            return horizontalLines.get(nextIndex).hasLine();
        }

        if (index == horizontalLines.size() - 1) {
            return horizontalLines.get(previousIndex).hasLine();
        }

        return horizontalLines.get(previousIndex).hasLine()
                && horizontalLines.get(nextIndex).hasLine();
    }

    private boolean isValid() {
        return isFirstLineFalse() && allHorizontalLineLineHasNoNeighborLine();
    }

    private boolean isFirstLineFalse() {
        return horizontalLines.get(0).hasLine();
    }

    private boolean allHorizontalLineLineHasNoNeighborLine() {
        boolean valid = true;
        for (int i = 0; i < horizontalLines.size(); i++) {
            boolean inValid = HorizontalLines.hasNeighborLine(horizontalLines, i);
            if (inValid) {
                valid = false;
            }
        }
        return valid;
    }

    public static HorizontalLines of(VerticalLines verticalLines) {
        List<HorizontalLine> horizontalLines = verticalLines.getVerticalLines().stream()
                .map(VerticalLine::getLeftHorizontalLine)
                .collect(Collectors.toList());
        return new HorizontalLines(horizontalLines);
    }

    public static HorizontalLines of(List<Boolean> booleans) {
        List<HorizontalLine> horizontalLines = booleans.stream()
                .map(HorizontalLine::of)
                .collect(Collectors.toList());
        return new HorizontalLines(horizontalLines);
    }

    public int size() {
        return horizontalLines.size();
    }

    public List<HorizontalLine> getHorizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }
}
