package amazon;

import java.util.HashMap;
import java.util.Map;

/*
 * Write code to read a math operation (ex: 1 + 2 * 3 /4) from a string and display the result. 
 */
public class CalculateExpression {

	private enum Operator {
		PLUS("+", false) {
			@Override
			public double doIt(double operand1, double operand2) {
				return operand1 + operand2;
			}
		},
		MINUS("-", false) {
			@Override
			public double doIt(double operand1, double operand2) {
				return operand1 - operand2;
			}
		},
		MULTIPLY("*", true) {
			@Override
			public double doIt(double operand1, double operand2) {
				return operand1 * operand2;
			}
		},
		DIVIDE("/", true) {
			@Override
			public double doIt(double operand1, double operand2) {
				return operand1 / operand2;
			}
		};
		
		private boolean precedent;
		private String symbol;
		
		private static Map<String, Operator> operators;
		
		private Operator(String symbol, boolean precedent) {
			this.symbol = symbol;
			this.precedent = precedent;
		}

		public boolean isPrecedent() {
			return precedent;
		}

		public abstract double doIt(double operand1, double operand2);
		
		public static Operator fromSymbol(String symbol) {
			if (operators == null) {
				operators = new HashMap<String, Operator>();
				for (Operator op : Operator.values()) {
					operators.put(op.symbol, op);
				}
			}
			return operators.get(symbol);
		}				
	}
	
	public static void main(String[] args) {
		System.out.println(calculate(args));
	}

	private static double calculate(String[] args) {
		return calculate(args, 0);
	}

	private static double calculate(String[] args, int start) {
		double result = Double.valueOf(args[start]);
		if (start < args.length - 1) {
			Operator op = Operator.fromSymbol(args[start + 1]);
			if (op.isPrecedent()) {
				result = op.doIt(result, Double.valueOf(args[start + 2]));
				args[start + 2] = String.valueOf(result);
				result = calculate(args, start + 2);
			} else {
				result = op.doIt(result, calculate(args, start + 2));
			}
		}
				
		return result;
	}
}
