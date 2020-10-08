
public class Calculation {

	SimpleWindow gw;
	DoubleStack stack;
	String input;

	Calculation(SimpleWindow gw, DoubleStack stack) {
		this.gw = gw;
		this.stack = stack;

	}

	public void insertValue() {
		{
			if (stack.depth() == 0) {
				gw.clear();
				gw.addString("[empty]\n");
				gw.addString("Commands: q=quit c=clear + - * / number");
			} else {
				gw.clear();
				gw.addString(stack.toString());
			}

		}
	}

	public void inputString() {

		String input = gw.getString().trim();
		if (input.equals("")) {
			input = " ";
		}

		this.input = input;
	}

	public void parseCommand() {

		char command = input.charAt(0);
		if (Character.isDigit(command)) {
			double value = Double.parseDouble(input);
			stack.push(value);
		} else if (command == '+') {
			double v1 = stack.pop();
			double v2 = stack.pop();
			stack.push(v1 + v2);
		} else if (command == '-') {
			double v1 = stack.pop();
			double v2 = stack.pop();
			stack.push(v2 - v1);
		} else if (command == '*') {
			double v1 = stack.pop();
			double v2 = stack.pop();
			stack.push(v1 * v2);
		} else if (command == '/') {
			double v1 = stack.pop();
			double v2 = stack.pop();
			stack.push(v2 / v1);
		} else if (command == 'c') {
			stack.clear();
			gw.clear();
		} else if (command == 'q') {
			stack.clear();
			gw.exit();
		} else {
			gw.addString("Illegal command\n");
		}
	}

}
