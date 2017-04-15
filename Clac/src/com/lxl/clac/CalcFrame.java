package com.lxl.clac;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 计算器的视图，实现观察者
 * 
 * @author lxl
 *
 */
public class CalcFrame extends JFrame implements Observer, CalcCallback {

	private static final long serialVersionUID = 1L;

	/**
	 * 显示计算结果
	 */
	private JLabel labelResult;

	String[] title = { "!", "^", "√", "π", "C", "sin", "(", ")", "e", "←",
			"cos", "7", "8", "9", "÷", "tan", "4", "5", "6", "×", "ln", "1",
			"2", "3", "-","log", "0", ".", "=", "+" };

	/**
	 * 按钮
	 */
	private JButton[] buttons = new JButton[title.length];

	// 按钮的监听器
	private Controller controller = null;

	// /**
	// * 设置方法（注入）视图所需的控制器
	// *
	// * @param controller
	// */
	// public void setController(Controller controller) {
	// this.controller = controller;
	//
	// }

	public CalcFrame(Controller controller) {
		this.controller = controller;
		initui();
		setVisible(true);
	}

	private void initui() {
		setTitle("计算器");
		setSize(320, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 添加结果标签
		labelResult = new JLabel("0.0");
		labelResult.setBorder(new EmptyBorder(20, 10, 20, 10));
		labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResult.setFont(new Font("微软雅体", Font.PLAIN, 32));
		add(labelResult, BorderLayout.NORTH);

		// 添加按钮
		// 按钮面板
		JPanel buttonPanel = new JPanel();
		// 设置布局
		buttonPanel.setLayout(new GridLayout(6, 6, 5, 5));
		// 按钮面板添加到窗口中间
		add(buttonPanel, BorderLayout.CENTER);

		for (int i = 0; i < title.length; i++) {
			if (title[i].length() == 0) {
				// 不显示内容的标签
				buttonPanel.add(new JLabel(""));
			} else {
				// 按钮
				buttons[i] = new JButton(title[i]);
				buttons[i].setActionCommand(title[i]);
				// System.out.println(buttons[i].getSize());
				// 添加按钮的点击监听器
				buttons[i].addActionListener(controller);
				buttonPanel.add(buttons[i]);

			}

		}
	}

	/**
	 * 模型更新视图(回调)
	 */
	@Override
	public void update(Observable o, Object arg) {
		String result = (String) arg;
		labelResult.setText(result);
	}

	/**
	 * 
	 */
	@Override
	public void showResult(String result) {
		// result = labelResult.getText();
	}
}
