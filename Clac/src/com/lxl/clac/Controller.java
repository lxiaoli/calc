package com.lxl.clac;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
	private JLabel labelResult;
	
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
//		System.out.println(command);
		
		switch(command){
		case "←":
			String text;
			if(!input.toString().equals("0.0")){
				text = input.toString();
				text = text.substring(0, text.length()-1);
				input.setLength(0);
				input.append(text);
				calcModel.setInput(input.toString());
			}
			break;
		case "C":
			calcModel.clear();
			input.setLength(0);
			break;
		case "=":
			calcModel.setInput(input.toString());
			text = input.toString();
			calculate c = new calculate(text);
			input.setLength(0);
			input.append(c.getNumStack());
			calcModel.setInput(input.toString());
			break;
		default:
			input.append(command);
			calcModel.setInput(input.toString());
			
		}
		
	}




}
