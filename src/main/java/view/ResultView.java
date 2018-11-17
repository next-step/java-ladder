package view;

import model.Line;
import model.Participant;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printResult(List<Participant> participants, List<Line> lines) {
        System.out.println("실행결과");
        for (Participant participant : participants) {
            System.out.printf("%s  ",participant.getName());
        }
        System.out.println();
        int size = lines.get(0).getPoints().size();
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            ArrayList<Boolean> points = line.getPoints();
            System.out.print("   ");
            for (int j = 0; j < points.size()-1; j++) {
                if(points.get(j).booleanValue()) {
                    System.out.print("|-----");
                } else {
                    System.out.print("|     ");
                }
            }
            System.out.println();
        }

    }
}
