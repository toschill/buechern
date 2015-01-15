
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
object registrierung extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(fehler:Boolean):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.18*/("""
"""),_display_(/*2.2*/main("Registrierung")/*2.23*/{_display_(Seq[Any](format.raw/*2.24*/("""
	"""),format.raw/*3.2*/("""<script src="""),_display_(/*3.15*/routes/*3.21*/.Assets.at("javascripts/registration.js")),format.raw/*3.62*/("""></script>
			<div id="content">

				<div id="register">
					<h1>Herzlich Willkommen bei buechern.de</h1>
					<h2>...nur noch wenige Schritte bis du los buechern kannst</h2>
					<div id="persInfo">
						<form id="reg" onsubmit="return checkReg();" onreset="resetAll()" action="addUser" method="Get">
							<fieldset class="reg_fs">
								<legend>Persönliche Informationen</legend>
								<div id="pic_div">
									<img id="picUpl" src="""),_display_(/*14.32*/routes/*14.38*/.Assets.at("images/AddUser.png")),format.raw/*14.70*/(""" """),format.raw/*14.71*/("""name"Plus">
								</div>
								<ol> 
									<li>
										
									</li>
									<li>
										<label for="FirstName">Dein Vorname</label>
										<input id="FirstName" name="FirstName" maxlength="30" type="text">
									</li>
									<li>
										<label for="LastName">Dein Nachname</label>
										<input id="LastName" name="LastName" maxlength="30" type="text">
									</li>
									<li>
										<label for="Email">Deine E-mail Adresse</label>
										<input id="Email" name="Email" maxlength="30" type="text">
									</li>
									<li>
										<label for="EmailRep">Gib zur Sicherheit bitte nochmal die E-mail Adresse ein</label>
										<input id="EmailRep" name="EmailRep" maxlength="30" type="text"> </br>
									</li>
									<li>
										<label for="Passwort">Bitte gib ein Passwort ein</label>
										<input id="Passwort" name="Passwort" maxlength="30" type="password">
									</li>
									<li>
										<label for="PasswortRep">Gib dein Passwort bitte erneut ein</label>
										<input id="PasswortRep" name="PasswortRep" maxlength="30" type="password">
									</li>
								</ol>
							</fieldset>
							<fieldset class="reg_fs">
								<legend>Informationen zu deinem Studium</legend>
								<ol>
									<li>
										<label for="Fakultaet">In welcher Fakultät studierst du?</label>
										<select required name="Fakultaet"> 
											<option value="">wählen...</option>
											<option value="in">Informatik</option>
											<option value="ar" >Architektur</option>
											<option value="ei" >Elektrotechnik</option>
										</select>
									</li>
									<li>
										<label for="Studiengang">Wie lautet dein Studiengang?</label>
										<select name="Studiengang">
											<option value="">wählen...</option>
											<option value="WIN">Wirtschaftsinformatik</option>
											<option value="AIN">Angewante Informatik</option>
										</select>
									</li>
									<li>
										<label for="Semester">In welchem Semester bist du?</label>
										<select name="Semester">
											<option value="">wählen...</option>
											<option value="1">Erstes</option>
											<option value="2">Zweites</option>
										</select>
									</li>
								</ol>
							</fieldset>
							<fieldset id="button_fs">
								<input type="reset" value="reset" id="reButton">
								<input type="submit" value="weiter" id="subButton"/>
							</fieldset>
						</form>
					</div>
				</div>
			</div>

""")))}))}
  }

  def render(fehler:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(fehler)

  def f:((Boolean) => play.twirl.api.HtmlFormat.Appendable) = (fehler) => apply(fehler)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/registrierung.scala.html
                  HASH: 20e4afaf1a31542d2e3b3793132b039d8c2600bb
                  MATRIX: 732->1|836->17|864->20|893->41|931->42|960->45|999->58|1013->64|1074->105|1559->563|1574->569|1627->601|1656->602
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|31->3|42->14|42->14|42->14|42->14
                  -- GENERATED --
              */
          