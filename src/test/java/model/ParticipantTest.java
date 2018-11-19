package model;

import generator.AutoLadderGenerator;
import org.junit.Test;
import view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @Test
    public void getName_5자() {
        Participant participant = Participant.getParticipant("bbibb");
        assertThat(participant.getName()).isEqualTo("bbibb");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getName_5자초과() {
        Participant participant = Participant.getParticipant("bbibbb");
    }

    @Test
    public void move() {
        List<Participant> participants = Participant.getParticipants("pobi,crong,tg,kkk");
        Participant participant = participants.get(0);
        AutoLadderGenerator autoLadderGenerator = new AutoLadderGenerator();
        String height = "5";
        int countOfPerson = 4;
        List<Line> lines = autoLadderGenerator.getLines(height, countOfPerson);
        List<Result> results = Result.getResults("꽝,5000,꽝2,3000");
        ResultView.printResult(participants, lines, results);
        Positive resultIdx = Ladder.move(lines, Positive.of(0), Positive.of(5));

        System.out.println(results);
        System.out.println("결과 : " + results.get(resultIdx.getNum()));
        System.out.println("결과 : " + resultIdx.getNum());
    }

    @Test
    public void findByName() {
        Participant pobi = Participant.findByName("pobi", Participant.getParticipants("pobi,crong,tk,cjk"));
        assertThat(pobi).isNotNull();
    }

    @Test
    public void isAll_shouldTrue() {
        assertThat(Participant.isAll("all")).isTrue();
    }
}