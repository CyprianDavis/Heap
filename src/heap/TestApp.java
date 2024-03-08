package heap;

public class TestApp {
	public static void main(String[]args) {
		HeapPriorityQueue<Integer,String> tasks = new HeapPriorityQueue<Integer,String>();
		tasks.add(5, "Libaray System");
		tasks.add(1, "Data Structure");
		tasks.add(2, "Network Programming");
		tasks.add(3, "Multithreading");
		tasks.add(4, "JAVA IO");
		
		System.out.println(tasks.removeMin());
		System.out.println(tasks.removeMin());
		System.out.print(tasks.getMin());
		System.out.println();
		tasks.add(1, "JPA");
		tasks.add(2, "Spring FrameWork");
		
		System.out.println(tasks.removeMin());
		System.out.println(tasks.getMin());
		
		
	}

}
