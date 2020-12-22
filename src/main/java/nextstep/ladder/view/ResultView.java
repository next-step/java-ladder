package nextstep.ladder.view;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.People;
import nextstep.ladder.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private String PRINT_PEOPLE_RESULTS = "all";

    public void printLadder(List<Person> people, String[] results, List<Line> lines) {

        System.out.println("사다리 결과");
        System.out.println();

        for(Person person : people){
            System.out.printf("%6s", person.getName());
        }
        System.out.println();

        for (Line line : lines) {
            System.out.printf("%6s", "|");
            printLine(line);
            System.out.println();
        }

        for(String result : results){
            System.out.printf("%6s", result);

        }
        System.out.println();
    }

    public void printLine(Line line) {
        List<Boolean> points = line.getPoints();
        List<String> strLines = points.stream()
                            .map(point -> point? "-----|":"     |")
                            .collect(Collectors.toList());

        for(String strLine : strLines){
            System.out.print(strLine);
        }
    }
    public void printResult(String name, People people, String[] results){
        System.out.println("실행 결과");
        if(name.equals(PRINT_PEOPLE_RESULTS)){
            printPeopleResults(people.getPeople(), results);
        }

        if(!name.equals(PRINT_PEOPLE_RESULTS)){
            printPersonResults(people.oneOfPerson(name), results);
        }


    }

    public void printPeopleResults(List<Person> people, String[] results){
        for(Person person : people){
            System.out.println(person.getName()+" : "+results[person.getPosition()]);
        }
    }

    public void printPersonResults(Person person, String[] results){
        System.out.println(results[person.getPosition()]);
    }

}
