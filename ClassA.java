package collectionTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ClassA {
	private int x = 7;	
	public ClassA() {
	   System.out.println ("This is ClassA, x = " + x);
	}

	static ArrayList<Integer> arrayList    = new ArrayList<Integer> ();
	static LinkedList<Integer> linkList    = new LinkedList<Integer> (); 
    static TreeSet<Integer> treeSet        = new TreeSet<Integer>();
	
	public class InnerClass {
		public void seeOuter() {
			System.out.println ("seeOuter gets x = " + x);
			arrayList.add(1); arrayList.add(2); arrayList.add(3);
			linkList.add(1); linkList.add(2); linkList.add(3);
			treeSet.add(1); treeSet.add(2); treeSet.add(3);
		}
		
	}

}
