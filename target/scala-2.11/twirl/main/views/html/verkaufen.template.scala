
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
object verkaufen extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""
"""),_display_(/*2.2*/main("Verkaufen")/*2.19*/{_display_(Seq[Any](format.raw/*2.20*/("""

			"""),format.raw/*4.4*/("""<div id="content">
				<div id="addBook">
					<div class="addForm">
						<form action="addBook" method="Post">
							<p>Buchtitel:</p>
							<input type="text" name ="Booktitel" id="Booktitel" placeholder="Buchtitel"></input>
							<p>Autor:</p>
							<input type="text" name = "Autor" id="Autor"  placeholder="Autor"></input>
							<p>Erscheinungsjahr:</p>
							<input type="text" name="Erscheinungsjahr" id="Erscheinungsjahr" placeholder ="Erscheinungsjahr"></input>
							<p>ISBN:</p>
							<input type="text" name="ISBN" id="ISBN" placeholder="ISBN"></input>
							<p>Auflage :</p>
							<input type="text" name="Auflage" id="Auflage " placeholder="Auflage "></input>
							<p>Zustand  :</p>
							<input type="text" name="Zustand" id="Zustand" placeholder="Zustand  "></input>
							<p>Preis  :</p>
							<input type="text" name="Preis" id="Preis" placeholder="Preis  "></input></br>
								
							<input type="submit" id="buchEinstellen" value="Buch einstellen"></input>
						</form>
					</div>
				</div>
			</div>
""")))}),format.raw/*28.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/verkaufen.scala.html
                  HASH: 48ef1d84a1bd888695911af6474c4dbb827acc63
                  MATRIX: 720->1|809->3|837->6|862->23|900->24|933->31|2031->1099
                  LINES: 26->1|29->1|30->2|30->2|30->2|32->4|56->28
                  -- GENERATED --
              */
          