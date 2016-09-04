import java.util.List;

public class Problem {
	int startingNum;
	int targetNum;
	List<Action> actions;
	OptionNode solution;
	
	public Problem(int startingNum, int targetNum, List<Action> actions){
		this.startingNum = startingNum;
		this.targetNum = targetNum;
		this.actions = actions;
		this.solution = null;
	}
	
	/**
	 * check if is in goal state
	 * 
	 * @param numAtCurrentState
	 *            the number at current state
	 * @return true if in goal state
	 */
	public boolean reachGoal(int numAtCurrentState){
		return numAtCurrentState == targetNum;
	}
}
