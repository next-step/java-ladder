package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameParticipants {

  private final String PRINT_ALL_PARTICIPANTS_KEY = "all";

  private List<Participant> participants;

  public GameParticipants(List<Participant> participants) {
    this.participants = participants;
  }

  public GameParticipants(String participants) {
    this.participants = Arrays.asList(participants.split(",")).stream()
        .map(Participant::new).collect(Collectors.toList());
  }

  public int getParticipantsSize() {
    return participants.size();
  }

  public Participant getGameParticipants(int index) {
    return participants.get(index);
  }

  public int getParticipantNameLenth(int index) {
    return getGameParticipants(index).getParticipantName().length();
  }

  public GameParticipants getGameParticipants(String name) {

    List<Participant> participantsResult = new ArrayList<>();

    for (Participant participant : participants) {
      addParticipant(name, participant, participantsResult);
    }

    return new GameParticipants(participantsResult);
  }

  private void addParticipant(String name, Participant participant,
      List<Participant> participants) {
    if (name.equals(PRINT_ALL_PARTICIPANTS_KEY) || equalParticipantName(name, participant)) {
      participants.add(participant);
    }
  }

  private Boolean equalParticipantName(String name, Participant participant) {
    return participant.getParticipantName().equals(name);

  }
}
