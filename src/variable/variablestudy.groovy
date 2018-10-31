package variable

import org.codehaus.groovy.runtime.GStringImpl

int x =10
//println x.class

double y=3.14
//println y.class

def x_1=11
def y_1=2.1415
def name ='qndroid'
//println x_1.class
//println y_1.class
//println name.class

x_1=3.54
//println x_1.class
//println name.class

def name1='a single \' a\' string'
//println name1

//三个单引号,可以直接指定输出格式
def tripleName="""
thre 
    single 
string"""
//println tripleName.class
//println tripleName

//双引号
def doubleName ="this is a common string"
//println(doubleName)

def jeremy="Jeremy"
//println(jeremy.class)
def sayHello="Hello,${jeremy}"
//println(sayHello)
//println(sayHello.class)

//def sum ="The sum of 2 and 3 equals ${2+3}"
//println(sum)

String echo(GString message){
    return message;
}

//def result =echo(sum);
//println(result.class)
