package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final String LADDER_VERTICAL_CHARACTER = "|";
    private static final String LADDER_LINE_STRING = "-----";
    private static final String LADDER_NO_LINE_STRING = "     ";
    private static final int NEXT_NONADJACENT_INDEX = 2;

    private List<String> users;
    private List<Line> lines = new ArrayList<>();
    private int width;
    private int height;

    public Ladder(List<String> users, int height) {
        this.users = users;
        this.width = users.size() - 1;
        this.height = height;
    }

    public List<Line> createAllLines(List<Integer> beforeNumbers, int start) {
        List<Line> lines = new ArrayList<>();
        for (int i = start; i < width; i++) {
            createSeperateNumbers(beforeNumbers, lines, i);
            List<Integer> numbers = new ArrayList<>(beforeNumbers);
            numbers.add(i);
            lines.addAll(createAllLines(numbers, i + NEXT_NONADJACENT_INDEX));
        }

        return lines;
    }

    private void createSeperateNumbers(List<Integer> beforeNumbers, List<Line> lines, int i) {
        List<Integer> numbers = new ArrayList<>(beforeNumbers);
        numbers.add(i);
        lines.add(new Line(numbers));
    }

    public List<String> getUsers() {
        return users;
    }

    public int getHeight() {
        return height;
    }

    public void createLines(List<Line> randomLine) {
        lines.addAll(randomLine);
    }

    public String getUserFormat() {
        StringBuilder sb = new StringBuilder();
        for (String user : users) {
            sb.append(fillCharacter(user));
        }
        return sb.toString();
    }

    private String fillCharacter(String user) {
        return String.format("%-6s", user);
    }

    public List<String> drawLadder() {
        List<String> ladderFormat = new ArrayList<>();
        for (Line line : lines) {
            ladderFormat.add(drawLine(line));
        }
        return ladderFormat;
    }

    private String drawLine(Line line) {
        StringBuilder sb = new StringBuilder(LADDER_VERTICAL_CHARACTER);
        for (int i = 0; i < users.size() - 1; i++) {
            sb.append(decideLine(line, i))
                    .append(LADDER_VERTICAL_CHARACTER);
        }
        return sb.toString();
    }

    private String decideLine(Line line, int i) {
        return line.contains(i) ? LADDER_LINE_STRING : LADDER_NO_LINE_STRING;
    }
}
