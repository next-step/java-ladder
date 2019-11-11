package com.seok2.ladder;

import com.seok2.ladder.user.domain.Participant;
import com.seok2.ladder.user.domain.Participants;
import com.seok2.ladder.view.InputView;

public class GameMain {

    public static void main(String[] args) {

        Participants participants = Participants.of(InputView.getNames());


    }

}
