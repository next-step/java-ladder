package nextstep.ladder.view;

import nextstep.ladder.dto.LadderElementsDto;

import java.text.MessageFormat;

import static java.util.stream.Collectors.joining;

public class LadderElementConsoleOutput {

    private static final String DELIMITER = " ";
    private static final String NEXT_LINE = "\n";
    private static final String NONE = "";

    public static void print(final LadderElementsDto ladderElementsDto, final int maxLength) {
        System.out.println(ladderElementsDto.getElements()
                .stream()
                .map(elementNames -> toName(maxLength, elementNames))
                .collect(joining(DELIMITER, NEXT_LINE, NONE)));
    }

    private static String toName(final int maxLength, final String elementNames) {
        String format = MessageFormat.format("%{0}s", maxLength);
        return String.format(format, elementNames);
    }
}
