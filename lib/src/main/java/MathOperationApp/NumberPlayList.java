package MathOperationApp;

import java.util.ArrayList;
import java.util.function.Consumer;

public class NumberPlayList {

	public static void main(String[] args) {
		ArrayList<Integer> myNumberList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++)
			myNumberList.add(i);

		for (int i : myNumberList)
			System.out.println("numbers are" + i);
		// explicit lambda fucntion
		Consumer<Integer> myListAction = n -> System.out.println("lambda impl foreach value :" + n);
		myNumberList.forEach(myListAction);

		// implicit lambda function
		myNumberList.forEach(n -> System.out.println("values are: " + n));

		class MyConsumer implements Consumer<Integer> {
			public void accept(Integer t) {
				System.out.println("values of list using class: " + t);
			};
		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);
	}

}
