package com.lxl.clac;

import java.util.Stack;

/**
 * ��������ģ��(Model)
 * @author lxl
 *
 */
public class CalcModel {
	
	//�沨�����ʽ��������ʽ)
	
	//�������������
	private Stack<String> stack;
	
	/**
	 * ������
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
	 * ���
	 */
	public void clear(){
		stack.clear();
	}

}
