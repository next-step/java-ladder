package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class ResultView {
    public static final String BLANK = " ";
    public static final String POLE = "|";
    public static final String RUNG = "-";
    public static final int NAME_SPACE = 5;
    private final PrintWriter out;

    public ResultView(Writer out) {
        this.out = new PrintWriter(out, true);
    }

    public void printLadder(Ladder ladder) {
        println("실행결과");
        println("");
        printNames(ladder.getPlayers());
        ladder.forEach(this::printLine);
        printNames(ladder.getGoals());
    }

    public void printResult(Map<String, String> names) {
        println("실행 결과");
        names.forEach(this::printResult);
    }

    void printLine(Line line) {
        print(times(BLANK, 4));
        line.toSpokeStream()
                .map(this::makeRung)
                .map(this::withPole)
                .forEach(this::print);
        println("|");
    }

    void printNames(List<String> names) {
        println(
                names.stream()
                        .map(name -> String.format("%" + NAME_SPACE + "s", name))
                        .collect(joining(" "))
        );
    }

    private String makeRung(Boolean spokeExists) {
        if (spokeExists) {
            return makeRung();
        }
        return makeEmptyRung();
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

    private void printResult(String name, String result) {
        println(name + ":" + result);
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
