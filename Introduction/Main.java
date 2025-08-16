import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
       public static void main(String[] args) {
              ArrayList<String> cars = new ArrayList<String>();
              cars.add("Volvo");
              cars.add("BMW");
              cars.add("Ford");
              cars.add("Mazda");
              System.out.println(cars);
              System.out.println("First car: " + cars.get(0));
              System.out.println("Change " + cars.set(1, "Opel") + " to " + cars.get(1));
              System.out.println(cars);
              System.out.println("Remove third car: " + cars.remove(2));
              System.out.println(cars);
              System.out.println("Total cars: " + cars.size());
              cars.add("Volvo");
              System.out.println("Add Volvo: " + cars);
              HashSet<String> carSet = new HashSet<String>(cars);
              System.out.println("Unique cars: " + carSet);
              System.out.println("Set " + cars.set(cars.size() - 1, "BMW") + " to " + cars.get(cars.size() - 1));
              System.out.println(cars);
              HashMap<String, Double> carPrices = new HashMap<String, Double>();
              carPrices.put(cars.get(0), 21000.0);
              carPrices.put(cars.get(1), 8000.0);
              carPrices.put(cars.get(2), 11000.0);
              carPrices.put(cars.get(3), 42500.0);
              Iterator<String> it = cars.iterator();
              int i = 0;
              while (it.hasNext() && i < cars.size()) 
                     System.out.println(it.next() + " : " + carPrices.get(cars.get(i++)));
       }
}
