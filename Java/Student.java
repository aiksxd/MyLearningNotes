/*
学生类
	学号：int
	姓名：String
	年龄：int
	性别：char
	住址：String

成员变量可以不手动赋值，系统会默认赋值：
	类型			默认值
--------------------------------
	byte			0
	short			0
	int				0
	long			0L
	float			0.0F
	double			0.0
	boolean			false
	char			\u0000
	引用数据类型	null	//null[nʌl]是一个java关键字，全部小写，表示空。

对于成员变量来说，每一个对象都有相同的属性名和独立的内存空间与数据
*/
public class Student{	//定义一个类（学生类）
	//属性(描述状态)，在java程序中以“成员变量”的形式存在，属性可以被赋值，如果没有则系统以默认值(见上)进行初始化。
	
	//学生的学号（成员变量、静态数据、属性）
	int num;		//该成员变量又名实例变量-->对象级别的变量（同类下的不同对象间的实例变量是独立的，且不可以直接通过类名在外部访问）
	
	//学生的姓名。
	String name;

	//年龄
	int age;
	
	//性别
	char sex;

	//住址
	String address;
	
	//以下为this后学习内容：
	
	String code;	//定义一个实例变量(考号)

	//定义一个带参的构造器
	/*像w1，w2这样的名字可读性较差，难以理解
	public Student(String w1,String w2){
		name = w1;
		code = w2;
	}*/
	public Student(String name,String code){
		name = name;	//由于java的就近原则，两个name都是构造方法形参中传入的实参值，两值相同，没有达到给实例变量赋传入值的效果。
		this.name = name;	//为了让系统能够区分，在被赋值的name前加this表示当前对象下的实例变量this，从而做到一石二鸟，既提高了代码的可读性，还达成了给实例变量赋值的目的。
		this.code = code;
	}
	//定义一个无参构造器
	public Student(){	/*假设给它赋默认值
		name = "无名氏";	//此处this可省略
		code = "000";	//代码与带参构造器有较多重复，可以通过this()来提高代码复用程度(特别是当代码较为复杂时，效果更明显)*/
		this("无名氏","000");	//同本构造器注释部分代码效果相同。
	}
	//定义一个实例方法(动态行为)：考试
	public void test(){
		System.out.println("考号为"+this.code+"的考生"+this.name+"正在应考"); //实例变量(code、name)都必须通过"引用.访问"，而引用依赖于new来创建对象，可这里是对象的实例方法，是对象的行为动作，期间没有实际的对象被创建。
		//而实例方法成功使用的前提就是有对应的对象，所以为了能够在使用中调用实例变量，this就能代替此处的引用，来指向当前的对象。
	}
	//定义一个实例方法：睡觉
	public void sleep(){
		System.out.println("考号为"+code+"的考生"+name+"正在睡觉");	//this在绝大部分的情况下可以省略
	}
}

















































	//JavaEveryday.class关于类与对象的前源代码：（因更换教程而被更换，但因形式独特得以保留，将下面每一行开头的"//"删去保存编译再执行即可查看效果）
		//System.out.println(
        //        "在下面代码中：\npublic static class SxtStu {      //定义一个类（学生类）\n" +
        //                "    int id;         //学生的学号（成员变量、静态数据、属性）\n" +
        //                "    int age = 16;   //学生的年龄，属性可以被赋值，如果没有被赋值则按照上面的默认值初始化。\n" +
        //                "    String name;    //学生的名称，String类型属于引用类型，默认值为null(空)\n" +
        //                "\n" +
        //                "    public void study(){     //定义一个方法（动态行为）：学习\n" +
        //                "        System.out.println(\"学习中\");\n" +
        //                "    }\n" +
        //                "\n" +
        //                "    public void kickball(){ //定义一个方法：踢球\n" +
        //                "        System.out.println(\"踢球中\");\n" +
        //                "    }\n" +
        //                "}\npublic static void main (String[] args)\n" +
        //                "    \n" +
        //                "    SxtStu s1 = new SxtStu();       //这里我们创建了一个对象(右SxtStu)将对象的地址指向类(左SxtStu)并赋给了变量s1，现在s1的地址指向类SxtStu\n" +
        //                "    System.out.println(s1.id);      //打印s1指向的类SxtStu中的属性id\n" +
        //                "    System.out.println(s1.name);    //打印s1指向的类SxtStu中的属性name\n" +
        //                "    s1.id = 1001;                   //同时，我们也可以对类下的属性赋值\n" +
        //                "    s1.name = \"小明\";\n" +
        //                "    System.out.println(s1.id);      //再打印赋值后的SxtStu下的属性id和name查看效果\n" +
        //                "    System.out.println(s1.name);\n" +
        //                "    s1.study();                     //同时我们也可以引用类下的方法\n" +
        //                "    s1.kickball();" +
        //                "\n运行结果：\n0\t\ts1指向的地址类下属性id被默认值初始化的值" +
        //                "\nnull\ts1指向的地址类下属性name被默认值初始化的值" +
        //                "\n1001\ts1指向的地址类下属性id的值" +
        //                "\n小明\t\ts1指向的地址类下属性name的值" +
        //                "\n学习中\ts1指向的地址类下的方法study的语句执行效果" +
        //                "\n踢球中\ts1指向的地址类下的方法kickball的语句执行效果");