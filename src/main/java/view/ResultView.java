package view;

import dto.*;

import java.util.List;

public class ResultView {

    public static void printPlayer(List<Player> players){
        for(Player player : players){
            formatString(player.getName());
            System.out.print("  ");
        }
        System.out.println();
    }

    public static void printResultMent(){
        System.out.print("사다리 결과");
        System.out.println();
    }

    public static void printLine(LadderLine line){
        StringBuilder sb = new StringBuilder();
        for(Point point : line.getPoints()){
            sb.append(isLine(point.getDirection().isLeft()));
            sb.append("|");
        }
        System.out.println(sb.toString());
    }

    private static String isLine(boolean status){
        return status? "-----" : "     ";
    }

    public static void formatString(String name){
        System.out.print(String.format("%5s",name));
    }

    public static void printScore(Score scores){
        for(String score : scores.getScores()){
            formatString(score);
            System.out.print("  ");
        }
        System.out.println();
    }

    public static void seePlayerResult(String result){
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void seePlayerResult(GameResult result){
        System.out.println("실행 결과");
        System.out.println(result.toString());
    }


}
