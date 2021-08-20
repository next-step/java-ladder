package nextstep.ladder.application;

import nextstep.ladder.domain.ladder.ColumnLine;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;

public class PlayLadder {

    public static Ladder playLadder(List<String> names, int height, List<String> results) {
        validateResultAndNameSize(results,names);
        List<ColumnLine> columnLines = createColumnLines(names.size(), height, results);
        Ladder ladder = new Ladder(height, columnLines);
        ladder.drawRowLines();
        return ladder;
    }

    private static void validateResultAndNameSize(List<String> results, List<String> names) {
        if (results.size() != names.size()) {
            throw new IllegalArgumentException("참여 인원수와 실행 결과 갯수 는 같아야 합니다.");
        }
    }

    public static List<ColumnLine> createColumnLines(int countOfUser, int height, List<String> results) {
        List<ColumnLine> columnLines = new ArrayList<>();
        for (int i = 0; i < countOfUser; i++) {
            columnLines.add(new ColumnLine(new Height(height), results.get(i)));
        }
        return columnLines;
    }
}
