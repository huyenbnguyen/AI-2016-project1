import java.util.List;

/**
 * Abstract class for implementing algorithms to solve the problem
 * Problems description please see ./Problem.java
 * @author yinglu
 *
 */
public abstract class Algorithm {
	int error;
	double timeLimit;
	Problem problem;
	int numOfNodesExpanded;
	double currTime;
	int searchDepth;

	public Algorithm(double time, int startingNum, int targetNum, List<Action> actions) {
		this.error = 0;
		this.timeLimit = time;
		this.problem = new Problem(startingNum, targetNum, actions);
		this.numOfNodesExpanded = 0;
		this.searchDepth = 0;
	}

	/**
	 * triggers search
	 * @param startingNum the initial state
	 * @return OptionNodeList if result found. In case of cutoff, check OptionNodeList.isCutOff flag. In case of a failure, would return null.
	 */
	public abstract StateNodeList search();

	/**
	 * getter for number of nodes expanded in the search
	 * @return
	 */
	public int getNumOfNodesExpanded(){
		return this.numOfNodesExpanded;
	}

	/**
	 * getter for depth reached in this search
	 * @return
	 */
	public int getSearchDepth(){
		return this.searchDepth;
	}
	
}
