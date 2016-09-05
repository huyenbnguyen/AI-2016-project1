import java.util.Stack;
import java.util.Iterator;

/**
 * A list of state nodes using stack (LIFO)
 * @author yinglu
 *
 */
public class StateNodeList extends Stack<StateNode>{
	/**
	 * indicate if the list is cut off in Depth First Search
	 */
	boolean isCutOff;
	
	
	public StateNodeList(){
		super();
		this.isCutOff = false;
	}
	
	/**
	 * return if the option node list is a cut-off list
	 * @return true if it is cut off, else false
	 */
	public boolean isCutOff(){
		return this.isCutOff;
	}
	
	/**
	 * print list given the first number
	 * @param startingNum
	 */
	public void printList(){
		Iterator<StateNode> itr = this.iterator();
		while (itr.hasNext()){
			StateNode node = itr.next();
			System.out.println(node.printNode());
		}
	}

	/**
	 * setter for isCutOff flag
	 * @param isCutOff
	 */
	public void setCutOff(boolean isCutOff) {
		this.isCutOff = isCutOff;
	}

	
}
