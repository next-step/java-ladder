package nextstep.ladder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class ResultView {
    public static final String BLANK = " ";
    public static final String POLE = "|";
    public static final String RUNG = "-";
    public static final int NAME_SPACE = 5;
    private final PrintWriter out;

    public ResultView(StringWriter out) {
        this.out = new PrintWriter(out);
    }

    public void printLadder(Line line) {
        print(times(BLANK, 4));
        line.toSpokeStream()
                .map(spokeExists -> {
                    if (spokeExists) {
                        return makeRung();
                    }
                    return makeEmptyRung();
                })
                .map(this::withPole)
                .forEach(this::print);
        println("|");
    }

    public void printLadders(List<Line> lines) {
        lines.forEach(this::printLadder);
    }

    public void printNames(List<String> names) {
        println(
                names.stream()
                        .map(name -> String.format("%" + NAME_SPACE + "s", name))
                        .collect(joining(" "))
        );
    }

    private String withPole(String rung) {
        return POLE + rung;
    }

    private String makeEmptyRung() {
        return times(BLANK, NAME_SPACE);
    }

    private String makeRung() {
        return times(RUNG, NAME_SPACE);
    }

    private void println(String string) {
        out.println(string);
    }

    private void print(String string) {
        out.print(string);
    }

    static String times(String string, int repeat) {
        return IntStream.range(0, repeat).mapToObj(__ -> string).collect(joining());
    }
}
