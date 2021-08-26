package ladderGame.step4.controller;

import java.util.List;
import ladderGame.step4.dto.CreatorDto;
import ladderGame.step4.dto.ModelDto;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.service.LadderService;

public class LadderMainController {

  private final LadderService service;

  public LadderMainController() {
    this.service = new LadderService();
  }

  public ModelDto create(final CreatorDto creatorDto){
    return service.create(creatorDto);
  }

  public List<MatchResult> findResult(final ModelDto modelDto, final String findName) {
    return service.getMatchResults(modelDto.getLadder(), modelDto.getPlayers(), findName);
  }
}