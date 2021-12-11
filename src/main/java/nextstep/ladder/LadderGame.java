package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.Ladder;

public class LadderGame {
    public static void main(String[] args) {
        final List<String> names = List.of("name1", "name2", "name3");
        final int height = 5;
        Ladder ladder = Ladder.of(names, height);

        System.out.println(ladder.playerList());
        System.out.println(ladder.ladder());
    }
}
