
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
object leerSeite extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Büchern - Webtech</title>
<link rel="stylesheet" type="text/css" href="style.css">
<meta name="description"
	content="Büchern - Das Portal um gebrauchte Bücher zu Vorlesungen zu kaufen und zu verkaufen">
<meta name="author" content="Gruppe 6">
<meta name="keywords"
	content="WebtechWS14, Webtech, Büchern, Büchern Konstanz, Büchern HTWG, HTWG Konstanz, HTWG, Konstanz">
</head>
<body>
	<div id="homepage">
		<div id="homepagecontent">
			<div id="head">
				<div id="logo">
					<img id="logobild" src="logo.jpg" name="büchernlogo" />
				</div>

				<div id="headerrechts">
					<div id="registerlink">
						<a href="registrierung.html">Registrieren</a>
					</div>


					<div id="login">
						<form>

							<input name="benutzername" type="text" value="benutzername"
								size="30" maxlength="30"><br> <input
								name="passwort" type="text" value="passwort" size="30"
								maxlength="40">
						</form>
					</div>
				</div>
			</div>

			<div id="slider">
				<div id="bilderslider">
					<img id="bildinslider" src="slider.jpg" />
				</div>
			</div>

			<div id="navigation">
				<div id="respnav">
					<img src="navi.png" />
				</div>
				<span class="link"><a href="index.html">Startseite</a></span> <span
					class="linktrenner"> | </span> <span class="link"><a
					href="einkaufen.html">Einkaufen</a></span> <span class="linktrenner"> | </span> <span
					class="link"><a href="verkaufen.html">Verkaufen</a></span> <span
					class="linktrenner"> | </span> <span class="link"><a
					href="index.html">Bestseller</a></span> <span class="linktrenner"> | </span> <span
					class="link"><a href="profile.html">Profil</a></span>

			</div>



			<div id="content">
				<div id="register">
					<h1>test</h1>
				</div>
			</div>

			<div id="footer_container">
				<div id="footer">
					<span class="link"><a href="#">Telefonnummer</a></span> <span
						class="linktrenner"> | </span> <span class="link"><a
						href="#">E-Mail Nachricht</a></span>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jan 15 18:56:03 CET 2015
                  SOURCE: C:/Users/Fabian/Documents/WebTech/buechern/app/views/leerSeite.scala.html
                  HASH: 3e9cbac94c83aef2e8e35a8792c27c698ed39fe9
                  MATRIX: 802->0
                  LINES: 29->1
                  -- GENERATED --
              */
          