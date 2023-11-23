package ladder;

import ladder.domain.PersonNames;
import ladder.view.InputView;

public class LadderApplication {

    public static void main(String[] args) {
        PersonNames personNames = InputView.inputNames();
        int maxHeight = InputView.inputLadderMaxHeight();
        
        System.out.println("실행결과");
        System.out.println(personNames);
    }
}
