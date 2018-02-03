
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lewis
 */
public class MenuTransTrie {
    private class Trie {
        boolean isWord;
        HashMap<Character, Trie> TrieNode;
        int id;
        
        public Trie() {
            TrieNode = new HashMap();
            isWord = false;
            id = -1;
        }
    }
    
    private final Trie head;
    
    public MenuTransTrie() {
        head = new Trie();
    }
    
    public void insert(List<Character> list, int id) {
        Trie curNode = head;
        for(int i = 0; i < list.size(); i++) {
            Character c = list.get(i);
            if(!curNode.TrieNode.containsKey(c)) {
                curNode.TrieNode.put(c, new Trie());
            }
            curNode = curNode.TrieNode.get(c);
        }
        curNode.isWord = true;
        curNode.id = id;
    }
    
    public int search(List<Character> list) {
        Trie curNode = head;
        for(int i = 0; i < list.size(); i++) {
            Character c = list.get(i);
            if(!curNode.TrieNode.containsKey(c))
                return -1;
            else {
                curNode = curNode.TrieNode.get(c);
            }
        }
        if(curNode.isWord)
            return curNode.id;
        else
            return -1;
    }
    
    public void buildTree(List<String> list, List<Integer> ids){
        if(list.size() != ids.size()) {
            System.out.println("Tree Build Failed: Lists are not the same size.");
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            insert(strToList(list.get(i)),ids.get(i));
        }
    }
    
    public static List<Character> strToList(String str) {
        List<Character> chars = str.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        return chars;
    }
    
    public static void main(String[] args) {
        MenuTransTrie myTrie = new MenuTransTrie();
        List<Character> list1 = strToList("海鮮酸辣湯");
        List<Character> list2 = strToList("涼拌海帶絲");
        List<Character> list3 = strToList("干扁四季豆");
        List<Character> list4 = strToList("干扁四季豆");
        myTrie.insert(list1, 1);
        myTrie.insert(list2, 2);
        myTrie.insert(list3, 3);
        System.out.println(myTrie.search(list1));
        System.out.println(myTrie.search(list2));
        System.out.println(myTrie.search(list3));
        System.out.println(myTrie.search(list4));
    }
}