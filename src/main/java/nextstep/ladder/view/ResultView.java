package nextstep.ladder.view;

import java.util.Arrays;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.MemberList;

public class ResultView {
    public void printMember(MemberList list){
        list.getMembers().stream().forEach(s -> System.out.print(s.getName() + "    "));
        System.out.println();
    }

    public void printLadder(Ladder ladder){
        ladder.getLadder()
                .stream()
                .forEach(l ->  {
                    Arrays.stream(l.getArray()).forEach(n -> checkLadder(n));
                    System.out.println();
                });
    }

    public void checkLadder(int num){
        if (num == 2){
            System.out.print(" |");
        }
        if (num == 1){
            System.out.print(" ---");
        }
        if (num == 0){
            System.out.print("    ");
        }
    }
}