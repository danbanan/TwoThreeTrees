## Two Three Trees

- You will need a TwoThreeTree class, with a TwoThreeTree constructor which takes no parameters.

- TwoThreeTree will need an insert(int x) method, which will insert the value x into your tree. For this tree, duplicate insertions should be discarded.  That is, if I insert a value into the tree which is already in the tree, do not change your tree. Your method should return true if the element is added (which should happen if it isn't already in the tree), and false if it is not added (if the number was already in the tree).

- TwoThreeTree will need a search(int x) method, which will search for the value x in your tree. The method should return a String, formatted as follows. If the value x is in the tree, it will reside in a node with either one or two keys. For a one key node, the string will just be that node's key as a String. If it is a two key node, the string should be the two values, in increasing order, with a single space between them. Example: if we are searching for the number 17, and it is a key alone in a node, the search function should return "17".  If it is in a node with 35, you should return "17 35".  If it is in a node with 3, you should return "3 17". **Do not format differently. No different spaces, no extra spaces at the end.**

If the value searched for is not in the tree, your search should have terminated at a leaf node.  In that case, print the contents of that leaf node, with the same formatting described above. That is, if 17 is not in the tree, and you end in a node that contains keys 18 and 20, return "18 20".