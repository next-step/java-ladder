package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;

public class OutputView {
  public static void output(List<String> participants, Ladder ladder){
    System.out.println("\n실행결과\n");
    for(int i = 0; i < participants.size(); i++){
      if(i != 0){
        System.out.print(" ");
      }
      System.out.printf("%5s", participants.get(i));
    }
    System.out.println();
    System.out.println(ladder);
  }
}
