package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@ToString
@EqualsAndHashCode
@Setter // 테스트 코드 하려고 넣었습니다..ㅠㅠ
public class Ladder {
    public static final int MIN_FLOOR = 2;
    private List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        validateHeight(height);
        initLine(countOfPerson, height);
    }

    private void validateHeight(int height) {
        if(height < MIN_FLOOR) {
            throw new IllegalArgumentException("적어도 2층정돈 해줘야죠ㅠㅠ");
        }
    }

    private void initLine(int countOfPerson, int height) {
        IntStream.range(0, height).forEach(count -> lines.add(new Line(countOfPerson)));
    }

    // TODO :  여기는 람다를 어떻게 써야할 지 모르겠습니다..
    // 람다를 쓰면 pointIndex가 final이지 않으면 안된다고 하고... 묘수 없을런지요??ㅠㅠ
    public int move(int index) {
        int pointIndex = index;
//        IntStream.range(0, lines.size()).forEach(lineIndex -> pointIndex = lines.get(lineIndex).movePoint(index));
        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            pointIndex = lines.get(lineIndex).movePoint(pointIndex);
        }
        return pointIndex;
    }
}
