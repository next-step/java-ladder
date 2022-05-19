package ladder;

import java.util.List;

public class Ladder {
    private int height;
    private int line;

    public Ladder(int maxHeight, List<User> users) {
        this.height = maxHeight;
        this.line = users.size();
    }

    public void print() {
        for(int i = 0; i < line; i++) {
            System.out.println("|    ");
        }
    }
}
