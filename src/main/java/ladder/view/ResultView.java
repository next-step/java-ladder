package ladder.view;

import java.util.List;

public class ResultView {

    public void printLadderMap(List<String> ladderMap){
        for(String line:ladderMap){
            System.out.println(line);
        }
    }
}
