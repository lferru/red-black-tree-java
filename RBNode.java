/* Luis Ferrufino
** 6/18/20
** RBNode.java
** red-black-tree-java
 */

public class RBNode<T> {

    T key;
    boolean isRed;

    public RBNode() {

        key = null;
        isRed = false;
    }

    public RBNode(T k) {

        key = k;
        isRed = true;
    }


}