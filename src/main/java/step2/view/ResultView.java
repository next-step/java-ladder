package step2.view;

import java.util.List;

public class ResultView {
    public static void printUserName(List<String> userName) {
        StringBuilder sb = new StringBuilder();
        for (String name : userName){
            sb.append(name);
        }

        System.out.println(sb.toString());
    }
    public static void printLadder(List<List<Boolean>> ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            for (int j = 0; j < ladder.get(i).size(); j++){
                if (j == 0) {
                    System.out.print("    |");
                }

                if (ladder.get(i).get(j)) {
                    System.out.print("-----|");
                }else{
                    System.out.print("     |");
                }
            }
            System.out.println();
        }
    }
}
