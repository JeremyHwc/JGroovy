package objectorientation.expand

import objectorientation.Person

class Entry {
    static void main(def args){
        println('应用程序正在启动')
        //初始化
        ApplicationManager.init()
        println('应用程序初始化完成...')

        def person = PersonManager.createPerson('JGradle', 25)
        println("the person name is ${person.name},age is ${person.age}")
        def person1 = PersonManager.createPerson('JGradle1', 26)
        println("the person1 name is ${person1.name},age is ${person1.age}")
    }
}
