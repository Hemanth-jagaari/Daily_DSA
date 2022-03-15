//Leetcode 28-Jan-2022
/*
---------------------------------------------------------------211. Design Add and Search Words Data Structure---------------------------------------
Medium

4661

195

Add to List

Share
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.
*/
class Node {
    Node links[] = new Node[26]; 
    boolean flag = false; 
    
    public Node() {
        
    }
    boolean contains(char ch) {
        return (links[ch - 'a'] != null); 
    }
    Node get(char ch) {
        return links[ch-'a']; 
    }
    void put(char ch, Node node) {
        links[ch-'a'] = node; 
    }
    void setEnd() {
        flag = true; 
    }
    boolean isEnd() {
        return flag; 
    }
}

class Solution211 {
    private Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
         Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.contains(word.charAt(i))) {
                node.put(word.charAt(i), new Node()); 
            }
            node = node.get(word.charAt(i)); 
        }
        node.setEnd(); 
    }
    public boolean search(String word) {
       // return helper(word,0,root);
        
        Node curr = root;
        
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if(ch == '.') {
                return searchRegex(curr, word, i);
            }
            
            if(!curr.contains(ch))
                return false;
            
            curr = curr.get(ch);
        }
        
        return curr.isEnd();
    }
    private boolean search(Node n, String word, int ind) {
        Node curr = n;
        
        for(int i = ind; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if(ch == '.') {
                return searchRegex(curr, word, i);
            }
            
            if(!curr.contains(ch))
                return false;
            
            curr = curr.get(ch);
        }
        
        return curr.isEnd();
    }
     private boolean searchRegex(Node n, String word, int ind) {
        for(char ch = 'a'; ch <= 'z'; ch++) {
            if(n.contains(ch) && search(n.get(ch), word, ind + 1))
                return true;
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 **/