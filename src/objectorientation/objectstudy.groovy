package objectorientation

/**
 * 无论你是直接通过对象.还是调用get/set最终都是调用get/set
 */
def person=new Person(name:'JGradle',age: 26)
println("the name is ${person.name},the age is ${person.age}")
println("the name is ${person.getName()},the age is ${person.getAge()}")
person.increaseAge(20)
println(person.age)

//元编程演示
def person1=new Person(name: 'JGradle')
println(person1.cry())
//为类动态的添加一个属性
Person.metaClass.sex='male'
Person person2=new Person()
person2.sex='female'
println(person2.getSex())
//为类动态的添加方法
Person.metaClass.sexUpperCase ={-> sex.toUpperCase()}
Person person3=new Person()
println(person3.sexUpperCase())
//为类动态添加静态方法
Person.metaClass.static.createPerson={
    String name,int age->new Person(name: name,age: age)
}
def person4 = Person.createPerson('JGradle', 25)
println(person4.name+"---"+person4.age)
//为类动态的添加静态属性
//Person.metaClass.static.number='100'
//println(Person.number)
