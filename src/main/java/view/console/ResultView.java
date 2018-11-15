package view.console;

import domain.ladder.Line;
import domain.ladder.Player;

import java.util.List;

public class ResultView {

    public void result(List<Player> players, List<Line> lines) {
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


    }
}
