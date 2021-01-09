package view;

import domain.Ladder;
import domain.PersonList;

public class ResultView {
    public static void ladder(PersonList personList, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        personList.getList()
                .stream()
                .map(person -> person.getName())
                .forEach(System.out::print);

        System.out.println();

        for (int i = 0; i < ladder.getLadder().size(); i++) {
            ladder.getLadder().get(i).getLine();
            System.out.print("|");
            for (int j = 0; j < ladder.getLadder().get(i).getLine().size(); j++) {
                boolean line = ladder.getLadder().get(i).getLine().get(j);
                if (line) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
