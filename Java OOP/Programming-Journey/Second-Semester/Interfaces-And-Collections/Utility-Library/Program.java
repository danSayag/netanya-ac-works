
    class Demo implements Comparable, Showable {
        private int value;
    
        public Demo(int value) {
            this.value = value;
        }
    
        public int compareTo(Object other) {
            Demo otherDemo = (Demo) other;
            return this.value - otherDemo.value;
        }
    
        public void show() {
            System.out.println("Demo value: " + value);
        }
    }
    
    public class Program {
        public static void main(String[] args) {
            Demo[] demoArray = {
                new Demo(5),
                new Demo(3),
                new Demo(8),
                new Demo(1),
                new Demo(6),
            };
    
            System.out.println("Displaying all elements using showAll:");
            Utility.showAll(demoArray);
    
            Demo searchElement = new Demo(8);
            System.out.println("\nSearching for element using search:");
            boolean found = Utility.search(demoArray, searchElement);
            System.out.println("Element found? " + found);
    
            System.out.println("\nFinding max element using max:");
            Demo maxElement = (Demo) Utility.max(demoArray);
            maxElement.show();
        }
    }

