package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<String> users;
    private List<Line> lines = new ArrayList<>();
    private int width;
    private int height;

    public Ladder(List<String> users, int height) {
        this.users = users;
        this.width = users.size() - 1;
        this.height = height;
    }

    public void createLines() {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(new PointCreatingStrategy(), width));
        }
    }

    public String getUserFormat() {
        return users.stream()
                .map(this::fillCharacter)
                .collect(Collectors.joining());
    }

    private String fillCharacter(String user) {
        return String.format("%-6s", user);
    }

    public List<String> drawLadder() {
        List<String> ladderFormat = new ArrayList<>();
        for (Line line : lines) {
            ladderFormat.add(line.drawLine());
        }
        return ladderFormat;
    }

    public List<String> getUsers() {
        return users;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
