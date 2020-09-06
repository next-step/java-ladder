# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## Step2 사다리 생성 (기능요구사항)

- [x] 사다리게임에 참여하는 사람의 이름은 최대 5글자
- [x] 사다리 출력할때 사람이름도 같이 출력
- [x] 사람 이름은 쉼표를 기준으로 구분
- [x] 사다리의 라인이 겹치지 않도록 설계


### Flow정리
1. 게임을 시작한다.
2. InputView - 참여할 사람이름을 입력받는다.
3. InputView - 사다리 높이를 입력받는다.
4. 사다리 게임에 대한 정보를 LadderGameManager에 관리한다.
5. LadderGameManager에 입력된 값을 가져와서 사다리를 만든다.
6. 사다리 높이만큼 Bridge의 정보(List<boolean> points)를 반복해서 입력받는다.
7. Bridge정보를 담은 Line의 리스트로 Ladder일급컬렉션으로 관리한다.
8. ResultView - 실행결과를 출력한다.
9. ResultView - Users 일급컬렉션을 먼저 출력한다.
10.ResultView - Ladder 일급컬렉션을 출력한다.
11.ResultView - Line 일급컬렉션에서 bridge유무에따라 다리를 그린다/빈칸으로둔다.
 
## Step3 사다리 게임실행 (기능요구사항)

- [ ] Step2 피드백 반영
- [ ] 사다리 실행 결과 출력
- [ ] InputView - 실행결과를 입력
- [ ] ResultView - 이름입력시 개인별 결과출력
- [ ] ResultView - all 입력시 전체 참여자의 결과출력

