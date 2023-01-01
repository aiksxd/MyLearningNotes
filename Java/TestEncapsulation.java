public class TestEncapsulation{
	//封装：
    //1.属性私有化(使用private关键字进行修饰)
    //2.对外提供简单的操作入口。
	//pravite 表示私有的，被该关键词修饰后，被修饰的数据只能在本类中访问，在其他类中都无法直接访问。
	private int password;		//离开本类，secret无法被访问和修改
	//password是实例变量(属性)

	//对外提供简单的访问入口
	/*(推荐)访问/修改方法的语法规范：
	public 返回值类型 get(访问) + 属性名但其首字母大写(无参){
		return 属性名;
	}
	public 返回值类型 set(修改) + 属性名但其首字母大写(1个参数){
		[关卡]
		属性名 = 参数
	}
	*///只是推荐，可以不遵守
	public int getPassword(){	//访问secretNumber变量值的方法
	//该方法没有static修饰，此种方法被称为：实例方法(对象方法)，实例方法在调用时需先创建对象，再使用"引用.实例方法名"的语法调用
		return password;	//将secretNuber的值作为方法的返回值返回，通过在本类中访问拷贝值，传递给方法的返回值再传到本类外部，间接地实现了对被private修饰的变量的访问。
	}

	public void setPassword(int newPassword){	//修改secretNumber变量值的方法
		//除了直接使用password = newPassword将方法参数newPassword的值赋给password属性以外，我们还可以对参数做要求（例如：newPassword的值必须大于等于100000）
		if(newPassword < 100000){
			System.out.println("修改值不合法("+newPassword+")");
			return;		//不合法时直接结束方法
		}
		password = newPassword;	//将调用时传的实参赋给secretNumber变量，实现在同一类下对被private修饰的变量。
	}
}