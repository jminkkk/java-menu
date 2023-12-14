package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    public void run() {
        OutputView.println("점심 메뉴 추천을 시작합니다.");
        OutputView.println();

        OutputView.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String[] coachNames = InputView.input().split(",");
        OutputView.println();

        for (String s: coachNames) {
            OutputView.println(s + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String cantEat = InputView.input();
            OutputView.println();
        }

        OutputView.println("메뉴 추천 결과입니다.");
        OutputView.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        OutputView.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");

        for (String s: coachNames) {
            OutputView.println("s");
        }

        OutputView.println();
        OutputView.println("추천을 완료했습니다.");
    }
}
