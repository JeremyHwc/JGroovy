package variable

def range=1..10
println(range[0])

println(range.from)

println(range.to )

Range range1

//遍历
range.each {
//    println(it)
}

for (i in range){
//    println(i)
}

//switch case
def getGrade(Number number){
    def result
    switch (number){
        case 0..<60:
            result='不及格'
            break
        case 60..<70:
            result='及格'
            break
        case 70..<80:
            result='良好'
            break
        case 80..<100:
            result='优秀'
            break
    }
    return result
}


println(getGrade(0))



