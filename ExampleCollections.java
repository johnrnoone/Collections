package collectionTypes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ExampleCollections {

	private static final int MAX_SIZE =  (int) 10e0;
	private static final int MAX_INT  = (int) 10e2;
//	private static final int MAX_INT  = (int) Integer.MAX_VALUE;


	public static void main (String[] args) {
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss.SS");

		int i = MAX_SIZE;
		System.out.println ("This is ExampleCollections, i = " + i);

		ArrayList<Integer> arrayList    = new ArrayList<Integer> ();
		LinkedList<Integer> linkList    = new LinkedList<Integer> (); 
		HashMap<String, String> hashMap = new HashMap<String, String>();
	    TreeSet<Integer> intTree        = new TreeSet<Integer>();
	    
        Comparator<String> comparator = new StringLengthComparator();
	    TreeSet<String> strTree         = new TreeSet<String>(comparator);
	    TreeSet<String> strAlphaTree    = new TreeSet<String>();

		
	    Date today = Calendar.getInstance().getTime();
	    String dateStr = formatter.format(today); System.out.println("Local time: " + dateStr);
	    
		Calendar calendar1 = Calendar.getInstance();
		long milliseconds1 = calendar1.getTimeInMillis();

//		getRandomArray(arrayList, i);
		getRandomMap(hashMap, i);
		getRandomTree(intTree, i);
		
		Calendar calendar2 = Calendar.getInstance();
		long milliseconds2 = calendar2.getTimeInMillis(); double diffSeconds = (double) (milliseconds2 - milliseconds1) /1E03;
		System.out.println("Seconds to sort hashMap.size " + MAX_SIZE + " is "+ diffSeconds);
		
	    today = Calendar.getInstance().getTime();
	    dateStr = formatter.format(today); System.out.println("Local time: " + dateStr);
	    
		System.out.println("intTree.toString = "+ intTree.toString());	
		printMap (hashMap);
		
		usePriorityQueue();

		getRandomList(linkList, i); printList (linkList);
		
		System.out.println ("get StringLength treeSet: ");
		getStringTreeSet (strTree);
		System.out.println ("get StringAphabetic treeSet: ");
		getStringTreeSet (strAlphaTree);
		
		HashSet<String> hs = new HashSet<String>();
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		hs.add("xxxabc"); hs.add("abc");
		lhs.add("xxxabc"); lhs.add("xxxdef");
		lhs.addAll(hs); System.out.println ("Case 1: after lhs.addAll(hs) = "+lhs);
		
		hs = new HashSet<String>();
		lhs = new LinkedHashSet<String>();
		hs.add("xxxabc"); hs.add("abc");
		lhs.add("xxxabc"); lhs.add("xxxdef");
		lhs.removeAll(hs); System.out.println ("Case 2: after lhs.removeAll(hs) = "+lhs);
		
		hs = new HashSet<String>();
		lhs = new LinkedHashSet<String>();
		hs.add("xxxabc"); hs.add("abc");
		lhs.add("xxxabc"); lhs.add("xxxdef");
		lhs.retainAll(hs); 

		System.out.println ("arrayList.size() = " + arrayList.size());
		arrayList.add(1); arrayList.add(1); arrayList.add(1); arrayList.add(1); arrayList.add(1);
		System.out.println ("arrayList.size() = " + arrayList.size());
		arrayList.add(1); arrayList.add(1); arrayList.add(1); arrayList.add(1); arrayList.add(1);
		System.out.println ("arrayList.size() = " + arrayList.size());
		arrayList.add(1);
		System.out.println ("arrayList.size() = " + arrayList.size());
		arrayList.ensureCapacity(20);
		System.out.println ("arrayList.size() = " + arrayList.size());


	}

    public static void getStringTreeSet(TreeSet<String> strTree)
    {
    	strTree.add("short");
    	strTree.add("very long indeed");
    	strTree.add("medium");
    	strTree.add("a");
    	strTree.add("b");
    	strTree.add("c");

        while (strTree.size() != 0)
        {
        	String first = strTree.pollFirst(); strTree.remove(first);
            System.out.println(first);
        }
    }
    
    public static void usePriorityQueue()
    {
        Comparator<String> comparator = new StringLengthComparator();
        
        PriorityQueue<String> queue = 
            new PriorityQueue<String>(10, comparator);
        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
        }
    }
    
	public static void getRandomArray (ArrayList<Integer> arrayList, int size) {
		Random rand = new Random(); rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < size; i++) {arrayList.add (rand.nextInt(MAX_INT));}
	}
	
	public static void getRandomList (LinkedList<Integer> linkList, int size) {
		Random rand = new Random(); rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < size; i++) {linkList.add (rand.nextInt(MAX_INT));}
	}

	public static void getRandomMap (HashMap<String, String> hashMap, int size) {
		Random rand = new Random(); rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < size; i++) {
			String key = String.valueOf(rand.nextInt(MAX_INT));
			hashMap.put (key, key); 
		}
	}

	public static void printList (LinkedList<Integer> linkList) {
		Iterator<Integer> it = linkList.iterator();
		System.out.print ("linkList = " );
		while (it.hasNext()) System.out.print (it.next() + ", ");
		System.out.println ();
	}
	
	public static void printMap (HashMap<String, String> hashMap) {
		Set<String> entrySet = hashMap.keySet();
		Iterator<String> it = entrySet.iterator();
		System.out.print ("entrySet = " );
		while (it.hasNext()) System.out.print (it.next() + ", ");
		System.out.println ();
	}
	
	public static void getRandomTree (TreeSet<Integer> intTree, int size) {
		Random rand = new Random(); rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < size; i++) {
			Integer key = new Integer(rand.nextInt(MAX_INT));
			intTree.add(key);
		}
	}

}

 class StringLengthComparator implements Comparator<String>
{
    @Override
    public int compare(String x, String y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        if (x.length() < y.length())
        {
            return -1;
        }
        if (x.length() > y.length())
        {
            return 1;
        }
        return 0;
    }
}
