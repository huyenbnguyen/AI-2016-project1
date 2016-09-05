/**
 * Class that holds information about an action that can be operated on a state
 * @author yinglu
 *
 */
public class Action {
	/**
	 * operator
	 */
	String operatorStr = "";
	/**
	 * the value that should be operated onto current state
	 */
	int operationValue;
	
	public Action(String input) {
		String[] str = input.split(" ");
		this.operatorStr = str[0];
		this.operationValue = Integer.parseInt(str[1]);
	}
	
	/**
	 * given a input number, calculate the result of executing the operation stored in this current node
	 * @param input the input number
	 * @return the result of the operation
	 */
	public int getOperationResult(int input){
		switch(operatorStr){
		case "+":
			return input + this.operationValue;
		case "-":
			return input - this.operationValue;
		case "*":
			return input * this.operationValue;
		case "/":
			return input / this.operationValue;
		case "^":
			return (int)Math.pow((double)input, (double)this.operationValue);
		default:
			return input;
		}
	}
}
