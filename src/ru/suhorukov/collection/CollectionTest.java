package ru.suhorukov.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Stream;

import ru.suhorukov.auto.Car;

public class CollectionTest {

	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
		long time = System.nanoTime();
		List<Object> diverseList = new ArrayList<>();
		diverseList.add(1);
		diverseList.add(2.);
		diverseList.add("Test");
		diverseList.add("Test");
		diverseList.add("Test");
		diverseList.add("Test");
		diverseList.add(null);
		diverseList.add(new Car());
		for (int i = 0; i < diverseList.size(); i++){
			System.out.println(diverseList.get(i));
		}
		for (Object obj : diverseList){
			if (diverseList.indexOf(obj) == 0){
				int index = (Integer) diverseList.get(0);
			}
			System.out.println(diverseList.indexOf(obj) + "-" + obj);
		}
		List<Integer> intList = new ArrayList<>(); 
		intList.add(1);
		intList.add(2);
		for (int i = 1000; i < 10000; i++){
			intList.add(i);
		}
		System.out.println(intList);
		
		Generic<Integer> genericInt = new Generic<>();
		Generic<String> genericStr = new Generic<>();
		Generic<Car> genericCar = new Generic<>();
		diverseList.add(genericInt);
		
		List<String> strList = new LinkedList<>();
		strList.add("Test0");
		for (int i = 0; i < 100; i++){
			strList.add("Test" + i);
		}
		System.out.println(strList);
		
		List<Integer> removedIndex = new ArrayList<>();
		for (String str : strList){
			if ("Test5".equals(str)){
				removedIndex.add(strList.indexOf(str));
//				strList.remove(str);
			}
		}
		for (Integer index : removedIndex){
			strList.remove(index);
		}
		
		for(Iterator<String> iter = strList.iterator(); iter.hasNext();){
			if (iter.next().equals("Test5")){
				iter.remove();
			}
		}
		System.out.println(strList);
		
		Set<Integer> intSet = new LinkedHashSet<>(100);
		intSet.add(null);
		for (int i = 1000; i <= 1090; i++){
			intSet.add(i);
		}
		intSet.add(null);
		intSet.add(1000);
		intSet.add(1089);
		intSet.add(1090);
		intSet.add(1050);
		
//		Set<String> newSet = new TreeSet<>(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return -o1.compareTo(o2);
//			}
//		});
		
		Comparator<String> comparator = (o1,  o2) -> {
			System.out.println("gfdgf"); 
			return -o1.compareTo(o2);
		};
		
		Set<String> newSet = new TreeSet<>(comparator);
		
		for (String str : strList){
			newSet.add(str);
		}
		
		System.out.println(intSet);
		System.out.println(newSet);
		
		System.out.println("------------");
		System.out.println(strList);
		Stream<String> stream = strList.stream().filter(e -> e.startsWith("Test0"));
		System.out.println(stream.count());
		
		Collections.sort(strList, (arg1, arg2) -> arg1.compareTo(arg2));
		System.out.println(strList);
		
		Set<String> setSt = new TreeSet<>(strList);
//		Set<String> set = (Set<String>) strList;
		Set<String> unmodifisbleSet = Collections.unmodifiableSet(setSt);
//		unmodifisbleSet.add("fsghnsgksgf");
		
		Iterator<String> iter = strList.iterator();
		while(iter.hasNext()){
			String str = iter.next();
		}
		ListIterator<String> listIterator = strList.listIterator();
		
		
//		Set<Generic<Integer>> set = new TreeSet<>(new Comparator<Generic<Integer>>() {
//			@Override
//			public int compare(Generic<Integer> o1, Generic<Integer> o2) {
//				return o1.order - o2.order;
//			}
//		});
		
//		Stack<Integer> stack = new Stack<>();
//		
//		Queue<Integer> quue = new PriorityQueue<>();
//		quue.offer(1);
//		System.out.println(quue.peek());
//		System.out.println(quue);
		System.out.println("Время работы Вашей программы - " +  (System.currentTimeMillis() - currentTime) + " мс");
		System.out.println("Время работы Вашей программы - " +  (System.nanoTime() - time) + " нс");
		
		Random rand = new Random();
		String phone = "7";
		for (int i = 0; i < 10; i++){
			phone += Integer.toString(rand.nextInt(9));
		}
		System.out.println(phone);
	}
}

