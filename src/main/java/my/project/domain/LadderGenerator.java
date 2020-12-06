package my.project.domain;

import my.project.dto.Ladder;

import java.util.stream.IntStream;

/**
 * Created : 2020-12-04 오전 10:14
 * Developer : Seo
 */
public class LadderGenerator {
    public static final int START = 0;
    private final Users users;
    private final int height;

    public LadderGenerator(Users users, int height) {
        this.users = users;
        this.height = height;
    }

    public Ladder generate() {
        Ladder ladder = new Ladder();
        IntStream.range(START, height)
                .forEach(i -> ladder.add(new Line(users.getUsers().size())));
        return ladder;
    }
}
