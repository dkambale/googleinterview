package trie;

import tree.TreeNode;

public class Trie {

  TrieNode root=new TrieNode();
  static class TrieNode {


    int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;
    Character c ;

    TrieNode() {
       c = null;
      isEndOfWord = false;
      for (int i = 0; i < ALPHABET_SIZE; i++) {
        children[i] = null;
      }
    }

    TrieNode(Character ch) {
      this.c = ch;
      isEndOfWord = false;
      for (int i = 0; i < ALPHABET_SIZE; i++) {
        children[i] = null;
      }
    }

  }


  public void insert(String key) {

    int charAtFirst = key.charAt(0) - 'a';
    int level = key.length();
    TrieNode curr = root;
    for (int i = 0; i < level; i++) {
      if (curr.children[key.charAt(i) - 'a'] == null) {
        TrieNode tt = new TrieNode(key.charAt(i));
        curr.children[key.charAt(i) - 'a'] = tt;
        curr = curr.children[key.charAt(i) - 'a'];
      } else {
        curr = curr.children[key.charAt(i) - 'a'];
      }
    }
    curr.isEndOfWord=true;
  }

  public boolean search(String key) {

    TrieNode curr = root;
    int level=key.length();
    for(int i=0;i<level;i++) {
      if(curr.children[key.charAt(i)-'a'] !=null) {
        curr=curr.children[key.charAt(i)-'a'];
      } else {
        break;
      }
    }
    if(curr==null || curr.isEndOfWord==false) {
      return false;
    }
    return true;
  }


  public static void main(String[] args) {
// Input keys (use only 'a' through 'z' and lower case)
    String keys[] = {"the", "a", "there", "answer", "any",
        "by", "bye", "their"};
    Trie trieNode=new Trie();
    int i;
    for (i = 0; i < keys.length; i++) {
      trieNode.insert(keys[i]);
    }
    System.out.println(" is Present :"+trieNode.search("there"));
  }

}
