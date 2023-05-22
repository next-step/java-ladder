package nextstep.ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Line {

    private List<Boolean> bridges = new ArrayList<>();

    public static Line createLine(int countOfPerson, BridgeStrategy strategy) {
        Line line = new Line(countOfPerson, strategy);
        validate(line);
        return line;
    }

    private static void validate(Line line) {
        if (line.isInvalidBridge()) {
            throw new RuntimeException("올바르지 않은 라인입니다.");
        }
    }

    private Line(int countOfPerson, BridgeStrategy strategy) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            Optional<Integer> prevIndex = Optional.ofNullable(i)
                    .map(o -> o - 1);

            Boolean expected = build(strategy);
            bridges.add(decide(prevIndex, expected));
        }
    }

    private static Boolean build(BridgeStrategy strategy) {
        return strategy.bridgeBuild();
    }

    private Boolean decide(Optional<Integer> prevIndex, Boolean expected) {
        return prevIndex.filter(i -> i >= 0)
                .map(i -> bridges.get(i))
                .map(b -> Boolean.TRUE.equals(b) ? Boolean.valueOf(false) : expected)
                .orElse(expected);
    }

    public int getNextPosition(int position) {
        // bridges[position - 1] == T 이면 왼쪽으로
        Boolean toLeft = ableToLeft(position);

        // bridges[position] == T 이면 오른쪽으로
        Boolean toRight = ableToRight(position);

        if (toLeft && toRight) {
            throw new RuntimeException("사다리 상태를 다시 확인해주세요.");
        }

        if (toLeft) {
            return position - 1;
        }

        if (toRight) {
            return position + 1;
        }

        return position;
    }

    public Boolean ableToRight(int position) {
        return Optional.ofNullable(position)
                .filter(o -> o < bridges.size())
                .map(o -> bridges.get(o))
                .filter(b -> b)
                .orElse(false);
    }

    public Boolean ableToLeft(int position) {
        return Optional.ofNullable(position)
                .map(o -> o - 1)
                .filter(o -> o >= 0)
                .map(o -> bridges.get(o))
                .filter(b -> b)
                .orElse(false);
    }

    public boolean isValidBridge() {
        boolean valid = true;
        for (int i = 0; i < bridges.size(); i++) {
            if (ableToLeft(i) && ableToRight(i)) {
                valid = false;
            }
        }
        return valid;
    }
    public boolean isInvalidBridge() {
        return !isValidBridge();
    }


    public String status() {
        String result = "";
        for (Boolean bridge : bridges) {
            result += "|";
            result += bridge ? "-----" : "     ";
        }
        result += "|\n";
        return result;
    }
}
