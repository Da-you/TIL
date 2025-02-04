public class UnsafeSequence {
	private int value;

	/** 유일한 값 리턴 */
	public int getNext() {
		value = 1;
		return value++;
	}
}

