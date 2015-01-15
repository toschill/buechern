// @SOURCE:C:/Users/Fabian/Documents/WebTech/buechern/conf/routes
// @HASH:8aa4fab2f377499b1a13634b18e66024f0bef1e1
// @DATE:Thu Jan 15 18:56:02 CET 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:8
private[this] lazy val controllers_Application_profile1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
private[this] lazy val controllers_Application_profile1_invoker = createInvoker(
controllers.Application.profile(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "profile", Nil,"GET", """""", Routes.prefix + """profile"""))
        

// @LINE:9
private[this] lazy val controllers_Application_changeUserData2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userDatenAendern"))))
private[this] lazy val controllers_Application_changeUserData2_invoker = createInvoker(
controllers.Application.changeUserData(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changeUserData", Nil,"GET", """""", Routes.prefix + """userDatenAendern"""))
        

// @LINE:10
private[this] lazy val controllers_Application_verkaufen3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("verkaufen"))))
private[this] lazy val controllers_Application_verkaufen3_invoker = createInvoker(
controllers.Application.verkaufen(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "verkaufen", Nil,"GET", """""", Routes.prefix + """verkaufen"""))
        

// @LINE:11
private[this] lazy val controllers_Application_einkaufen4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("einkaufen"))))
private[this] lazy val controllers_Application_einkaufen4_invoker = createInvoker(
controllers.Application.einkaufen(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "einkaufen", Nil,"GET", """""", Routes.prefix + """einkaufen"""))
        

// @LINE:12
private[this] lazy val controllers_Application_einkaufen5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("einkaufen"))))
private[this] lazy val controllers_Application_einkaufen5_invoker = createInvoker(
controllers.Application.einkaufen(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "einkaufen", Nil,"GET", """""", Routes.prefix + """einkaufen"""))
        

// @LINE:13
private[this] lazy val controllers_Application_registrierung6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registrierung"))))
private[this] lazy val controllers_Application_registrierung6_invoker = createInvoker(
controllers.Application.registrierung(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registrierung", Nil,"GET", """""", Routes.prefix + """registrierung"""))
        

// @LINE:15
private[this] lazy val controllers_Application_logOut7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logOut"))))
private[this] lazy val controllers_Application_logOut7_invoker = createInvoker(
controllers.Application.logOut(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logOut", Nil,"GET", """""", Routes.prefix + """logOut"""))
        

// @LINE:16
private[this] lazy val controllers_Application_logIn8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logIn"))))
private[this] lazy val controllers_Application_logIn8_invoker = createInvoker(
controllers.Application.logIn(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logIn", Nil,"POST", """""", Routes.prefix + """logIn"""))
        

// @LINE:17
private[this] lazy val controllers_Application_addBook9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addBook"))))
private[this] lazy val controllers_Application_addBook9_invoker = createInvoker(
controllers.Application.addBook(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addBook", Nil,"POST", """""", Routes.prefix + """addBook"""))
        

// @LINE:18
private[this] lazy val controllers_Application_deleteBook10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteBook"))))
private[this] lazy val controllers_Application_deleteBook10_invoker = createInvoker(
controllers.Application.deleteBook(fakeValue[Integer]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteBook", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """deleteBook"""))
        

// @LINE:19
private[this] lazy val controllers_Application_buyBook11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("buyBook/"))))
private[this] lazy val controllers_Application_buyBook11_invoker = createInvoker(
controllers.Application.buyBook(fakeValue[Integer]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "buyBook", Seq(classOf[Integer]),"GET", """""", Routes.prefix + """buyBook/"""))
        

// @LINE:20
private[this] lazy val controllers_Application_addUser12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addUser"))))
private[this] lazy val controllers_Application_addUser12_invoker = createInvoker(
controllers.Application.addUser(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addUser", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """addUser"""))
        

// @LINE:21
private[this] lazy val controllers_Application_changePass13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("changePass"))))
private[this] lazy val controllers_Application_changePass13_invoker = createInvoker(
controllers.Application.changePass(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changePass", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """changePass"""))
        

// @LINE:22
private[this] lazy val controllers_Application_changeEmail14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("changeEmail"))))
private[this] lazy val controllers_Application_changeEmail14_invoker = createInvoker(
controllers.Application.changeEmail(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changeEmail", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """changeEmail"""))
        

// @LINE:23
private[this] lazy val controllers_Application_statusWs15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("statusWs"))))
private[this] lazy val controllers_Application_statusWs15_invoker = createInvoker(
controllers.Application.statusWs(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "statusWs", Nil,"GET", """""", Routes.prefix + """statusWs"""))
        

// @LINE:24
private[this] lazy val controllers_Application_searchBook16_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("searchBook"))))
private[this] lazy val controllers_Application_searchBook16_invoker = createInvoker(
controllers.Application.searchBook(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "searchBook", Seq(classOf[String]),"GET", """""", Routes.prefix + """searchBook"""))
        

// @LINE:28
private[this] lazy val controllers_Assets_at17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at17_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Application.profile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userDatenAendern""","""controllers.Application.changeUserData()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """verkaufen""","""controllers.Application.verkaufen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """einkaufen""","""controllers.Application.einkaufen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """einkaufen""","""controllers.Application.einkaufen()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registrierung""","""controllers.Application.registrierung()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logOut""","""controllers.Application.logOut()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logIn""","""controllers.Application.logIn()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addBook""","""controllers.Application.addBook()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteBook""","""controllers.Application.deleteBook(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """buyBook/""","""controllers.Application.buyBook(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addUser""","""controllers.Application.addUser(FirstName:String, LastName:String, Email:String, EmailRep:String, Passwort:String, PasswortRep:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """changePass""","""controllers.Application.changePass(oldPasswort:String, newPasswort:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """changeEmail""","""controllers.Application.changeEmail(oldEmail:String, newEmail:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """statusWs""","""controllers.Application.statusWs()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """searchBook""","""controllers.Application.searchBook(sucheBook:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:8
case controllers_Application_profile1_route(params) => {
   call { 
        controllers_Application_profile1_invoker.call(controllers.Application.profile())
   }
}
        

// @LINE:9
case controllers_Application_changeUserData2_route(params) => {
   call { 
        controllers_Application_changeUserData2_invoker.call(controllers.Application.changeUserData())
   }
}
        

// @LINE:10
case controllers_Application_verkaufen3_route(params) => {
   call { 
        controllers_Application_verkaufen3_invoker.call(controllers.Application.verkaufen())
   }
}
        

// @LINE:11
case controllers_Application_einkaufen4_route(params) => {
   call { 
        controllers_Application_einkaufen4_invoker.call(controllers.Application.einkaufen())
   }
}
        

// @LINE:12
case controllers_Application_einkaufen5_route(params) => {
   call { 
        controllers_Application_einkaufen5_invoker.call(controllers.Application.einkaufen())
   }
}
        

// @LINE:13
case controllers_Application_registrierung6_route(params) => {
   call { 
        controllers_Application_registrierung6_invoker.call(controllers.Application.registrierung())
   }
}
        

// @LINE:15
case controllers_Application_logOut7_route(params) => {
   call { 
        controllers_Application_logOut7_invoker.call(controllers.Application.logOut())
   }
}
        

// @LINE:16
case controllers_Application_logIn8_route(params) => {
   call { 
        controllers_Application_logIn8_invoker.call(controllers.Application.logIn())
   }
}
        

// @LINE:17
case controllers_Application_addBook9_route(params) => {
   call { 
        controllers_Application_addBook9_invoker.call(controllers.Application.addBook())
   }
}
        

// @LINE:18
case controllers_Application_deleteBook10_route(params) => {
   call(params.fromQuery[Integer]("id", None)) { (id) =>
        controllers_Application_deleteBook10_invoker.call(controllers.Application.deleteBook(id))
   }
}
        

// @LINE:19
case controllers_Application_buyBook11_route(params) => {
   call(params.fromQuery[Integer]("id", None)) { (id) =>
        controllers_Application_buyBook11_invoker.call(controllers.Application.buyBook(id))
   }
}
        

// @LINE:20
case controllers_Application_addUser12_route(params) => {
   call(params.fromQuery[String]("FirstName", None), params.fromQuery[String]("LastName", None), params.fromQuery[String]("Email", None), params.fromQuery[String]("EmailRep", None), params.fromQuery[String]("Passwort", None), params.fromQuery[String]("PasswortRep", None)) { (FirstName, LastName, Email, EmailRep, Passwort, PasswortRep) =>
        controllers_Application_addUser12_invoker.call(controllers.Application.addUser(FirstName, LastName, Email, EmailRep, Passwort, PasswortRep))
   }
}
        

// @LINE:21
case controllers_Application_changePass13_route(params) => {
   call(params.fromQuery[String]("oldPasswort", None), params.fromQuery[String]("newPasswort", None)) { (oldPasswort, newPasswort) =>
        controllers_Application_changePass13_invoker.call(controllers.Application.changePass(oldPasswort, newPasswort))
   }
}
        

// @LINE:22
case controllers_Application_changeEmail14_route(params) => {
   call(params.fromQuery[String]("oldEmail", None), params.fromQuery[String]("newEmail", None)) { (oldEmail, newEmail) =>
        controllers_Application_changeEmail14_invoker.call(controllers.Application.changeEmail(oldEmail, newEmail))
   }
}
        

// @LINE:23
case controllers_Application_statusWs15_route(params) => {
   call { 
        controllers_Application_statusWs15_invoker.call(controllers.Application.statusWs())
   }
}
        

// @LINE:24
case controllers_Application_searchBook16_route(params) => {
   call(params.fromQuery[String]("sucheBook", None)) { (sucheBook) =>
        controllers_Application_searchBook16_invoker.call(controllers.Application.searchBook(sucheBook))
   }
}
        

// @LINE:28
case controllers_Assets_at17_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at17_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     