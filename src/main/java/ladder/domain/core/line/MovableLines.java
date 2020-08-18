package ladder.domain.core.line;

import java.util.ArrayList;
import java.util.List;

public class MovableLines {
    static List<Integer> getLinePathResult(List<MovableLine> lines, int startIndex) {
        int size = lines.size();

        List<Integer> result = new ArrayList<>(size);
        result.add(lines.get(0).move(startIndex));
        for (int i = 1; size > i; ++i) {
            MovableLine line = lines.get(i);
            result.add(line.move(result.get(i-1)));
        }

        return result;
    }
}
