import java.util.Iterator;
import java.util.List;

/**
 * Iterative Deepening Search algorithm
 * @author yinglu
 *
 */
public class IterativeDeepeningSearch extends Algorithm {
	int maxDepth = Integer.MAX_VALUE;
	long preTime = 0;
	

	public IterativeDeepeningSearch(double time, int startingNum, int targetNum, List<Action> actions) {
		super(time, startingNum, targetNum, actions);
		this.path = new ItrDpStateNodeStack();
	}

	/**
	 * see parent: Algorithm.java
	 */
	public ItrDpStateNodeStack search() {
		int depth = 0;
		long startTime = System.currentTimeMillis(), endTime = 0;
		ItrDpStateNodeStack result = new ItrDpStateNodeStack();
		this.preTime = this.currSearchTime;
		while(resumeSearching(this.timeSpent, depth)){
			this.searchDepth = depth;
			result = this.depthLimitedSearch(problem, depth);
			endTime = System.currentTimeMillis();
			this.currSearchTime = endTime - startTime;
			this.timeSpent += this.currSearchTime;	
			depth++; //add depth if fail to find solution
			if(!result.isCutOff()){
				error = 0;
				return result;
			}
		}
		error = problem.startingNum;
		return result;
	}

	/**
	 * test if the search should be cut off
	 * @param currTime time spent on searching so far
	 * @param depth the depth reached so far
	 * @return true if not exceeds time limit or depth limit, else false
	 */
	private boolean resumeSearching(long currTime, int depth) {
		return enoughTime() && depth <= this.maxDepth;
	}

	/**
	 * Estimate if there is enough time left to complete the search in the next level of depth
	 * @return true if time is okay to resume by estimation, otherwise false 
	 */
	private boolean enoughTime(){
		boolean hasEnoughTime;
		if(this.preTime == 0){
			this.preTime = this.currSearchTime;
			return true;
		}
		hasEnoughTime = (this.timeLimit - this.timeSpent) > (this.currSearchTime/this.preTime) * this.currSearchTime;
		this.preTime = this.currSearchTime;
		return hasEnoughTime;
	}

	/**
	 * depth limited search: DFL with depth limit
	 * @param problem
	 * @param limit depth limit
	 * @return OptionNodeList solution
	 */
	private ItrDpStateNodeStack depthLimitedSearch(Problem problem, int limit){
		ItrDpStateNodeStack visitedList = new ItrDpStateNodeStack();
		return this.recursiveDLS(new StateNode(problem.startingNum, null), problem.actions, limit, visitedList);
	}

	/**
	 * depth limited search in recursion
	 * @param currentState 
	 * @param actions actions available
	 * @param limit depth limit
	 * @param visitedList solution path
	 * @return
	 */
	private ItrDpStateNodeStack recursiveDLS(StateNode currentState, List<Action> actions, int limit, ItrDpStateNodeStack visitedList){
		visitedList.add(currentState);
		if (problem.reachGoal(currentState.getCurrentState())) {
			this.path = visitedList;
			return visitedList; //success
		} else if (limit == 0){
			visitedList.setCutOff(true); //mark cutoff
			visitedList.pop(); //remove unsuccessful nodes
			return visitedList; //cutoff
		} else {
			this.numOfNodesExpanded++;
			boolean isCutOff = false;
			Iterator<Action> actionsItr = actions.iterator(); //loop thru all actions in action list
			while(actionsItr.hasNext()){
				visitedList.setCutOff(false); //reset cut off flag
				Action currAction = actionsItr.next();
				currentState.action = currAction; //set action in node in order to expand
				//for testing purpose
				StateNode child = new StateNode(currentState.getChildState(), null); //create child nodes
				ItrDpStateNodeStack result = recursiveDLS(child, actions, limit - 1, visitedList); //recursive call to examine the child
				if(result.isCutOff){
					isCutOff = true; //if any of the children returns a cutoff, mark cutoff
				} else if (!result.isEmpty()){ //if there is a solution (not cutoff or failure)
					return result;
				}
			}
			//up to this point, if there is a solution, it should have been returned, which only leaves cutoff and failure cases
			if(isCutOff){
				visitedList.setCutOff(true);
				visitedList.pop(); //pop failed node
				return visitedList;
			} else { //if not cut off, then it's a failure, return null in this case
				return null;
			}
		}
	}



}
