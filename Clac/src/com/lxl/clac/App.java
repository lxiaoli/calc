package com.lxl.clac;

public class App {
	public static void main(String[] args) {
		
		//不改变程序的功能,调整代码结构（重构）
		//模型
		CalcModel calcModel = new CalcModel();
		
		//控制器
		Controller controller = new Controller();
		
		//装配（依赖关系)
		//解决组件之间的依赖问题
		//1）构造方法注入
		//2）setter方法注入依赖组件
		controller.setModel(calcModel);
		
		//视图
		CalcFrame calcFrame = new CalcFrame(controller);
		//模型设置回调接口，视图实现了回调接口
		calcModel.setCallback(calcFrame);
		
		//订阅（添加观察者）
		calcModel.addObserver(calcFrame);
		
		//装配（依赖关系)
		//解决组件之间的依赖问题
		//1）构造方法注入
		//2）setter方法注入依赖组件
//		calcFrame.setController(controller);
		
	}

}
