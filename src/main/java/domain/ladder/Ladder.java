package domain.ladder;

import domain.player.Player;
import generator.bool.BooleansGenerator;
import generator.bool.impl.NonContinuousGenerator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class Ladder {

    private static final String BOUNDARY = "|";

    private static final String NOT_CONNECTED = " ";

    private static final String CONNECTED = "-";

    private final List<Boolean> lines;

    public Ladder(int length, BooleanSupplier booleanSupplier) {
        this.lines = Collections.unmodifiableList(createLines(length, booleanSupplier));
    }

    private List<Boolean> createLines(int length, BooleanSupplier booleanSupplier) {
        BooleansGenerator generator = new NonContinuousGenerator(booleanSupplier, true);

        List<Boolean> lines = new ArrayList<>();
        lines.add(Boolean.FALSE);
        lines.addAll(generator.generate(length - 1));

        return lines;
    }

    public int move(int lineIndex) {
        return Direction.generate(lines, lineIndex).move(lineIndex);
    }

    public String beautify() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.leftPad(BOUNDARY, Player.MAX_NAME_LENGTH))
                .append(convertLinesSkipFirst())
                .append(BOUNDARY);

        return sb.toString();
    }

    private String convertLinesSkipFirst() {
        return lines.stream()
                .skip(1)
                .map(line -> StringUtils.leftPad("",
                        Player.MAX_NAME_LENGTH, line == Boolean.FALSE ? NOT_CONNECTED : CONNECTED))
                .collect(Collectors.joining(BOUNDARY));
    }

    protected List<Boolean> getLines() {
        return this.lines;
    }
}
