package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<User> users;
    private List<Line> lines;
    private int height;

    public Ladder(List<String> names, int height) {
        this.users = names.stream()
                          .map(User::new)
                          .collect(Collectors.toList());

        this.lines = new ArrayList<>();
        this.height = height;
        for (int i = 0; i < height; i++) {
            lines.add(new Line(i, new RandomLineStrategy()));
        }
    }

    public int getHeight() {
        return height;
    }
}
