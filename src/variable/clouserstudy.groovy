package variable

/**
 * 闭包的用法
 * （1）与基本类型的结合使用
 * （2）与String结合使用
 * （3）与数据结构结合使用
 * （4）与文件等结合使用
 * /
 /*========================================================基本使用====================================*/
//有参数的闭包
def clouser = { String name -> println("hello ${name}") }

clouser.call('ggg')
clouser("hhhh")

def clouser1 = { String name, int age -> println("hello,${name},My age is ${age}") }
clouser1("张三", 18)

//所有闭包都有的默认参数
def clouser2 = {
    println("hello ${it}")
}

clouser2('yryr')

//闭包的返回值
def clouser3 = {
    return "hello ,${it}"
}

println(clouser3("jjjj"))

def clouser4 = {
    println("hello ,${it}")
}

println(clouser4("jjjj"))

/*========================================================闭包使用详解====================================*/

//用来求指定number的阶乘

int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

int x = fab(5)
println(x)

int fab2(int number) {
    int result = 1;
    number.downto(1) {
        num -> result *= num;
    }
    return result
}

println(fab2(6))

int cal(int number) {
    int result = 0
    number.times {
        num -> result += num
    }
    return result;
}

println(cal(101))

//字符串与闭包结合使用
String str = 'the 2 and 3 is 5'
str.each {
    String temp -> print temp.multiply(2)
}

//find来查找符合条件的第一个
println str.find {
    String s -> s.isNumber()
}

def list = str.findAll {
    String s -> s.isNumber()
}
println list.toListString()

//判断字符串包含数字字符
def result = str.any {
    String s -> s.isNumber()
}
println(result)

//判断每一项是否是数字
def every = str.every {
    String s -> s.isNumber()
}
println(every)

//大写
String toUpperCase = str.collect {
    it.toUpperCase()
}
println(toUpperCase)

/*========================================================进阶讲解====================================*/

/**
 * 闭包关键变量，this/owner/delegate
 * 闭包委托策略
 */

def scriptClouser = {
    println this//代表闭包定义处的类
    println owner//代表闭包定义处的类或者对象
    println delegate//代表任意对象
}

scriptClouser.call()

//定义一个内部类

class Person {

    def classClouser = {
        println(this)
        println(owner)
        println(delegate)
    }

    def say() {

        def classClouser = {
            println(this)
            println(owner)
            println(delegate)
        }

        classClouser.call()
    }
}

Person person = new Person()
person.classClouser.call()
person.say()

//闭包中定义一个闭包
def nestClouser = {
    def innerClouser = {
        println(this)
        println(owner)
        println(delegate)
    }
    innerClouser.delegate = person//修改默认的delegate

    //注意：this和owner是不能被修改的，delegate可以任意修改指向任意对象
    innerClouser.call()
}

nestClouser.call()

/**
 * 闭包的委托策略
 *
 */

class Student {
    String name;
    def pretty = {
        println "My NAME IS ${name}"
    }

    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name1
}

def student = new Student(name: "Sarash")
Teacher tea=new Teacher(name1: "qdroid")

student.pretty.delegate=tea
student.pretty.resolveStrategy=Closure.DELEGATE_FIRST

student.toString()


