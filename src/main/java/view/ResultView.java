package view;

import dto.Line;
import dto.Player;
import dto.Point;

import java.util.List;

public class ResultView {

    public static void printPlayer(List<Player> players){
        for(Player player : players){
            poersonName(player.getName());
            System.out.print("  ");
        }
        System.out.println();
    }

    public static void printLine(Line line){
        StringBuilder sb = new StringBuilder();
        for(Point point : line.getPoints2()){
            sb.append(isLine(point.getDirection().isLeft()));
            sb.append("|");
        }
        System.out.println(sb.toString());
    }

    private static String isLine(boolean status){
        return status? "-----" : "     ";
    }

    public static void poersonName(String name){
        System.out.print(String.format("%5s",name));
    }
}
