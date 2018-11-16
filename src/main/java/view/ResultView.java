package view;

import domain.Line;
import domain.Player;

import java.util.List;

public class ResultView {

    public static void resultStart(){
        System.out.println("실행결과");
    }

    public static void printNames(List<Player> players){
        players.forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(List<Line> lines) {
        lines.forEach(System.out::println);
    }
}
