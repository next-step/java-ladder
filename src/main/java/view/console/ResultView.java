package view.console;

import domain.ladder.LadderManage;
import domain.ladder.Line;
import domain.ladder.Player;

import java.util.List;

public class ResultView {

    public void result(LadderManage ladderManage, List<String> results) {
        List<Player> players = ladderManage.getPlayers();
        List<Line> lines = ladderManage.getLines();

        System.out.println("\n실행결과");

        players.stream().forEach(player -> System.out.print(player.getName() + " ") );

        for(Line line : lines){
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("|");
            for(Boolean point : line.getPoints()){
                if(point == true){
                    sb.append("-----");
                }else{
                    sb.append("     ");
                }
                sb.append("|");
            }
            System.out.print(sb.toString());
        }

        System.out.println();
        results.stream().forEach(result -> System.out.print(result + "   "));
    }
}
