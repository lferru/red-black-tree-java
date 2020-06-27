/* Luis Ferrufino
** 6/18/20
** RBNode.java
** red-black-tree-java
 */

public class RBNode<T> {

    T key;
    boolean isRed;
    RBNode<T> left, right;

    public RBNode() {

        key = null;
        isRed = false;
    }

    public RBNode(T k) {

        key = k;
        isRed = true;
        left = null;
        right = null;
    }

    public T getKey() {

        return key;
    }

    public boolean isColourRed() {

        return isRed;
    }

    public boolean isDaughterless() {

        return left == null && right == null;
    }

    public void swapColour() {

        isRed = !isRed;
    }
}