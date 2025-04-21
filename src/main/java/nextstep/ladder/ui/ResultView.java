package nextstep.ladder.ui;

import nextstep.ladder.Ladder;
import nextstep.ladder.Player;
import nextstep.ladder.Players;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static void viewPerson(Players players){
        for (Player player : players.getPlayers()){
            System.out.print(player.getName() + " ");
        }
        System.out.println();
    }
    public static void viewLadder(Ladder ladder, int personOfCount){
        ladder.getLines().stream()
                .map(line ->
                        IntStream.range(0, personOfCount - 1)
                                .mapToObj(j -> "|" + (line.getPoints().get(j) ? "-----" : "     "))
                                .collect(Collectors.joining()) + "|"
                )
                .forEach(System.out::println);
    }
}
