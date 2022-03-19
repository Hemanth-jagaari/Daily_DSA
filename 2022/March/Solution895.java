//Leetcode 19-March-2022
/*
---------------------------------------895. Maximum Frequency Stack------------------------------------------------------------
Hard

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]

Explanation
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 

Constraints:

0 <= val <= 109
At most 2 * 104 calls will be made to push and pop.
It is guaranteed that there will be at least one element in the stack before calling pop.
*/
class FreqStack895 {

    List<Stack<Integer>> freqstack=null;
    HashMap<Integer,Integer> map=null;
    public FreqStack() {
        freqstack=new ArrayList<>();
        map=new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        int freq=map.get(val);
        if(freq-1>=freqstack.size()){
            freqstack.add(new Stack<Integer>());
        }
        freqstack.get(freq-1).push(val);
    }
    
    public int pop() {
        int val=freqstack.get(freqstack.size()-1).pop();
        if(freqstack.get(freqstack.size()-1).isEmpty()){
            freqstack.remove(freqstack.size()-1);
        }
        map.put(val,map.get(val)-1);
        if(map.get(val)==0){
            map.remove(val);
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */