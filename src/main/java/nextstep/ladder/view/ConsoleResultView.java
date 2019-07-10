package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.formatter.Formatter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConsoleResultView implements ResultView {
    private static final int MARGIN = 4;
    private static final int LENGTH_NAME = 5;
    private static final String MARGIN_LADDER = " ";
    private static final String DELIMITER = "\n";
    private static final String MARGIN_NAME = " ";
    private static final String DELIMITER_NAMES = " ";
    private static final String MESSAGE_FOR_RESULT = "\n실행결과\n";

    private final Formatter<Ladder> ladderFormatter;

    public ConsoleResultView(final Formatter<Ladder> ladderFormatter) {
        this.ladderFormatter = ladderFormatter;
    }

    @Override
    public void print(final List<String> names, final Ladder ladder) {
        final String formattedNames = this.formatNames(names);
        final String formattedLadder = ladderFormatter.format(ladder);
        final String result = this.addMargin(formattedLadder, MARGIN);

        System.out.println(MESSAGE_FOR_RESULT);
        System.out.println(formattedNames);
        System.out.println(result);
    }

    private String formatNames(final List<String> names) {
        return names.stream()
                .map(this::formatName)
                .collect(Collectors.joining(DELIMITER_NAMES));
    }

    private String formatName(final String name) {
        final StringBuilder stringBuilder = new StringBuilder(name);
        while (stringBuilder.length() < LENGTH_NAME) {
            stringBuilder.insert(0, MARGIN_NAME);
        }
        return stringBuilder.toString();
    }

    private String addMargin(final String target, final int margin) {
        final String marginString = IntStream.range(0, margin)
                .mapToObj(number -> MARGIN_LADDER)
                .collect(Collectors.joining());
        return Stream.of(target.split(DELIMITER))
                .map(string -> marginString + string)
                .collect(Collectors.joining(DELIMITER));
    }
}
