/**
 * A class to denote states as nodes
 * 
 * @author yinglu
 *
 */
public class StateNode {
	
	/**
	 * current state value
	 */
	int currentState;

	/**
	 * the action performed at this state after expanded
	 */
	Action action;


	public StateNode(int currentState, Action action) {
		this.currentState = currentState;
		this.action = action;
	}
	
	/**
	 * get current state
	 * @return current state value
	 */
	public int getCurrentState(){
		return this.currentState;
	}
	
	/**
	 * return the resulting state from operating this state with this action
	 * @return operation result
	 */
	public int getChildState(){
		return action.getOperationResult(currentState);
	}

	/**
	 * print the operation performed in this node
	 * @return String of the operation
	 */
	public String printNode(){
		if(action == null){
			return Integer.toString(this.currentState);
		}
		return Integer.toString(this.currentState) + " " + action.operatorStr + " " + Integer.toString(action.operationValue) + " = " + action.getOperationResult(this.currentState);
	}
}
