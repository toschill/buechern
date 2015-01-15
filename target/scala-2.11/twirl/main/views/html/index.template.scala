
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""
"""),_display_(/*2.2*/main("Welcome to buechern")/*2.29*/{_display_(Seq[Any](format.raw/*2.30*/("""
			"""),format.raw/*3.4*/("""<div id="content">
				<div class="contenttext">
					<h1>buechern.de - Die HTWG interne Buchbörse</h1>
					<h2>fair - einfach - gut!</h2>

					</br>
						<p class="center">&#10003; Verkaufe FH-Bücher an Kommilitonen</p>
						<p class="center">&#10003; Kaufe Bücher die dir wirklich helfen</p>
						<p class="center">&#10003; Bekomme Buchempfehlungen von Kommilitonen aus höheren Semestern</p>
						<img class="comic" src="""),_display_(/*12.31*/routes/*12.37*/.Assets.at("images/comix.jpg")),format.raw/*12.67*/(""" """),format.raw/*12.68*/("""name="Comic">
				</div>
			</div>
""")))}),format.raw/*15.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/index.scala.html
                  HASH: e804f1012d38ce4b3f35c65ba0981447b707f771
                  MATRIX: 716->1|805->3|833->6|868->33|906->34|937->39|1402->477|1417->483|1468->513|1497->514|1566->553
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|40->12|40->12|40->12|40->12|43->15
                  -- GENERATED --
              */
          