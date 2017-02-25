import java.util.*;

/**
 * Aho-Corasick State Automaton
 */
public class AC {
  private int nodes;
  private Node root;
  private ArrayList<String> words;

  public AC(ArrayList<String> words) {
    this.nodes = 0;
    this.root = null;
    this.words = words;
    process();
  }

  public ArrayList<String> match(String str) {
    char[] arr = str.toCharArray();
    int m = arr.length;

    ArrayList<String> matched = new ArrayList<String>();
    Node curr = this.root;
    for (int i = 0; i < m; i++) {
      while (!curr.hasChild(arr[i])) {
        curr = curr.getFailure(); 
      }
      curr = curr.getChild(arr[i]);
      if (curr.isWord()) {
        matched.add(curr.getWord());
      }
    }
    return matched;
  }

  private void process() {
    this.root = new Node(this.nodes);
    this.nodes++;
    /*
     * Phase 1, add words to key word tree
     */ 
    for (String word : words) {
      add(word);
    }

    /*
     * Phase 2, build failure functions via BFS
     */
    phase2();
  }

  private void phase2() {
    // queue
    LinkedList<Node> q = new LinkedList<>();

    // base case root children
    for (char c : this.root.getChildren()) {
      Node child = this.root.getChild(c);
      child.setFailure(this.root);
      q.addLast(child);
    }

    // recursive bfs cases
    while (!q.isEmpty()) {
      Node p = q.removeFirst();
      for (char c : p.getChildren()) {
        Node child = p.getChild(c);
        q.addLast(child);

        Node v = p.getFailure();
        while (!v.hasChild(c) && v != this.root) {
          v = v.getFailure();
        }

        if (v.getChild(c) == null) {
          child.setFailure(this.root);
        } else {
          child.setFailure(v.getChild(c));
        }
      }
    }
  }

  private void add(String word) {
    char[] arr = word.toCharArray();
    int n = arr.length;

    // add word to keyword tree
    Node p = this.root;
    for (int i = 0; i < n; i++) {
      char c = arr[i];
      Node curr = null;
      if (p.hasChild(c)) {
        curr = p.getChild(c);
      } else {
        curr = new Node(this.nodes);
        this.nodes++;
        p.addChild(c, curr);
      }

      if (i == n - 1)
        curr.setWord(word);
      p = curr;
    }
  }



  private StringBuffer str = null;
  public String toString() {
    str = new StringBuffer();
    preOrder(this.root, '*');
    String copy = str.toString(); 
    str = null;
    return copy;
  }

  private void preOrder(Node p, char c) {
    Set<Character> children = p.getChildren();
    int n = children.size();
    if (n == 0) {
      str.append(String.format("%s:%c:%s", p, c, p.getFailure()));
      return;
    }

    str.append(String.format("%s:%c:%s(", p, c, p.getFailure())); 
    int i = 0;
    for (char child : children) {  
      preOrder(p.getChild(child), child);
      if (i != n - 1)
        str.append(",");
      i++;
    }
    str.append(")");
  }
}
