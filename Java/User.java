public class User{

	//用户id
	int id;

	//用户名
	String username;

	//家庭住址
	//address是成员变量，是实例变量，也是引用，由此可见，引用不一定是局部变量
	Address address;	//数据类型为引用数据类型的类名称Address
}