package MathOperationApp;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {

	public static void main(String[] args) {
		ArrayList<Integer> myNumberList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
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

		// using Anonymous class
		myNumberList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("values of list using Anonymous class: " + t);
			}
		});

		// implicit lambda function to print double values of integer array list
		Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
		myNumberList.forEach(
				n -> System.out.println("foreach lambda function to double value " + toDoubleFunction.apply(n)));

		// implicit lambda function to check even
		Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;
		myNumberList.forEach(n -> System.out
				.println((isEvenFunction.test(n) == true) ? +n + " is even number" : +n + " is a odd number"));

		// Stream foreach to print numbers
		myNumberList.stream().forEach(n -> System.out.println("number is :" + n));

		// transform to double and store the result
		List<Double> doubleList = myNumberList.stream().map(toDoubleFunction).collect(Collectors.toList());
		System.out.println("obtained double list is " + doubleList);

		// filter number even number from stream and storing
		List<Integer> evenStreamList = myNumberList.stream().filter(isEvenFunction).collect(Collectors.toList());
		System.out.println("even number list is:" + evenStreamList);

		// peek first even number and store it
		Integer firstEvenNumber = myNumberList.stream().filter(isEvenFunction).findFirst().orElse(null);
		System.out.println("first even number is :" + firstEvenNumber);

		// find min and max in number stream
		Integer minEvenNumber = myNumberList.stream().filter(isEvenFunction).min(Integer::compare).orElse(null);
		System.out.println("min even number is " + minEvenNumber);

		Integer maxEvenNumber = myNumberList.stream().filter(isEvenFunction).max(Integer::compare).orElse(null);
		System.out.println("max even number is " + maxEvenNumber);

		Integer sum = myNumberList.stream().reduce(0, Integer::sum);
		System.out.println("sum is " + sum);
		OptionalDouble average = myNumberList.stream().mapToInt(Integer::intValue).average();
		System.out.println("average of list is " + average);
	}

}
