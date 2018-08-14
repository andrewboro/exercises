package com.example.exercises.singlylinkedlist;

public class ListFactory {

	public static List<Integer> createSortedIntegerList() {
		List<Integer> list = new List<>();
		list.add(12);
		list.add(5);
		return list;
	}
}
