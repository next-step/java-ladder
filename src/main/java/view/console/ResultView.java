package view.console;

import domain.ladder.*;

import java.util.List;

public class ResultView {

    public void result(LadderManage ladderManage, LadderResult ladderResult) {
        List<Player> players = ladderManage.getPlayers();
        List<Line> lines = ladderManage.getLines();

        System.out.println("\n사다리 결과");
        System.out.println();

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
        ladderResult.getResults().stream().forEach(result -> System.out.print(result.toString() + "   "));

    }

    public void resultPlay(List<PlayResult> playResult) {
        System.out.println("실행결과");
        playResult.stream().forEach(result -> System.out.println(result.toString()));
    }
}
