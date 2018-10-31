package file

import groovy.xml.MarkupBuilder

final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android">
                <book available="20" id="1">
                    <title>疯狂Android讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14" id="2">
                   <title>第一行代码</title>
                   <author id="2">郭林</author>
               </book>
               <book available="13" id="3">
                   <title>Android开发艺术探索</title>
                   <author id="3">任玉刚</author>
               </book>
               <book available="5" id="4">
                   <title>Android源码设计模式</title>
                   <author id="4">何红辉</author>
               </book>
           </books>
           
           <books id="2" classification="web">
               <book available="10" id="1">
                   <title>Vue从入门到精通</title>
                   <author id="4">李刚</author>
               </book>
           </books>
           
       </value>
    </response>
    '''

//开始解析xml字符串
def slurper = new XmlSlurper()
def response = slurper.parseText(xml)
println(response.value.books[0].book[0].title.text())
println(response.value.books[1].book[0].@id)

//查找所有是李玉刚的书
def list = []
response.value.books.each {
    books ->
        books.book.each {
            book ->
                def author = book.author.text()
                if (author.equals("李刚")) {
                    list.add(book.title.text())
                }
        }
}
println(list.toListString())

//通过深度遍历方法完成以上操作
def all = response.depthFirst().findAll {
    book ->
        return book.author.text() == '李刚'
}
println(all.toListString())

/**
 * '**'是深度遍历
 */

def all1 = response.'**'.findAll {
    book ->
        return book.author.text() == '李刚'
}

def list2 = []
all1.each {
    book ->
        list2.add(book.title.text())
}
println(list2.toListString())

/**
 * 广度遍历xml数据
 * '*'代表广度遍历，即替换一下的children()
 */

def collect = response.value.books.children().findAll {
    node ->
        node.name() == 'book' && node.@id == '2'
}.collect {
    node -> return node.title.text()
}

println(collect)

/**
 * 生成xml数据
 * <langs type='current' count='3' mainstream='true'>
 *      <language flavor='static' version='1.5'>Java</language>
 *       <language flavor='dynamic' version='1.6.0'>Groovy</language>
 *       <language flavor='dynamic' version='1.9'>JavaScript</language>
 *  </langs>
 *
 * */
def st = new StringWriter()
MarkupBuilder markupBuilder = new MarkupBuilder(st)
markupBuilder.langs(type: 'current', count: '3', mainstream: true) {
    //第一个language结点
    language(flavor: 'static', version: '1.5', 'Java') {
        age('16')
    }
    language(flavor: 'dynamic', version: '1.6.0', 'Groovy') {
        age(age: 'number', 16)
    }
    language(flavor: 'dynamic', version: '1.9', 'JavaScript') {
        age('16')
    }
}
println(st)

//对应xml中的langs结点
class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [
            new Language(flavor: 'static', version: '1.5', value: 'Java'),
            new Language(flavor: 'dynamic', version: '1.6.0', value: 'Groovy'),
            new Language(flavor: 'dynamic', version: '1.9', value: 'JavaScript'),
    ]
}

//对应xml中的language结点
class Language {
    String flavor
    String version
    String value
}

def langs = new Langs()
markupBuilder.langs(type:langs.type,count:langs.count,mainstream:langs.mainstream){
    langs.languages.each {
        lang->
            language(flavor:lang.flavor,
            version:lang.version,
                    lang.value
            )
    }
}

println(st)
