
    public class Program {
    public static void main(String[] args) {
        List list1 = new List("list1");
        List list2 = new List("list2");

        list1.insertAtFront("hello");
        list1.insertAtFront("world");
        list1.insertAtBack("!");

        list2.insertAtFront(1);
        list2.insertAtFront(2);
        list2.insertAtBack(3);

        System.out.println("\nshow\n");
        list1.show();
        list2.show();

        System.out.println("-------------------");

        System.out.println("showRev\n");
        list1.showRev();
        list2.showRev();

        System.out.println("-------------------");

        System.out.println("removeAt\n");
        System.out.println(list2.removeAt(1));
        list2.show();

        System.out.println("-------------------");

        System.out.println("toArray\n");
        ListNode[] arr = list2.toArray();
        System.out.print("array list1: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        arr = list1.toArray();
        System.out.print("\narray list2: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}