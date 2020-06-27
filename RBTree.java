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
        //System.out.println(dummyNull.getKey());
    }

    public void insertKey(T newKey) {

        RBNode<T> newNode = new RBNode<T>(newKey);

        //if no root exists:
        if ( dummyRoot.isDaughterless() ) {

            dummyRoot.setLeftChild(newNode());
            return;
        }

        RBNode<T> greatgrandmother, grandmother, mother, daughter, aunt;
        grandmother = mother = aunt = dummyNull;
        daughter = getRoot();
        char lastTurn = 'l';
        char penultimateTurn = 'l';
        char antepenultimateTurn = 'l';

        //Now we go down the binary search tree:

        while ( daughter != dummyNull ) {

            if (daughter.areBothDaughtersRed()) {

                daughter.swapColours();
                daughter.getRightChild().swapColours();
                daughter.getLeftChild().swapColours();

                //recall that if the mother is dummmyNull, it will be black, so we won't worry about it:
                if ( mother.isRed() )
                    rotate(greatgrandmother, grandmother, mother, daughter, lastTurn, penultimateTurn, antepenultimateTurn);
            }

            if (newKey <= daughter.getKey()) {

                //aunt = mother.getRightChild();
                greatgrandmother = grandmother;
                grandmother = mother;
                mother = daughter;
                aunt = getNewAunt(grandmother, penultimateTurn);
                daughter = daughter.getLeftChild();
                antepenultimateTurn = penultimateTurn;
                penultimateTurn = lastTurn;
                lastTurn = 'l';
            } else {

                greatgrandmother = grandmother;
                grandmother = mother;
                mother = daughter;
                aunt = getNewAunt(grandmother, penultimateTurn);
                daughter = daughter.getRightChild();
                antepenultimateTurn = penultimateTurn;
                penultimateTurn = lastTurn;
                lastTurn = 'r';
            }



        }
        //Recall that all new nodes that we add will be red.
        if ( lastTurn == 'l' ) mother.setLeftChild(newNode);
        else mother.setRightChild(newNode);

        //Do a rotation if we've two consecutive red nodes:
        if ( mother.isRed() ) rotate(grandmother, mother, daughter, lastTurn, penultimateTurn, antepenultimateTurn);

        //After we have done our insertion, we ensure that the root is black.
        if (!getRoot().isColourRed()) getRoot.swapColour();

    }

    public RBNode<T> getNewAunt(RBNode<T> g, char p) {

        if ( p == 'l' ) return g.getRightChild();
        else return g.getLeftChild();
    }

    public RBNode<T> getRoot() {

        return dummyRoot.leftChild(); // the root is always the dummy's left child.
    }

    public void rotate(RBNode<T> gg, RBNode<T> g, RBNode<T> m, RBNode<T> d, char u, char p, char a) {

        if ( u == 'l' && p == 'l' ) rightRotate(gg, g, m, d, a); //left-left case
        else if ( u == 'l' && p == 'r' ) { //left-right case

            leftRotate(g, m, d, dummyNull, 'l');
            rightRotate(gg, g, d, m, a);
            d.swapColour();
        } else if ( u == 'r' && p == 'l') { //right-left case

            rightRotate(g, m, d, dummyNull, 'r');
            leftRotate(gg, g, d, m, a);
            d.swapColour();
        } else leftRotate(gg, g, m, d, a); //right-right case
    }

    public void leftRotate(RBNode<T> gg, RBNode<T> g, RBNode<T> m, RBNode<T> d, char a) {

        RBNode<T> middleTree = m.getLeftChild();
        m.setLeftChild(g);
        g.setRightChild(middleTree);
        m.swapColours();
        g.swapColours();

        if ( a == 'l' ) gg.setLeftChild(m);
        else gg.setRightChild(m);
    }

    public void rightRotate(RBNode<T> gg, RBNode<T> g, RBNode<T> m, RBNode<T> d, char a) {

        RBNode<T> middleTree = m.getRightChild();
        m.setRightChild(g);
        g.setLeftChild(middleTree);
        m.swapColours();
        g.swapColours();

        if ( a == 'l' ) gg.setLeftChild(m);
        else gg.setRightChild(m);
    }
}