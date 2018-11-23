package ladder.view;

import ladder.domain.Attendee;
import ladder.domain.Attendees;
import ladder.domain.Gifts;
import ladder.domain.Ladder;

import java.text.MessageFormat;

public class ResultView {

    private final Attendees attendees;
    private final Gifts gifts;
    private final Ladder ladder;

    private ResultView(Attendees attendees, Gifts gifts, Ladder ladder) {
        this.attendees = attendees;
        this.gifts = gifts;
        this.ladder = ladder;
    }

    public static ResultView create(Attendees attendees, Gifts gifts, Ladder ladder) {
        return new ResultView(attendees, gifts, ladder);
    }

    public void showLadder() {
        System.out.println("\n사디리결과\n");
        System.out.println(attendees.toString());
        System.out.println(ladder.toString());
        System.out.println(gifts.toString());
    }

    public void showResult(Attendee attendee) {
        System.out.println("\n실행결과");
        if(attendee.isAll()) {
            this.showResultByAll();
        } else {
            this.showResultByUser(attendee);
        }
    }

    private void showResultByAll() {
        for (int i = 0; i < attendees.size(); i++) {
            Attendee attendee = attendees.get(i);
            int countOfPerson = attendees.indexOf(attendee);
            int endpoint = ladder.endpoint(countOfPerson);
            System.out.println("[" + countOfPerson + "," + endpoint + "]");
            System.out.println(MessageFormat.format("{0} : {1}", attendee, gifts.get(endpoint)));
        }
    }

    private void showResultByUser(Attendee attendee) {
        int countOfPerson = attendees.indexOf(attendee);
        int endpoint = ladder.endpoint(countOfPerson);
        System.out.println(gifts.get(endpoint));
    }
}
