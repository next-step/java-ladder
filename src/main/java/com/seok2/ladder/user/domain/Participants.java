package com.seok2.ladder.user.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import com.seok2.global.util.StringUtils;
import java.util.Arrays;
import java.util.List;

public class Participants {

    protected final List<Participant> participants;

    private Participants(List<Participant> participants) {
        System.out.println(participants.size());
        validate(participants);
        this.participants = participants;
    }

    private void validate(List<Participant> participants) {
        if(participants.size() < 2) {
            throw new IllegalArgumentException("최소 2명의 참가자를 입력해주세요.");
        }
    }

    public static Participants of(String names) {
        return Arrays.stream(StringUtils.split(names))
            .map(String::trim)
            .map(Participant::of)
            .collect(collectingAndThen(toList(), Participants::new));
    }

    public int size () {
        return participants.size();
    }
}
