import java.util.Stack;

public class RPNCalculator {


	public static void main(String[] args) {
		SimpleWindow gw = new SimpleWindow("Calculator");
		DoubleStack stack = new DoubleStack();
		//Stack<Double> theStack = new Stack<>();
		
		Calculation calc = new Calculation(gw, stack);

		while (true){
			
			calc.insertValue();

			calc.inputString();
			
			
			calc.parseCommand();
		}

	}

}
