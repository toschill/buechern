// @SOURCE:C:/Users/Fabian/Documents/WebTech/buechern/conf/routes
// @HASH:8aa4fab2f377499b1a13634b18e66024f0bef1e1
// @DATE:Thu Jan 15 18:56:02 CET 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:28
class ReverseAssets {


// @LINE:28
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {


// @LINE:23
def statusWs(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "statusWs")
}
                        

// @LINE:12
// @LINE:11
def einkaufen(): Call = {
   () match {
// @LINE:11
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "einkaufen")
                                         
   }
}
                                                

// @LINE:16
def logIn(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "logIn")
}
                        

// @LINE:18
def deleteBook(id:Integer): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "deleteBook" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                        

// @LINE:13
def registrierung(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "registrierung")
}
                        

// @LINE:8
def profile(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "profile")
}
                        

// @LINE:17
def addBook(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "addBook")
}
                        

// @LINE:10
def verkaufen(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "verkaufen")
}
                        

// @LINE:22
def changeEmail(oldEmail:String, newEmail:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "changeEmail" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("oldEmail", oldEmail)), Some(implicitly[QueryStringBindable[String]].unbind("newEmail", newEmail)))))
}
                        

// @LINE:20
def addUser(FirstName:String, LastName:String, Email:String, EmailRep:String, Passwort:String, PasswortRep:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "addUser" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("FirstName", FirstName)), Some(implicitly[QueryStringBindable[String]].unbind("LastName", LastName)), Some(implicitly[QueryStringBindable[String]].unbind("Email", Email)), Some(implicitly[QueryStringBindable[String]].unbind("EmailRep", EmailRep)), Some(implicitly[QueryStringBindable[String]].unbind("Passwort", Passwort)), Some(implicitly[QueryStringBindable[String]].unbind("PasswortRep", PasswortRep)))))
}
                        

// @LINE:9
def changeUserData(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "userDatenAendern")
}
                        

// @LINE:24
def searchBook(sucheBook:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "searchBook" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("sucheBook", sucheBook)))))
}
                        

// @LINE:19
def buyBook(id:Integer): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "buyBook/" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                        

// @LINE:21
def changePass(oldPasswort:String, newPasswort:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "changePass" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("oldPasswort", oldPasswort)), Some(implicitly[QueryStringBindable[String]].unbind("newPasswort", newPasswort)))))
}
                        

// @LINE:15
def logOut(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logOut")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:28
class ReverseAssets {


// @LINE:28
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {


// @LINE:23
def statusWs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.statusWs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "statusWs"})
      }
   """
)
                        

// @LINE:12
// @LINE:11
def einkaufen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.einkaufen",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "einkaufen"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "einkaufen"})
      }
      }
   """
)
                        

// @LINE:16
def logIn : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logIn",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "logIn"})
      }
   """
)
                        

// @LINE:18
def deleteBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteBook",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteBook" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:13
def registrierung : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registrierung",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registrierung"})
      }
   """
)
                        

// @LINE:8
def profile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.profile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        

// @LINE:17
def addBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addBook",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addBook"})
      }
   """
)
                        

// @LINE:10
def verkaufen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.verkaufen",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "verkaufen"})
      }
   """
)
                        

// @LINE:22
def changeEmail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.changeEmail",
   """
      function(oldEmail,newEmail) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "changeEmail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("oldEmail", oldEmail), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("newEmail", newEmail)])})
      }
   """
)
                        

// @LINE:20
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addUser",
   """
      function(FirstName,LastName,Email,EmailRep,Passwort,PasswortRep) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addUser" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("FirstName", FirstName), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("LastName", LastName), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("Email", Email), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("EmailRep", EmailRep), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("Passwort", Passwort), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("PasswortRep", PasswortRep)])})
      }
   """
)
                        

// @LINE:9
def changeUserData : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.changeUserData",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userDatenAendern"})
      }
   """
)
                        

// @LINE:24
def searchBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.searchBook",
   """
      function(sucheBook) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchBook" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("sucheBook", sucheBook)])})
      }
   """
)
                        

// @LINE:19
def buyBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.buyBook",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "buyBook/" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:21
def changePass : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.changePass",
   """
      function(oldPasswort,newPasswort) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "changePass" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("oldPasswort", oldPasswort), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("newPasswort", newPasswort)])})
      }
   """
)
                        

// @LINE:15
def logOut : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logOut",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logOut"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:28
class ReverseAssets {


// @LINE:28
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {


// @LINE:23
def statusWs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.statusWs(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "statusWs", Seq(), "GET", """""", _prefix + """statusWs""")
)
                      

// @LINE:11
def einkaufen(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.einkaufen(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "einkaufen", Seq(), "GET", """""", _prefix + """einkaufen""")
)
                      

// @LINE:16
def logIn(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logIn(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logIn", Seq(), "POST", """""", _prefix + """logIn""")
)
                      

// @LINE:18
def deleteBook(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteBook(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteBook", Seq(classOf[Integer]), "GET", """""", _prefix + """deleteBook""")
)
                      

// @LINE:13
def registrierung(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registrierung(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registrierung", Seq(), "GET", """""", _prefix + """registrierung""")
)
                      

// @LINE:8
def profile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.profile(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "profile", Seq(), "GET", """""", _prefix + """profile""")
)
                      

// @LINE:17
def addBook(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addBook(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addBook", Seq(), "POST", """""", _prefix + """addBook""")
)
                      

// @LINE:10
def verkaufen(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.verkaufen(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "verkaufen", Seq(), "GET", """""", _prefix + """verkaufen""")
)
                      

// @LINE:22
def changeEmail(oldEmail:String, newEmail:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.changeEmail(oldEmail, newEmail), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changeEmail", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """changeEmail""")
)
                      

// @LINE:20
def addUser(FirstName:String, LastName:String, Email:String, EmailRep:String, Passwort:String, PasswortRep:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addUser(FirstName, LastName, Email, EmailRep, Passwort, PasswortRep), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addUser", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """addUser""")
)
                      

// @LINE:9
def changeUserData(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.changeUserData(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changeUserData", Seq(), "GET", """""", _prefix + """userDatenAendern""")
)
                      

// @LINE:24
def searchBook(sucheBook:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.searchBook(sucheBook), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "searchBook", Seq(classOf[String]), "GET", """""", _prefix + """searchBook""")
)
                      

// @LINE:19
def buyBook(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.buyBook(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "buyBook", Seq(classOf[Integer]), "GET", """""", _prefix + """buyBook/""")
)
                      

// @LINE:21
def changePass(oldPasswort:String, newPasswort:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.changePass(oldPasswort, newPasswort), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changePass", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """changePass""")
)
                      

// @LINE:15
def logOut(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logOut(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logOut", Seq(), "GET", """""", _prefix + """logOut""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    