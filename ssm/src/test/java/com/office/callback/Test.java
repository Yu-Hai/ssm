package com.office.callback;

public class Test {
	/**
	 * 场景：
	 * 有一天小王遇到一个很难的问题，问题是“1 + 1 = ?”，就打电话问小李，
	 * 小李一下子也不知道，就跟小王说，等我办完手上的事情，就去想想答案，
	 * 小王也不会傻傻的拿着电话去等小李的答案吧，于是小王就对小李说，我还
	 * 要去逛街，你知道了答案就打我电话告诉我，于是挂了电话，自己办自己的
	 * 事情，过了一个小时，小李打了小王的电话，告诉他答案是2
	 * @param args
	 */
	public static void main(String[] args) {
		Li li = new Li();

		Wang wang = new Wang(li);

		/**
		 * 小王问小李问题
		 */
		wang.askQuestion("1+1=?");
	}

}
