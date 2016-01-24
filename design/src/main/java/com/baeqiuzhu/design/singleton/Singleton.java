package com.baeqiuzhu.design.singleton;

public class Singleton {

	public static Singleton instance = null;

	private Singleton() {
		
	}
	
	/**
	 * 基本符合单例模式要求
	 * 但是在多线程环境中，毫无线程安全问题
	 * @return
	 */
	public static Singleton getInstance() {
		if (null != instance) {
			instance = new Singleton();
		}
		return instance;
	}
	
	/**
	 * 线程已经安全了，synchronized锁住的是整个对象，在高并发情况下，性能有影响
	 * @return
	 */
	public static synchronized Singleton getSynObjectInstance() {
		if (null != instance) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public static Singleton getSynFirstInstance() {
		if (null != instance) {
			synchronized(instance) {
				if (null != instance) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 如果该对象被用于序列化，可以保证被序列化前后是一致的
	 * @return
	 */
	public Object readResolve() {
		return getInstance();
	}
	
	private static class SingletonFactory {
		private static Singleton innerInstance = new Singleton();
	}
	
	/**
	 * 实际情况中通过使用内部实现类实现单例模式
	 * @return
	 */
	public static Singleton getInnerInstance() {
		return SingletonFactory.innerInstance;
	}
}
