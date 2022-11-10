package nextstep.ladder.view;

import static java.lang.System.*;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;
import nextstep.ladder.view.dto.LadderCreateResultDto;

public class ResultView {
    private static final String LADDER_CREATE_RESULT_TITLE = "실행 결과";
    private static final String LINE_BREAK = "\n";
    private static final String BLANK = " ";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";

    public void showLadderCreateResult(LadderCreateResultDto ladderCreateResultDto) {
        print(LADDER_CREATE_RESULT_TITLE);
        print(LINE_BREAK);

        print(makeNameString(ladderCreateResultDto.getNames()));
        print(LINE_BREAK);
        print(makeLadderString(ladderCreateResultDto.getLadder()));
    }

    private String makeNameString(Names names) {
        return names.getNames().stream()
            .map(name -> BLANK.repeat(Name.LENGTH_OF_NAME_MAX_VALUE - name.getName().length()) + name.getName())
            .collect(Collectors.joining(BLANK));
    }

    private String makeLadderString(Ladder ladder) {
        Lines lines = ladder.getLines();
        return lines.getLines().stream()
            .map(this::makeLineString)
            .collect(Collectors.joining(LINE_BREAK));
    }

    private String makeLineString(Line line) {
        List<Boolean> points = line.getPoints();
        return BLANK.repeat(Name.LENGTH_OF_NAME_MAX_VALUE) +
            VERTICAL_LINE +
            points.stream()
                .map(point -> Boolean.TRUE.equals(point) ? HORIZONTAL_LINE.repeat(Name.LENGTH_OF_NAME_MAX_VALUE) :
                    BLANK.repeat(Name.LENGTH_OF_NAME_MAX_VALUE))
                .collect(Collectors.joining(VERTICAL_LINE)) +
            VERTICAL_LINE;
    }

    private void print(String text) {
        out.print(text);
    }
}
