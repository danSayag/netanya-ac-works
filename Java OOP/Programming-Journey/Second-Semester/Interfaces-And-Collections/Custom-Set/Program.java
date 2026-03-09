 public class Program {

        public static void main(String[] args) {
            Set set1= new Set(12, "alex", 1, 314, "ma kore", "beseder", 9, 21, "totem", 3, 3.14,1);
            Set set2 = new Set(3, 314, "alex", 1);
    
            
            System.out.println("\n\nArithmetic operations:");
            System.out.println("+--------------------------------------------------------------+");
    
    
            //---------------- Arithmetic operations ----------------\\
    
            Set union = (Set) set1.add(set2);
            System.out.println("  Union: " + union);
        
            Set difference = (Set) set1.sub(set2);
            System.out.println("  Difference: " + difference);
       
    
            Set intersection = (Set) set1.mul(set2);
            System.out.println("  Intersection: " + intersection);
    
    
    
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("\n");
    
            
            System.out.println("toString:");
            System.out.println("+--------------------------------------------------------+");
    
    
            //---------------- toString ----------------\\
    
            System.out.println("  Set 1: " + set1.toString());
            System.out.println("  Set 2: " + set2.toString());
    
    
    
            System.out.println("+--------------------------------------------------------+");
            System.out.println("\n");
    
    
            System.out.println("+-----------------------+");
            System.out.println("|  Get Objects By Type: |");
            System.out.println("+-----------------------+");
            System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvv\n\n");
    
            System.out.println("Strings in set1:");
            System.out.println("+--------------------------------+");
    
    
            // ---------------- getObjectsByType ----------------\\
    
            Object[] strings = set1.getObjectsByType(String.class);
            for (Object str : strings) {
                System.out.println("  " +str);
            }
    
    
            System.out.println("+--------------------------------+\n\n");
    
            
            System.out.println("+------------------------+");
            System.out.println("|  Get Distinct Classes: |");
            System.out.println("+------------------------+");
            System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvv\n\n");
    
            System.out.println("Distinct classes in set1:");
            System.out.println("+--------------------------------+");
    
    
            //---------------- getDistinctClasses ----------------\\
    
            Class<?>[] distinctClasses = set1.getDistinctClasses();
            for (Class<?> clazz : distinctClasses) {
                System.out.println("  " + clazz.getSimpleName());
            }
    
    
            System.out.println("+--------------------------------+\n\n");
    
    
            System.out.println("+--------------------+");
            System.out.println("|  ScanOp interface: |");
            System.out.println("+--------------------+");
            System.out.println("vvvvvvvvvvvvvvvvvvvvvv\n\n");
    
            System.out.println("Scanning set1:");
            System.out.println("+--------------------------------+");
    
    
            //---------------- ScanOp interface ----------------\\ 
    
            set1.reset();
            while (set1.forward()) {
                System.out.println("  " + set1.getCurrent());
            }
        }
    
}
