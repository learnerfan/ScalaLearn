package MyLesson01.TraitTest

/**
 * Created by songsf on 2016/1/12.
 */

class Person
trait TTeacher extends Person{
  def teach //虚方法，，没有实现
}
trait TPianoPlayer extends Person{
  def playPiano={println("I`m playing piano.")}  //实方法，有实现
}
class PianoplayingTeacher extends Person with TTeacher with TPianoPlayer{
  def teach={println("I`m teaching students.")} //定义虚方法的实现
}
class Test extends Person with TPianoPlayer{
  //没有继承含有虚方法的TTeacher，所以不需要实现虚方法，继承含有虚方法的类，就必须实现虚方法
}
object TrainLearn {
  def main(args: Array[String]) {
    val t1=new PianoplayingTeacher
    //trait 可以实现多继承，利用with语句来混合多个特征到一个类中，特征不可以直接创建实例，
    // 特征可以在创建对象时才将特征各自的特点赋予对象
    t1.playPiano
    t1.teach
    val tanakaTaro=new Person with TTeacher with TPianoPlayer{
      def teach={println("I`m teaching students.")}
    }
    tanakaTaro.playPiano
    tanakaTaro.teach
  }
}
