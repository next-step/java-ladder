# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 람다 실습
* CarTest에 있는 익명 클래스를 람다로 전환
* Lambda 클래스 내부의 sumAll를 추가하여 중복 제거
* stream method 실습
  * nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass
  * nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
    * 단어의 길이가 12자를 초과하는 단어를 추출한다.
    * 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
    * 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
    * 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.