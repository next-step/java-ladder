package nextstep.ladder.model;

import java.util.*;

public class People {

    private List<Person> people = new ArrayList<>();

    public People(String peopleStr){

       String[] peopleArr = Arrays.stream(peopleStr.split(","))
                                    .map(String::trim).toArray(String[]::new);

       for(int i=0;i<peopleArr.length;i++){
           people.add(new Person(peopleArr[i], i));
       }
    }

    public List<Person> getPeople(){
        return Collections.unmodifiableList(people);
    }
    public Person oneOfPerson(String name){
        return Optional.of(people.stream()
                                .filter(person -> person.getName().equals(name))
                                .findAny()
                                .get())
                                .orElseThrow(NoSuchElementException::new);

    }


    public void movePeoplePosition(List<Line> lines){
        people.stream()
                .forEach(person -> person.getPosition(lines));
    }
}
