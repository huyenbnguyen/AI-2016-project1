import java.text.DecimalFormat;
import java.util.List;

/**
 * Abstract class for implementing algorithms to solve the problem
 * Problems description please see ./Problem.java
 * @author yinglu
 *
 */
public abstract class Algorithm {
	int error;
	long timeLimit;
	Problem problem;
	int numOfNodesExpanded;
	long timeSpent;
	long currSearchTime;
	int searchDepth;

	public Algorithm(long time, int startingNum, int targetNum, List<Action> actions) {
		this.error = 0;
		this.timeLimit = time * 1000;
		this.problem = new Problem(startingNum, targetNum, actions);
		this.numOfNodesExpanded = 0;
		this.searchDepth = 0;
		this.currSearchTime = 0;
		this.timeSpent = 0;
	}

	/**
	 * triggers search
	 * @param startingNum the initial state
	 * @return OptionNodeList if result found. In case of cutoff, check OptionNodeList.isCutOff flag. In case of a failure, would return null.
	 */
	public abstract ItrDpStateNodeStack search();

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
	
	/**
	 * getter for the time spent in the search so far
	 * @return String (using DecimalFormat)
	 */
	public long getTimeSpent(){
		return this.timeSpent; //to convert from millisecond to second
	}
	
}
