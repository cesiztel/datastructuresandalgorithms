/*
Write an implementation of hash tables from scratch. Define the following methods: get(key), put(key,value), remove(key), containsKey(key), and size().
Do not use any of Java's generic data structures. Assume that both keys and values are of type Object, just as for HashMaps.
Every Object has a hash code, so at least you don't have to define your own hash functions.
Also, you do not have to worry about increasing the size of the table when it becomes too full.
 */
public class HashTableFromScratch {

    static private class ListNode {
        Object key;
        Object value;
        ListNode next;
    }

    private ListNode[] table; // Representation of the hash table

    private int count;

    public HashTableFromScratch() {
        // Assume initial size of 64
        table = new ListNode[64];
    }

    public HashTableFromScratch(int initialSize) {
        // Precondition: initialSize > 0
        table = new ListNode[initialSize];
    }

    private int hash(Object key) {
        // Precondition: key can not be null
        return (Math.abs(key.hashCode())) % table.length;
    }

    public Object get(Object key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key)) {
                return list.value;
            }

            list = list.next; // move to the next
        }

        return null;
    }

    public void put(Object key, Object value) {
        // Precondition: key can not be null
        int bucket = hash(key);
        ListNode list = table[bucket];

        // Looking for duplicates.
        while (list != null) {
            if (list.key.equals(key)) {
                break;
            }

            list = list.next; // move to the next
        }

        if (list == null) {
            if (count >= 0.75*table.length) {
                resize();
            }

            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;
            count++;
        } else {
            list.value = value;
        }
    }

    private void resize() {
        ListNode[] newTable = new ListNode[table.length*2];
        for (int i = 0; i < table.length; i++) {
            ListNode list = table[i];
            while (list != null) {
                ListNode next = list.next;
                int hash = (Math.abs(list.key.hashCode())) % newTable.length;
                list.next = newTable[hash];
                newTable[hash] = list;
                list = next;
            }
        }
        table = newTable;
    }

    public void remove(Object key) {
        int bucket = hash(key);
        if (table[bucket] == null) {
            return;
        }

        if (table[bucket].key.equals(key)) {
            table[bucket] = table[bucket].next; // the next go to head (next can be null)
            count--;
            return;
        }

        ListNode prev = table[bucket];
        ListNode curr = prev.next;
        while (curr != null && !curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }

        if (curr != null) {
            prev.next = curr.next;
            count--;  // Record new number of items in the table.
        }
    }

    public boolean containsKey(Object key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }

        return false;
    }

    public int size() {
        return count;
    }

    public void dump() {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ":");
            ListNode list = table[i];
            while (list != null) {
                System.out.print("  (" + list.key + "," + list.value + ")");
                list = list.next;
            }
            System.out.println();
        }
    }
}
