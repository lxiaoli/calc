package com.lxl.clac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 计算表达式
 * @author lxl
 *
 */
public class calculate {
	private static final double π = Math.PI;
	
	
	private String text;
	private Stack<String> numStack;
	private Stack<String> operStack;
	
	public double getNumStack() {
		double num = Double.parseDouble(numStack.pop());
		return num;
	}

	public calculate(String text) {
		super();
		this.text = text;
		count(text);
	}
	
	public void count(String text){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("+", 1);
		map.put("-", 1);
		map.put("×", 2);
		map.put("÷", 2);
		map.put("√", 3);
		numStack = new Stack<>();
		operStack = new Stack<>();
		ArrayList<String> list = new ArrayList<>();
		String[] t = text.split("[\\+\\-\\×\\÷\\√]");
		for (int i = 0; i < t.length; i++) {
			if(!t[i].equals("")){
				list.add(t[i]);
			}
		}
		String[] m = text.split("\\π|\\.|\\d+");
		/**
		 * 将符号放入到栈operStack中
		 */
		while(text.length() !=0){
			int i = text.length()-1;
			char c = text.charAt(i);
			System.out.println("c="+c);
			if((c>='0'&&c<='9')|c =='.' | c == ' '|c=='π'){
				text = text.substring(0,i);
			}else{
			    operStack.add(text.substring(i));
				text = text.substring(0,i);
			}
		}
		System.out.println("oper="+operStack.peek());
		int k = 0;
		String oper2;
		String oper1 ="";
		if(list.size()==1){
			numStack.add(list.get(k));
		}else{
			numStack.add(list.get(k));
			numStack.add(list.get(++k));
		}
		
		
		while (!operStack.isEmpty()){
			if(operStack.size() ==1){
				comput(numStack, operStack.pop());
			}else{
				oper1 = operStack.pop();
				oper2 = operStack.peek();
				if (map.get(oper1) == map.get(oper2)) {
					comput(numStack, oper1);
					numStack.push(list.get(++k));
				}
				if (map.get(oper1) < map.get(oper2)) {
					if(oper2.equals("√")){
						comput(numStack, oper2);
						operStack.pop();
						operStack.push(oper1);
					}else{
						numStack.push(list.get(++k));
						comput(numStack, oper2);
						operStack.pop();
						operStack.push(oper1);
					}
				}
				if (map.get(oper1) > map.get(oper2)) {
					if(oper1.equals("√")){
						String num = numStack.pop();
						comput(numStack, oper1);
						numStack.push(num);
					}else{
						comput(numStack, oper1);
						numStack.push(list.get(++k));
					}

				}
			}
			
		}
	}
	
	
	/**
	 * 计算结果
	 * @param numStack
	 * @param oper
	 */
	public static void comput(Stack<String> numStack, String oper) {
		Double sum = 0.0;
		double num1 = 0.0;
		double num2 = 0.0;
		if(!oper.equals("√")){
			num1 = Double.parseDouble(numStack.pop());
			num2 = Double.parseDouble(numStack.pop());
		}
		switch (oper) {
		case "√":
			 num2 = Double.parseDouble(numStack.pop());
				sum = Math.sqrt(num2);
//				System.out.print("√"+num2+" = "+sum);
//				System.out.println();
				numStack.push(sum.toString());
			break;
		case "+":
			sum = num1+num2;
//			System.out.print(num1+"+"+num2+" = "+sum);
//			System.out.println();
			numStack.push(sum.toString());
			break;
		case "-":
			sum = num2-num1;
//			System.out.print(num2+"-"+num1+" = "+sum);
//			System.out.println();
			numStack.push(sum.toString());
			break;
		case "×":
//			double num2 = Double.parseDouble(numStack.pop());
			sum = num1*num2;
//			System.out.print(num1+"*"+num2+" = "+sum);
//			System.out.println();
			numStack.push(sum.toString());
			break;
		case "÷":
			sum = num2/num1;
//			System.out.print(num2+"/"+num1+" = "+sum);
//			System.out.println();
			numStack.push(sum.toString());
			break;
		}

	}
	

}
