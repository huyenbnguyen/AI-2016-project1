import java.util.ArrayList;
import java.util.List;

public class GreedyBestFirstSearch extends Algorithm {

	double time;
	int startingNum;
	int targetNum;
	List<Action> actions;
	List<Integer> visited;
	int nSteps = 0;

	long startTime;

	GreedyNodeLinkedList nodeList = new GreedyNodeLinkedList();

	public GreedyBestFirstSearch(double time, int startingNum, int targetNum, List<Action> actions) {
		super(time, startingNum, targetNum, actions);

		this.time = time;
		this.startingNum = startingNum;
		this.targetNum = targetNum;
		this.actions = actions;

		visited = new ArrayList();
	}

	@Override
	public ItrDpStateNodeStack search() {
		startTime = System.currentTimeMillis();

		int bestHeuristic;
		Action startAction = new Action("+ 0");
		nodeList.add(new GreedyNode(startingNum, startAction, startingNum, 0 ));

		ItrDpStateNodeStack result = new ItrDpStateNodeStack();

		GreedyNode frontier = nodeList.get(0);
		while ((frontier.getCurrentState() != targetNum) &&
				((System.currentTimeMillis() - startTime) < (time * 1000))){
			frontier = nodeList.get(0);

			bestHeuristic = Integer.MAX_VALUE;
			//Find the one with the best heuristic
			for (int i = 0; i < nodeList.size(); i++) {

				if ((computeHeuristic(nodeList.get(i).getCurrentState()) < bestHeuristic)
						&& (!visited.contains(nodeList.get(i).getCurrentState()))){
					bestHeuristic = (computeHeuristic(nodeList.get(i).getCurrentState()));
					frontier = nodeList.get(i);
				}
			}
			ExpandNodeList(frontier);
		}

		timeSpent = System.currentTimeMillis() - startTime;
		error = Math.abs(frontier.getCurrentState() - targetNum);

		result.push(new StateNode(frontier.getCurrentState(),null));
		while (frontier.getDepth()>0) {
			int p = frontier.getPreviousState();
			Action a = null;
			for (int i = 0;i < actions.size();i++) {
				if (actions.get(i).getOperationResult(p) == frontier.getCurrentState()) {
					a = actions.get(i);
				}
			}

			StateNode s = new StateNode(frontier.getPreviousState(),a);
			result.push(s);


			for (int i =0;i<nodeList.size();i++){
				if (nodeList.get(i).getCurrentState() == frontier.getPreviousState()) {
					frontier = nodeList.get(i);
					break;
				}
			}

		}
		nSteps = result.size();
		return result;

	}

	public void ExpandNodeList( GreedyNode frontier) {

		//Find the one with the best heuristic
		visited.add(frontier.getCurrentState());
		for (int i = 0; i < actions.size();i++) {
			int result = actions.get(i).getOperationResult(frontier.getCurrentState());
			nodeList.add(new GreedyNode(result,actions.get(i),frontier.getCurrentState(),frontier.getDepth()+1));
			this.numOfNodesExpanded++;
			if (frontier.getDepth() > this.searchDepth) {
				this.searchDepth = frontier.getDepth();
			}
		}
	}

	private int computeHeuristic(int current) {
		return Math.abs(current - targetNum);
	}

	@Override
	public int getNumberOfSteps() {
		return nSteps - 1;
	}

}
