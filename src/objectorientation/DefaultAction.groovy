package objectorientation

/**
 * groovy中trait 和 interface的区别在于trait中可以提供方法的默认实现，而接口不行，接口的方法必须由子类实现
 */
trait DefaultAction {

    abstract void eat()

    void play() {
        println('i can play')
    }

}