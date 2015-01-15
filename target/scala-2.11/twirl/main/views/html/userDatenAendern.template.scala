
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object userDatenAendern extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""
"""),_display_(/*2.2*/main("userDatenAendern")/*2.26*/{_display_(Seq[Any](format.raw/*2.27*/("""
			"""),format.raw/*3.4*/("""<div id="content">
				<div id="changeUserData">
					<h1>Eigene Daten Ändern</h1>
						<div class="change">
							<form action="changePass"  method="Get"> 
								<h1>Passwort ändern</h1>
								<input name="oldPasswort" type="password" placeholder="Altes Passwort"></input></br>
								<input name="newPasswort" type="password" placeholder="NeuePasswort"></input></br>
								<input name="changePasswort" type="submit" value="Ändern"></input>
							</form>
							<form action="changeEmail" methode="Get">
								<h1>Email ändern</h1>
								<input name="oldEmail" type="text" placeholder="Alte Email"></input></br>
								<input name="newEmail" type="text" placeholder="Neue Email"></input></br>
								<input name="changeEmail" type="submit" value="Ändern"></input>
							</form>
						</div>
				</div>
			</div>

""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/userDatenAendern.scala.html
                  HASH: 776fe709e63666c3c91b36c2255738fdee9e13e8
                  MATRIX: 727->1|816->3|844->6|876->30|914->31|945->36
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3
                  -- GENERATED --
              */
          