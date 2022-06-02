public class Main {

    public static void main(String[] args) {
        HashTableFromScratch table = new HashTableFromScratch(2);
        /*
          The resize method will resize the table and avoid
          the probability of collisions.
          Remove resize() call on put method to see how
          the collisions are handled.
         */
        table.put("Andrew", 27);
        table.dump();
        table.put("Maria", 43);
        table.dump();
        table.put("Pere", 12);
        table.dump();
        table.put("Mario", 23);
        table.dump();

        Object value = table.get("Maria");
        System.out.println(value);
    }
}