package com.baeqiuzh.design;

import org.junit.Test;

import com.baeqiuzhu.design.ISender;
import com.baeqiuzhu.design.factory.AbstractSmsFactory;
import com.baeqiuzhu.design.factory.FactoryMethod;
import com.baeqiuzhu.design.factory.IAbstactFactoryMethod;
import com.baeqiuzhu.design.factory.MultiFactoryMethod;
import com.baeqiuzhu.design.factory.StaticFactoryMethod;

public class FactoryTest {
	
	private static final String CLASS_NAME_SMS = "com.baeqiuzhu.design.impl.SmsSender";
	private static final String CLASS_NAME_MAIL = "com.baeqiuzhu.design.impl.MailSender";

	/**
	 * 简单工厂模式
	 */
	@Test
	public void testFactoryMethod() {
		FactoryMethod fm = new FactoryMethod();
		ISender smsSender = fm.produce(FactoryMethod.METHORD_SMS);
		smsSender.send();
		ISender mailSender = fm.produce(FactoryMethod.METHORD_MAIL);
		mailSender.send();
	}
	
	/**
	 * 多个工厂方法模式
	 */
	@Test
	public void testMultiFactoryMethod() {
		ISender smsSender = new MultiFactoryMethod().produceSmsSender();
		smsSender.send();
	}
	
	/**
	 * 静态工厂方法
	 */
	@Test
	public void testStaticFactoryMethod() {
		ISender smsSender = StaticFactoryMethod.produceSmsSender();
		smsSender.send();
	}
	
	/**
	 * 通过反射机制动态生成
	 * 静态方法获取实例
	 */
	@Test
	public void testStaticFactoryInstance() {
		ISender smsSender = StaticFactoryMethod.getInstance(CLASS_NAME_SMS);
		System.out.println("通过反射机制动态生成!");
		smsSender.send();
		ISender mailSender = StaticFactoryMethod.getInstance(CLASS_NAME_MAIL);
		System.out.println("通过反射机制动态生成!");
		mailSender.send();
	}
	
	/**
	 * 抽象工厂模式测试
	 */
	@Test
	public void testAbstractFactory() {
		System.out.println("抽象工厂模式生产！");
		IAbstactFactoryMethod smsFactory = new AbstractSmsFactory(); 
		ISender smsSender = smsFactory.produce();
		smsSender.send();
	}
	
}
