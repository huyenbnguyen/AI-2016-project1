import java.util.List;
import java.util.PriorityQueue;

public abstract class Algorithm {
	int error;
	double time;
	int startingNum;
	int targetNum;
	int nodesExpanded;
	List<OptionNode> options;
	PriorityQueue<Integer> expandedNodesQueue = new PriorityQueue<Integer>();

	public Algorithm(double time, int startingNum, int targetNum, List<OptionNode> optionList) {
		this.error = 0;
		this.time = time;
		this.startingNum = startingNum;
		this.targetNum = targetNum;
		this.nodesExpanded = 0;
		this.options = optionList;
	}


	public abstract void search(int startingNum);
	// public void expandNode(); //return type TBD

	/**
	 * check if is in goal state
	 * 
	 * @param currentNum
	 *            the number at current state
	 * @return true if in goal state
	 */
	public boolean reachGoal(int currentNum) {
		return currentNum == this.targetNum;
	}
	
	public PriorityQueue<Integer> expandNode(PriorityQueue<Integer> currentQueue) {
		return currentQueue;
	}
}
