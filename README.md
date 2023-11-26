# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## step1 기능분해
* [X] MoveStrategy-> CarTest 익명 클래스 람다로 전환
* [ ] Lambda.sumAll 메소드 람다를 활용해 
* [ ] Lambda.sumAllEven 메소드 람다로 전환
* [ ] Lambda.sumAllOverThree 메소드 람다로 전환
* [ ] nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거
  * [ ] 변경되는 부분과 변경되지 않는 부분 분리
  * [ ] 변경되는 부분을 인터페이스로 분리
  * [ ] 인터페이스 구현체를 익명 클래스로 구현해 메소드의 인자로 전달