package objectorientation.expand

import objectorientation.Person

/**
 * Person类的管理器
 */
class PersonManager {
    static Person createPerson(String name,int age){
        return Person.createPerson(name,age)
    }
}
