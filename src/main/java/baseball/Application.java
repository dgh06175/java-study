package baseball;

import java.util.*;

public class Application {
    static boolean isContinue = true;
    // 재시작 로직 어떻게 짜지 ?
    static List<Integer> computerNumber = new ArrayList<>(0);
    // 컴퓨터 숫자 정수로 할까 문자열로 할까 문자 배열로 할까?

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isContinue) {
            initComputerNumber();
            gameStart();
            isContinue = inputGameContinue();
        }
    }

    private static void initComputerNumber() {
        computerNumber.clear();
        for (int i = 0; i < 3; i++) {
            computerNumber.add((int)(Math.random() * 9 + 1));
        }
        System.out.println(computerNumber);
    }

    private static boolean gameStart() {
        return false;
    }

    private static boolean inputGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        return inputInt == 1;
    }

}
