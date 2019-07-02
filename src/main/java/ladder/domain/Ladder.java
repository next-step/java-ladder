package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
코드를 작성하다 보니 Ladder VerticalLines 와 HorizontalLines 가 하는일이 거의 중복되어서 VerticalLines 를 삭제할 예정입니다.
수정하게 되면 List 로 VerticalLines 가 아닌 HorizontalLines 를 사용할것 같습니다.
그런데 이처럼 List<VerticalLines> 로 갖고 있는게 옳은 방법인지 햇갈립니다.
이것도 다시한번 클래스로 랩핑 하여 랩핑된 클래스를 자료형으로 갖고 있어야 할까요?
 */
public class Ladder {
    private final List<VerticalLines> levels;

    public Ladder(int verticalLineQuantity, int verticalLineHeight) {
        List<VerticalLines> verticalLines = new ArrayList<>();
        // 이와 같은 for 문은 Stream 을 이용하는 좋은 방법이 있을까요?
        for (int i = 0; i < verticalLineHeight; i++) {
            verticalLines.add(new VerticalLines(verticalLineQuantity));
        }
        this.levels = verticalLines;
    }

    private Ladder(List<VerticalLines> levels) {
        this.levels = levels;
    }

    public static Ladder of(List<HorizontalLines> horizontalLinesList) {
        return new Ladder(
                horizontalLinesList.stream()
                        .map(VerticalLines::of)
                        .collect(Collectors.toList())
        );
    }

    public VerticalLines verticalLinesByLevel(int level) {
        return levels.get(level);
    }

    public HorizontalLines horizontalLinesByLevel(int level) {
        return HorizontalLines.of(verticalLinesByLevel(level));
    }

    public int height() {
        return levels.size();
    }
}
