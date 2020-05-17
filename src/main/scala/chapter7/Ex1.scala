object Ex1 extends App {
}

package com.horstmann {

  object Horst {
    val name: String = "horstmann"
  }

}

package com {
  package horstmann {
    package impatient {

      class EmployeeA(val name: String) {
        println(Horst.name) //Horst is accessible
      }

    }

  }

}

package com.horstmann.impatient {

  class EmployeeB(val name: String) {
    //println(Horst.name) Horst is not accessible
  }

}

package com.horstmann {

  class EmployeeC(val name: String) {
    println(Horst.name)
  }

}