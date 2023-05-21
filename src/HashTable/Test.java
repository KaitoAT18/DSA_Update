package HashTable;

public class Test {
    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<String, String>(10);
        hashTable.put("dog", "con chó");
        hashTable.put("cat", "con mèo");
        hashTable.put("pig", "con lợn");
        hashTable.put("lion", "con sử tử");
        hashTable.put("hippo", "con hà mã");

        System.out.println("Current size in hashtable: " + hashTable.size());
        String removedValue = hashTable.remove("pig");
        System.out.println("Removed value: " + removedValue);
        System.out.println("Current size in hashtable after removed: " + hashTable.size());
    }
}
