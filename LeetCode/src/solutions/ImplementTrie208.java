package solutions;


/**
 * @Author: Nandi Ouyang
 * @Date : May 13, 2015
 * @Desc : Implement a trie with insert, search, and startsWith methods.
 */
public class ImplementTrie208 {
	

	public static void main(String[] args) {

		TrieNode root = new TrieNode();

		root.addChildren("nemathelminth".toCharArray());
		root.addChildren("entracte".toCharArray());

		System.out.println(root.search("nematiu".toCharArray()));

		char[] a = new char[2];
		a[0] = 'a';
		a[1] = 'b';

		char[] b = new char[2];
		b[0] = 'a';
		b[1] = 'b';

		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

	}

}

class TrieNode {
	TrieNode[] children = new TrieNode[26];

	String val = "";

	// Initialize your data structure here.
	public TrieNode() {

	}

	public TrieNode(String val) {
		this.val = val;
	}

	public void addChildren(char[] chars) {

		String charsVal = new String(chars);
		if (charsVal.equals(val))
			return;

		String childVal = val + String.valueOf(chars[val.length()]);
		int index = chars[val.length()] - 'a';

		if (children[index] != null) {
			children[index].addChildren(chars);
		} else {
			TrieNode child = new TrieNode(childVal);
			child.addChildren(chars);
			children[index] = child;
		}
	}

	public boolean search(char[] chars) {

		String charsVal = new String(chars);
		if (charsVal.equals(val)) {
			return true;
		}

		else {

			int index = chars[val.length()] - 'a';

			if (children[index] != null)
				return children[index].search(chars);

		}
		return false;

	}
	
	
}
