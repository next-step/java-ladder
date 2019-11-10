package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<String> users;
    private List<Line> lines = new ArrayList<>();
    private int height;

    public Ladder(List<String> users, int height) {
        this.users = users;
        this.height = height;
    }

    public List<String> getUsers() {
        return users;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }
}
