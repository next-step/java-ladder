package nextstep.ladder.view;

import nextstep.ladder.model.Line;

import java.util.List;

public class ResultView {

    public void test(){

    }


    public void printLadder(String[] people, int height, List<Line> lines){

        System.out.println("실행결과");
        System.out.println();

        for(int i=0;i<people.length;i++){
            System.out.printf("%6s", people[i]);
        }
        System.out.println();

        for(Line line : lines){
            System.out.printf("%6s","|");
            printLine(line);
            System.out.println();
        }
    }
    public void printLine(Line line){
        List<Boolean> points = line.getPoints();

        for(int i=0;i< points.size();i++){
            if(points.get(i)){
                System.out.print("-----");
            }else{
                System.out.print("     ");
            }
            System.out.printf("|");
        }

        //points.stream().filter(point-> point == true?"-----":"     ");



    }
}
