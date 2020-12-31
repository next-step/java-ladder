package nextstep.ladder;

import nextstep.ladder.model.*;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PeopleTest {

    @Test
    @DisplayName("사람 생성 테스트")
    public void initTest(){
        People people = new People("a,b,c");

        assertThat(people.getPeople().size()).isEqualTo(3);

        assertThat(people.getPeople().get(0).getName()).isEqualTo("a");
        assertThat(people.getPeople().get(0).getPosition()).isEqualTo(0);


        assertThrows(NoSuchElementException.class, () ->{
           people.oneOfPerson("bee");
        });

    }

    @Test
    @DisplayName("위치 테스트")
    public void positionTest(){
        People people = new People("a,b,c,d");
        Results results = new Results("꽝,4000,꽝,5000");
        Ladder ladder = new Ladder(4,5);

        ResultView resultView = new ResultView();

        resultView.printLadder(people.getPeople(),results.getResults(), ladder.getLines());
        Map<Person, Result> matches = ladder.getPersonResult(people.getPeople(), results.getResults());

        for(Person person : people.getPeople()){
            System.out.println(person.getName() +" : "+ person.getPosition());
        }

    }
}
