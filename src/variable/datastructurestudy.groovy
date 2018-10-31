package variable

//def list=new ArrayList()//java的定义方式

def list = [1, 2, 3, 4, 5]//gradle集合定义方式

println(list.class)
println(list.size())

def array = [1, 2, 3, 4, 5] as int[]//gradle定义数组
println(array.class)

int[] array2 = [1, 2, 3]
println(array2.class)

/**
 * 列表的排序
 */

def sortList = [6, -3, 9, 2, -7, 1, 5]
Comparator mc = { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }
Collections.sort(sortList, mc)
println(sortList)

sortList.sort()
println(sortList)

sortList.sort { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1 }//排序结果有点不理解
println(sortList)

def sortStringList = ['abc', 'z', 'Hello', 'groovy', 'java']
sortStringList.sort {
    it -> it.size()
}

println(sortStringList)

class Student1 {
    Student1(int age, String name) {
        this.age = age
        this.name = name
    }

    int age
    String name

    @Override
    String toString() {
        return age + "--" + "name"
    }
}

def s1 = new Student1(1, "a")
def s2 = new Student1(2, "b")
def s3 = new Student1(3, "c")
def s4 = new Student1(4, "d")

def students = new ArrayList<Student1>()
students.add(s1)
students.add(s4)
students.add(s2)
students.add(s3)
students.sort {
    it -> it.name
}

println(students)

/**
 列表的查找*/
def findList = [-3, 9, 6, 2, -7, 1, 5]
int result = findList.find { return it % 2 == 0 }//找出第一个偶数
println(result)

def result1 = findList.findAll { return it % 2 == 0 }//找出所有偶数
println(result1)

def result2 = findList.any { return it % 2 != 0 }//存在奇数
println(result2)

def result3 = findList.every { return it % 2 == 0 }//所有偶数
println(result3)

println(findList.min())//最小值

println(findList.max())//最大值

println(findList.min {return  Math.abs(it)})//绝对值的最小值

println(findList.max {return  Math.abs(it)})//绝对值的最大值

println findList.count {return it%2==0}//统计数量
