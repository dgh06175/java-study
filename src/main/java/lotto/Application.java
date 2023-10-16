package lotto;



public class Application {
    enum Direction {
        EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

        private static final Direction[] DIR_ARR = Direction.values();
        private final int value; // 꼭 final일 필요는 없지면 상수이므로 붙혀준다.
        private final String symbol;

        Direction(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }

        public int getValue() { return value; }
        public String getSymbol() { return symbol; }

        // num 만큼 90도 시계방향으로 회전한 방향을 반환한다.
        public Direction rotate(int num) {
            num %= 4;
            if (num < 0) num += 4; // nun<0 일때 시계 반대 방향으로 회전
            return DIR_ARR[(value - 1 + num) % 4];
        }

        @Override
        public String toString() {
            return name() + getSymbol();
        }
    }
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.play();
    }
}

