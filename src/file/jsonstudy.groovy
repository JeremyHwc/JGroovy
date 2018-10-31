package file

import com.google.gson.Gson
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectorientation.Person

def list=[1:new Person(name: 'john',age: 25),
          2:new Person(name: 'jeremy',age: 15)]
def tojson = JsonOutput.toJson(list)
//println(tojson)
println JsonOutput.prettyPrint(tojson)

def slurper = new JsonSlurper()
def text = slurper.parseText(tojson)

def getNetworkData(String url){
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response=connection.content.text

    //将json转化为实体对象
    def slurper = new JsonSlurper()
    return slurper.parseText(response)
}

def response = getNetworkData('https://www.sojson.com/api/qqmusic/8446666/json')
println(response.data.playlist)


