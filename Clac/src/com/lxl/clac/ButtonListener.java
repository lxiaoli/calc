package com.lxl.clac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 按钮点击的监听器事件
 * @author lxl
 *
 */
public class ButtonListener implements ActionListener{
	
	/**
	 * 计算器的核心部分
	 */
	private CalcModel calcModel;
	
	private StringBuilder input = new StringBuilder();
	
	private CalcCallback calcCallback;
	

	public ButtonListener(CalcModel calcModel,CalcCallback calcCallback) {
		super();
		this.calcModel = calcModel;
		this.calcCallback = calcCallback;
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
			calcModel.push(input.toString());
			input.delete(0, input.length());
			calcModel.push(command);
		case "C":
			calcModel.clear();
			break;
		case "=":
			break;
		default:
			input.append(command);
		}
		calcCallback.showInput();
		
//		calcModel.push(command);
		
	}

}
