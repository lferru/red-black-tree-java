/* Luis Ferrufino
 ** 6/18/20
 ** RBTree.java
 ** red-black-tree-java
 */

public class RBTree<T> {

    private RBNode<T> dummyNull, dummyRoot;

    public RBTree() {

        dummyNull = new RBNode<T>();
        dummyRoot = new RBNode<T>();
    }
}