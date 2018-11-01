# JGradle

## 第2章 gradle快速入门
    领域特定语言DSL介绍
        DSL:全称domin specific language
        DSL与通用编程语言的区别：
            解决某一特定领域的问题
        核心思想：求专不求全，解决特定问题
        
    groovy讲解之groovy初探
        是一种基于JVM的敏捷开发语言
        结合了Python、Ruby和Smalltalk的许多强大的特性
        groovy可以与java完美结合，而且可以使用jva所有的库
        
        groovy特性：
            语法上支持动态类型，闭包等新一代语言特性
            无缝集成所有已经存在的java类库
            既支持面向对象编程也支持面向过程编程
        
        groovy优势：
            一种更加敏捷的编程语言
            入门非常的容易，但功能非常的强大
            既可以作为编程语言也可以作为脚本语言
            熟练掌握java的同学非常容易掌握groovy
            
    为什么选择groovy
    
## 第3章 开发环境搭建
    mac/linux环境下，groovy开发环境搭建
    windows环境下，groovy开发环境搭建
    IntelliJ IDEA 开发工具安装及groovy环境配置
    在IDEA中创建一个groovy工程
    
    需要大家提前安装好JDK环境
    
    搭建环境
    （1）安装好JDK环境
    （2）到官网下载好groovySDK,解压到合适的位置
        groovy文件介绍：
            groovy:执行groovy编译完成以后的字节码文件，相当于java命令
            groovyc:类似于javac命令，是将groovy文件编译成字节码文件
            groovysh:解释执行groovy脚本
            doc文件夹：里面主要是api
    （3）在电脑中配置groovy环境变量
    
## 第4章 Gradle核心语法讲解及实战    
    本章概述
        （1）groovy基础语法（变量定义，字符串）
        （2）groovy闭包讲解
        （3）groovy数据结构
        （4）groovy面向对象
    基础语法讲解
        （1）groovy中变量详解
            groovy中的变量
                变量的类型---基本类型，对象类型
                    基本类型：char、byte、short、int、double、float、long
                    对象类型：任何对象创建的变量都是对象类型
                    
                    在groovy中所有的数据类型都是对象类型
                变量的定义---强类型定义方式，弱类型定义方式
                    强类型定义：int x=10
                    弱类型定义：def x=10
                经验：
                    如果变量只使用在自己类里面，不会被其他类使用，推荐def，反之，强类型
                    用def定义的变量，在使用过程中，其变量类型可以改变
    String详解
        可以用单引号，三引号，双引号定义字符串，其特点如下：
        单引号：
        双引号：双引号是可扩展的字符串，可以包含变量，如果字符串里面包含引用变量，那么字符串的类是class org.codehaus.groovy.runtime.GStringImpl
                GString可以直接转换成String，但String不可以直接转换成GString
        三引号：可以直接定义输出格式
        
    字符串方法详解
        String方法包括
        （1）java.lang.String
        （2）DefaultGroovyMethods
        （3）StringGroovyMethods,包括普通类型的参数、闭包类型的参数
        
    逻辑控制详解
        顺序逻辑：单步往下执行
        条件逻辑：if/else;switch/case
        循环逻辑：while/for
        
    第二部分  闭包
        1.groovy中闭包基础详解
            闭包概念：
            （1）闭包的定义
            （2）闭包的调用
            闭包参数：
            （1）普通参数
            （2）隐式参数
            闭包返回值：
                总是有返回值的，默认是null
                
        2.groovy中闭包使用详解
            闭包的用法：
            （1）与基本类型的结合使用,例：upTo,downTo,times()
            （2）与String结合使用
            （3）与数据结构结合使用
            （4）与文件等结合使用
            
        3.groovy中闭包进阶讲解
            闭包的关键变量：
            this:代表闭包定义处的类
            owner:代表闭包定义处的类或者对象
            delegte://代表任意对象
        
            闭包委托策略：
                
    第三部分  数据结构
        1.groovy中列表详解
            列表的定义：
            
            列表的操作：
                增：
                删：
                查：
                排：
            
        2.groovy中的映射详解
        3.groovy中的范围详解   
        
    groovy元编程作业：
        将String类中动态添加一个reverse方法
    必知必会：
        对groovy整体语法特点有一个了解
        掌握groovy的变量，字符串，数据结构的用法
        掌握groovy的闭包和面向对象思想
        
## 第5章 Gradle高级用法实战
    本章概述：
        groovy json操作详解
        groovy xml文件操作详解
        groovy文件操作详解
        groovy与java对比总结
        
    Json操作详解
        （1）实体对象转换成json字符串，直接调用JsonOutput.toJson();
        （2）json字符串转化成对象，def slurper = new JsonSlurper()  slurper.parseText(response)
        
    Xml文件处理详解
        groovy中如何解析一个xml格式数据
        groovy中如何创建一个xml格式数据
        
        作业：将从网络请求的json字符串转换成xml格式数据
        思路：json字符串 ---jsonSlurper--> 实体对象---MarkupBuilder--> xml格式数据
        
    文件操作
        java如何处理文件：
            （1）节点流，InputStream,OutputStream及其子类
            （2）处理流或称包装流，Reader，Writer及其子类
        groovy如何处理文件：
            （1）所有java对文件的处理类，groovy都可以使用
            （2）groovy扩展了许多更加快捷和强大的方法
            
        作业：将xml数据保存在文件中
            
    groovy与java的对比
        写法上：没有java那么多的限制
        功能上：对java已有的功能进行了极大的扩展
        作用上：即可以编写应用，也可以编写脚本
        
    groovy学习总结
        groovy变量，字符串，循环等基本语法讲解
        groovy中的数据结构：列表，映射，范围用法
        groovy中的方法，类等面向对象相关讲解
        groovy中对普通文件，xml，json处理，另外还可连接数据库

## 第6章 Gradle生命周期探索
    gradle基本概念讲解
    gradle优势
    gradle执行流程讲解
    
    gradle是什么，能做什么  主要是用来构建应用程序
    
    gradle组成：
        （1）groovy核心语法
        （2）build script block
        （3）gradle api
        
    gradle优势：相比于ant、maven
        （1）灵活性
        （2）粒度性
        （3）扩展性
        （4）兼容性，兼容了ant、maven
        
    gradle生命周期：
        （1）Initialization初始化阶段----解析整个工程中所有Project,构建所有的Project对应的project对象
        （2）Configuration配置阶段 ---- 解析所有的projets对象的task，构建好所有task的拓扑图
        （3）Execution执行阶段 ---- 执行具体的tak及其依赖task
        
        疑问：如何监听gradle的生命周期？
        答疑：settings.gradle里面会有限执行初始化，而后执行项目build.gradle里面的一下三个方法，但是经过检验，
              beforeEvaluate()并没有打印出任何东西，存疑.....................
        
        /**
         * 配置阶段开始前的监听回调
         */
        this.beforeEvaluate {
            println 'beforeEvaluate...配置阶段开始前...'
        }
        
        /**
         * 配置阶段完成以后的回调
         */
        this.afterEvaluate {
            println 'afterEvaluate...配置阶段执行完毕'
        }
        
        /**
         * gradle执行完毕后的回调监听
         */
        this.gradle.buildFinished {
            println '执行阶段执行完毕'
        }
        
        /**
         * 等同于beforeEvaluate
         */
        this.gradle.beforeProject {
            println 'beforeProject...配置阶段开始前...'
        }
        
        /**
         * 等同于afterEvaluate
         */
        this.gradle.afterProject {
            println 'afterProject...配置阶段执行完毕'
        }
        
        /**
         * 添加监听
         */
        this.gradle.addBuildListener(new BuildListener() {
            @Override
            void buildStarted(Gradle gradle) {
        
            }
        
            @Override
            void settingsEvaluated(Settings settings) {
        
            }
        
            @Override
            void projectsLoaded(Gradle gradle) {
        
            }
        
            @Override
            void projectsEvaluated(Gradle gradle) {
        
            }
        
            @Override
            void buildFinished(BuildResult result) {
        
            }
        })
        
        //this.gradle.addListener()
        this.gradle
        .addProjectEvaluationListener(new ProjectEvaluationListener() {
            @Override
            void beforeEvaluate(Project project) {
        
            }
        
            @Override
            void afterEvaluate(Project project, ProjectState state) {
        
            }
        })
        
    本章必知必会
        了解gradle是什么，能做什么
        明白gradle相较于以前的构建工具有事在哪里
        掌握gradle的声明周期阶段
        
## 第7章 Gradle核心之Project详解及实战（注：gradle编程框架中最重要概念）
    本章概述
        深入了解Project
        Project核心API讲解
        Project核心API实战
        
        注意：在Android中，Root Project和其下面的module，对于gradle来讲，其地位是平等的，都是看成project
              Root Project用于管理所有的子project
              子project对于一个输出，app的project对应apk的输出，library module对应于aar的输出
    
    Project API组成
        （1）gradle声明周期api
        （2）project相关api
        （3）task相关api
        （4）属性相关api
        （5）file相关api
        （6）其他api
        
        1.project相关api
        
        root project ----> getSubProject() 获取子project
        sub project  ----> getParent() 获取父project
        
        getAllProjects()获取当前project及其所有sub project 
        
        问题：如何能够在root project里面通过api去配置sub project？
        答疑：通过project() api可以配置所有sub project里面的配置
        案例：
            project('app'){Project project->
                apply plugin:'com.android.application'
                group 'com.tencent'
                version '1.0.0-release'
                dependencies {
            
                }
            
                android{
            
                }
            }
            
        作用：所有project都需要相同的一个配置，可以抽取到root project进行配置
        
        疑问：如何为所有的工程都配置，包括root project
        案例：
            allprojects {
                repositories {
                    google()
                    jcenter()
                }
            }
    
        疑问：如何为所有sub project配置，不包括root project
        案例：
            subprojects {
                /*为所有的为library的库配置发布到maven的配置*/
                Project project->
                    if (project.plugins.hasPlugin('com.android.library')){
                        apply from:'../publishToMaven.gradle'
                    }
            }
    
        作业：将合适的配置运用project(),allProjects(),subProjects()配置到合适的位置
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    