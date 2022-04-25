//Leetcode 21-April-2022
/*
---------------------------------705. Design HashSet-------------------------------------------------------------------
Easy
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
 

Constraints:

0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.
*/
class MyHashSet705 {
    boolean[] arr;
    int size;
    List<Integer>[] lst;
    public int hash(int key){
        return key%size;
    }
    public MyHashSet() {
        size=1000;
        lst=new LinkedList[size];
    } 
    public void add(int key) {
        int i=hash(key);
        if(lst[i]==null) lst[i]=new LinkedList<>();
        if(lst[i].indexOf(key)==-1) lst[i].add(key);
    }
    
    public void remove(int key) {
        int i=hash(key);
        if(lst[i]==null || lst[i].indexOf(key)==-1) return;
        lst[i].remove(lst[i].indexOf(key));
    }
    
    public boolean contains(int key) {
        int i=hash(key);
        if(lst[i]==null || lst[i].indexOf(key)==-1) return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */