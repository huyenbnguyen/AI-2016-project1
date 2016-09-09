import java.util.Stack;
import java.util.Iterator;

/**
 * A list of state nodes using stack (LIFO)
 * @author yinglu
 *
 */
public class ItrDpStateNodeStack  extends Stack<StateNode> implements StateNodeList{
	/**
	 * indicate if the list is cut off in Depth First Search
	 */
	boolean isCutOff;

	public ItrDpStateNodeStack(){
		super();
		this.isCutOff = false;
	}

	public boolean isCutOff(){
		return this.isCutOff;
	}

	public void printList(){
		Iterator<StateNode> itr = this.iterator();
		if (!itr.hasNext() && this.isCutOff){
			System.out.println("Search is cut off. No path found within time/depth limit.");
		}
		while (itr.hasNext()){
			StateNode node = itr.next();
			System.out.println(node.printNode());
		}
	}

	public void printReverseList() {
		while (!this.isEmpty()) {
			System.out.println(this.pop().printNode());
		}
	}

	public void setCutOff(boolean isCutOff) {
		this.isCutOff = isCutOff;
	}

	@Override
	public int length() {
		return this.size() - 1;
	}


}
