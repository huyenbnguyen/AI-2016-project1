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
	int maxDepth = Integer.MAX_VALUE;

	public IterativeDeepeningSearch(double time, int startingNum, int targetNum, List<Action> actions) {
		super(time, startingNum, targetNum, actions);
		this.searchDepth = 0;
	}

	public OptionNodeList search() {
		int depth = 0;
		
	while(!shouldStopSearching(this.currTime, depth)){
			this.result = this.depthLimitedSearch(problem, depth);
			if(!this.result.isCutOff()){
				return this.result;
			}
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
		return this.recursiveDLS(new OptionNode(problem.startingNum), problem, limit);
	}
	private OptionNodeList recursiveDLS(OptionNode node, Problem problem, int limit){
		if (problem.reachGoal(node.getCurrentState())) {
			this.result.add(node);
			return this.result;
		} else if (limit == 0){
			this.result.cutOff();
			return this.result;
		} else {
			boolean isCutOff = false;
			Iterator<Action> actions = problem.actions.iterator();
			while(actions.hasNext()){
				Action currAction = actions.next();
				OptionNode child = addChild(problem, node, currAction);
				result = recursiveDLS(child, problem, limit - 1);
				if(result.isCutOff){
					isCutOff = true;
				} else if (!result.isEmpty()){
					return result;
				}
			}
			if(isCutOff){
				result.cutOff();
				return result;
			} else {
				return null;
			}
		}
	}

	private OptionNode addChild(Problem problem, OptionNode node, Action currAction) {
		problem.solution.childrenList.add(node);
		return null;
	}

}
