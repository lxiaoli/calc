package com.lxl.clac;

import java.util.Observable;
import java.util.Stack;

/**
 * 计算器的模型(Model)
 * 
 * 模型中的数据发布出去（成为被订阅的主题、被观察的对象或者数据）
 * 
 * @author lxl
 *
 */
public class CalcModel extends Observable{
	
	private String input;
	
	//逆波兰表达式（后序表达式)
	//操作数和运算符
	private Stack<String> stack;
	
	private CalcCallback callback;
	
	public void setCallback(CalcCallback callback) {
		this.callback = callback;
	}
	
	/**
	 * 计算器
	 */
	public CalcModel() {
		stack = new Stack<>();
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
		
		//设置改变通知观察者
		setChanged();
		notifyObservers(stack.toString());
		callback.showResult(stack.toString());
	}
	
	/**
	 * 清空
	 */
	public void clear(){
		stack.clear();
		//通知
		setChanged();
		notifyObservers();
	}
	public void setInput(String input){
		this.input = input;
		
		//通知视图更新
		setChanged();
		notifyObservers(input);
	}
	

}
