package my.project.domain;

import my.project.dto.Ladder;
import my.project.dto.Users;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created : 2020-12-04 오전 10:14
 * Developer : Seo
 */
public class LadderGenerator {
    private final Users users;
    private final int height;

    public LadderGenerator(Users users, int height) {
        this.users = users;
        this.height = height;
    }

    public Ladder generate() {
        Ladder ladder = new Ladder();
        IntStream.range(0, height)
                .forEach(i -> ladder.add(new Line(users.getUsers().size())));
        return ladder;
        /*
        int width = getWidth(users);
        String[][] ladders = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isVertical(j)) {
                    ladders[i][j] = VERTICAL_LINE;
                } else {
                    if (isLine()) {
                        if (j < 3) {
                            ladders[i][j] = String.format("%-" + User.MAX_LENGTH + "s", LINE);
                        } else if (!ladders[i][j - 2].equals(LINE)) {
                            ladders[i][j] = String.format("%-" + User.MAX_LENGTH + "s", LINE);
                        } else {
                            ladders[i][j] = String.format("%-" + User.MAX_LENGTH + "s", NO_LINE);
                        }
                    } else {
                        ladders[i][j] = String.format("%-" + User.MAX_LENGTH + "s", NO_LINE);
                    }
                }
            }
        }
        return new Ladder(ladders);
         */
    }

    private boolean isVertical(int j) {
        return j % 2 == 0;
    }

    private boolean isLine() {
        return new Random().nextInt(2) % 2 == 0;
    }

    private int getWidth(Users users) {
        int size = users.getUsers().size();
        return size + (size - 1);
    }

}
