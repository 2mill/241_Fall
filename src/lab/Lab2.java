package lab;
import collection.MyVector;
/**
 * @author : Yannick Dorn ydorn0@frostburg.edu
 * @version 2018.9.19
 */
public class Lab2 {
    public static void test() {
        MyVector lab = new MyVector();
        for (int i = 0; i < 25; i++) {
            if (i == 0 || i == 1) lab.append(i);
            else lab.append((int)lab.elementAt(i - 2) + (int)lab.elementAt(i - 1));
        }
        System.out.println(lab);
        lab.reverse();
        System.out.println(lab);
        MyVector lab2 = null;
        try {
            lab2 = lab.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        double key = Math.random();
        for (int i = 0; i < lab.size(); i++) {
            if (i % 2 != 0) {
                lab.replace(i, key);
            }
        }
        while(lab.remove(key));
        System.out.println(lab);
	System.out.println(lab2);
        lab2.reverse();

        System.out.println(lab2);
	lab.merge(lab2);
	System.out.println(lab);
    }
}
