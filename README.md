# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# Step1 기능구현
## 람다(lambda)
- CarTest MoveStrategy 람다로 적용
- fp.lambda의 sumAll, sumAllEven, sumAllOverThree 메서드의 중복 제거
## 스트림(stream)
- fp.StreamStudyTest sumOverThreeAndDouble() 테스트 통과
- fp.StreamStudy printLongestWordTop100() 메서드 
  - 단어의 길이가 12자를 초과하는 단어를 추출한다. 
  - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
  - 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
  - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
## Optional
- Optinal을 활용해 조건에 따른 반환
  - optional.UserTest의 테스트가 모두 pass
- Optional에서 값을 반환
  - optional.Users의 getUser()메서드를 stream, Optional로 리팩토링
- Optional에서 exception 처리
  - optional.ExpressionTest의 테스트가 통과하도록 Expression의 of메서드를 구현

# Step2 기능구현
## 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야한다.
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
## 구현
- Ladder
  - List<Line>
- Line
  - List<Boolean>
    - 우측으로 연결되었는지 T/F
  - 이전에 연결 되었는지 확인
