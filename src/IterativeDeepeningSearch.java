import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class IterativeDeepeningSearch extends Algorithm {
	/*
	 * parent fileds:
	 * 	int error;
	 *	double time;
	 *	int startingNum;
	 *	int targetNum;
	 *	int nodesExpanded;
	 *	List<OptionNode> options;
	 *	PriorityQueue<Integer> expandedNodesQueue = new PriorityQueue<Integer>();
	 * */
	int searchDepth;
	//	int maxDepth = Integer.MAX_VALUE;
	int maxDepth = 3;

	public IterativeDeepeningSearch(double time, int startingNum, int targetNum, List<Action> actions) {
		super(time, startingNum, targetNum, actions);
		this.searchDepth = 0;
	}

	public OptionNodeList search() {
		int depth = 0;
		OptionNodeList result = new OptionNodeList();
		while(!shouldStopSearching(this.currTime, depth)){
			result = this.depthLimitedSearch(problem, depth);
			if(!result.isCutOff()){
				return result;
			}
			depth++;
		}
		return null;
	}

	/**
	 * test if the search should be cut off
	 * @param currTime time spent on searching so far
	 * @param depth the depth reached so far
	 * @return true if exceeds time limit or depth limit
	 */
	private boolean shouldStopSearching(double currTime, int depth) {
		return currTime>=this.timeLimit || depth > this.maxDepth;
	}

	private OptionNodeList depthLimitedSearch(Problem problem, int limit){
		OptionNodeList visitedList = new OptionNodeList();
		return this.recursiveDLS(new OptionNode(problem.startingNum, null), problem.actions, limit, visitedList);
	}
	private OptionNodeList recursiveDLS(OptionNode node, List<Action> actions, int limit, OptionNodeList visitedList){
		System.out.println(node.printNode());
		visitedList.add(node);
		if (problem.reachGoal(node.getCurrentState())) {
			return visitedList; //success
		} else if (limit == 0){
			visitedList.cutOff();
			return visitedList; //cutoff
		} else {
			boolean isCutOff = false;
			Iterator<Action> actionsItr = actions.iterator();
			while(actionsItr.hasNext()){
				visitedList.isCutOff = false;
				Action currAction = actionsItr.next();
				node.action = currAction;
				OptionNode child = new OptionNode(node.getChildState(), null);
				OptionNodeList result = recursiveDLS(child, actions, limit - 1, visitedList);
				if(result.isCutOff){
					isCutOff = true;
				} else if (!result.isEmpty()){
					return result;
				}
			}
			if(isCutOff){
				visitedList.cutOff();
				visitedList.remove(node);
				return visitedList;
			} else {
				return null;
			}
		}
	}

	//	private OptionNode addChild(Problem problem, OptionNode node, Action currAction) {
	//		problem.solution.childrenList.add(node);
	//		return null;
	//	}

}
