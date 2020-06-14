# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항
* Direction
    * boolean left, right
    * 라인이 겹치지 않도록 생성(True일 경우 무조건 다음은 False)
    * 첫번째 라인 왼쪽은 False
    * 마지막 라인 오른쪽은 False
* Point
    * 현재 위치 기준으로 양옆 이동
    * 왼쪽에 라인 있으면 index - 1
    * 오른쪽에 라인 있으면 index + 1
* LadderLine
    * 사람수 입력 받아 그만큼 라인 생성
    * move
* LadderFactory
    * 사람수와 사다리 높이 입력 받아 사다리 생성
* Ladder
    * 현재 위치 값 받아 사다리 타기 (move)
* Players
    * 참가자들 이름 저장
    * 참가자 이름을 최대 5글자까지 부여
* ResultGoods
    * 상품 이름들 저장
* ResultOfPlayer
    * 참가자 이름과 당첨된 상품 이름 저장
* ResultRecord
    * 모든 경기 결과 저장
* GenerateRandomBoolean
    * Line Random 생성
* InputView
    * 참가자 이름 입력
    * 사다리 높이 입력
    * 실행 결과 입력
    * 결과 보고 싶은 사람 입력
* ResultView
    * 사다리 출력
    * 입력 받은 사람의 결과 출력
    * 사람 이름 5자 기준으로 출력하므로 결과에 따라  
      |-----| or |(5칸 띄어쓰기)| 사다리 라인 출력
* Main
    * Controller

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)
