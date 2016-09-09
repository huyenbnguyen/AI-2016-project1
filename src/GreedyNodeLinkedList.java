import java.util.ArrayList;

/**
 * Created by yx on 9/9/16.
 */
public class GreedyNodeLinkedList extends ArrayList<GreedyNode> implements StateNodeList{

    public GreedyNodeLinkedList (){

    }

    @Override
    public boolean isCutOff() {
        return false;
    }

    @Override
    public void printList() {

    }

    @Override
    public void setCutOff(boolean isCutOff) {

    }

    @Override
    public int length() {
        return this.size();
    }

}
