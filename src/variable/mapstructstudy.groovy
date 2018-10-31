package variable

def colors = ["red": 'ff0000',
              green: '00ff00',
              blue : '0000ff']


println(colors.red)
println(colors.get('red'))
println(colors.red)

colors.yellow = 'ffff00'
println(colors.toMapString())

colors.complex = [a: '1', b: '2']//可以添加任何对象
println(colors.toMapString())

println(colors.getClass())

colors as HashMap
println(colors.getClass())

//注意点：
//    （1）定义map时的key通常是字符串和number，而且字符串一定要使用不可变字符串，即单引号字符串,但是双引号的没有报错？
//    （2）要获取map是谁的实例，不能用map.class，应该用map.getClass()

//删除元素
colors.remove('red')
println(colors.toMapString())

//Map操作详解


def students = [
        2: [number: '0002', name: 'Boe', score: 65, sex: 'female'],
        1: [number: '0001', name: 'Bod', score: 55, sex: 'male'],

        3: [number: '0003', name: 'Bof', score: 75, sex: 'male'],
        4: [number: '0004', name: 'Bog', score: 85, sex: 'female']
]
//=============================================================================遍历
students.each { def student ->
//    println "the key is ${student.key}," + "the value is ${student.value}"

}
//带索引的遍历
students.eachWithIndex { def student, int index ->
//    println "the index ${index},"+"the key is ${student.key}," + "the value is ${student.value}"
}
//直接遍历key-value
students.each { key, value -> println("the key is ${key}" + "the value is ${value}") }

students.eachWithIndex { key, value, index ->
    println("the index is ${index}," + "the key is ${key}"
            + "the value is ${value}")
}

//=============================================================================查找

def entry = students.find { def student -> return student.value.score >= 60 }
println(entry)

def entrys = students.findAll { def student -> return student.value.score >= 60 }
println(entrys)

def count = students.count { def student -> return student.value.score >= 60 && student.value.sex == 'male'
}
println(count)


def names = students.findAll { def student -> return student.value.score >= 60 }.collect {
    return it.value.name
}
println names.toListString()

//分组
def group = students.groupBy {
    def student -> return student.value.score >= 60 ? '及格' : '不及格'
}
println(group.toMapString())

//排序
def sort = students.sort {//返回的是新的map
    def student1, def student2 ->
        Number score1 = student1.value.score
        Number score2 = student2.value.score
        return score1 == score2 ? 0 : score1 < score2 ? -1 : 1
}
println(sort.toMapString())

