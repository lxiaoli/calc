package com.lxl.clac;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * 按钮点击的监听器事件
 * @author lxl
 *
 */
public class Controller implements ActionListener{
	
	/**
	 * 计算器的核心部分
	 */
	private CalcModel calcModel;
	private CalcFrame frame;
	
	private StringBuilder input = new StringBuilder();
	
//	private CalcCallback callback;
//	
//	public void setCallback(CalcCallback callback) {
//		this.callback = callback;
//	}
	

	/**
	 * 控制器的构造方法
	 */
	  public Controller() {
//		super();
//		this.calcModel = calcModel;
	}

	/**
	 * 设置控制器依赖的模型
	 * @param model
	 */
	public void setModel(CalcModel model) {
		this.calcModel=model;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		System.out.println(command);
		
		switch(command){
		case "+":
		case "-":
		case "*":
		case "/":
		case "C":
			calcModel.clear();
			input.setLength(0);
			break;
		case "=":
			calcModel.setInput(input.toString());
			input.setLength(0);
			break;
		default:
			input.append(command);
			calcModel.setInput(input.toString());
		}
		
	}




}
