# 사다리 게임

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 사다리 생성 방법

- TransverseLadder: '-----'를 연속되지 않게 생성한다.
- LadderLine: TransverseLadder와 참가자 수를 조합하여 LadderLine을 생성한다.
- 홀수번째는 true, 짝수번째는 Random하게 true or false를 저장한다.
- ex. 참가자: pobi, cron, jh 사다리 높이: 3

```
## TransverseLadder
true/false, true/false

## Ladder
pobi               cron               jh
|(true) true/false |(true) true/false |(true) <= LadderLine
|(true) true/false |(true) true/false |(true) <= LadderLine
|(true) true/false |(true) true/false |(true) <= LadderLine

=> Ladder(List<LadderLine>)
```


## 요구사항 정리
1. 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
2. 사람 이름은 쉼표(,)를 기준으로 구분한다.
3. 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
4. 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

- 사다리(Ladder)를 생성한다.
    1. 참가자(Participants)수 만큼 '|'를 생성한다.
    2. 사다리가 연속되지 않도록 크기가 1인 사다리를 생성한다. |-----|-----| (x)
    3. 입력 받은 사다리의 높이 만큼 사다리를 생성한다.
- 참가자(Participants) 생성한다.
    1. 입력받은 참가자의 수가 0보다 작으면 exception을 throw
    2. 입력받은 참가자의 이름이 5자 이상이면 exception을 throw
- 사다리와 참가자를 관리하는 사다리 게임(LadderGame)을 생성한다.

### TODO

### DONE
- 가로 사다리를 생성
    1. 랜덤하게 생성할지 말지를 결정하고, 이전 가로 사다리가 생성되어 있으면 생성하지 않음
- 세로 사다리를 생성
- 가로 사다리, 세로 사다리를 합쳐서 사다리 게임 생성
- TransverseLadder(가로 사다리) indent 1로 수정
- 참가자(Participants)를 생성하는 Class 추가
- 사다리 게임 생성 및 실행 결과 구현
- 중복되는 이름 입력시 Exception을 throw
- 사용하지 않는 메서드 삭제 및 클래스 이름 변경
- Ladder, LadderLine 테스트 코드 작성
- 요구사항 정리
- ErrorMessage 삭제
