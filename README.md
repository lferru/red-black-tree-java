# red-black-tree-java
A red-black tree implemented in Java as practice.
Used "Data Structures & Problem Solving Using Java", 4th Ed., by Mark Allen Weiss as a reference.
This r-b tree's implementation uses top-down insertion, i.e. if, on the path down the tree,
it finds a node with two red children, it performs a color swap and a rotation if needed;
thus we won't have to go back up the tree after insertion to illegal states.
