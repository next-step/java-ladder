package nextstep.ladder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String string = "pobi,honux,crong,jk";
        Players players = Players.from(Arrays.stream(string.split(",")).collect(Collectors.toList()));

        Ladder ladder = Ladder.of(5, players.list().size());
        ladder.lines().forEach(Line::draw);
    }
}
