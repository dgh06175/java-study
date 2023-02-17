package crossingBridge;

// 다리에 관한 정보들을 다루는 클래스

public class Bridge {
	private int[] bridge = {0, 0, 0};
	private int len;
	
	public Bridge() {
		this.len = 3;
		for(int i=0; i<this.len; i++) {
			double r = Math.random();
			if (r >= 0.5) {
				bridge[i] = 0;
			} else {
				bridge[i] = 1;
			}
		}
	}
	
	public Bridge(int len) {
		this.len = len;
		for(int i=0; i<this.len; i++) {
			double r = Math.random();
			if (r >= 0.5) {
				bridge[i] = 0;
			} else {
				bridge[i] = 1;
			}
		}
	}
	
	void printBridge() {
		System.out.print("밝혀진 다리의 모습: ");
		for(int i=0; i<len; i++) {
			System.out.print(bridge[i]);
		}
		System.out.println();
	}
	
	
	void printBridge(int idx) {
		System.out.print("밝혀진 다리의 모습: ");
		for(int i=0; i<idx; i++) {
			System.out.print(bridge[i]);
		}
		System.out.println();
	}
	
	int[] getBridge() {
		return bridge;
	}
	
	void setBridgeLength(int len) {
		this.len = len;
	}
	
}
