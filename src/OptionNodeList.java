import java.util.ArrayList;
import java.util.Iterator;

public class OptionNodeList extends ArrayList<OptionNode>{
	/**
	 * indicate if the list is cut off in Depth First Search
	 */
	boolean isCutOff;
	
	
	public OptionNodeList(){
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
		Iterator<OptionNode> itr = this.iterator();
		while (itr.hasNext()){
			OptionNode node = itr.next();
			System.out.println(node.printNode());
		}
	}

	public void cutOff() {
		this.isCutOff = true;
		
	}
}
