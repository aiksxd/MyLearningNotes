public class ExtendsTest{
	public static void main(String[] args){
	// 创建普通账户
	Account act = new Account();
	act.setActno("1145141");
	act.setBalance(-114514);
	System.out.println(act.getActno() + "，余额" + act.getBalance());

	// 创建信用账户
	CreditAccount ca = new CreditAccount();
	ca.setActno("1111111");
	ca.setBalance(10000);
	ca.setCredit(0.99);
	System.out.println(ca.getActno() + "，余额：" + ca.getBalance() + "，信誉分：" + ca.getCredit);
	System.out.println(ca);		//我们重写了toString方法，打印引用时不再是对象地址，而是我们新方法执行的结果。
	
	// Object类测试：
	/* Object类下toString方法源码：
	public String toString() {
		return getClass() .getName() + "@" + Integer.toHexString(hashCode());
	}
	*/
	AlphaTest et = new AlphaTest();
	System.out.println("调用继承的toString方法："+et.toString);	//调用默认继承Object的AlphaTest类调用继承的toString方法
	System.out.println("打印引用值："+et);		//直接打印引用值
	//可以发现两次打印结果相同，说明当单独打印引用值时，会默认调用继承Object类来的toSring方法
	//toString字面理解即为转换成字符串，这里即将对象转换成字符串形式
	}
}
class Alpha{	//即使该类是空的，他也有默认继承Object类的内容
}

//银行账户类，账户属性包括：账号余额
class  Account{
	private String actno;
	private double balance;

	public Account(){
	
	}
	public Account(String actno, double balance){
		this.actno = actno;
		this.balance = balance;
	}

	public void setActno(String actno){
		this.actno  = actno;
	}
	public String getActno(){
		return actno;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public double getBalance(){
		return balance;
	}
}

//其它类型的账户：信用卡账户（账号、余额、信誉度）
class CreditAccount extends Account{	//extends Account为继承部分，注释的内容与Account类重复，可利用继承提高代码复用率 
	// private String actno;
	// private double balance;
	private double credit;

	public Account(){
	
	}
	public Account(String actno, double balance){
		this.actno = actno;
		this.balance = balance;
		this.credit = credit;
	}

	// public void setActno(String actno){
	// 	this.actno = actno;
	// }
	// public String getActno(){
	// 	return actno;
	// }
	// public void setBalance(double balance){
	// 	this.balance = balance;
	// }
	// public double getBalance(){
	// 	return balance;
	// }
	public void setCredit(double credit){
		this.credit = credit;
	}
	public double getCredit(){
		return credit;
	}
	//Override方法覆盖：
	public String getActno(){
		return "用户名为：" + actno;	//使用相同定义的方法覆盖继承父类的旧方法后，再在此类中调用getBalance()方法只会调用新写的方法，但并非方法重载(重载需要方法间同名但其他定义不同而产生并列关系)
	}
	public void setActno(String actno){	//覆盖要求的父子方法定义相同包括：相同的返回值类型、方法名、形式参数列表、访问修饰符(访问权限可以更高但不能更低)等。
		this.actno = actno;
		System.out.println("用户名已改为：" + actno);
	}
	//toString方法覆写测试：
	public String toString(){
		return "用户名：" + getActno() + "余额为：" + getBalance() + "信誉分为：" + getCredit());
	}
}