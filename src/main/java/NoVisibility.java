public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {
				Thread.yield(); // 다른 스레드에게 실행 양보
				System.out.println(number);
			}
		}

		public static void main(String[] args) {
			new ReaderThread().start();
			number = 42;
			ready = true;
		}
	}
}
