package nextstep.ladder.view;

import java.util.Arrays;

import nextstep.ladder.domain.Ladder;

public class ResultVIew {
    public void printMember(String[] list){
        Arrays.stream(list).forEach(s -> System.out.print(s + "    "));
        System.out.println();
    }

    public void printLadder(Ladder ladder){
        ladder.getLadder()
                .stream()
                .forEach(l ->  {
                    Arrays.stream(l).forEach(n -> checkLadder(n));
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