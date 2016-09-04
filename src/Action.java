
public class Action {
	String operatorStr = "";
	int operationValue;
	
	public Action(String input) {
		String[] str = input.split(" ");
		this.operatorStr = str[0];
		this.operationValue = Integer.parseInt(str[1]);
	}
	
	/**
	 * given a input number, calculate the result of executing the operation stored in this current node
	 * then store the result in this.resultValue
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
