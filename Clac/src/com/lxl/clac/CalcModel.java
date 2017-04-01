package com.lxl.clac;

import java.util.Stack;

/**
 * 计算器的模型(Model)
 * @author lxl
 *
 */
public class CalcModel {
	
	//逆波兰表达式（后序表达式)
	
	//操作数和运算符
	private Stack<String> stack;
	
	/**
	 * 计算器
	 */
	public CalcModel() {
		stack = new Stack<String>();
	}
	
	public String getResult(){
		return stack.toString();
	}
	/**
	 * 
	 * @param e
	 */
	public void push(String e){
		stack.push(e);
		System.out.println(stack);
	}
	
	/**
	 * 清空
	 */
	public void clear(){
		stack.clear();
	}

}
