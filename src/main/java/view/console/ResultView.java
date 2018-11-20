package view.console;

import domain.ladder.*;

import java.util.List;

public class ResultView {

    public void result(LadderManage ladderManage, LadderResult ladderResult) {
        Players players = ladderManage.getPlayers();
        Lines lines = ladderManage.getLines();

        //
        List<LadderLine> ladderLines = ladderManage.getLines().getLine();

        System.out.println("\n사다리 결과");
        System.out.println();

        players.getPlayers().stream().forEach(player -> System.out.print(player.getName() + " ") );

        //
        for(LadderLine ladderLine : ladderLines){
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("|");

            for(Point point : ladderLine.getPoints()){
                if(point.getDirection().isRight() == true){
                    sb.append("-----");
                }else{
                    sb.append("     ");
                }
            }
            sb.append("|");

            System.out.print(sb.toString());
        }

       /* for(Line line : lines.getLine()){
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
        }*/

        System.out.println();
        ladderResult.getResults().stream().forEach(result -> System.out.print(result.toString() + "   "));

    }

    public void resultPlay(List<PlayResult> playResult) {
        System.out.println("실행결과");
        playResult.stream().forEach(result -> System.out.println(result.toString()));
    }
}
