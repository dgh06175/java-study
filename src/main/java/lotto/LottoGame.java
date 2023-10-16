package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class LottoGame {
    private static final int INVALID_MONEY = -1;
    private static final int LOTTO_PRICE = 1000;

    private Lotto winningLotto;
    private int bonusNumber;
    private int money;
    private ArrayList<Lotto> lottoArray;

    public void play() {
        money = inputMoney();
        if (money == INVALID_MONEY) return;
        int lottoCount = money / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottoArray = lottoMachine(lottoCount);
        printLotto(lottoArray);

        winningLotto = inputWinNumbers();
        bonusNumber = inputBonusNumber();
        System.out.println("당첨번호는 "+ winningLotto.getNumbers() + " \n보너스 번호는 " + bonusNumber);
    }

    private int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        try {
            return validateInputMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return INVALID_MONEY;
        }
    }

    private int validateInputMoney(String inputMoney) throws IllegalArgumentException {
        int parsedMoney;
        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 돈 값을 입력했습니다.");
        }

        if (parsedMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000 미만의 값을 입력했습니다.");
        }

        return parsedMoney;
    }

    private ArrayList<Lotto> lottoMachine(int lottoCount) {
        ArrayList<Lotto> lottoArray = new ArrayList<>(lottoCount);
        for(int i = 0; i<lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoArray.add(new Lotto(numbers));
        }
        return lottoArray;
    }

    private void printLotto(ArrayList<Lotto> lottoArray) {
        for (Lotto lotto : lottoArray) {
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto inputWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] winNumberStringArray = Console.readLine().split(",");
        List<Integer> winNumberIntegerArray = new ArrayList<>(0);
        for(String num: winNumberStringArray) {
            winNumberIntegerArray.add(Integer.parseInt(num));
        }
        return new Lotto(winNumberIntegerArray);
    }

    private int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
