
public class OptionNode {
	String operatorStr;
	double value;

	public OptionNode(String input) {
		String[] str = input.split(" ");
		this.operatorStr = str[0];
		this.value = Double.parseDouble(str[1]);
	}
	
	public double operate(double input){
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
			return Math.pow(input, this.value);
		default:
			return input;
		}

	}
	
	public String print(double input){
		return Double.toString(input) + " " + operatorStr + " " + Double.toString(this.value) + " = " + operate(input);
	}
}
