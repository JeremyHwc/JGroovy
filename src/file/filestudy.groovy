package file

import jline.internal.Log
import objectorientation.Person

def file = new File('D:\\Projects\\LearningProjects\\Groovy\\GroovySpecification\\GroovySpecification.iml')
//遍历文件内容,有以下三种方法
//file.eachLine {
//    line -> println(line)
//}

//def text = file.getText()
//println(text)

//def lines = file.readLines()
//println(lines.toListString())

//读取文件部分内容
def chars = file.withReader {
    reader ->
        char[] buffer = new char[10]
        reader.read(buffer)
        return buffer
}
println(chars.toString())

//复制文件内容
def copy(String sourcePath, String destationPath) {
    try {
        //创建目标文件
        def destFile = new File(destationPath)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }
        //开始copy
        def sourceFile = new File(sourcePath)
        if (!sourceFile.exists()) {
            Log.error("源文件找不到")
            return
        }
        sourceFile.withReader {
            reader ->
                /*def lines = reader.readLines()
                destFile.withWriter {
                    writer->
                        lines.each {
                            line->writer.append("\n"+line)
                        }
                }*/
                def text = reader.getText()
                destFile.withWriter {
                    writer ->
                        writer.write(text)
                }
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
}

copy('D:\\\\Projects\\\\LearningProjects\\\\Groovy\\\\GroovySpecification\\\\GroovySpecification.iml',
        'D:\\\\Projects\\\\LearningProjects\\\\Groovy\\\\GroovySpecification\\\\GroovySpecification.iml1')

//将对象存储在文件中

def saveObject(Object object, String path) {
    try {
        def file = new File(path)
        if (!file.exists()) {
            file.createNewFile()
        }
        file.withObjectOutputStream {
            out ->
                out.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) return null
        //文件存在
        file.withObjectInputStream {
            input ->
                obj = input.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}

def person = new Person(name: 'Jeremy', age: 18)
saveObject(person,'D:\\\\\\\\Projects\\\\\\\\LearningProjects\\\\\\\\Groovy\\\\\\\\GroovySpecification\\\\\\\\person.bin')
def object = (Person)readObject('D:\\\\\\\\Projects\\\\\\\\LearningProjects\\\\\\\\Groovy\\\\\\\\GroovySpecification\\\\\\\\person.bin')
println(object.name+"---"+object.age)
