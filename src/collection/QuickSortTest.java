package collection;
public class QuickSortTest {

	public static void main(String args[]) {
		MyVector vec = new MyVector();
		for (int i = 0; i < 4; i++) {
			int number = (int)(Math.random() * 100);
			vec.append(number);	
		}	
		System.out.println(vec);
		MySort.mergeSort(vec);
		System.out.println(vec);
		System.out.println(isSorted(vec));
	}
    public static boolean isSorted(MyVector vec) {
        int first = (int)(vec.elementAt(0));
        for (int i = 0; i < vec.size() - 1; i++) {
            if (!(first <= (int)(vec.elementAt(i + 1)))) return false;
            else first = (int)vec.elementAt(i+1);
        }
        return true;
    }
}
