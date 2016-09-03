public class OptionNode {
	String operatorStr;
	int value;

	public OptionNode(String input) {
		String[] str = input.split(" ");
		this.operatorStr = str[0];
		this.value = Integer.parseInt(str[1]);
	}
	
	public int operate(int input){
		switch(operatorStr){
		case "+":
			return input + this.value;
		case "-":
			return input - this.value;
		case "*":
			return input * this.value;
		case "/":
			return input / this.value;
		case "^":
			return (int)Math.pow((double)input, (double)this.value);
		default:
			return input;
		}
	}
	
	public String print(int input){
		return Integer.toString(input) + " " + operatorStr + " " + Integer.toString(this.value) + " = " + operate(input);
	}
}
