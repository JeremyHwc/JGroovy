package objectorientation

/**
 * 面向对象
 * groovy中的类，接口等的定义和使用
 * 1.groovy中默认所有的变量，类，接口，方法都是public的
 * 2.所有的groovy类都是继承与groovyobject
 * 3.无论你是直接通过对象.还是调用get/set最终都是调用get/set
 *
 *
 * groovy中的元编程
 *
 * 调用 --> 类中是否有此方法 --是--> 直接调用类中方法
 *                          --否-->MetaClass中是否有此方法 --是--> 调用MetaClass中的方法
 *                                                        --否--> 是否重写了methodMissing()方法 --是--> 调用methodMissing()方法
 *                                                                                             --否--> 是否重写了invokeMethod()方法 --是--> 调用invokeMethod()方法
 *                                                                                                                                 --否--> thr0w MissingMethodException
 *
 */
class Person implements DefaultAction,Serializable{
    String name
    Integer age

    def increaseAge(Integer years) {
        this.age += years
    }

    @Override
    void eat() {

    }

    def invokeMethod(String name,Object args){
        return "the method is ${name},the params is ${args}"
    }

    def methodMissing(String name,Object args){
        return "the method is ${name} missing"
    }

}
