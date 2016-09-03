import java.util.List;
import java.util.PriorityQueue;

public class IterativeDeepeningSearch extends Algorithm {
	int searchDepth;

	public IterativeDeepeningSearch(double time, int startingNum, int targetNum, List<OptionNode> optionList) {
		super(time, startingNum, targetNum, optionList);
		this.searchDepth = 0;
	}

	public void search(int startingNum) {
		int currentValue = startingNum;
		int level = 0;
		PriorityQueue<Integer> frontier;
		while (!reachGoal(currentValue)) { // check the time also

//			expandNode();
		}
	}

}
