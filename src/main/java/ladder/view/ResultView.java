package ladder.view;

import ladder.domain.Ladder;

public class ResultView {

    public static void drawLadder(Ladder ladder) {

        for(int i = 0 ; i < ladder.getLineCount(); i++){
            for(int j = 0; j < ladder.getCountOfPerson(); j++) {
                if(j%2 == 0){
                    System.out.print("     |");
                }
                else{
                    System.out.print("-----|");
                }

            }
            System.out.println();
        }
    }
}
