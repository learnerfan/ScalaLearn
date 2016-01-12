package MyLesson01.TraitTest

/**
 * Created by songsf on 2016/1/12.
 */
//用特征来声明表示基本动作方法的模块Action
trait TAction{
  def doAction //定义需要执行的处理流程方法
}
//接着作为被加入方面，定义加入了前置处理和后置处理的特征TBeforeAfter
trait TBeforeAfter extends TAction{

  abstract override def doAction= {
    println("/entry before-action.") // doAction的前置处理
    super.doAction //调用原来的处理
    println("/exit after-action")  //doAction的后置处理
  }
}
trait TTwiceAction extends TAction{
  abstract override def doAction: Unit ={
    for (i <- 0 to 2){
      super.doAction
      println("======> NO."+i)
    }
  }
}
class RealAction extends TAction{
  def doAction={println("*** real action done!! ***")}
}
object TrainUsedExample {
  def main(args: Array[String]) {
    //通过上面的abstract override def doAction {}语句来覆盖虚方法。
    // 具体来说这当中的super.doAction是关键，他调用了TAction的doAction方法。
    // 其原理是，由于doAction是虚方法，所以实际被执行的是被调用的实体类中所定义的方法。
    val act1=new RealAction with TBeforeAfter
    act1.doAction
    println("--------------------------------------------")
    val act2=new RealAction with TBeforeAfter with TTwiceAction
    act2.doAction
    //改变with特征类的顺序
    println("--------------------------------------------")
    val act3=new RealAction with TTwiceAction with TBeforeAfter
    act3.doAction
  }
}
