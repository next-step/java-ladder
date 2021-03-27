package ladder.view;

import java.util.List;

public class ResultView {

    public void printLadderMap(List<String> ladderMap){
        System.out.println("실행 결과");
        for(String line:ladderMap){
            System.out.println(line);
        }
    }
}
